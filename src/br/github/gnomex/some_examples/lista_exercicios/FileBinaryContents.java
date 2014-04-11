package br.github.gnomex.some_examples.lista_exercicios;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class FileBinaryContents extends JFrame {

	private JPanel contentPane;
	private static final String title = "Arquivo Salvo";
	private boolean hasChanged = false;
	JFileChooser chooser = new JFileChooser();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileBinaryContents frame = new FileBinaryContents();
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
	public FileBinaryContents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 444, 344);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 6, 5, 5));

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane);

		final JTextArea resultado = new JTextArea();
		scrollPane.setViewportView(resultado);

		JPanel panel = new JPanel();
		contentPane.add(panel);

		JButton btnAbrirArquivo = new JButton("Abrir Arquivo");
		btnAbrirArquivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int returnVal = chooser.showOpenDialog(null);

				if (returnVal == JFileChooser.APPROVE_OPTION) {

					File f = chooser.getSelectedFile();
					BufferedReader br = null;
					try {
						br = new BufferedReader(new FileReader(f));
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					String st = "";
					String linhas = "";

					try {
						while ((st = br.readLine()) != null) {
							linhas = linhas + st + "\n";

						}

						resultado.setText(linhas);
					} catch (IOException e) {
						e.printStackTrace();
					}

				}
			}
		});
		panel.add(btnAbrirArquivo);

		JButton btnSalvarArquivo = new JButton("Salvar Arquivo");
		btnSalvarArquivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int returnVal = chooser.showSaveDialog(null);

				if (returnVal == JFileChooser.APPROVE_OPTION) {

					File f = chooser.getSelectedFile();
					try {

						FileWriter fw = new FileWriter(f);
						//pega o texto do TextArea e envia pra stream no arquivo
						//A função write escreve uma string para o arquivo. Existem outras opções
						//a função write pode gerar IOException
						fw.write(resultado.getText());
						fw.close();//fecha arquivo
						setTitle(title); //seta o titulo pra remover o * se houver
						hasChanged = false; //marca como não alterado
					} catch (FileNotFoundException e) { //Não encontrou o arquivo
						e.printStackTrace();
					} catch (IOException e) { //Algum outro erro de io, não conseguiu gravar pois não tem permissão por exemplo
						e.printStackTrace();
					}
				}
			}
		});
		panel.add(btnSalvarArquivo);



		JButton btnNewButton = new JButton("Binario");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File f = chooser.getSelectedFile();
				BufferedReader br = null;
				try {
					br = new BufferedReader(new FileReader(f));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String st = "";
				String linhas = "";

				try {
					while ((st = br.readLine()) != null) {

					}

				} catch (IOException e) {
					e.printStackTrace();
				}
				byte[] b = new byte[1024];
				int i = 0;
				int x = 0;
				int d = 0;
				int k = 0;
				int t = 0;
				try {
					FileInputStream fi = new FileInputStream(f);
					while ((i = fi.read(b)) > -1) {
						linhas += "Indice| 		                         Conteudo do Arquivo";

						for (int j = 0; j < i; j++) {

							String s1 = String.format("%8s",
									Integer.toBinaryString(b[x] & 0xFF))
									.replace(' ', '0');

							if (j == k) {
								k = k + 12;
								linhas += "\n\r";

								if (t < 9) {
									linhas += "0";
								}
								linhas += "00" + t + "  |";
								t += 12;
							}
							linhas = linhas + s1 + " ";
							x++;
						}
					}

					resultado.setText(linhas);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Decimal");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File f = chooser.getSelectedFile();
				BufferedReader br = null;
				try {
					br = new BufferedReader(new FileReader(f));
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String st = "";
				String linhas = "";

				try {
					while ((st = br.readLine()) != null) {

					}

				} catch (IOException e1) {
					e1.printStackTrace();
				}
				byte[] b = new byte[1024];
				int i = 0;
				int x = 0;
				int k = 0;
				int t = 0;
				try {
					FileInputStream fi = new FileInputStream(f);
					while ((i = fi.read(b)) > -1) {
						linhas += "Indice| 	   Conteudo do Arquivo";

						for (int j = 0; j < i; j++) {
							String s1 = String.format("%8s",
									Integer.toBinaryString(b[x] & 0xFF))
									.replace(' ', '0');
							s1 = Integer.toString(Integer.parseInt(s1, 2));

							if (j == k) {
								k = k + 12;
								linhas += "\n\r";

								if (t < 9) {
									linhas += "0";
								}
								linhas += "00" + t + "  |";
								t += 12;
							}
							linhas = linhas + s1 + " ";
							x++;


						}
					}

					resultado.setText(linhas);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Octa");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File f = chooser.getSelectedFile();
				BufferedReader br = null;
				try {
					br = new BufferedReader(new FileReader(f));
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String st = "";
				String linhas = "";

				try {
					while ((st = br.readLine()) != null) {

					}

				} catch (IOException e1) {
					e1.printStackTrace();
				}
				byte[] b = new byte[1024];
				int i = 0;
				int x = 0;
				int k = 0;
				int t=0;
				try {
					FileInputStream fi = new FileInputStream(f);
					while ((i = fi.read(b)) > -1) {
						linhas += "Indice| 	   Conteudo do Arquivo";
						for (int j = 0; j < i; j++) {
							String s1 = String.format("%8s",
									Integer.toBinaryString(b[x] & 0xFF))
									.replace(' ', '0');
							s1 = Integer.toOctalString(Integer.parseInt(s1, 2));


							if (j == k) {
								k = k + 12;
								linhas += "\n\r";

								if (t < 9) {
									linhas += "0";
								}
								linhas += "00" + t + "  |";
								t += 12;
							}
							linhas = linhas + s1 + " ";
							x++;

						}
					}

					resultado.setText(linhas);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Hexadecimal");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File f = chooser.getSelectedFile();
				BufferedReader br = null;
				try {
					br = new BufferedReader(new FileReader(f));
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String st = "";
				String linhas = "";

				try {
					while ((st = br.readLine()) != null) {

					}

				} catch (IOException e1) {
					e1.printStackTrace();
				}
				byte[] b = new byte[1024];
				int i = 0;
				int x = 0;
				int k = 0;
				int t = 0;
				try {
					FileInputStream fi = new FileInputStream(f);
					while ((i = fi.read(b)) > -1) {
						linhas += "Indice| 	   Conteudo do Arquivo";
						for (int j = 0; j < i; j++) {
							String s1 = String.format("%8s",
									Integer.toBinaryString(b[x] & 0xFF))
									.replace(' ', '0');
							s1 = Integer.toHexString(Integer.parseInt(s1, 2));


							if (j == k) {
								k = k + 12;
								linhas += "\n\r";

								if (t < 9) {
									linhas += "0";
								}
								linhas += "00" + t + "  |";
								t += 12;
							}
							linhas = linhas + s1 + " ";
							x++;

						}
					}

					resultado.setText(linhas);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		panel.add(btnNewButton_3);
	}
}