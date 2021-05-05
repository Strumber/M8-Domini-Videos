package com.video.domain;

public class Usuari {
	private String usuar;
	private String nom;
	private String cognom;
	private String password;
	private String data_registre;
	
	public Usuari() {
		
	}
	
	public Usuari(String usuari,String password) {
		
		this.usuar = "ITAcademy";
		this.password = "1234";
	}
	public Usuari(String usuari, String nom, String cognom, String password, String data_registre) {
		
		this.usuar = "ITAcademy";
		this.nom = "David";
		this.cognom = "Gonzalez";
		this.password = "1234";
		this.data_registre = "21/02/2021";
	}
	public String getUsuari() {
		return usuar;
	}
	public void setUsuari(String usuari) {
		usuar = usuari;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getCognom() {
		return cognom;
	}
	public void setCognom(String cognom) {
		this.cognom = cognom;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getData_registre() {
		return data_registre;
	}
	public void setData_registre(String data_registre) {
		this.data_registre = data_registre;
	}
	@Override
	public String toString() {
		return "Usuari [Usuari=" + usuar + ", nom=" + nom + ", cognom=" + cognom + ", password=" + password
				+ ", data_registre=" + data_registre + "]";
	}
	
}
