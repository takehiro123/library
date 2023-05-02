package com.libease.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServlet;

import com.libease.model.LibraryManager;
import com.libease.model.User;

public class SampleController extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			LibraryManager libManager = LibraryManager.getInstance();
			List<User> users;
			users = libManager.getUsersInfoAll();
			// JSPにデータを渡す
			request.setAttribute("userList", users);
			// JSPにリダイレクト
			RequestDispatcher dispatcher = request.getRequestDispatcher("");
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
