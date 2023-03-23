package edu.kh.jsp.student.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.jsp.student.model.service.StudentService;
import edu.kh.jsp.student.model.vo.Student;

@WebServlet("/student/selectDepartment")
public class DepartmentServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 서비스 객체 생성
				StudentService service = new StudentService();
				
				String search = req.getParameter("inputDept");
				try {
					
					List<Student> deptList = service.deptSearch(search);
					
					// 조회 결과 request에 세팅
					req.setAttribute("deptList", deptList);
					req.setAttribute("search", search);
					
					
					// 요청 위임
					RequestDispatcher dispatcher
						= req.getRequestDispatcher("/WEB-INF/views/student/selectDepartment.jsp");
					
					dispatcher.forward(req, resp);
					
				} catch(Exception e) {
					e.printStackTrace();
				}
	}
}
