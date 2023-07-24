package kh.test.jdbckh.lclass.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.test.jdbckh.lclass.model.dao.ClassDao;
import kh.test.jdbckh.lclass.model.vo.ClassVo;

/**
 * Servlet implementation class DepartmentGetController
 */
@WebServlet("/class/get")
public class ClassGetController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassGetController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ClassNo = request.getParameter("cno");
		System.out.println(ClassNo);
		// 2. 전달받은 데이터를 활용해 DB학생 상세 정보 가져오기
		ClassDao dao =new ClassDao();
		ClassVo vo = dao.selectOneClass(ClassNo);
		request.setAttribute("cvo", vo);
		request.getRequestDispatcher("/WEB-INF/view/class/get.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
