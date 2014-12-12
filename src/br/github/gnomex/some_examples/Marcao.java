package br.github.gnomex.some_examples;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextArea;

public class Marcao extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Marcao frame = new Marcao();
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
	public Marcao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(12, -13, 424, 261);
		contentPane.add(panel);
		panel.setLayout(null);

		textField = new JTextField();
		textField.setBounds(12, 28, 400, 33);
		panel.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(12, 60, 400, 33);
		panel.add(textField_1);
		textField_1.setColumns(10);

		final JTextArea textArea = new JTextArea();
		textArea.setBounds(12, 92, 400, 108);
		textArea.setEditable(Boolean.FALSE);
		panel.add(textArea);

		JButton btnGravar = new JButton("Gravar");
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				writeOnFile(textField.getText(), Boolean.TRUE);
				writeOnFile(textField_1.getText(), Boolean.TRUE);
			}
		});
		btnGravar.setBounds(12, 224, 117, 25);
		panel.add(btnGravar);

		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					for(String a : readFromFile())	{
						textArea.append(a + "\n");
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnMostrar.setBounds(141, 224, 117, 25);
		panel.add(btnMostrar);

		JButton btnApagar = new JButton("Apagar");
		btnApagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textArea.setText("");
				writeOnFile("", Boolean.FALSE);
			}
		});
		btnApagar.setBounds(280, 224, 117, 25);
		panel.add(btnApagar);

	}

	private File file = new File("questao7.txt");

	private FileWriter writer;
	private FileReader reader;

	public void writeOnFile(String lol, Boolean apagar)	{

		try	{

			writer = new FileWriter(file, apagar); //True is to append on file
			PrintWriter printer = new PrintWriter(writer);

			printer.println(lol);

			printer.close();
			writer.close();

		} catch (FileNotFoundException fn)	{
			System.out.println("Deu erro!");
			fn.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<String> readFromFile() throws IOException {

		ArrayList<String> records = new ArrayList<String>();

		BufferedReader bfreader = null;
		try {
			reader = new FileReader(file);
			bfreader = new BufferedReader(reader);

			String line = null;

			while((line = bfreader.readLine()) != null)	{
				records.add(line);	
			}
			
			bfreader.close();
			reader.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return records;

	}
}
