package com.libease.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.libease.view.SampleView;

public class ApiGetMessageServlet extends HttpServlet {
   public void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      try {
         response.setContentType("application/json");
         SampleView view = new SampleView();
         // Viewの処理を実行
         String render = view.renderJsonString();
         PrintWriter out = response.getWriter();
         out.println(render);
      } catch (Exception e) {
         // TODO: handle exception
         e.printStackTrace();
      }
   }
}