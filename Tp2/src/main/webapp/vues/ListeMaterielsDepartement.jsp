<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ taglib prefix="sec"      uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<c:set var="cxt" value="${pageContext.request.contextPath }"/>
<title>Insert title here</title>
</head>
<body>
<h1>Liste des matériels</h1>
 <sec:authorize access="hasRole('AGENT')">
  <a href="${cxt}/addMateriel">Ajouter un materiel</a></sec:authorize>
   <table border="1">
   <c:forEach items="${lm}" var="mat">
   <tr>
      <td>${mat.id}</td>
      <td>${mat.titre}</td>
     <td>${mat.type}</td>
     <td>${mat.num}</td>
     <td>${mat.qte}</td>
     <td>${mat.etat}</td>
      <sec:authorize access="hasRole('ADMIN')">
     <td> <a href="${cxt}/delete/${mat.id}">Supprimer</a></td></sec:authorize>
      </tr>
   
   </c:forEach>
   </table>
   
   <sec:authorize access="isAuthenticated()" >
   Bienvenue <sec:authentication property="name"/>
   <a href="<c:url value="/logout"/>">Logout</a>
   </sec:authorize>
   
   
</body>
</html>