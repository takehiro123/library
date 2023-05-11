package com.libease.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class UserController {
    public void Login() {

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
