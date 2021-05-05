package com.video.application;

import java.util.Scanner;

import com.video.domain.Usuari;

public class VideoController {

	Scanner tecla = new Scanner(System.in);

	public void login() {
		Usuari usuari = new Usuari("ITAcademy", "1234");
		String usuarilogin;
		String passwordlogin = null;
		int intentu = 0;
		boolean validat = false;

		// demanar usuari i contrasenya per accedir a les funcions de l' App

		System.out.println("Login:");
		do {

			System.out.println("Introdueix Usuari:");
			usuarilogin = tecla.nextLine();
			System.out.println("Introdueix Password:");
			passwordlogin = tecla.nextLine();

			if (usuarilogin.equals(usuari.getUsuari()) && passwordlogin.equals(usuari.getPassword())) {
				System.out.println("Usuari correcte");

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
			System.out.println("Accés autoritzat");
		} else {
			System.out.println("Accés NO AUTORITZAT !!");
		}

	}
}
