package kh.lclass.test.model.trade.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.lclass.test.model.trade.model.dto.TradeDTO;
import kh.lclass.test.model.trade.service.TradeService;

/**
 * Servlet implementation class TradetestController
 */
@WebServlet("/trade")
public class TradeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TradeController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TradeService service = new TradeService();
		List<TradeDTO> dto = service.selectListLog();
		request.setAttribute("tradeList", dto);
		
		request.getRequestDispatcher("/WEB-INF/view/trade/trade.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
