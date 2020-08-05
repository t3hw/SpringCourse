<!DOCTYPE html>
<html>
<head>
	<title>Hello World - Input Form</title>
	
		
	<link rel="stylesheet" type="text/css" 
		  href="${pageContext.request.contextPath}/resources/css/my-test.css">

    <script src="${pageContext.request.contextPath}/resources/js/simple-test.js"></script>
	
</head>
<body>
	
	<br><br>
	
	student name: ${param.studentName}
	
	
	<br><br>
	
	The message: ${message}
	

	<br><br>

	<img src="${pageContext.request.contextPath}/resources/images/ehud-olmert.jpg">

	<br><br>

	<input type="button" onclick="doSomeWork()" value="Click Me"/>
	
	<br><br>
		
	<a href="backToMenu">Back to main menu</a>	
	

</body>


</html>