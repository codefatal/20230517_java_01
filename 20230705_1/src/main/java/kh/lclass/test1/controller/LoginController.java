package kh.lclass.test1.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
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
		request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("POST");
		String id = request.getParameter("mid");
		String pwd = request.getParameter("mpwd");
		System.out.println(id);
		System.out.println(pwd);
		// DB에 저장하러 가기
		int result = 1; // 0이면 실패, 1이면 성공;
		if(result>0) {
		// DB에 id/pwd 일치하는 항목 확인
		// 메인 화면으로 이동
			response.sendRedirect(request.getContextPath()+"/index");
			
		} else {
		// DB에 일치하는 정보가 없다면
		// 경고창 띄우고 회원가입 화면으로 이동
		// 경고창 띄우고 로그인으로 이동
//			alert("아이디 혹은 패스워드가 맞지 않습니다.");
			response.sendRedirect(request.getContextPath()+"/login");
		}
	}

}
