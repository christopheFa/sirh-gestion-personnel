<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>SGP - App</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap-3.4.1-dist/css/bootstrap.css">
</head>
	<body>
         <div class="container">
             <h1>Nouveau Collaborateur</h1>
             <form method="post" action="<%= request.getContextPath() %>/collaborateurs/nouveau">
               <fieldset>
                 <legend>Création d'un collaborateur</legend>
                 
                 <div class="form-group">
                   <label for="nom">Nom</label>
                   <input type="text" class="form-control" name="nom" placeholder="Nom">
                   
                 </div>
                 
                 <div class="form-group">
                   <label for="prenom">Prénom</label> 
                   <input type="text" class="form-control" name="prenom" placeholder="prénom">              
                 </div>
                 
                  <div class="form-group">
				    <label for="dateDeNaissance"> Date de Naissance</label>
				    <input type="date" class="form-control" name="dateDeNaissance" placeholder="01/01/1980">
				  </div>
                 
                 <div class="form-group">
                   <label for="adresse">Adresse</label>
                   <textarea class="form-control" name="adresse" rows="3"></textarea>                
                 </div>
                 
                 <div class="form-group">
                   <label for="nom">Numéro de sécurité sociale</label>
                   <input type="text" class="form-control" name="numSecu" placeholder="174931516561416">                 
                 </div>
                 
                 <button class="btn btn-primary" type="submit">Créer</button>
				
               </fieldset>
             </form>
         </div>
    </body>
</html>
</html>