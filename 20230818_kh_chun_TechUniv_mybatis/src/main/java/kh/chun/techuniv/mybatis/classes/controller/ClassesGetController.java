package kh.chun.techuniv.mybatis.classes.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.chun.techuniv.mybatis.classes.model.dto.ClassesDTO;
import kh.chun.techuniv.mybatis.classes.model.service.ClassesService;

/**
 * Servlet implementation class ClassesGetController
 */
@WebServlet("/class/get")
public class ClassesGetController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassesGetController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String classNo = request.getParameter("classNo");
		ClassesDTO result = new ClassesService().selectOne(classNo);
		request.setAttribute("classNo", result);
		request.getRequestDispatcher("/WEB-INF/view/classes/get.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
