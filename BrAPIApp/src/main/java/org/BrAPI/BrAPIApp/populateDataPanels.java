package org.BrAPI.BrAPIApp;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import org.BrAPI.Helper.ColorColumnRenderer;
import org.BrAPI.Helper.Location;
import org.BrAPI.Helper.ProgramList;
import org.BrAPI.Helper.*;
import org.BrAPI.Helper.UserList;

public class populateDataPanels {

	public static void fillProgramListPanel(JTable progListTable) {
		int status;
		ArrayList<ProgramList> programList = new ArrayList<ProgramList>();
		status = org.BrAPI.Helper.Util.getPrograms(programList);
		if (status == 200) {
			DefaultTableModel model = new DefaultTableModel();
			model.setColumnIdentifiers(new Object[] { "Crop", "Name", "uniqueID", "id" });
			for (ProgramList program : programList) {
				model.addRow(new Object[] { program.getCrop().replaceAll("\"", ""), program.getName(),
						program.getUniqueId(), program.getId() });
			}
			progListTable.setModel(model);
			TableColumn tm = progListTable.getColumnModel().getColumn(0);
			tm.setCellRenderer(new ColorColumnRenderer(Color.lightGray, Color.blue));

		} else {
			// TODO
		}
	}

	public static void fillCropListPanel(JTable cropListTable) {
		int status;
		ArrayList<String> cropList = new ArrayList<String>();
		status = org.BrAPI.Helper.Util.getCrops(cropList);
		if (status == 200) {
			DefaultTableModel model = new DefaultTableModel();
			model.setColumnIdentifiers(new Object[] { "Crop Name" });
			for (String crop : cropList) {
				model.addRow(new Object[] { crop });
			}
			cropListTable.setModel(model);

		} else {
			// TODO
		}

	}

	public static void fillUserListPanel(JTable userListTable) {
		int status;
		ArrayList<UserList> userList = new ArrayList<UserList>();
		status = org.BrAPI.Helper.Util.getUsers(userList);
		if (status == 200) {
			DefaultTableModel model = new DefaultTableModel();
			model.setColumnIdentifiers(new Object[] { "username", "id", "role", "email" });
			for (UserList user : userList) {
				model.addRow(new Object[] { user.getUsername(), user.getId(), user.getRole(), user.getEmail() });
			}
			userListTable.setModel(model);
			TableColumn tm = userListTable.getColumnModel().getColumn(0);
			tm.setCellRenderer(new ColorColumnRenderer(Color.lightGray, Color.blue));

		} else {
			// TODO
		}

	}

	public static void fillLocationData(String crop, JTable cropLocationTable) {
		int status;
		ArrayList<Location> locList = new ArrayList<Location>();
		status = org.BrAPI.Helper.Util.getCropLocation(crop, locList);
		if (status == 200) {
			DefaultTableModel model = new DefaultTableModel();
			model.setColumnIdentifiers(new Object[] {"name", "locationDbId", "locationType", "countryName" });
			for (Location loc : locList) {
				model.addRow(new Object[] { loc.getName(), loc.getLocationDbId(), loc.getLocationType(), loc.getCountryName() });
			}
			cropLocationTable.setModel(model);
			TableColumn tm = cropLocationTable.getColumnModel().getColumn(0);
			tm.setCellRenderer(new ColorColumnRenderer(Color.lightGray, Color.blue));

		} else {
			// TODO
		}

	}

	public static void fillTrialSummaryData(String crop, JTable trialSummaryTable) {
		int status;
		ArrayList<TrialSummary> trialSummaryList = new ArrayList<TrialSummary>();
		status = org.BrAPI.Helper.Util.getTrialSummary(crop, trialSummaryList);
		if (status == 200) {
			DefaultTableModel model = new DefaultTableModel();
			model.setColumnIdentifiers(new Object[] {"trialDbId", "trialName", "startDate", "endDate", "active"});
			for (TrialSummary ts : trialSummaryList) {
				model.addRow(new Object[] { ts.getTrialDbId(), ts.getTrialName().replaceAll("\"", ""), ts.getStartDate().replaceAll("\"", ""), ts.getEndDate().replaceAll("\"", ""), ts.getActive()});
			}
			trialSummaryTable.setModel(model);
			TableColumn tm = trialSummaryTable.getColumnModel().getColumn(0);
			tm.setCellRenderer(new ColorColumnRenderer(Color.lightGray, Color.blue));

		} else {
			// TODO
		}

	}
}
