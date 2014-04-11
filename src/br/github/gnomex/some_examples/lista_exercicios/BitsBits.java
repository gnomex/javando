package br.github.gnomex.some_examples.lista_exercicios;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class BitsBits extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField valor;
	private JTextField resultado1;
	private JTextField resultado2;
	private JTextField resultado3;
	private JTextField resultado4;
	JFileChooser chooser = new JFileChooser();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BitsBits frame = new BitsBits();
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
	public BitsBits() {
		setTitle("Caixa Eletronico BITf");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int returnVal = chooser.showSaveDialog(null);

				if (returnVal == JFileChooser.APPROVE_OPTION) {

					File f = chooser.getSelectedFile();
					try {

						FileWriter fw = new FileWriter(f);
						fw.write("Valor Sacado: ");
						fw.write("|N notas de 50: "+resultado1.getText()+"|");
						fw.write("N notas de 10: "+resultado2.getText()+"|");
						fw.write("N notas de 5: "+resultado3.getText()+"|");
						fw.write("N notas de 1: "+resultado4.getText()+"|");
						fw.close();//fecha arquivo

						@SuppressWarnings("unused")
						boolean hasChanged = false; //marca como não alterado
					} catch (FileNotFoundException e) { //Não encontrou o arquivo
						e.printStackTrace();
					} catch (IOException e) { //Algum outro erro de io, não conseguiu gravar pois não tem permissão por exemplo
						e.printStackTrace();
					}
				}
			}
		});

		JButton btnSacar = new JButton("Sacar");

		btnSacar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int saque = Integer.parseInt(valor.getText());
				int notas[]=new int[4];

				notas[0]=notas[1]=notas[2]=notas[3]=0;
				if(saque >= 1 || saque <= 10000)
				{
					notas[0] = saque/50;
					saque = saque%50;
					resultado1.setText(notas[0]+" ");

					notas[1] = saque/10;
					saque = saque%10;
					resultado2.setText(notas[1]+" ");

					notas[2] = saque/5;
					saque = saque%5;
					resultado3.setText(notas[2]+" ");

					notas[3] = saque;
					resultado4.setText(notas[3]+" ");

					JOptionPane.showMessageDialog(null, "Retire seu dinheiro");
				}

			}
		});
		contentPane.add(btnSacar, BorderLayout.SOUTH);
		contentPane.add(btnSalvar, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 5, 5));

		JLabel lblNewLabel_1 = new JLabel("Valor B$: ");
		lblNewLabel_1.setForeground(Color.RED);
		panel.add(lblNewLabel_1);

		valor = new JTextField();
		panel.add(valor);
		valor.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Nº Notas B$50,00");
		panel.add(lblNewLabel_2);

		resultado1 = new JTextField();
		panel.add(resultado1);
		resultado1.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Nº Notas B$10,00");
		panel.add(lblNewLabel_3);

		resultado2 = new JTextField();
		panel.add(resultado2);
		resultado2.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Nº Notas B$5,00");
		panel.add(lblNewLabel_4);

		resultado3 = new JTextField();
		panel.add(resultado3);
		resultado3.setColumns(10);

		JLabel lblNewLabel = new JLabel("Nº Notas B$1,00");
		panel.add(lblNewLabel);

		resultado4 = new JTextField();
		panel.add(resultado4);
		resultado4.setColumns(10);
	}

}
