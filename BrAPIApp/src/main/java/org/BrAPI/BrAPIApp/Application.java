package org.BrAPI.BrAPIApp;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import javax.swing.JLabel;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.ImageIcon;

public class Application {

	private JFrame frame;
	JPanel loginPanel, mainPanel, sidePanel, contentPanel;
	JPanel programListPanel, cropListPanel, userListPanel, locationPanel, trialPanel;
	ArrayList<JPanel> panelList = new ArrayList<JPanel>();
	JLabel lblBmsDashboard, bmsLogoLabel, icrisatLogoLabel;
	JPasswordField passwordField;
	JTextField userNameField;
	JButton loginBtnSubmit;
	JTable progListTable, cropListTable, userListTable;

	/**
	 * * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Application window = new Application();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Application() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1200, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));

		getPanels();

		loginBtnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginPanel.setVisible(false);
				mainPanel.setVisible(true);
				contentPanel.setVisible(true);
				int status = org.BrAPI.Helper.Util.authenticate(userNameField.getText(),
						new String(passwordField.getPassword()));
				// Has auth succeeded
				if (status == 200) {
					populateDataPanels.fillProgramListPanel(progListTable);
					populateDataPanels.fillCropListPanel(cropListTable);
					populateDataPanels.fillUserListPanel(userListTable);
				} else {
					// TODO
				}
			}
		});
	}

	public void getPanels() {
		loginPanel = new JPanel();
		loginPanel.setLayout(null);
		frame.getContentPane().add(loginPanel, "name_953582053256428");

		mainPanel = new JPanel();
		mainPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		frame.getContentPane().add(mainPanel, "name_952170427650952");
		mainPanel.setLayout(null);

		sidePanel = new JPanel();
		sidePanel.setBounds(0, 0, 150, 755);
		mainPanel.add(sidePanel);

		contentPanel = new JPanel();
		contentPanel.setBounds(150, 0, 1043, 755);
		mainPanel.add(contentPanel);
		contentPanel.setLayout(new CardLayout(0, 0));

		createSubPanels();

		addButtonToSidePanel();

		getLoginPanel(loginPanel);

		addbmsLogo();
		addIcrisatLogo();
	}

	public void createSubPanels() {
		createCropListPanel();
		createProgramListPanel();
		createUserPanel();
		createLocationPanel();
		createTrialSummaryPanel();
	}

	public void addButtonToSidePanel() {
		addButtonToSidePanel("Crop List", cropListPanel);
		addButtonToSidePanel("Program List", programListPanel);
		addButtonToSidePanel("User List", userListPanel);
		addButtonToSidePanel("Crop Location", locationPanel);
		addButtonToSidePanel("Trial Summary", trialPanel);
	}

	private void addButtonToSidePanel(String btnText, final JPanel reqPanel) {
		JButton btn = new JButton(btnText);
		btn.setPreferredSize(new Dimension(120, 30));
		sidePanel.add(btn);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (JPanel panel : panelList) {
					panel.setVisible(false);
				}
				reqPanel.setVisible(true);
			}
		});
	}

	public void addIcrisatLogo() {
		icrisatLogoLabel = new JLabel("");
		icrisatLogoLabel.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\SBDM\\Downloads\\icrisat-logo-2016-new.png")
				.getImage().getScaledInstance(150, 50, Image.SCALE_DEFAULT)));
		icrisatLogoLabel.setBounds(966, 27, 167, 50);
		loginPanel.add(icrisatLogoLabel);
	}

	public void addbmsLogo() {
		bmsLogoLabel = new JLabel("");
		bmsLogoLabel.setIcon(new ImageIcon("C:\\Users\\SBDM\\Downloads\\ibp_logo2.jpg"));
		bmsLogoLabel.setBounds(458, 105, 95, 110);
		loginPanel.add(bmsLogoLabel);
	}

	/**
	 * Create location Panel
	 */
	private void createTrialSummaryPanel() {
		trialPanel = CreateSubPanels.createTrialSummaryPanel();
		panelList.add(trialPanel);
		contentPanel.add(trialPanel);
	}

