package com.lombax.GPA;

import java.awt.EventQueue;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.lombax.GPA.panel.GPACalcFrame;
import com.lombax.GPA.worker.GPACalcFrameUpdateWorker;

public class GPA {

	private GPACalcFrame gpaCalcFrame;
	
	private GPACalcFrameUpdateWorker gpaUpdateWorker;
	
	private GPA(String[] args){
		
	}
	
	//Pass args to constructor
	public static void main(String[] args) {
		new GPA(args).Run();
	}
	
	//Start the program
		private void Run(){
			
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (ClassNotFoundException | InstantiationException
					| IllegalAccessException | UnsupportedLookAndFeelException exception) {
				exception.printStackTrace();
			}
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						gpaCalcFrame = new GPACalcFrame();
						gpaCalcFrame.setVisible(true);
					} catch (Exception exception) {
						exception.printStackTrace();
					}
					gpaUpdateWorker = new GPACalcFrameUpdateWorker(gpaCalcFrame);
					gpaUpdateWorker.execute();
				}
			});	
			
		}

}
