<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h2>Application Error, please contact support.</h2><br>
	<h3>Debug Information</h3>
	Exception if for id ${id}
	Exception = ${exception.message} 
	<strong>Exception stack trace</strong>>
	<%-- <c:forEach items = "${exception.stack}" var ="ste" >
	${ste}
	</c:forEach> --%>
</body>
</html>