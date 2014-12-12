package br.github.gnomex.some_examples;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class Counter extends JFrame implements Runnable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
//	JLabel label;
	private JLabel label;
	Timer timer;
	int current = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Counter frame = new Counter();
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
	public Counter() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		label = new JLabel("0");
		contentPane.add(label, BorderLayout.CENTER);
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
		this.setVisible(true);
//		this.go();
	}
	
}
