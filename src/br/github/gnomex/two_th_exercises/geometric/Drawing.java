package br.github.gnomex.two_th_exercises.geometric;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Drawing {

	private JFrame frmDraw;
	private Point onClick;
	private Point onRelease;
	
	private int drawer_shape = 1;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Drawing window = new Drawing();
					window.frmDraw.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Drawing() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			//		        UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
		} 
		catch (UnsupportedLookAndFeelException e) {
			// handle exception
		}
		catch (ClassNotFoundException e) {
			// handle exception
		}
		catch (InstantiationException e) {
			// handle exception
		}
		catch (IllegalAccessException e) {
			// handle exception
		}

		frmDraw = new JFrame();
		frmDraw.setTitle("Draw!!!");
		frmDraw.setBounds(100, 100, 1024, 720);
		frmDraw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDraw.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(12, 12, 998, 52);
		frmDraw.getContentPane().add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnCircle = new JButton("Circle");
		btnCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawer_shape = 1;
			}
		});
		panel.add(btnCircle);

		JButton btnLine = new JButton("Line");
		btnLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawer_shape = 2;
			}
		});
		panel.add(btnLine);

		JButton btnRectangle = new JButton("Rectangle");
		btnRectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawer_shape = 3;
			}
		});
		panel.add(btnRectangle);

		JButton btnEllipse = new JButton("Ellipse");
		btnEllipse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawer_shape = 4;
			}
		});
		panel.add(btnEllipse);

		final JPanel panel_1 = 	new JPanel();
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				onClick = e.getLocationOnScreen();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				onRelease = e.getLocationOnScreen();
				paintComponent(
						panel_1.getGraphics(), 
						onClick,
						onRelease
					);
				
			}
		});
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(12, 73, 998, 595);
		frmDraw.getContentPane().add(panel_1);
	}

	public void paintComponent(Graphics g, Point i, Point n)	{
		g.setColor(Color.RED);
		
		switch (drawer_shape) {
		case 1://Circle - Oval
			
			g.drawOval((int) i.getX(), (int) n.getY(), 10, 10);
			
			break;
		case 2://Line
			
			g.drawLine((int) i.getX(),(int) i.getY(), (int) n.getX(), (int) n.getY());
			
			break;
		case 3://Retangle
			
			g.drawRect((int) i.getX(), (int) n.getY(), 20, 15);
			
			break;
		case 4://Ellipse
			
			g.drawOval((int) i.getX(), (int) n.getY(), 10, 20);
			
			break;

		default:
			break;
		}
	}

}
