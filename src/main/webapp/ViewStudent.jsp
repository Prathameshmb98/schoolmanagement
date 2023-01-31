<%@page import="java.util.Iterator"%>
<%@page import="com.school_management.Student"%>
<%@page import="java.util.List"%>
<%@page import="javax.persistence.Query"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
EntityManagerFactory emf=Persistence.createEntityManagerFactory("Prathamesh");
EntityManager em=emf.createEntityManager();

Query q=em.createQuery("select a from Student a ");
List<Student> student=q.getResultList();
%>
<table cellpadding="20px" border="1">
<th>id</th>
<th>name</th>
<th>branch</th>
<th>fees</th>

<%for(Student s:student){ %>
<tr align="center">
<td><%= s.getId() %></td>
<td><%= s.getName() %></td>
<td><%= s.getBranch() %></td>
<td><%= s.getFees() %></td>
<%} %>
</body>
</html>