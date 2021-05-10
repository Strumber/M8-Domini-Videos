package com.video.application;

import java.util.Scanner;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import com.video.domain.Tag;
import com.video.domain.Usuari;
import com.video.domain.Video;

public class VideoController {

	Scanner tecla = new Scanner(System.in);
	int id_Video = 1;
	private boolean validat = false;
	ArrayList<Video> llistavideos = new ArrayList<Video>();
	List<Tag> llistatags = new ArrayList<Tag>();
	// format Data a mostrar
	SimpleDateFormat Datallarga = new SimpleDateFormat("hh:mm:ss a dd-MMM-yyyy");
	SimpleDateFormat Datacurta = new SimpleDateFormat("dd-MMM-yyyy");
	SimpleDateFormat hora = new SimpleDateFormat("hh:mm:ss");

	public boolean isValidat() {
		return validat;
	}

	public void setValidat(boolean validat) {
		this.validat = validat;
	}

	public void login() {

		Usuari usuari = new Usuari();// "ITAcademy", "1234"

		String usuarilogin;
		String passwordlogin = null;
		int intentu = 0;

		// demanar usuari i contrasenya per accedir a les funcions de l' App

		System.out.println("Login:");
		do {

			System.out.println("Introdueix Usuari:");
			usuarilogin = tecla.nextLine();
			System.out.println("Introdueix Password:");
			passwordlogin = tecla.nextLine();

			if (usuarilogin.equals(usuari.getUsuari()) && passwordlogin.equals(usuari.getPassword())) {
				System.out.println("Accés Autoritzat ");

				Usuari verificat = new Usuari(usuarilogin, usuari.getNom(), usuari.getCognom(), passwordlogin,
						usuari.getData_registre());
				System.out.println("hola " + verificat);

				validat = true;

			} else {
				intentu++;
				System.out.println("Usuari o password incorrectes, et queden " + (3 - intentu) + " intent/s");

			}

		} while (!validat && intentu < 3);
		if (validat = true && intentu < 3) {
			System.out.println("----------------------");
		} else {
			System.out.println("Accés NO AUTORITZAT !!");
		}

	}

	public void menuvideo() throws Exception {
		boolean repetir = false;
		int opciomenu = 0;
		do {
			System.out.println("-------------------------------------");
			System.out.println("Escull una opcio");
			System.out.println("-------------------------------------");
			System.out.println("1-Crear Video");
			System.out.println("2-LListat de videos");
			System.out.println("3-Estat dels videos");
			System.out.println("4-Sortir");
			System.out.println("-------------------------------------");

			System.out.println("Selecciona:");

			try {

				opciomenu = tecla.nextInt();
				validat = true;

			} catch (Exception e) {
				System.out.println("Opció incorrecte selecciona 1, 2 , 4 o 4");
				tecla.nextLine();
				validat = false;

			}
			validat = false;
			switch (opciomenu) {
			case 1:
				crearvideo();

				break;
			case 2:
				mostrarVideo();
				tecla.nextLine();
				break;

			case 3:
				estatvideo();
				tecla.nextLine();
				break;
			case 4:

				return;

			}
			System.out.println("Vols tornar a fer un altre operació (S/N?");

			String opcio = tecla.nextLine();
			if (opcio.equalsIgnoreCase("s")) {
				repetir = false;

			} else if (opcio.equalsIgnoreCase("n")) {
				repetir = true;
			} else {
				System.out.println("L' opcio escollida es incorrecte");
				repetir = false;
			}

		} while (!repetir);

	}

	public void crearvideo() throws Exception {
		String Iurl = null;
		String Ivideo = null;
		boolean buit = false;
		tecla.nextLine();
		System.out.println("1-Crear Video");

		System.out.println("Introduïr URL");
		try {
			Iurl = tecla.nextLine();

			if (Iurl.isEmpty()) {
				throw new camps_buits();

			}
		} catch (camps_buits e) {
			System.out.println("el camp URL no pot estar buit");
			buit = true;
		}

		System.out.println("Introduïr titol del Video");
		try {
			Ivideo = tecla.nextLine();

			if (Ivideo.isEmpty()) {
				throw new camps_buits();
			}
		} catch (camps_buits e) {
			System.out.println("el camp Video no pot estar buit");
			buit = true;

		}

		// Afegir tags video
		String noutag;

		do {

			System.out.println("Vols introduïr tag per al video : " + Ivideo + " S/N");
			noutag = tecla.nextLine();

			if (noutag.equalsIgnoreCase("s")) {
				String altretag;
				do {
					System.out.println("Introduïr el tag del Video");
					String Itag = tecla.nextLine();
					Tag newtag = new Tag(id_Video, Itag);
					llistatags.add(newtag);
					System.out.println("Tag emmagatzemat, vols incloure un altre tag al video ? (s/n)");
					altretag = tecla.nextLine();
					if (altretag.equalsIgnoreCase("n")) {
						System.out.println("ok");
						noutag = "n";
					} else if (altretag.equalsIgnoreCase("s")) {
						System.out.println("Nou tag per al video : " + Ivideo);
					} else {
						System.out.println("Has escollit una opcio incorrecte !!");
					}
				} while (altretag.equalsIgnoreCase("s"));

			} else if (noutag.equalsIgnoreCase("n")) {
				System.out.println("ok");
			} else {
				System.out.println("Has escollit una opcio incorrecte !!");
			}
		} while (noutag.equalsIgnoreCase("s"));

		// Data Registre

		Date registre_data = new Date();

		System.out.println("Video Creat :" + Datallarga.format(registre_data)); 

		if (buit == false) {
			llistavideos.add(new Video(id_Video, Iurl, Ivideo, llistatags, registre_data));
			id_Video++;
		} else {
			System.out.println("Video no registrat");
		}

		validat = true;
	}

	public void estatvideo() {

		Date hora_actual = new Date();
		long actual = (hora_actual.getTime()) / 1000; // Hora actual en segons

		for (Video e : llistavideos) {

			System.out.println("Video nº: " + e.getVideo_id() + " Titol del Video : " + e.getTitol() + "\n ------->");
			System.out.println(" Hora Actual :" + hora.format(hora_actual));
			System.out.println(" Hora Registre :" + hora.format(e.getData_pujada()));
			long reg = (e.getData_pujada().getTime()) / 1000; // Hora de registre en segons
			long diferencia = actual - reg;
			System.out.print("Diferencia en segons : " + diferencia + "\n ESTAT :");
			if (diferencia < 30) { // temps inferior a 30 segons
				System.out.println("-->Uploading");

			} else if (diferencia < 30 || diferencia < 60) { // temps entre 30 i 60 segons
				System.out.println("-->Verifying");
			} else {
				System.out.println("-->PUBLIC");// temps superior a 60 segons
			}

		}

	}

	public void mostrarVideo() {

		for (Video e : llistavideos) {
			System.out.println("Video nº: " + e.getVideo_id() + " Url: " + e.getUrl() + " Titol del Video : "
					+ e.getTitol() + "\n video creat :" + Datacurta.format(e.getData_pujada()));
			System.out.println(" Hora :" + hora.format(e.getData_pujada()));
			for (Tag t : llistatags) {

				if (e.getVideo_id() == t.getTag_id()) {

					System.out.println("-Id Video: " + t.getTag_id() + " Tag : " + t.getTags() + "\n");

				} else {

				}

			}

		}
	}
}
