<%@ page language= "java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${param.inputDept} 학과 검색 결과</title>
    
    <style>
    	table {
    		border-collapse: collapse;
    	}
    	
    	th {
    		background-color: black;
    		color: white;
    		height:30px
    	}
    	
    	td:not(:last-child) {
    		width:100px;
    		text-align:center;
    	}
    	
    	
    	tr:nth-child(2n-1) {
    		background-color: #ddd;
    	}
    	
    	tr:hover > td {
    		background-color: #B1AFFF;
    		cursor: pointer;
    	}
    </style>
</head>
<body>

	<h1>[${param.inputDept}] 학과 검색 결과</h1>
	
	
    <table>
    	
    	<tr>
    		<th>순서</th>
    		<th>학번</th>
    		<th>이름</th>
    		<th>학과</th>
    		<th>주소</th>
    	</tr>
    	
    	<c:choose>
    		<c:when test= "${empty deptList }">
    			
    				<h1 style="color:red;">일치하는 학과가 존재하지 않습니다</h1>
    			
    		</c:when>
    		
    		<c:otherwise>
		    	<c:forEach var="student" items="${deptList}" varStatus="vs">
		     	
		    		<tr>
		    			<td>${vs.count}</td>
		    			<td>${student.studentNo}</td>
		    			<td>${student.studentName}</td>
		    			<td>${student.departmentName}</td>
		    			<td>${student.studentAddress}</td>
		    		</tr>
		    	
		    	</c:forEach>
    		
    		</c:otherwise>
    	</c:choose>
    </table>
</body>
</html>