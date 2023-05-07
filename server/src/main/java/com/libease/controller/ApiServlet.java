package com.libease.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.libease.view.SampleView;

@WebServlet(urlPatterns = {"/api"})
public class ApiServlet extends HttpServlet {
   public void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      try {
         response.setContentType("text/html");
         SampleView view = new SampleView();
         // Viewの処理を実行
         String render = view.render();

         // jsp側にHTMLを表示する
         PrintWriter out = response.getWriter();
         out.println(render);
      } catch (Exception e) {
         // TODO: handle exception
         e.printStackTrace();
      }
   }

}