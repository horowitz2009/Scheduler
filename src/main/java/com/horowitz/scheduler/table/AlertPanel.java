package com.horowitz.scheduler.table;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.horowitz.scheduler.model.Alert;

public class AlertPanel extends JPanel {
	private JTable table;
	
	
	public AlertPanel(List<Alert> alerts) {
		super(new BorderLayout());
		final AlertTableModel model = new AlertTableModel(alerts);
		table = new JTable(model);
		table.setAutoCreateRowSorter(true);
		table.setFocusable(false);
		table.setRowSelectionAllowed(false);
		
		table.setDefaultRenderer(Date.class, new WhenRenderer());
		table.setDefaultRenderer(Long.class, new RemainsRenderer());
		
		
		TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
		table.setRowSorter(sorter);
		
		List<RowSorter.SortKey> sortKeys = new ArrayList<>();
		 
		int columnIndexToSort = 2;
		sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.ASCENDING));
		 
		sorter.setSortKeys(sortKeys);
		sorter.sort();
		
		
		add (new JScrollPane(table), BorderLayout.CENTER);
		
		Timer timer = new Timer(true);
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				//System.err.println(new Date());
				model.triggerRefresh();
				
			}
		}, 2000, 1000);
	}

}
