package com.horowitz.scheduler.table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.horowitz.scheduler.model.Alert;

public class AlertTableModel extends AbstractTableModel {

	private String[] columnNames = { "mute", "When", "Remains", "Comment" };
	private List<Alert> data;

	public AlertTableModel(List<Alert> alerts) {
		this.data = alerts;
		int ind = 1;
		for (Alert alert : alerts) {
			alert.setIndex(ind++);
		}
	}

	@Override
	public int getRowCount() {
		return data.size();
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		if (data.isEmpty()) {
			return Object.class;
		}

		switch (columnIndex) {
//		case 1:
//			// when
//			return 
		case 2:
			// remains
			return Long.class;
		case 3:
			// comment
			return String.class;
		}

		return getValueAt(0, columnIndex).getClass();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Alert alert = data.get(rowIndex);
		Object res = null;
		switch (columnIndex) {
		case 0:
			res = alert.isMute();
			break;

		case 1:
			// when
			res = alert.getWhen();
			break;
		case 2:
			// remains
			long now = System.currentTimeMillis();
			long remains = alert.getWhen().getTime() - now;
			res = remains;
			break;
		case 3:
			// comment
			res = alert.getName();
			break;

		default:
			throw new IllegalArgumentException("Unexpected value: " + columnIndex);
		}
		return res;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex == 0;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Alert alert = data.get(rowIndex);
		if (columnIndex == 0) {
			alert.setMute(!alert.isMute());
			fireTableCellUpdated(rowIndex, columnIndex);
		}

	}

	public void triggerRefresh() {
		fireTableDataChanged();
	}

}
