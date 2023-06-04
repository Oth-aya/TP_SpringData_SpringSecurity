<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ taglib prefix="sec"      uri="http://www.springframework.org/security/tags" %>
    
    <%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<c:set var="cxt" value="${pageContext.request.contextPath }"/>
<title>Insert title here</title>
</head>
<body>



 <h1>Liste des Départements</h1>
  
   <table border="1">
   <c:forEach items="${ld}" var="dep">
   <tr>
      <td>${dep.idd}</td>
      <td>${dep.titre}</td>
     <sec:authorize access="hasRole('AGENT')">
     <td> <a href="${cxt}/Materiel/${dep.idd}">Liste de Materiels</a></td></sec:authorize>
      </tr>
   
   </c:forEach>

   
   </table>
<sec:authorize access="isAuthenticated()" >
   Bienvenue <sec:authentication property="name"/>
   <a href="<c:url value="/logout"/>">Logout</a>
   </sec:authorize>
   
</body>
</html>