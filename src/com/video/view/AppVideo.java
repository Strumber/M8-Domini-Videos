package com.video.view;

import com.video.application.VideoController;

public class AppVideo {

	public static void main(String[] args) throws Throwable {
		VideoController vc = new VideoController();

		// Login Usuari: ITAcademy password: 1234

		vc.login();

		System.out.println("M8 Exercici Domini Videos-Milestone 1");

		if (vc.isValidat() == true) {

			vc.menuvideo();

		}

		System.out.println("Fi APP ");
	}

}
