package com.benjamin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.benjamin.dao.UserDao;
import com.benjamin.entity.User;

@WebServlet("/servlet/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		UserDao userDao = new UserDao();
		int id = Integer.parseInt(request.getParameter("id"));
		User user = userDao.get(id);
		// request.setAttribute("user", user);
		// request.getRequestDispatcher("").forward(request, response);
		PrintWriter pw = response.getWriter();
		pw.write(user.toString());
		pw.flush();
		pw.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
