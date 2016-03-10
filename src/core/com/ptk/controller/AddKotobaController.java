package core.com.ptk.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.com.ptk.entity.Kotoba;
import core.com.ptk.entity.Typeword;
import core.com.ptk.serviceImpl.KotobaServiceImpl;
import core.com.ptk.serviceImpl.TypewordServiceImpl;

/**
 * Servlet implementation class AddKotobaController
 */
@WebServlet("/addKotoba")
public class AddKotobaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AddKotobaController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Typeword> typewords = new TypewordServiceImpl().getAll();
		request.setAttribute("lesson", request.getParameter("lesson"));
		request.setAttribute("typeword", typewords);
		request.getRequestDispatcher("./addKotoba.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		Kotoba kotoba = new Kotoba();
		kotoba.setJp(request.getParameter("jp"));
		kotoba.setVn(request.getParameter("vn"));
		kotoba.setEn(request.getParameter("en"));
		kotoba.setTypeword((new TypewordServiceImpl()).getById(Integer.parseInt(request.getParameter("typeword"))));
		kotoba.setLesson(Integer.parseInt(request.getParameter("lesson")));
		(new KotobaServiceImpl()).insert(kotoba);
		request.setAttribute("lesson", request.getParameter("lesson"));
		request.setAttribute("typeword", new TypewordServiceImpl().getAll());
		if (request.getParameter("kj") == null)
			request.getRequestDispatcher("./addKotoba.jsp").forward(request, response);
		else {
			request.setAttribute("kanjiRoot", request.getParameter("kanjiRoot"));
			request.setAttribute("level", request.getParameter("level"));
			request.getRequestDispatcher("./addKanji").forward(request, response);
		}
	}

}
