package kh.test.jdbckh.student.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.test.jdbckh.student.model.dao.StudentDao;
import kh.test.jdbckh.student.model.vo.StudentVo;

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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		// 1. 전달받은 parameter 읽어내기
		String studentNo = request.getParameter("studentNo");
		String departmentNo = request.getParameter("departmentNo");
		String studentName = request.getParameter("studentName");
		String studentSsn = request.getParameter("studentSsn");
		String studentAddress = request.getParameter("studentAddress");
		String entranceDate = request.getParameter("entranceDate");
		String absenceYn = request.getParameter("absenceYn");
		String coachProfessorNo = request.getParameter("coachProfessorNo");
		StudentDao dao = new StudentDao();
		StudentVo vo = new StudentVo(studentNo, departmentNo, studentName, studentSsn, studentAddress, entranceDate, absenceYn, coachProfessorNo);
		int result = dao.insertStudent(vo);
		System.out.println(result);
		if(result == 0) {
			System.out.println("입력실패");
		} else {
			System.out.println("입력성공");
		}
		response.sendRedirect(request.getContextPath()+"/student/list");
	}

}
