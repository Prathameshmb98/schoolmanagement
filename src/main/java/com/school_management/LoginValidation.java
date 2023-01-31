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

@WebServlet("/login1234")
public class LoginValidation extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Prathamesh");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Principal principal1=em.find(Principal.class, email);
		if(principal1!=null)
		{
			if(password.equals(principal1.getPassword()))
			{
				RequestDispatcher rd=req.getRequestDispatcher("StudentTeacher.html");
				rd.forward(req, resp);
			}
			else
			{
				RequestDispatcher rd1=req.getRequestDispatcher("Login.html");
				PrintWriter pr=resp.getWriter();
		        pr.write("Wrong Password");
			    rd1.include(req, resp);
			    resp.setContentType("text/html");
			}
			
			
		}
		else
		{
			RequestDispatcher rd1=req.getRequestDispatcher("Login.html");
			PrintWriter pr=resp.getWriter();
	        pr.write("Invalid Credentials");
		    rd1.include(req, resp);
		    resp.setContentType("text/html");
		}
	}

}
