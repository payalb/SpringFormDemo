	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
    <%@taglib uri="http://www.springframework.org/tags"  prefix="tag"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="?lang=fr">French</a>
<a href="?lang=en">English</a>
<spring:form action="user" method="post" modelAttribute="user" enctype="multipart/form-data">
<%-- <spring:errors cssStyle="color:red" path="name" ></spring:errors>
<spring:errors cssStyle="color:red" path="password" ></spring:errors> --%>
<spring:errors cssStyle="color:red" path="*" ></spring:errors>
Photo:
	<spring:input path="photo" type="file"  />
	 <tag:message 
      code="name.label"/> <spring:input path="name" id="name" />
      <tag:message 
      code="password.label"/> 
	 <spring:input path="password" id="password" />
	<input type="submit"/>
</spring:form>
</body>
</html>