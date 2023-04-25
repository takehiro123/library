package com.libease.view;


public class SampleView {
    public String render() {
        // HTMLを生成する処理
        return "./api works. Try <a href='./api/getMessage'>./api/getMessage</a>";
    }

    public String renderJsonString() {
        // HTMLを生成する処理
        return "{ \"message\": \"The board is green!\" }";
    }
}
