package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.TitleDao;
import database.TitleDaoImpl;

public class doDeleteTitle extends HttpServlet{
     public void doPost(HttpServletRequest request,HttpServletResponse response)
     		throws ServletException,IOException{
    	 response.setContentType("text/html");
    	 String isbn=request.getParameter("isbn");
    	 TitleDao titleDao = new TitleDaoImpl();
    	 int n=titleDao.delete(isbn);
    	 if(n>0)
    		 response.sendRedirect("/bookstore/listBook.jsp");
    	 else
    		 response.sendRedirect("/bookstore/error.jsp");
     }
}

