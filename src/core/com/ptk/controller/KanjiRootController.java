package core.com.ptk.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.com.ptk.serviceImpl.KanjiRootServiceImpl;

/**
 * Servlet implementation class KotobaController
 */
@WebServlet("/kanjiRoot")
public class KanjiRootController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public KanjiRootController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("./kanjiRoot.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String kanjiRoot = request.getParameter("kanjiRoot");
		int level = Integer.parseInt(request.getParameter("level"));
		request.setAttribute("kanjiRoot", kanjiRoot);
		request.setAttribute("level", level);
		
		if ((new KanjiRootServiceImpl()).getByKanji(kanjiRoot) != null){
			request.getRequestDispatcher("./addKanji.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("./addKanjiRoot.jsp").forward(request, response);
		}
	}

}
