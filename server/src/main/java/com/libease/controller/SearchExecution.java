package com.libease.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServlet;

import com.libease.common.PathManager;
import com.libease.model.Book;
import com.libease.model.BookStatusData;

@WebServlet(urlPatterns = { "/searchExecution" })
public class SearchExecution extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Optional<Integer> userIdOpt = Optional.ofNullable((Integer) request.getAttribute("ususer_ider"));
			LibraryController libCon = new LibraryController();
			if (userIdOpt.isPresent()) {
				// 検索実行
				try {
					List<Book> books = libCon.findReservedBooks(userIdOpt.get());
					request.setAttribute("books", books);
				} catch (Exception e) {
					// スタックトレースを維持したまま再スローする
					throw new RuntimeException(e);
				}
			}
			// リクエストパラメータの取得
			String bookName = request.getParameter("bookName");
			String author = request.getParameter("author");
			// 検索実行
			List<BookStatusData> bookStatusDatas = libCon.searchExecution(bookName, author);
			request.setAttribute("bookStatusDatas", bookStatusDatas);

			// JSPにデータを渡す
			// JSPにリダイレクト
			request.getRequestDispatcher(PathManager.BOOKING_BOOK).forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			request.getRequestDispatcher(PathManager.ERROR).forward(request, response);
		}
	}
}
