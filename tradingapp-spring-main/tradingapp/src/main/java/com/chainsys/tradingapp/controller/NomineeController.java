package com.chainsys.tradingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.chainsys.tradingapp.dao.NomineeDAO;
import com.chainsys.tradingapp.dao.UserDAO;
import com.chainsys.tradingapp.dao.impl.NomineeImpl;
import com.chainsys.tradingapp.dao.impl.UserImpl;
import com.chainsys.tradingapp.model.Nominee;
import com.chainsys.tradingapp.model.User;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/nominee")
@Validated
public class NomineeController {
    private final NomineeDAO nomineeOperations;
    private final UserDAO userOperations;

    private static final String REDIRECT_PROFILE = "redirect:/profile";

    @Autowired
    public NomineeController(NomineeImpl nomineeImpl, UserImpl userImpl) {
        this.nomineeOperations = nomineeImpl;
        this.userOperations = userImpl;
    }

    @GetMapping("/list")
    public String listNominees(HttpSession session) throws SQLException, ClassNotFoundException {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }

        User updatedUser = userOperations.getUserByEmail(user.getEmail());
        List<Nominee> nomineeList = nomineeOperations.getAllNomineesByUserId(user.getId());
        session.setAttribute("user", updatedUser);
        session.setAttribute("listNominees", nomineeList);
        return REDIRECT_PROFILE;
    }

    @PostMapping("/add")
    public String addNominee(@Valid @ModelAttribute Nominee nominee, HttpSession session) throws SQLException, ClassNotFoundException {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }

        nominee.setUserId(user.getId());
        nomineeOperations.addNominee(nominee);

        User updatedUser = userOperations.getUserByEmail(user.getEmail());
        session.setAttribute("user", updatedUser);
        return REDIRECT_PROFILE;
    }

    @PostMapping("/update")
    public String updateNominee(@Valid @ModelAttribute Nominee nominee, HttpSession session) throws SQLException, ClassNotFoundException {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }

        Nominee existingNominee = nomineeOperations.getNomineeById(nominee.getId());
        if (existingNominee == null || existingNominee.getUserId() != user.getId()) {
            return "redirect:/error";
        }

        nominee.setUserId(user.getId());
        nomineeOperations.updateNominee(nominee);

        User updatedUser = userOperations.getUserByEmail(user.getEmail());
        session.setAttribute("user", updatedUser);
        return REDIRECT_PROFILE;
    }

    @PostMapping("/delete")
    public String deleteNominee(@RequestParam int nomineeId, HttpSession session) throws SQLException, ClassNotFoundException {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }

        Nominee nominee = nomineeOperations.getNomineeById(nomineeId);
        if (nominee == null || nominee.getUserId() != user.getId()) {
            return "redirect:/error";
        }

        nomineeOperations.deleteNominee(nomineeId);

        User updatedUser = userOperations.getUserByEmail(user.getEmail());
        session.setAttribute("user", updatedUser);
        return REDIRECT_PROFILE;
    }
}
