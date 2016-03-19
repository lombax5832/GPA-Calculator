package com.lombax.GPA.worker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.SwingWorker;

import com.lombax.GPA.panel.AddSliderPanelPanel;
import com.lombax.GPA.panel.GPACalcFrame;
import com.lombax.GPA.panel.SliderPanel;
import com.lombax.GPA.util.GPAMath;

public class GPACalcFrameUpdateWorker  extends SwingWorker<Integer, String>{

	private GPACalcFrame gpaCalcFrame;
	private ArrayList<SliderPanel> sliderList;
	
	final private AddSliderPanelPanel addPanel = new AddSliderPanelPanel();
	
	public GPACalcFrameUpdateWorker(GPACalcFrame gpaCalcFrame){
		this.gpaCalcFrame = gpaCalcFrame;
		this.sliderList = gpaCalcFrame.sliderList;
	}
	
	@Override
	protected Integer doInBackground(){
		
		addPanel.btnAddCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Clicked add");
				final SliderPanel sliderPanel = new SliderPanel(sliderList.size());
				sliderPanel.btnClosePanel.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						sliderPanel.removePanel(sliderList);
						refreshCalcFrame(gpaCalcFrame);
					}
				});
				sliderPanel.txtCredits.addKeyListener(new KeyAdapter() {
					@Override
					public void keyReleased(KeyEvent e) {
//						System.out.println(e.getKeyChar()=='\n');
						gpaCalcFrame.lblAvgGPA.setText("Average GPA: " + GPAMath.calculateGpa(sliderList));
					}
				});
				sliderPanel.txtGPA.addKeyListener(new KeyAdapter() {
					@Override
					public void keyReleased(KeyEvent e) {
//						System.out.println(e.getKeyChar()=='\n');
						gpaCalcFrame.lblAvgGPA.setText("Average GPA: " + GPAMath.calculateGpa(sliderList));
					}
				});
				sliderList.add(sliderPanel);
				refreshCalcFrame(gpaCalcFrame);
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
		
		refreshCalcFrame(gpaCalcFrame);
		
		return null;
	}
	
	private void refreshCalcFrame(GPACalcFrame gpaCalcFrame){
		gpaCalcFrame.panel.removeAll();
		int i = 0;
		for(SliderPanel sliderPanel: sliderList){
			sliderPanel.index=i;
			sliderPanel.revalidate();
			sliderPanel.repaint();
			gpaCalcFrame.panel.add(sliderPanel);
			i++;
		}
		gpaCalcFrame.panel.add(addPanel);
		gpaCalcFrame.panel.validate();
		gpaCalcFrame.scrollPane.validate();
		gpaCalcFrame.panel.repaint();
		gpaCalcFrame.scrollPane.repaint();
	}

}