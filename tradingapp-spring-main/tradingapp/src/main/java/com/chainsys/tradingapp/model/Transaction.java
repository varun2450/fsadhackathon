package com.chainsys.tradingapp.model;

import java.sql.Timestamp;

public class Transaction {
    private int transactionId;       // Unique transaction ID
    private int userId;              // User ID associated with the transaction
    private int stockId;             // Stock ID
    private int shares;              // Number of shares involved in the transaction
    private double price;            // Price of the stock at the time of transaction
    private String transactionType;  // Type of the transaction (buy/sell)
    private Timestamp timestamp;     // Timestamp of the transaction
    private String stockSymbol;      // Stock symbol (e.g., AAPL)
    private String companyName;      // Company name associated with the stock
    private double profitOrLoss;     // Profit or Loss from the transaction

    // Getter and Setter for transactionId
    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    // Getter and Setter for userId
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    // Getter and Setter for stockId
    public int getStockId() {
        return stockId;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
    }

    // Getter and Setter for shares
    public int getShares() {
        return shares;
    }

    public void setShares(int shares) {
        this.shares = shares;
    }

    // Getter and Setter for price
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Getter and Setter for transactionType
    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    // Getter and Setter for timestamp
    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    // Getter and Setter for stockSymbol
    public String getStockSymbol() {
        return stockSymbol;
    }

    public void setStockSymbol(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }

    // Getter and Setter for companyName
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    // Getter and Setter for profitOrLoss
    public double getProfitOrLoss() {
        return profitOrLoss;
    }

    public void setProfitOrLoss(double profitOrLoss) {
        this.profitOrLoss = profitOrLoss;
    }
}
