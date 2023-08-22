package kh.chun.techuniv.mybatis.department.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.chun.techuniv.mybatis.department.model.dto.DepartmentDTO;
import kh.chun.techuniv.mybatis.department.model.service.DepartmentService;

/**
 * Servlet implementation class DepartmentListController
 */
@WebServlet("/department/list")
public class DepartmentListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentListController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[Department List Controller]");
		List<DepartmentDTO> result = new DepartmentService().selectList();
		request.setAttribute("departmentList", result);
		request.getRequestDispatcher("/WEB-INF/view/department/list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
