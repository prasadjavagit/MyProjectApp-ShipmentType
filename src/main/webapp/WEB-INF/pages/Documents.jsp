<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Welcome to File Upload Page</h3>
	<form action="upload" method="POST" enctype="multipart/form-data">
		<pre>
			ID:<input type="text" name="fileId" />
			Doc:<input type="file" name="fileOb" />
			<input type="submit" value="Upload" />
		</pre>
	</form>
	${message }
</body>
</html>