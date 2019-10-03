/*package com.revature.grading.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Login {
	private static final long serialVersionUID = 1L;
       
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {*/
package com.revature.grading.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.revature.grading.dao.RegisterDao;
import com.revature.grading.exception.DBException;
import com.revature.grading.model.Admindetails;
//@WebServlet("/Register")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            		
String UserName = request.getParameter("UserName");
    		String Password = request.getParameter("PassWord");
            PrintWriter out = response.getWriter();
            
            String json = Controller.login(UserName, Password);
           out.write(json);
           out.flush();
    	
    	}

	
}
