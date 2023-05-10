package com.libease.controller;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServlet;

import com.libease.common.PathManager;
import com.libease.model.LibraryManager;

@WebServlet(urlPatterns = { "/logout" })
public class Logout extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            LibraryManager libManager = LibraryManager.getInstance();
            // JSPにリダイレクト
            request.getRequestDispatcher(PathManager.BOOKING_BOOK).forward(request, response);
            // TODO 削除してください エラー回避のためのコードです。
            throw new SQLException(getServletName(), getServletInfo(), 0, null);
        } catch (SQLException e) {
            e.printStackTrace();
            request.getRequestDispatcher(PathManager.ERROR).forward(request, response);
        }
    }
}
