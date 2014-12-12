package br.github.gnomex.some_examples;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Contador extends JPanel implements Runnable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel label;
	Timer timer;
	int current = 0;

	public Contador() {
		this.add(this.getLabel());
		this.go();
	}

	public JLabel getLabel() {
		if (this.label == null) {
			this.label = new JLabel(this.current + "");
			this.label.setPreferredSize(new Dimension(100, 22));
		}
		return this.label;
	}

	public void go() {
		ActionListener action = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label.setText(++current + "");
			}
		};
		this.timer = new Timer(1000, action);
		this.timer.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.go();
	}
	
	
}