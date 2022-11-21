<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.example.dao.BookDAO"%>
<%@ page import="com.example.dao.BookDAO" %>

<% request.setCharacterEncoding("utf-8"); %>

<jsp:useBean id="u" class="com.example.bean.BookVO" />
<jsp:setProperty property="*" name="u"/>

<%
	BookDAO bookDAO = new BookDAO();
	int i=bookDAO.updateBook(u);
	response.sendRedirect("posts.jsp");
%>