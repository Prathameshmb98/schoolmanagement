<%@page import="com.school_management.Student"%>
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
String id=request.getParameter("id");
int id1=Integer.parseInt(id);

EntityManagerFactory emf=Persistence.createEntityManagerFactory("Prathamesh");
EntityManager em=emf.createEntityManager();

Student student=em.find(Student.class, id1);

%>

<form action="UpdateStudent" method="post">
id:<input type="text" value="<%=student.getId() %>" name="id"><br><br>
name:<input type="text" value="<%=student.getName()%>" name="name"><br><br>
Branch:<input type="text" value="<%=student.getBranch() %>" name="branch"><br><br>
fees:<input type="text" value="<%=student.getFees() %>" name="fees"><br><br>
<input type="submit" value="Submit">
</form>

</body>
</html>