package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Title;
import database.TitleDao;
import database.TitleDaoImpl;

@WebServlet("/doAdd")
public class doAddTitle extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response)
				throws ServletException,IOException{
		response.setContentType("text/html");
		//从页面获取文本框数据
		String isbn=request.getParameter("isbn");
		String title=request.getParameter("title");
		title=new String(title.getBytes("ISO-8859-1"),"GBK");
		String copyright=request.getParameter("copyright");
		String imageFile=request.getParameter("imageFile");
		int editionNumber=Integer.parseInt(request.getParameter("editionNumber"));
		int publisherId=Integer.parseInt(request.getParameter("publisherId"));
		float price=Float.parseFloat(request.getParameter("price"));
		
		Title titles=new Title();
		titles.setIsbn(isbn);
		titles.setCopyright(copyright);
		titles.setEditionNumber(editionNumber);
		titles.setImageFile(imageFile);
		titles.setPrice(price);
		titles.setPublisherId(publisherId);
		titles.setTitle(title);
		
		TitleDao titleDao=new TitleDaoImpl();
		System.out.print(titles);
		int n=titleDao.add(titles);
		System.out.print(request.getContextPath());
		if(n>0) response.sendRedirect("/bookstore/listBook.jsp");
		else
		 response.sendRedirect("/bookstore/error.jsp");
	}
}
