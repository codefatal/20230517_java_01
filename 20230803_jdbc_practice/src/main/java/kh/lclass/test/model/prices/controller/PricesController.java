package kh.lclass.test.model.prices.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.lclass.test.model.prices.model.dto.PricesDTO;
import kh.lclass.test.model.prices.service.PricesService;

/**
 * Servlet implementation class PricesController
 */
@WebServlet("/prices")
public class PricesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PricesController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PricesService service = new PricesService();
		List<PricesDTO> dto = service.selectListLog();
		request.setAttribute("pricesList", dto);
		
		request.getRequestDispatcher("/WEB-INF/view/prices/prices.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
