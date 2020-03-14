<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
			<div class="card-header bg-primary text-center text-white text-uppercase">
				<h3>Welcome to Purchase Order Register Page</h3>
			</div>
			<div class="card-body">
				<form:form action="save" method="POST" modelAttribute="purchaseOrder">
					<div class="row">
						<div class="col-4">
							<label for="orderCode">Order Code</label>
						</div>
						<div class="col-4">
							<form:input path="orderCode" class="form-control"/>
						</div>
						<div class="col-4">
							<!-- Error message -->
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="">Shipment Code</label>
						</div>
						<div class="col-4">
							<form:select path="shipOb.shipId" class="form-control">
								<form:option value="">-SELECT-</form:option>
								<form:options items="${shipmentMap }"/>
							</form:select>
						</div>
						<div class="col-4">
							<!-- Error message -->
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="refNum">Reference Number</label>
						</div>
						<div class="col-4">
							<form:input path="refNum" class="form-control"/>
						</div>
						<div class="col-4">
							<!-- Error message -->
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="qltyChk">Quality Check</label>
						</div>
						<div class="col-4">
							<form:radiobutton path="qltyChk" value="Required"/>Required
							<form:radiobutton path="qltyChk" value="Not Required"/>Not Required
						</div>
						<div class="col-4">
							<!-- Error message -->
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="status">Dafault Status</label>
						</div>
						<div class="col-4">
							<form:input path="status" class="form-control"/>
						</div>
						<div class="col-4">
							<!-- Error message -->
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="note">Description</label>
						</div>
						<div class="col-4">
							<form:textarea path="note" class="form-control" />
						</div>
						<div class="col-4">
							<!-- Error message -->
						</div>
					</div>
					<div class="row">
						<div class="col-4">			
						</div>
						<div class="col-4">
							<input type="submit" value="Place Order" class="btn btn-success"/>
						</div>
					</div>
				</form:form>
			</div>
			<c:if test="${!empty msg }">
			<div class="card-footer bg-info text-white text-center">
				<b>${msg }</b>
			</div>
			</c:if>
		</div><!-- card end -->
	</div><!-- container end -->
</body>
</html>