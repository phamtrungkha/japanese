package core.com.ptk.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.com.ptk.DaoImpl.KanjiDaoImpl;
import core.com.ptk.DaoImpl.KanjiRootDaoImpl;
import core.com.ptk.DaoImpl.KotobaDaoImpl;
import core.com.ptk.entity.Kanji;
import core.com.ptk.entity.Kotoba;
import core.com.ptk.entity.Typeword;
import core.com.ptk.serviceImpl.KanjiRootServiceImpl;
import core.com.ptk.serviceImpl.KanjiServiceImpl;
import core.com.ptk.serviceImpl.KotobaServiceImpl;
import core.com.ptk.serviceImpl.TypewordServiceImpl;

/**
 * Servlet implementation class AddKotobaController
 */
@WebServlet("/addKanji")
public class AddKanjiController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AddKanjiController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("kanjiRoot", request.getParameter("kanjiRoot"));
		request.setAttribute("level", request.getParameter("level"));
		request.getRequestDispatcher("./addKanji.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		Kanji kanji = new Kanji();
		kanji.setKanji(request.getParameter("kj"));
		kanji.setKanjiRoot((new KanjiRootServiceImpl()).getByKanji(request.getParameter("kanjiRoot")));
		kanji.setKotoba((new KotobaServiceImpl()).getByJp(request.getParameter("jp")));
		kanji.setLevel(Integer.parseInt(request.getParameter("level")));
		(new KanjiServiceImpl()).addKanji(kanji);
		request.setAttribute("kanjiRoot", request.getParameter("kanjiRoot"));
		request.setAttribute("level", request.getParameter("level"));
		request.getRequestDispatcher("./addKotoba.jsp").forward(request, response);
	}

}
