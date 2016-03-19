package com.lombax.GPA.panel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class AddSliderPanelPanel extends JPanel {
	
	private static final long serialVersionUID = 318140430558041251L;
	
	public JButton btnAddCourse = new JButton("Add New Course");

	public AddSliderPanelPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{180, 0};
		gridBagLayout.rowHeights = new int[]{23, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		GridBagConstraints gbc_btnAddCourse = new GridBagConstraints();
		gbc_btnAddCourse.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAddCourse.anchor = GridBagConstraints.NORTH;
		gbc_btnAddCourse.gridx = 0;
		gbc_btnAddCourse.gridy = 0;
		add(btnAddCourse, gbc_btnAddCourse);

	}

}
