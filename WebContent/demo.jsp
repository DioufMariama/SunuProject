<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="utils/bootstrap.min.css" rel="stylesheet">
<title>Démo</title>
</head>

<body>
	<div id="header"></div>
	
	<%
		String message = ((String)request.getAttribute("message"));
		
		if(message != null){
			out.print("<b><font color=\"red\">"+message+"</font></b><br><br>");
		}
	%>

	<ul>
		<li><a href="<%=request.getContextPath()%>/PeuplerDatabaseServlet">Peupler la base avec des contacts</a></li>
	</ul>
	
</body>

<script src="utils/jquery.min.js"></script>
<% if(request.getSession().getAttribute("acc")==null){ %>
<script> (function() { $("#header").load("header/headerNotConnected.html"); })(); </script>
<% } else { %>
<script> (function() { $("#header").load("header/headerConnected.html"); })(); </script>
<% } %>

</html>