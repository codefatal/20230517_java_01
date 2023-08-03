package kh.lclass.test.model.coins.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.lclass.test.model.coins.model.dto.CoinsDTO;
import kh.lclass.test.model.coins.service.CoinsService;

/**
 * Servlet implementation class CoinsController
 */
@WebServlet("/coins")
public class CoinsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoinsController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CoinsService service = new CoinsService();
		List<CoinsDTO> dto = service.selectListCoins();
		request.setAttribute("coinsList", dto);
		
		request.getRequestDispatcher("/WEB-INF/view/coins/coins.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