	/**
	 * Create location Panel
	 */
	private void createLocationPanel() {
		locationPanel = CreateSubPanels.createLocationPanel();
		panelList.add(locationPanel);
		contentPanel.add(locationPanel);
	}

	/**
	 * Designs user list panel.
	 */
	public void createUserPanel() {
		userListPanel = new JPanel();
		userListPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		userListTable = new JTable();
		JScrollPane scrollPane = new JScrollPane(userListTable);
		scrollPane.setPreferredSize(new Dimension(852, 702));
		userListTable.setBackground(Color.WHITE);
		userListTable.getTableHeader().setForeground(Color.BLUE);
		userListTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 25));
		userListTable.setFont(new Font("Times New Roman", Font.PLAIN, 20));

		userListTable.setRowHeight(30);
		userListPanel.add(scrollPane);
		panelList.add(userListPanel);

		contentPanel.add(userListPanel);
	}

	/*
	 * Designs program list panel.
	 */
	public void createProgramListPanel() {
		programListPanel = new JPanel();
		programListPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		progListTable = new JTable();
		JScrollPane scrollPane = new JScrollPane(progListTable);
		scrollPane.setPreferredSize(new Dimension(852, 702));
		progListTable.setBackground(Color.WHITE);
		progListTable.getTableHeader().setForeground(Color.BLUE);
		progListTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 25));
		progListTable.setFont(new Font("Times New Roman", Font.PLAIN, 20));

		progListTable.setRowHeight(30);
		programListPanel.add(scrollPane);
		panelList.add(programListPanel);

		contentPanel.add(programListPanel);
	}

	/**
	 * Designs crop list panel.
	 */
	public void createCropListPanel() {
		cropListPanel = new JPanel();
		cropListPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		cropListTable = new JTable();
		cropListTable.setBackground(Color.WHITE);
		cropListTable.getTableHeader().setForeground(Color.BLUE);
		cropListTable.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		JScrollPane scrollPane = new JScrollPane(cropListTable);
		scrollPane.setPreferredSize(new Dimension(451, 356));
		cropListTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 25));
		cropListTable.setRowHeight(40);
		cropListPanel.add(scrollPane);
		panelList.add(cropListPanel);

		contentPanel.add(cropListPanel);
	}

	/*
	 * Generates login panel
	 */
	private void getLoginPanel(JPanel panelLogin) {
		loginPanel.setLayout(null);

		lblBmsDashboard = new JLabel("BMS Dashboard");
		lblBmsDashboard.setIcon(null);
		lblBmsDashboard.setHorizontalAlignment(SwingConstants.CENTER);
		lblBmsDashboard.setForeground(Color.BLUE);
		lblBmsDashboard.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBmsDashboard.setBounds(567, 105, 273, 95);
		panelLogin.add(lblBmsDashboard);

		JLabel UserName = new JLabel("UserName");
		UserName.setFont(new Font("Times New Roman", Font.BOLD, 18));
		UserName.setBounds(458, 327, 101, 35);
		panelLogin.add(UserName);

		userNameField = new JTextField();
		userNameField.setBounds(619, 327, 160, 31);
		panelLogin.add(userNameField);
		userNameField.setColumns(10);

		JLabel password = new JLabel("Password");
		password.setFont(new Font("Times New Roman", Font.BOLD, 18));
		password.setBounds(458, 413, 101, 28);
		panelLogin.add(password);

		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setBounds(619, 410, 160, 31);
		panelLogin.add(passwordField);

		loginBtnSubmit = new JButton("Submit");
		loginBtnSubmit.setBounds(523, 492, 129, 41);
		panelLogin.add(loginBtnSubmit);
	}

}
