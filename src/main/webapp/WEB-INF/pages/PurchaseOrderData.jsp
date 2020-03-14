<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-header bg-primary text-white text-center">
				<h3>Welcome to Purchase Order Data Page</h3>
			</div>
			<div class="card-body">
				<a href="excel">Excel Export</a> <a href="pdf">Pdf Export</a>
				<c:choose>
					<c:when test="${!empty list }">
						<table border="1">
							<tr>
								<th>ORDER ID</th>
								<th>ORDER CODE</th>
								<th>SHIPMENT CODE</th>
								<th>REFERENCE NUMBER</th>
								<th>QUALITY CHECK</th>
								<th>DEFAULT STATUS</th>
								<th>DESCRIPTION</th>
							</tr>
							<c:forEach items="${list }" var="ob">
								<tr>
									<td>${ob.pId }</td>
									<td>${ob.orderCode }</td>
									<td>${ob.shipOb.shipCode }</td>
									<td>${ob.refNum }</td>
									<td>${ob.qltyChk }</td>
									<td>${ob.status }</td>
									<td>${ob.note }</td>
								</tr>
							</c:forEach>
						</table>
					</c:when>
					<c:otherwise>
						<h3>No Data found!!</h3>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
</body>
</html>