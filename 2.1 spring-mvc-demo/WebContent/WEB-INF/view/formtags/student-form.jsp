<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!doctype html>
<html>
<head>

</head>

<body>

	<form:form action="processForm" modelAttribute="student"> 
	
		First name: <form:input path="firstName"/>
		
		<br><br>
		
		Last name: <form:input path="lastName"/>
		
		<br><br>
		
		Country:
		
		<form:select path="country">
		<!-- hard coded jsp
			<form:option value="BRA" label="Brazil"/>
			<form:option value="FRA" label="France"/>
			<form:option value="GER" label="Germany"/>
			<form:option value="IND" label="India"/>
		 -->
		<!-- hard coded java -->
		   <form:options items="${student.countryOptions}"/> 
		
		<!-- properties file
		   <form:options items="${countries}"/> 
		  -->
		 	
		</form:select>
		
		<br><br>
		
		Favorite Language:
		
		<br>
		<!-- hard coded jsp
			Java <form:radiobutton path="favoriteLanguage" value="Java"/>
			C# <form:radiobutton path="favoriteLanguage" value="C#"/>
			PHP <form:radiobutton path="favoriteLanguage" value="PHP"/>
			Ruby <form:radiobutton path="favoriteLanguage" value="Ruby"/>
		-->
		<!-- hard coded java
			<form:radiobuttons path="favoriteLanguage" items="${student.favoriteLanguageOptions}"/>
		-->
		<!-- properties file --> 
			<form:radiobuttons path="favoriteLanguage" items="${languages}"/>
		
		<br><br>
		
		Linux <form:checkbox path="operatingSystems" value="Linux"/>
		Windows <form:checkbox path="operatingSystems" value="Windows"/>
		macOS <form:checkbox path="operatingSystems" value="macOS"/>
		
		
		<br><br>
		
		<input type="submit" value="Submit" />
		
		
		
	</form:form> 


</body>

</html>