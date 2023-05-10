package com.libease.controller;

import java.io.BufferedReader;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpServlet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.libease.model.Book;

@WebServlet(urlPatterns = { "/bookingExecutions" })
public class BookingExecutions extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // リクエストボディからJSON文字列を取得する
        BufferedReader reader = request.getReader();
        Stream<String> lines = reader.lines();
        String json = lines.collect(Collectors.joining("\r\n"));

        // JSON変換用のクラス
        ObjectMapper mapper = new ObjectMapper();
        try {
            Book book = mapper.readValue(json, Book.class);

            // セッションオブジェクトを取得する
            HttpSession session = request.getSession();
            // セッションスコープに属性を設定する
            session.setAttribute("successMessage",  MessageManager.SUCCESS_BOOKING);
            // JSPにデータを渡す
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
