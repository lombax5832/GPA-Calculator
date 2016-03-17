package com.lombax.GPA.panel;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

/**
 * @author Alexei
 *
 * Class for each Panel that is added when the user clicks add course
 */
public class SliderPanel extends JPanel {
	
	private static final long serialVersionUID = -1510799478198099168L;
	
	private JTextField txtClassName;
	
	public JFormattedTextField txtGPA;
	public JFormattedTextField txtCredits;
	
	public SliderPanel() {
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		txtClassName = new JTextField();
		txtClassName.setHorizontalAlignment(SwingConstants.CENTER);
		txtClassName.setText("Class Name");
		GridBagConstraints gbc_txtClassName = new GridBagConstraints();
		gbc_txtClassName.gridwidth = 2;
		gbc_txtClassName.insets = new Insets(5, 0, 5, 0);
		gbc_txtClassName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtClassName.gridx = 0;
		gbc_txtClassName.gridy = 0;
		add(txtClassName, gbc_txtClassName);
		txtClassName.setColumns(10);
		
		JLabel lblGPA = new JLabel("GPA");
		GridBagConstraints gbc_lblGPA = new GridBagConstraints();
		gbc_lblGPA.anchor = GridBagConstraints.EAST;
		gbc_lblGPA.insets = new Insets(0, 0, 5, 5);
		gbc_lblGPA.gridx = 0;
		gbc_lblGPA.gridy = 1;
		add(lblGPA, gbc_lblGPA);
		
		txtGPA = new JFormattedTextField(createFormatter("#.##"));
		txtGPA.setText("GPA");
		GridBagConstraints gbc_txtGPA = new GridBagConstraints();
		gbc_txtGPA.insets = new Insets(0, 0, 5, 0);
		gbc_txtGPA.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtGPA.gridx = 1;
		gbc_txtGPA.gridy = 1;
		add(txtGPA, gbc_txtGPA);
		
		JLabel lblCredits = new JLabel("Credits");
		GridBagConstraints gbc_lblCredits = new GridBagConstraints();
		gbc_lblCredits.anchor = GridBagConstraints.EAST;
		gbc_lblCredits.insets = new Insets(0, 0, 5, 5);
		gbc_lblCredits.gridx = 0;
		gbc_lblCredits.gridy = 2;
		add(lblCredits, gbc_lblCredits);
		
		txtCredits = new JFormattedTextField(createFormatter("#.#"));
		txtCredits.setText("Credits");
		GridBagConstraints gbc_txtCredits = new GridBagConstraints();
		gbc_txtCredits.insets = new Insets(0, 0, 5, 0);
		gbc_txtCredits.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCredits.gridx = 1;
		gbc_txtCredits.gridy = 2;
		add(txtCredits, gbc_txtCredits);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator.gridwidth = 2;
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 3;
		add(separator, gbc_separator);

	}
	
	public static MaskFormatter createFormatter(String s){
		MaskFormatter formatter = null;
		try {
			formatter = new MaskFormatter(s);
			formatter.setPlaceholderCharacter('0');
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return formatter;
	}

}
