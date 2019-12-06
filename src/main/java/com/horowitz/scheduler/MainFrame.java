package com.horowitz.scheduler;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import com.horowitz.scheduler.model.Alert;
import com.horowitz.scheduler.table.AlertPanel;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public MainFrame() throws HeadlessException {
		super();
		setBounds(100, 100, 700, 300);
		setTitle("Scheduler 3.0");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		initLayout();
	}

	private void initLayout() {

		List<Alert> alerts = new ArrayList<Alert>();
		alerts.add(new Alert("Farm", "2h"));
		alerts.add(new Alert("Eggs", "1m"));
		alerts.add(new Alert("Cows", "12m 33s"));
		AlertPanel alertPanel = new AlertPanel(alerts);

		setLayout(new BorderLayout());

		add(alertPanel, BorderLayout.WEST);
	}

}
