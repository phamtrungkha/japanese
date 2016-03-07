package core.com.ptk.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.com.ptk.DaoImpl.KanjiDaoImpl;
import core.com.ptk.entity.Kanji;
import core.com.ptk.entity.Kotoba;
import core.com.ptk.serviceImpl.KanjiServiceImpl;
import core.com.ptk.serviceImpl.KotobaServiceImpl;

/**
 * Servlet implementation class LearnKotobaController
 */
@WebServlet("/learnKanji")
public class LearnKanjiController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LearnKanjiController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String[] levelStr = request.getParameter("level").split(",");
		int[] levels = new int[levelStr.length];
		for (int i = 0; i < levelStr.length; i++)
			levels[i] = Integer.parseInt(levelStr[i]);
		List<Kanji> kanjis = (new KanjiServiceImpl()).getByLesson(levels);
		request.setAttribute("kanjis", kanjis);
		request.getRequestDispatcher("./learnKanji.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
