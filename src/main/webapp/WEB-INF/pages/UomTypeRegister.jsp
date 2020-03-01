<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Uom Type Register Page</h3>
	<form:form action="save" method="POST" modelAttribute="uomType">
		<pre>
		Uom Type:
		<form:select path="uomType">
			<form:option value="">--SELECT--</form:option>
			<form:option value="Packing">PACKING</form:option>
			<form:option value="No Packing">NO PACKING</form:option>
			<form:option value="NA">--NA--</form:option>
		</form:select>
		Uom Model:
		<form:input path="uomModel" />
		Description:
		<form:textarea path="uomDesc" />
		<input type="submit" value="Create Uom" />
	</pre>
	</form:form>
	${msg }
</body>
</html>