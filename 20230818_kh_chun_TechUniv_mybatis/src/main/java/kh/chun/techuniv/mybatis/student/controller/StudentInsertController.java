package kh.chun.techuniv.mybatis.student.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.chun.techuniv.mybatis.student.model.dto.StudentDTO;
import kh.chun.techuniv.mybatis.student.model.service.StudentService;

/**
 * Servlet implementation class StudentInsertController
 */
@WebServlet("/student/insert")
public class StudentInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/student/insert.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		String studentNo = request.getParameter("studentNo");
		String departmentNo = request.getParameter("departmentNo");
		String studentName = request.getParameter("studentName");
		String studentSsn = request.getParameter("studentSsn");
		String studentAddress = request.getParameter("studentAddress");
		String entranceDate = request.getParameter("entranceDate");
		String absenceYn = request.getParameter("absenceYn");
		String coachProfessorNo = request.getParameter("coachProfessorNo");
		int result = new StudentService().insert(new StudentDTO(studentNo, departmentNo, studentName, studentSsn, studentAddress, entranceDate, absenceYn, coachProfessorNo));
		response.sendRedirect(request.getContextPath()+"/student/list");
	}

}
