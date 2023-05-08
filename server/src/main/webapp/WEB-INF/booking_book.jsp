<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.libease.model.User" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>書籍予約画面</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div class="container">
<!--↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓この辺に予約書籍表示処理作っておいてください↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓-->













<!--↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑この辺に予約書籍表示処理作っておいてください↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑-->
<!--ここから下が書籍検索処理 -->
    <hr class="mt-5 mb-5">
    <h2 class="mt-5">書籍検索</h2>
    <!--Search Form -->
    <form action="${response.encodeRedirectURL(pageContext.request.contextPath + '/searchExecution')}" method="get" id="searchBookForm" role="form">
        <div class="row mt-5">
            <div class="col-md-5">
                <input type="text" name="bookName" id="bookName" value="${param.bookName}" class="form-control mb-2"
                       placeholder="Type book name" />
                <input type="text" name="author" id="author" value="${param.author}" class="form-control mb-2"
                       placeholder="Type author" />
            </div>
            <div class="col-md-5 d-flex align-items-end justify-content-end">
                <button type="submit" class="btn btn-info">
                    <span class="glyphicon glyphicon-search"></span>
                    Search
                </button>
            </div>
        </div>
    </form>
    
    <hr class="mt-5 mb-5">
    <c:choose>
        <c:when test="${not empty bookStatusDatas}">
            <p>検索結果：${bookStatusDatas.size()}件</p>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Book Name</th>
                    <th>Author</th>
                    <th>Status</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="bookStatus" items="${bookStatusDatas}">
                    <c:set var="classSuccess" value="" />
                    <tr class="${classSuccess}">
                        <td>${bookStatus.getBook().getBookId()}</td>
                        <td>${bookStatus.getBook().getBookName()}</td>
                        <td>${bookStatus.getBook().getAuthor()}</td>
                        <c:choose>
                            <c:when test="${bookStatus.getStatuts() == 'available'}">
                                <td>
                                    <form action="${response.encodeRedirectURL(pageContext.request.contextPath + '/bookingExecution ')}" method="post">
                                        <button type="submit" class="btn btn-info" name="bookId" value="${bookStatus.getBook().getBookId()}">貸出予約</button>
                                    </form>
                                </td>
                            </c:when>
                            <c:when test="${bookStatus.getStatuts() == 'borrowed'}">
                                <td>貸出済み</td>
                            </c:when>
                            <c:when test="${bookStatus.getStatuts() == 'reserved'}">
                                <td>予約済み</td>
                            </c:when>
                            <c:otherwise>
                                <td>不明</td>
                            </c:otherwise>
                    </c:choose>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            <div class="alert alert-info mt-5">
                Data not found.
            </div>
        </c:otherwise>
    </c:choose>

</div>

<script src="js/main.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
        crossorigin="anonymous"></script>
</body>
</html>
