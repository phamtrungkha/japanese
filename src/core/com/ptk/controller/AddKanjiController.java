package core.com.ptk.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		request.getRequestDispatcher("./addKanji.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String kj = request.getParameter("kj");
		String kanjiRoot = request.getParameter("kanjiRoot");
		String jp = request.getParameter("jp");
		int level = Integer.parseInt(request.getParameter("level"));
		Kotoba kotoba = (new KotobaServiceImpl()).getByJp(jp);
		if (kotoba == null){
			request.setAttribute("kj", kj);
			request.setAttribute("kanjiRoot", kanjiRoot);
			request.setAttribute("jp", jp);
			List<Typeword> typewords = (new TypewordServiceImpl()).getAll();
			request.setAttribute("typewords", typewords);
			request.setAttribute("level", level);
			request.getRequestDispatcher("./addKotobaWithKanji.jsp").forward(request, response);
		}
		else {
			Kanji kanji = new Kanji();
			kanji.setKanji(kj);
			kanji.setKanjiRoot((new KanjiRootServiceImpl()).getByKanji(kanjiRoot));
			kanji.setKotoba(kotoba);
			//kanji.setLevel(Integer.parseInt(request.getParameter("level")));		//need change
			(new KanjiServiceImpl()).insert(kanji);
			request.setAttribute("kanjiRoot", request.getParameter("kanjiRoot"));
			request.setAttribute("level", level);
			request.getRequestDispatcher("./addKanji.jsp").forward(request, response);
		}
	}

}
