package org.BrAPI.BrAPIApp;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class CreateSubPanels {


	static JPanel createLocationPanel() {
		final JTable cropLocationTable = new JTable();
		JPanel locationPanel = new JPanel();
		locationPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblCropName = new JLabel("Crop Name");
		lblCropName.setFont(new Font("Tahoma", Font.BOLD, 20));
		locationPanel.add(lblCropName);

		final JTextField locationCropName = new JTextField();
		locationPanel.add(locationCropName);
		locationCropName.setColumns(10);

		JButton btnLocSubmit = new JButton("Submit");
		btnLocSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				populateDataPanels.fillLocationData(locationCropName.getText(), cropLocationTable);
			}
		});
		locationPanel.add(btnLocSubmit);

		JButton btnLocPrevious = new JButton("Previous");
		locationPanel.add(btnLocPrevious);

		JButton btnLocNext = new JButton("Next");
		locationPanel.add(btnLocNext);

		JScrollPane scrollPane = new JScrollPane(cropLocationTable);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setPreferredSize(new Dimension(1000, 696));
		locationPanel.add(scrollPane);

		return locationPanel;
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	static JPanel createTrialSummaryPanel() {
		final JTable trialSummaryTable = new JTable();
		JPanel trialPanel = new JPanel();
		trialPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		final JLabel lblCropName = new JLabel("Crop Name");
		lblCropName.setFont(new Font("Tahoma", Font.BOLD, 20));
		trialPanel.add(lblCropName);
		
		final JTextField cropName = new JTextField();
		trialPanel.add(cropName);
		cropName.setColumns(10);
		
		JButton btnTrialSubmit = new JButton("Submit");
		btnTrialSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				populateDataPanels.fillTrialSummaryData(cropName.getText(), trialSummaryTable);
			}
		});
		
		trialPanel.add(btnTrialSubmit);
		
		JButton btnLocPrevious = new JButton("Previous");
		trialPanel.add(btnLocPrevious);

		JButton btnLocNext = new JButton("Next");
		trialPanel.add(btnLocNext);

		JScrollPane scrollPane = new JScrollPane(trialSummaryTable);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setPreferredSize(new Dimension(1000, 696));
		trialPanel.add(scrollPane);
		return trialPanel;
	}
}
