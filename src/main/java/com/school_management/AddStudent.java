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

@WebServlet("/addstudent")
public class AddStudent extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String branch=req.getParameter("branch");
		String fees=req.getParameter("fees");
		
		int id1=Integer.parseInt(id);
		double fees1=Double.parseDouble(fees);
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Prathamesh");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Student student=new Student();
		student.setId(id1);
		student.setName(name);
		student.setBranch(branch);
		student.setFees(fees1);
		
		et.begin();
		em.persist(student);
		et.commit();
		
		RequestDispatcher rd=req.getRequestDispatcher("CRUD.html");
		PrintWriter pr=resp.getWriter();
	    pr.write("Student Details Added Successfully");
		rd.include(req, resp);
		resp.setContentType("text/html");

		
	}

}
