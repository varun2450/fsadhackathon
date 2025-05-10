package com.chainsys.tradingapp.model;

public class Portfolio {
    private int portfolioId;  // Portfolio ID
    private int userId;       // User ID associated with the portfolio
    private String symbol;    // Stock symbol
    private String company;   // Company name
    private int stockId;      // Stock ID
    private int quantity;     // Quantity of stocks in the portfolio
    private double buyedPrice; // Average cost price of the stock
    private double total;     // Total cost for the stocks

    // Getter and Setter for portfolioId
    public int getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(int portfolioId) {
        this.portfolioId = portfolioId;
    }

    // Getter and Setter for userId
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    // Getter and Setter for symbol
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    // Getter and Setter for company
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    // Getter and Setter for stockId
    public int getStockId() {
        return stockId;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
    }

    // Getter and Setter for quantity
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Getter and Setter for buyedPrice
    public double getBuyedPrice() {
        return buyedPrice;
    }

    public void setBuyedPrice(double buyedPrice) {
        this.buyedPrice = buyedPrice;
    }

    // Getter and Setter for total
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
