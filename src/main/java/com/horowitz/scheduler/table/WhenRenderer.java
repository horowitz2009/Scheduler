package com.horowitz.scheduler.table;

import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class WhenRenderer extends JLabel implements TableCellRenderer {
private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		
		Date when = (Date) value;
		setText(sdf.format(when));
		return this;
	}

}
