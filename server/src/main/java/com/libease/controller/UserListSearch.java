package com.libease.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServlet;

import com.libease.common.PathManager;
import com.libease.model.LibraryManager;
import com.libease.model.User;

@WebServlet(urlPatterns = { "/userListSearch" })
public class UserListSearch extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String param = request.getParameter("userName");
			if (param != null) {
				LibraryManager libManager = LibraryManager.getInstance();
				List<User> users;
				users = libManager.getUsersInfoByQuery(convertToInt(param), param);
				// JSPにデータを渡す
				request.setAttribute("userList", users);
			}
			// JSPにリダイレクト
			RequestDispatcher dispatcher = request.getRequestDispatcher(PathManager.USER_LIST_SERACH);
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private int convertToInt(String str) {
		int result = 0;
		if (str != null && str.matches("\\d+")) {
			try {
				result = Integer.parseInt(str);
			} catch (NumberFormatException e) {
				// パースに失敗した場合は0を返す
			}
		}
		return result;
	}
}
