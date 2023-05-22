package com.libease.controller;

import java.sql.SQLException;

import com.libease.model.LibraryManager;
import com.libease.model.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class UserController {
    public void Login(HttpServletRequest request, int userId, String userName) throws SQLException {
        LibraryManager libManage = LibraryManager.getInstance();
        User user = libManage.getUserInfoFromIdAndName(userId, userName);

        HttpSession session = request.getSession();
        session.setAttribute("userName", user.getName());
        session.setAttribute("userId", user.getId());
    } 
    /**
     * @param request
     * ログアウト処理を行う　この処理を実行するとセッションに格納されている情報をすべて削除するため注意
     */
    public void Logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
    }
}
