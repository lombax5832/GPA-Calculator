package com.lombax.GPA.util;

import java.util.ArrayList;

import com.lombax.GPA.panel.SliderPanel;

public class GPAMath {

	public GPAMath(){
	}
	
	public static float calculateGpa(ArrayList<SliderPanel> sliderList) {
		System.out.println("Clicked calculate GPA");
		float totalEarnedGPA = 0.0F;
		float totalPossibleCredits = 0.0F;
		float avgGPA = 0.0F;
		for(SliderPanel sliderPanel: sliderList){
			totalEarnedGPA+=Float.parseFloat(sliderPanel.txtCredits.getText())*Float.parseFloat(sliderPanel.txtGPA.getText());
			totalPossibleCredits+=Float.parseFloat(sliderPanel.txtCredits.getText());
		}
		avgGPA=totalEarnedGPA/totalPossibleCredits;
		avgGPA=Math.round(avgGPA*100F)/100F;
		return avgGPA;
	}

}
