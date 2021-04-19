package dev.sgp.web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import dev.sgp.entite.Collaborateur;
import dev.sgp.service.CollaborateurService;
import dev.sgp.util.Constantes;

public class NouveauCollaborateurController extends HttpServlet {

	// recuperation du service
	private CollaborateurService collabService = Constantes.COLLAB_SERVICE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
        
		req.getRequestDispatcher("/WEB-INF/views/collab/nouveau.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String nom = req.getParameter("nom");
		String prenom = req.getParameter("prenom");
		String adresse = req.getParameter("adresse");
		String numSecu = req.getParameter("numSecu");
		String bDay = req.getParameter("dateDeNaissance");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.FRENCH);
		Date dateDeNaissance = new Date();
		
		String message = "Les paramètres suivants sont incorrects :";
		boolean isMissingParameter = false;
		
	    if (StringUtils.isBlank(nom)) { message += " nom "; isMissingParameter = true; }  
	    if (StringUtils.isBlank(prenom)) { message += " prenom "; isMissingParameter = true; } 
	    if (StringUtils.isBlank(bDay)) { message += " date de naissance"; isMissingParameter = true; }
	    else {
		    try {
				dateDeNaissance = formatter.parse(req.getParameter("dateDeNaissance"));
			} catch (ParseException e) {
				message += " date de naissance invalide "; 
				isMissingParameter = true;
			} 
	    }
	    if (StringUtils.isBlank(adresse)) { message += " adresse "; isMissingParameter = true; } 
	    if (StringUtils.isBlank(numSecu)) { message += " numéro de sécurité sociale "; isMissingParameter = true; }  
	    else if (numSecu.length() < 15) {
	    	message += " le numéro de sécurité sociale doit être supérieur à 15 caractères "; isMissingParameter = true;
	    }
		
	    if (isMissingParameter) {
	    	resp.sendError(400, message);
	    } else {	
	    	resp.setStatus(201);
	    	resp.setContentType("text/html");
	    	
	    	collabService.sauvegarderCollaborateur(new Collaborateur(nom, prenom, dateDeNaissance, adresse, numSecu));
	    	List<Collaborateur> collaborateurs = collabService.listerCollaborateurs();
			req.setAttribute("listeCollaborateurs", collaborateurs);
	    	req.getRequestDispatcher("/WEB-INF/views/collab/listerCollaborateurs.jsp").forward(req, resp);
		   
	    }
	    
	} 	
	
}
