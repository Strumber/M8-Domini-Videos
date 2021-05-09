package com.video.application;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import com.video.domain.Tag;
import com.video.domain.Usuari;
import com.video.domain.Video;

public class VideoController {

	Scanner tecla = new Scanner(System.in);
	int id_Video = 1;
	private boolean validat = false;
	ArrayList<Video> llistavideos = new ArrayList<Video>();
	List<Tag> llistatags = new ArrayList<Tag>();

	public boolean isValidat() {
		return validat;
	}

	public void setValidat(boolean validat) {
		this.validat = validat;
	}

	public void login() {
		Usuari usuari = new Usuari("ITAcademy", "1234");
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
			System.out.println("3-Sortir");
			System.out.println("-------------------------------------");

			System.out.println("Selecciona:");

			try {

				opciomenu = tecla.nextInt();
				validat = true;

			} catch (Exception e) {
				System.out.println("Opció incorrecte selecciona 1, 2 o 3");
				tecla.nextLine();
				validat = false;

			}
			validat = false;
			switch (opciomenu) {
			case 1:
				crearVideo();

				break;
			case 2:
				mostrarVideo();
				tecla.nextLine();
				break;

			case 3:
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

	public void crearVideo() throws Exception {
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
			System.out.println("el cap URL no pot estar buit");
			buit = true;
		}

		System.out.println("Introduïr titol del Video");
		try {
			Ivideo = tecla.nextLine();

			if (Ivideo.isEmpty()) {
				throw new camps_buits();
			}
		} catch (camps_buits e) {
			System.out.println("el cap Video no pot estar buit");
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

		if (buit == false) {
			llistavideos.add(new Video(id_Video, Iurl, Ivideo, llistatags));
			id_Video++;
		} else {
			System.out.println("Video no registrat");
		}

		validat = true;
	}

	public void mostrarVideo() {

		for (Video e : llistavideos) {
			System.out.println(
					"Video nº: " + e.getVideo_id() + " Url: " + e.getUrl() + " Titol del Video : " + e.getTitol());
			for (Tag t : llistatags) {

				if (e.getVideo_id() == t.getTag_id()) {

					System.out.println("-Id Video: " + t.getTag_id() + " Tag : " + t.getTags());

				} else {

				}

			}

		}
	}
}
