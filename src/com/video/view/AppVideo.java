package com.video.view;

import com.video.application.VideoController;

public class AppVideo {

	public static void main(String[] args) {
		VideoController vc = new VideoController();

		// Login Usuari: ITAcademy password: 1234

		vc.login();
		
		System.out.println("M8 Exercici Domini Videos");
				
		if (vc.isValidat() == true) {

			vc.menuvideo();

		} else {
			//System.out.println("Fi APP");
		}
		System.out.println("Fi APP ");
	}
	
}
