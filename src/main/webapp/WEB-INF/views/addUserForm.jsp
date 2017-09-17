<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
    <title>Add User Form</title>
</head>
<body>
<jsp:include page="indexloginn.jsp"></jsp:include>
<h2>Register a New User</h2>

<form:form action="adduser.htm" commandName="user" method="POST">

<table>
<tr>
    <td>First Name:</td>
    <td><form:input path="firstName" size="30" /> <font color="red"><form:errors path="firstName"/></font></td>
</tr>

<tr>
    <td>Last Name:</td>
    <td><form:input path="lastName" size="30" /> <font color="red"><form:errors path="lastName"/></font></td>
</tr>


<tr>
    <td>User Name:</td>
    <td><form:input path="username" size="30" /> <font color="red"><form:errors path="username"/></font></td>
</tr>

<tr>
    <td>Password:</td>
    <td><form:password path="password" size="30" /> <font color="red"><form:errors path="password"/></font></td>
</tr>

 <tr>
    <td>Email Id:</td>
    <td><form:input path="email.emailId" size="30" /> <font color="red"><form:errors path="email.emailId"/></font></td>
</tr> 

<tr colspan='2'>
	<b>Who are you?</b>
    <td><form:radiobutton path="usertype" value="buyer"/>Buyer
    <form:radiobutton path="usertype" value="seller"/>Seller<font color="red"><form:errors path="usertype"/></font> </td>
</tr> 

<tr>
    <td colspan="2"><input type="submit" value="Create User" /></td>
</tr>
</table>

</form:form>

</body>
</html>