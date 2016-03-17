package com.lombax.GPA.panel;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
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
	public ArrayList<JFormattedTextField> gpaList = new ArrayList<JFormattedTextField>();
	public ArrayList<JFormattedTextField> creditsList = new ArrayList<JFormattedTextField>();;

	public JButton btnAddCourse = new JButton("Add Course");
	public JButton btnRemoveCourse = new JButton("Remove Course");
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.setMinimumSize(new Dimension(200,200));
		this.setMaximumSize(new Dimension(500,700));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		GridBagConstraints gbc_toolBar = new GridBagConstraints();
		gbc_toolBar.insets = new Insets(0, 0, 5, 0);
		gbc_toolBar.anchor = GridBagConstraints.WEST;
		gbc_toolBar.gridx = 0;
		gbc_toolBar.gridy = 0;
		contentPane.add(toolBar, gbc_toolBar);
		
		btnAddCourse = new JButton("Add Course");
		toolBar.add(btnAddCourse);
		
		btnRemoveCourse = new JButton("Remove Course");
		toolBar.add(btnRemoveCourse);
		
		btnCalculateGpa = new JButton("Calculate GPA");
		toolBar.add(btnCalculateGpa);
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new MigLayout("flowy,fillx", "[grow,fill]", "[]"));
		
		lblAvgGPA = new JLabel("Average GPA: ");
		GridBagConstraints gbc_lblAvgGPA = new GridBagConstraints();
		gbc_lblAvgGPA.anchor = GridBagConstraints.WEST;
		gbc_lblAvgGPA.gridx = 0;
		gbc_lblAvgGPA.gridy = 2;
		contentPane.add(lblAvgGPA, gbc_lblAvgGPA);
	}

}
