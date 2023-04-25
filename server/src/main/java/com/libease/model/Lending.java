package com.libease.model;

public class Lending {
    private int lendingId;
    private int userId;
    private int bookId;
    
    public int getLendingId() {
        return lendingId;
    }
    
    public void setLendingId(int lendingId) {
        this.lendingId = lendingId;
    }
    
    public int getUserId() {
        return userId;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    public int getBookId() {
        return bookId;
    }
    
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
}
