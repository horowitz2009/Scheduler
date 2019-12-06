package com.horowitz.scheduler.table;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import com.horowitz.commons.DateUtils;

public class RemainsRenderer extends JLabel implements TableCellRenderer {

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {

		Long remains = (Long) value;
		setText(DateUtils.fancyTime2(remains, true));
		return this;
	}

}
