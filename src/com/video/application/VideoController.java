package com.video.application;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import com.video.domain.Usuari;
import com.video.domain.Video;

public class VideoController {

	Scanner tecla = new Scanner(System.in);
	private boolean validat = true;
	ArrayList<Video> llistavideos = new ArrayList<Video>();

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

	public void menuvideo() {
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
				break;

			case 3:
				return;

			}
			System.out.println("Vols tornar a fer un altre operació(S/N?");
			//tecla.nextLine();
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

		System.out.println("Fi modul");

	}

	public void crearVideo() {
		tecla.nextLine();
		System.out.println("1-Crear Video");
		int id_Video = 0;
		System.out.println("Introduïr URL");
		String Iurl = tecla.nextLine();
		System.out.println("Introduïr titol del Video");
		String Ivideo = tecla.nextLine();
		System.out.println("Introduïr el tag Video");
		String Itag = tecla.nextLine();
		id_Video++;

		llistavideos.add(new Video(id_Video, Iurl, Ivideo, Itag));
		/*
		 * for (Video e : llistavideos) { System.out.println("Video nº: "
		 * +e.getVideo_id()+" Url: "+e.getUrl()+ " Titol del Video : "+e.getTitol()
		 * +" Tags:"+e.getTags()); }
		 */
		validat = true;
	}

	public void mostrarVideo() {

		for (Video e : llistavideos) {
			System.out.println("Video nº: " + e.getVideo_id() + " Url: " + e.getUrl() + " Titol del Video : "
					+ e.getTitol() + " Tags:" + e.getTags());
		}
	}
}
