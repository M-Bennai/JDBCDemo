<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PAYS</title>
</head>
<body>

<form action ="helloworld" method="Post">

<label for="nom">Nom :</label>

<input type="text"  name="nom" required maxlength="20" size="10">

<input type="submit" value="Ajouter Pays" size="20">

</form>
<br>


 <ul>
        <c:forEach var="pays" items="${ Lpays }">
            <li><c:out value="${ pays.id }" /> <c:out value="${ pays.nom }" /></li>
        </c:forEach>
    </ul>  
 
</body>
</html>