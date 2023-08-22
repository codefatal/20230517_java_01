package kh.chun.techuniv.mybatis.department.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.chun.techuniv.mybatis.department.model.dto.DepartmentDTO;
import kh.chun.techuniv.mybatis.department.model.service.DepartmentService;

/**
 * Servlet implementation class DepartmentGetController
 */
@WebServlet("/department/get")
public class DepartmentGetController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentGetController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String departmentNo = request.getParameter("departmentNo");
		DepartmentDTO result = new DepartmentService().selectOne(departmentNo);
		request.setAttribute("departmentNo", result);
		request.getRequestDispatcher("/WEB-INF/view/department/get.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
