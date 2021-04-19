<%@page import="java.util.List"%>
<%@ page import="java.util.ArrayList" %>
<%@page import="dev.sgp.entite.Collaborateur"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SGP - App</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap-3.4.1-dist/css/bootstrap.css">
</head>
<body>
<h1>Les collaborateurs</h1>
<ul>
<%
List<Collaborateur> listeCollaborateurs = (List<Collaborateur>) request.getAttribute("listeCollaborateurs");
%>
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
        <%
        for (Collaborateur collaborateur : listeCollaborateurs) {
                out.println("<tr>");
                out.println("<td>" + collaborateur.getMatricule() + "</td>");
                out.println("<td>" + collaborateur.getPrenom() + "</td>");
                out.println("<td>" + collaborateur.getNom() + "</td>");
                out.println("<td>" + collaborateur.getDateDeNaissancetoString() + "</td>");
                out.println("<td>" + collaborateur.getNumeroDeSecuriteSociale() + "</td>");
                out.println("<td>" + collaborateur.getActif() + "</td>");
                out.println("</tr>");
            }
        %>
        </tbody>
    </table>
</body>
</html>