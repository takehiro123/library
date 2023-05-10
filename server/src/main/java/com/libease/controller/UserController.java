package com.libease.controller;

public class UserController {
    public int login(int userId, String userName) {
        // log inに失敗したら1を返してください。
        int errorCode = 0;
        // TODO ここでデータベースにアクセスしてユーザー情報を検索してください
        // TODO 成功したらセッション変数へUser IDと User nameを保存してください
        return errorCode;
    }

    public void logout() {
        // TODO セッション変数からユーザー情報を削除する
    }
}
