<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Add Product Form</title>
</head>
<body>


	<c:set var="contextPath" value="${pageContext.request.contextPath}" />

	<a href="${contextPath}/user/">Home</a><br/>

	<h2>Add a New Product</h2>


	<form:form action="${contextPath}/product/add" method="post" commandName="product">

		<table>
			<tr>
				<td>Product Name:</td>
				<td><form:input path="productName" size="30" required="required" /> <font color="red"><form:errors
							path="productName" /></font></td>
			</tr>
			
			<tr>
				<td>Category:</td>
				<td><form:input path="category" size="30" required="required" /> <font color="red"><form:errors
							path="category" /></font></td>
			</tr>

			<tr>
				<td>Caters to:</td>
				<td><form:input path="catersTo" size="30" required="required" /> <font color="red"><form:errors
							path="catersTo" /></font></td>
			</tr>

			<tr>
				<td>Unit:</td>
				<td><form:input path="unit" size="30" required="required" /> <font color="red"><form:errors
							path="unit" /></font></td>
			</tr>


			<tr>
				<td colspan="2"><input type="submit" value="Create Product" /></td>
			</tr>
		</table>

	</form:form>

</body>
</html>