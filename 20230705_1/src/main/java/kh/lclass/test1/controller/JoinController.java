package kh.lclass.test1.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JoinController
 */
@WebServlet("/join")
public class JoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		System.out.println("GET");
		request.getRequestDispatcher("/WEB-INF/view/join.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("POST");
		String id = request.getParameter("mid");
		String pwd = request.getParameter("mpwd");
		System.out.println(id);
		System.out.println(pwd);
		// DB에 저장하러 가기
		int result = 1; // 0이면 실패, 1이면 성공;
		if(result>0) {
		// DB에 잘 저장했다면
		// 로그인 화면으로 이동
			response.sendRedirect(request.getContextPath()+"/login");
			
		} else {
		// DB에 저장하지 못했다면
		// 경고창 띄우고 회원가입 화면으로 이동
		// 경고창 띄우고 메인화면으로 이동
			response.sendRedirect(request.getContextPath()+"/index");
		}
		
		
		
		
	}

}
