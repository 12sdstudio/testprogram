package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Title;
import database.TitleDao;
import database.TitleDaoImpl;

public class toEditTitle extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		response.setContentType("text/html");
		String isbn=request.getParameter("isbn");
		TitleDao titleDao=new TitleDaoImpl();
		Title titles=titleDao.findByIsbn(isbn);
		request.setAttribute("titles", titles);
		request.getRequestDispatcher("bookstore/editTitle.jsp").forward(request, response);
	}
}
