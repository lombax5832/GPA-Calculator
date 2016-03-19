package com.lombax.GPA.panel;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

/**
 * @author Alexei
 *
 * The main window for displaying the GPA calculator
 */
public class GPACalcFrame extends JFrame {
	private static final long serialVersionUID = -3206084337896393746L;

	private JPanel contentPane;
	
	public ArrayList<SliderPanel> sliderList = new ArrayList<SliderPanel>();
	
	public JButton btnCalculateGpa = new JButton("Calculate GPA");
	
	public JPanel panel;
	public JScrollPane scrollPane;
	public JLabel lblAvgGPA;
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GPACalcFrame frame = new GPACalcFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GPACalcFrame() {
		setTitle("Gpa Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.setMinimumSize(new Dimension(300, 200));
		this.setMaximumSize(new Dimension(500,700));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new MigLayout("flowy,fillx", "[grow,fill]", "[]"));
		
		lblAvgGPA = new JLabel("Average GPA: ");
		GridBagConstraints gbc_lblAvgGPA = new GridBagConstraints();
		gbc_lblAvgGPA.anchor = GridBagConstraints.WEST;
		gbc_lblAvgGPA.gridx = 0;
		gbc_lblAvgGPA.gridy = 1;
		contentPane.add(lblAvgGPA, gbc_lblAvgGPA);
	}

}
