package com.libease.controller;

import java.sql.SQLException;

import com.libease.model.LibraryManager;

public class Validator {
    public static String loginValidation () {
        return "";
    }
    public static String bookingValidation(int userId, int bookId) throws SQLException {
        String errorMsg = MessageManager.ERROR_BOOKING;
        if (userId <= 0) return errorMsg; 
        if (userId <= 0) return errorMsg; 
        LibraryManager libManager = LibraryManager.getInstance();
        libManager.getLendingRecode(bookId);
        
        return "";
    }
}
