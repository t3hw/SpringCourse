<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html>
<head>
	<title>Customer Confirmation</title>
</head>

<body>


The customer is confirmed: 
<br>
lastName: ${customer.lastName}
<br>
freePasses: ${customer.freePasses}
<br>
postalCode: ${customer.postalCode}
<br>
courseCode: ${customer.courseCode}

</body>
</html>