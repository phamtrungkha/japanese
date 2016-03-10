package core.com.ptk.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.com.ptk.entity.Typeword;
import core.com.ptk.serviceImpl.TypewordServiceImpl;

/**
 * Servlet implementation class KotobaController
 */
@WebServlet("/kotoba")
public class KotobaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public KotobaController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Typeword> typewords = new TypewordServiceImpl().getAll();
		request.setAttribute("typeword", typewords);
		request.getRequestDispatcher("./kotoba.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String choosen = request.getParameter("choosen");
		if (choosen.equals("add")){
			request.setAttribute("lesson", request.getParameter("lesson"));
			request.getRequestDispatcher("./addKotoba").forward(request, response);
		}
		else {
			String[] lessonStr = request.getParameter("choosen").split(",");
			int[] lessons = new int[lessonStr.length];
			for (int i = 0; i < lessonStr.length; i++)
				lessons[i] = Integer.parseInt(lessonStr[i]);
			request.setAttribute("lessons", lessons);
			request.getRequestDispatcher("./learnKotoba").forward(request, response);
		}
	}

}
