<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<jsp:useBean id = "testBeanClass" class="com.example.demo.service.testService" />
	<%
	
		out.print(testBeanClass.test());
	%>
	
</body>
</html>




