package com.lombax.GPA.worker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFormattedTextField;
import javax.swing.SwingWorker;

import com.lombax.GPA.panel.GPACalcFrame;
import com.lombax.GPA.panel.SliderPanel;

public class GPACalcFrameUpdateWorker  extends SwingWorker<Integer, String>{

	private GPACalcFrame gpaCalcFrame;
	private ArrayList<SliderPanel> sliderList;
	private ArrayList<JFormattedTextField> gpaList;
	private ArrayList<JFormattedTextField> creditsList;
	
	public GPACalcFrameUpdateWorker(GPACalcFrame gpaCalcFrame){
		this.gpaCalcFrame = gpaCalcFrame;
		this.sliderList = gpaCalcFrame.sliderList;
		this.gpaList = gpaCalcFrame.gpaList;
		this.creditsList = gpaCalcFrame.creditsList;
	}
	
	@Override
	protected Integer doInBackground(){
		gpaCalcFrame.btnAddCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Clicked add");
				sliderList.add(new SliderPanel());
				refreshCalcFrame(gpaCalcFrame);
			}
		});
		
		gpaCalcFrame.btnRemoveCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Clicked remove");
				System.out.println(sliderList.size());
				if(sliderList.size()>0){
					sliderList.remove(sliderList.size()-1);
					refreshCalcFrame(gpaCalcFrame);
				}
			}
		});
		
		gpaCalcFrame.btnCalculateGpa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
				gpaCalcFrame.lblAvgGPA.setText("Average GPA: "+avgGPA);
			}
		});
		
		return null;
	}
	
	private void refreshCalcFrame(GPACalcFrame gpaCalcFrame){
		gpaCalcFrame.panel.removeAll();
		gpaList.clear();
		creditsList.clear();
		int i = 0;
		for(SliderPanel sliderPanel: sliderList){
			sliderPanel.hasSeparator(sliderList.indexOf(sliderPanel)==sliderList.size()-1?false:true);
			sliderPanel.revalidate();
			sliderPanel.repaint();
			gpaCalcFrame.panel.add(sliderPanel);
			gpaList.add(sliderPanel.txtGPA);
			creditsList.add(sliderPanel.txtCredits);
			i++;
		}
		gpaCalcFrame.panel.validate();
		gpaCalcFrame.scrollPane.validate();
		gpaCalcFrame.panel.repaint();
		gpaCalcFrame.scrollPane.repaint();
	}

}