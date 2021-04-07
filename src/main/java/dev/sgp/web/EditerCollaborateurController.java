package dev.sgp.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

public class EditerCollaborateurController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String matricule = req.getParameter("matricule");
		
		 if (StringUtils.isBlank(matricule)) {
			 resp.sendError(400, "Un matricule est attendu");
		 } else {
			 resp.setStatus(200);
			 resp.setContentType("text/html");
			 // code HTML ecrit dans le corps de la reponse
			 resp.getWriter().write("<h1>Edition de collaborateur</h1>"
			 + "<br>"
			 + "<p>Matricule : "+ matricule + "</p>");
		 }
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String matricule = req.getParameter("matricule");
		String titre = req.getParameter("titre");
		String nom = req.getParameter("nom");
		String prenom = req.getParameter("prenom");
		String message = "Les paramètres suivants sont incorrects :";
		boolean isMissingParameter = false;
		
		if (StringUtils.isBlank(matricule)) { message += " matricule "; isMissingParameter = true; } 
	    if (StringUtils.isBlank(titre)) { message += " titre "; isMissingParameter = true; }  
	    if (StringUtils.isBlank(nom)) { message += " nom "; isMissingParameter = true; }  
	    if (StringUtils.isBlank(prenom)) { message += " prenom "; isMissingParameter = true; }  
		
	    if (isMissingParameter) {
	    	resp.sendError(400, message);
	    } else {	
	    	resp.setStatus(201);
	    	resp.setContentType("text/html");
		    // code HTML ecrit dans le corps de la reponse
		    resp.getWriter().write("<h1>Creation d&apos;un collaborateur avec les informations suivantes : </h1>"
		    + "<ul>"
		    + "<li>matricule : "+ matricule + "</li>"
		    + "<li>titre : "+ titre + "</li>"
		    + "<li>nom : "+ nom + "</li>"
		    + "<li>prenom : "+ prenom + "</li>"
		    + "</ul>");
	    }
	    
	} 
}
