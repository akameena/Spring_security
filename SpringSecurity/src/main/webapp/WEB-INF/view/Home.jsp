<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
hello.... 
<sec:authentication property="principal.username"/>
<sec:authentication property="principal.authorities"/>
<sec:authorize access="hasRole('HR')">
<a href="/SpringSecurity/hr">hr</a></sec:authorize>
<sec:authorize access="hasRole('ACCOUNTANT')">
<a href="/SpringSecurity/accountant">account</a></sec:authorize>
<form:form action="logout"
			   method="POST">
			   <input type="submit" value="logout">
	</form:form>
</body>

</html>