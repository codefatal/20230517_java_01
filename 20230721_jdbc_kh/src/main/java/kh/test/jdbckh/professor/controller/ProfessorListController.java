package kh.test.jdbckh.professor.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.test.jdbckh.professor.model.dao.ProfessorDao;
import kh.test.jdbckh.professor.model.vo.ProfessorVo;

/**
 * Servlet implementation class DepartmentListController
 */
@WebServlet("/professor/list")
public class ProfessorListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfessorListController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/professor/list doGet() 진입");
		ProfessorDao dao = new ProfessorDao();
		List<ProfessorVo> result = dao.selectListProfessor();
		request.setAttribute("professorList", result);
		request.getRequestDispatcher("/WEB-INF/view/professor/list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
