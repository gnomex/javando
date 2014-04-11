package br.github.gnomex.some_examples.lista_exercicios.geometry;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

public class OvalDrawer extends JFrame {

	private JPanel contentPane;
	
	private Point onClick;
	private Point onRelease;
	
	private JLabel lblAreaResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OvalDrawer frame = new OvalDrawer();
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
	public OvalDrawer() {
		
		super("Draw a circle!");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 588, 499);
		contentPane = new JPanel();
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				onClick = e.getLocationOnScreen();
				repaint();	
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				onRelease = e.getLocationOnScreen();
				
				Integer distance = Geometry.getDistanceBetwenTwoPoints(onClick, onRelease);
				
				Float area = Geometry.circleArea(distance);
				
				lblAreaResult.setText(Float.toString(area));
				
				paintComponent(
						getGraphics(), 
						new Double(onClick.getX() - distance).intValue(),
						new Double(onClick.getY() - distance).intValue(),
						new Double(distance + distance).intValue(),
						new Double(distance + distance).intValue()
					);
				
				clearClickFilds();
			}

		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblAreaResult = new JLabel("Circle Area");
		lblAreaResult.setBounds(12, 12, 558, 26);
		contentPane.add(lblAreaResult);
	}	

	 public void paintComponent(Graphics g, int d, int e, int f, int h)	{
		 g.setColor(Color.RED);
		 g.drawOval (d,e,f,h);
	  }
	
	private void clearClickFilds()	{
		onClick.setLocation(0, 0);
		onRelease.setLocation(0, 0);
	}
}
