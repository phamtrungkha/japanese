package core.com.ptk.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.com.ptk.entity.KanjiRoot;
import core.com.ptk.serviceImpl.KanjiRootServiceImpl;

/**
 * Servlet implementation class AddKanjiRootController
 */
@WebServlet("/addKanjiRoot")
public class AddKanjiRootController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddKanjiRootController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("kanjiRoot", request.getParameter("kanjiRoot"));
		request.getRequestDispatcher("./addKanjiRoot.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String kjr = request.getParameter("kanjiRoot");
		int level = Integer.parseInt(request.getParameter("level"));
		KanjiRoot kanjiRoot = new KanjiRoot();
		kanjiRoot.setKanji(kjr);
		kanjiRoot.setHanTu(request.getParameter("hantu"));
		kanjiRoot.setAmOn(request.getParameter("amon"));
		kanjiRoot.setAmKun(request.getParameter("amkun"));
		kanjiRoot.setMoTa(request.getParameter("mota"));
		request.setAttribute("kanjiRoot", kjr);
		request.setAttribute("level", level);
		
		int addKanjiR = (new KanjiRootServiceImpl()).addKanjiRoot(kanjiRoot);
		if (addKanjiR != 0)
			request.getRequestDispatcher("./addKanji.jsp").forward(request, response);
		else
			response.sendRedirect("./Error.jsp");
	}

}
