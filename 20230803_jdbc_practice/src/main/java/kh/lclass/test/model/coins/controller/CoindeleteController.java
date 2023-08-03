package kh.lclass.test.model.coins.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.lclass.test.model.coins.service.CoinsService;

/**
 * Servlet implementation class CoindeleteController
 */
@WebServlet("/coins/delete")
public class CoindeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoindeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/coins/coinDelete.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
    	response.setContentType("text/html; charset=utf-8");
    	response.setCharacterEncoding("utf-8");
    	int result = 0;
    	CoinsService service = new CoinsService();
    	String coincode = request.getParameter("coincode");
    	result = service.coinDelete(coincode);
    	if(result > 0) {
    		System.out.println("삭제 성공");
    	} else {
    		System.out.println("삭제 실패");
    	}
    	response.sendRedirect(request.getContextPath()+"/coins");
	}

}
