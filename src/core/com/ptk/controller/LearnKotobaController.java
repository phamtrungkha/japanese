package core.com.ptk.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.com.ptk.entity.Kotoba;
import core.com.ptk.serviceImpl.KotobaServiceImpl;

/**
 * Servlet implementation class LearnKotobaController
 */
@WebServlet("/learnKotoba")
public class LearnKotobaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LearnKotobaController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String[] lessonStr = request.getParameter("lesson").split(",");
		int[] lessons = new int[lessonStr.length];
		for (int i = 0; i < lessonStr.length; i++)
			lessons[i] = Integer.parseInt(lessonStr[i]);
		List<Kotoba> kotobas = (new KotobaServiceImpl()).getByLesson(lessons);
		request.setAttribute("kotobas", kotobas);
		request.getRequestDispatcher("./learnKotoba.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
