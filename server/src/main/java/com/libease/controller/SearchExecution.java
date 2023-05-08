package com.libease.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServlet;

import com.libease.common.PathManager;
import com.libease.model.BookStatusData;
import com.libease.model.LibraryManager;

@WebServlet(urlPatterns = { "/searchExecution" })
public class SearchExecution extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String bookName = request.getParameter("bookName");
			String author = request.getParameter("author");
			bookName = (bookName == null) ? "" : bookName;
			author = (author == null) ? "" : author;

			LibraryManager libManager = LibraryManager.getInstance();
			List<BookStatusData> bookStatusDatas = libManager.getBooksBySearchQuery(bookName, author);
			// JSPにデータを渡す
			request.setAttribute("bookStatusDatas", bookStatusDatas);
			// JSPにリダイレクト
			request.getRequestDispatcher(PathManager.BOOKING_BOOK).forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			request.getRequestDispatcher(PathManager.ERROR).forward(request, response);
		}
	}
}
