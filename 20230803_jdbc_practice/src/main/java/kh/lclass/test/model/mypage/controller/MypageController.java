package kh.lclass.test.model.mypage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.lclass.test.model.mypage.model.dto.MypageDTO;
import kh.lclass.test.model.mypage.service.MypageService;

/**
 * Servlet implementation class MypageController
 */
@WebServlet("/mypage")
public class MypageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypageController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MypageService service = new MypageService();
		int searchNum = Integer.parseInt(request.getParameter("searchNum"));
		MypageDTO dto = service.selectUserMypage(searchNum);
		request.setAttribute("mypage", dto);
		request.getRequestDispatcher("/WEB-INF/view/mypage/mypage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
