package edu.kh.jsp.student.model.service;

import java.sql.Connection;
import java.util.List;

import edu.kh.jsp.student.model.dao.StudentDAO;
import edu.kh.jsp.student.model.vo.Student;

import static edu.kh.jsp.common.JDBCTemplate.*;

public class StudentService {
	
	private StudentDAO dao = new StudentDAO();

	public List<Student> selectAll() throws Exception {
		
		// Connection 생성
		Connection conn = getConnection();
		
		// DAO 메서드 호출 후 결과 반환 받기
		List<Student> stdList = dao.selectAll(conn);
		
		// 트랜잭션 처리(DML인 경우에만 진행)
		
		// Connection 객체 반환
		close(conn);
		
		// 결과 반환
		
		
		return stdList;
	}

	public List<Student> deptSearch(String search) throws Exception{
		// Connection 생성
		Connection conn = getConnection();
				
		// DAO 메서드 호출 후 결과 반환 받기
		List<Student> deptList = dao.deptSearch(conn, search);
				
		// 트랜잭션 처리(DML인 경우에만 진행)
				
		// Connection 객체 반환
		close(conn);
				
		// 결과 반환
				
				
		return deptList;
		
	}
	
	

}
