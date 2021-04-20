<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dev.sgp.entite.Collaborateur"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SGP - App</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap-3.4.1-dist/css/bootstrap.css">
</head>
<body>
<h1>Les collaborateurs</h1>
 <table class="table table-bordered">
        <thead class="thead-light">
        <tr>
            <th scope="col">Matricule</th>
            <th scope="col">Prénom</th>
            <th scope="col">Nom</th>
            <th scope="col">Date de naissance</th>
            <th scope="col">Numéro de securité sociale</th>
            <th scope="col">Actif</th>
        </tr>
        </thead>
        <tbody>
         <c:forEach items="${listeCollaborateurs}" var="collaborateur" >
        <tr>
            <td> <c:out value="${collaborateur.getMatricule()}"/> </td>
            <td> <c:out value="${collaborateur.getPrenom()}"/> </td>
            <td> <c:out value="${collaborateur.getNom()}"/> </td>
            <td> <c:out value="${collaborateur.getDateDeNaissancetoString()}"/> </td>
            <td> <c:out value="${collaborateur.getNumeroDeSecuriteSociale()}"/> </td>
            <td> <c:out value="${collaborateur.getActif()}"/> </td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>