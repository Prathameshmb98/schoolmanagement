package com.school_management;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/createAccount")
public class SchoolDriver extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String age=req.getParameter("age");
		String mobileNo=req.getParameter("mobileno");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Prathamesh");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		int age1=Integer.parseInt(age);
		long mobileNo1=Long.parseLong(mobileNo);
		
		Principal principal=new Principal();
		principal.setName(name);
		principal.setAge(age1);
		principal.setMobileNo(mobileNo1);
		principal.setEmail(email);
		principal.setPassword(password);
		
		et.begin();
		em.persist(principal);
		et.commit();
		
		
		RequestDispatcher rd=req.getRequestDispatcher("Login.html");
		PrintWriter pr=resp.getWriter();
	    pr.write("Account Created Successfully");
		rd.include(req, resp);
		resp.setContentType("text/html");
	}
	

}
