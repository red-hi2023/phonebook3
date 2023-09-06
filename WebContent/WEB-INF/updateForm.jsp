<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="com.javaex.dao.PersonDao"%>
<%@ page import="com.javaex.vo.PersonVo"%>

<%
	//파라미터 꺼내기
	int personId = Integer.parseInt(request.getParameter("id"));
	//System.out.println(personId);

	//PersonDao 로 db관련 처리하기
	PersonDao personDao = new PersonDao();
	PersonVo personVo = personDao.personSelectOne(personId);
	System.out.println(personVo);
	
	//화면 처리하기

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>전화번호부</h1>
	<h2>수정폼</h2>
	
	<p>정보을 수정하는 폼입니다. 수정할 정보를 입력하고 수정 버튼을 누르세요</p>
	
	<form action="/phonebook3/pbc" method="get">
		이름(name): <input type="text" name="name" value="<%=personVo.getName()%>"><br>
		핸드폰(hp): <input type="text" name="hp" value="<%=personVo.getHp()%>"><br>
		회사(company): <input type="text" name="company" value="<%=personVo.getCompany()%>"><br>
		id hidden으로 처리 <input type="text" name="id" value="<%=personVo.getPerson_id()%>"><br>
		action hidden으로 처리 <input type="text" name="action" value="update"><br>
		<button type="submit">수정</button>
	</form>
	
	<br>
	<br>
	
	<a href="">리스트로 바로가기</a>

</body>
</html>