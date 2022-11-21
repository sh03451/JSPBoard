<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.example.dao.BookDAO, com.example.bean.BookVO"%>
<%
	String sid = request.getParameter("id");
	if (sid != ""){  
		int id = Integer.parseInt(sid);
		BookVO u = new BookVO();
		u.setSeq(id);
		BookDAO bookDAO = new BookDAO();
		bookDAO.deleteBook(u);
	}
	response.sendRedirect("posts.jsp");
%>