package dev.sgp.entite;

import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Locale;

public class Collaborateur {
	
	private static int id;
	private String matricule;
	private String nom;
	private String prenom;
	private Date dateDeNaissance;
	private String adresse;
	private String numeroDeSecuriteSociale;
	private String emailPro;
	private String photo;
	private ZonedDateTime dateHeureCreation;
	private Boolean	actif;
	
	
	
	public Collaborateur(String nom, String prenom, Date dateDeNaissance, String adresse, String numeroDeSecuriteSociale) {
		this.matricule = String.valueOf(id++);
		this.nom = nom;
		this.prenom = prenom;
		this.dateDeNaissance = dateDeNaissance;
		this.adresse = adresse;
		this.emailPro = prenom+"."+nom+"@societe.com";
		this.dateHeureCreation = ZonedDateTime.now();
		this.numeroDeSecuriteSociale = numeroDeSecuriteSociale;
		this.actif = true;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}
	
	public String getDateDeNaissancetoString() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.FRENCH);
		return formatter.format(dateDeNaissance);
	}
	
	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getNumeroDeSecuriteSociale() {
		return numeroDeSecuriteSociale;
	}
	public void setNumeroDeSecuriteSociale(String numeroDeSecuriteSociale) {
		this.numeroDeSecuriteSociale = numeroDeSecuriteSociale;
	}
	public String getEmailPro() {
		return emailPro;
	}
	public void setEmailPro(String emailPro) {
		this.emailPro = emailPro;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Boolean getActif() {
		return actif;
	}
	public void setActif(Boolean actif) {
		this.actif = actif;
	}
	public ZonedDateTime getDateHeureCreation() {
		return dateHeureCreation;
	}


}
