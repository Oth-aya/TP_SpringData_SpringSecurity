<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
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
<h1>Ajouter un matériel</h1>
   <form:form action="${cxt}/saveMateriel" method="post" modelAttribute="mat">
   <p> Titre: <form:input path="titre"/></p>
   <p> Type: <form:select path="type" >
                     <form:option value="Reseaux">Réseaux</form:option>
                     <form:option value="Info">Info</form:option>
                     <form:option value="Telecom">Telecom</form:option>
                     <form:option value="Electrique">Electrique</form:option>
                     <form:option value="Civil">Civil</form:option>
                     </form:select>
   </p>
   
   <p> Série: <form:input path="num"/></p>
   <p> Quantite: <form:input path="qte"/></p>
   <p> Etat:  <form:select path="etat" >
                     <form:option value="fonctionnel">Fonctionnel</form:option>
                     <form:option value="defectueux">défectueux</form:option>
          </form:select>               
   </p>
   
   <p> Département:  <form:select path="dep.idd" items="${ld}" itemLabel="titre" itemValue="idd" /></p>
                     
                
  
   <input type="submit" value="Ajouter">
</form:form>
<sec:authorize access="isAuthenticated()" >
   Bienvenue <sec:authentication property="name"/>
   <a href="<c:url value="/logout"/>">Logout</a>
   </sec:authorize>
   


</body>
</html>