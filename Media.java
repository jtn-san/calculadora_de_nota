package media;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Media extends JFrame {

	private JPanel contentPane;
	private JTextField txtNota1;
	private JTextField txtNota2;
	private JTextField txtMedia;
	private JButton btnLimpar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Media frame = new Media();
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
	public Media() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Media.class.getResource("/icones/calc5.png")));
		setTitle("Calculadora da m\u00E9dia");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 321, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nota 1");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 50, 44, 24);
		contentPane.add(lblNewLabel);
		
		txtNota1 = new JTextField();
		txtNota1.setFont(txtNota1.getFont().deriveFont(15f));
		txtNota1.setBounds(89, 54, 152, 20);
		contentPane.add(txtNota1);
		txtNota1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nota 2");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 98, 48, 14);
		contentPane.add(lblNewLabel_1);
		
		txtNota2 = new JTextField();
		txtNota2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNota2.setBounds(89, 97, 152, 20);
		contentPane.add(txtNota2);
		txtNota2.setColumns(10);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.setToolTipText("Calcular m\u00E9dia");
		btnCalcular.setIcon(new ImageIcon(Media.class.getResource("/icones/igual_128px (2).png")));
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DecimalFormat formatador = new DecimalFormat("#0.00");
				double nota1, nota2, media;
				nota1 = Double.parseDouble(txtNota1.getText().replace(",", "."));
				nota2 = Double.parseDouble(txtNota2.getText().replace(",", "."));
				media = (nota1 + nota2) /2;
				txtMedia.setText("" + formatador.format(media));
				if (media < 5) {
					JOptionPane.showMessageDialog(null, "REPROVADO", "STATUS", JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "APROVADO", "STATUS", JOptionPane.YES_NO_CANCEL_OPTION);
				}
				
			}
		});
		btnCalcular.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCalcular.setBounds(10, 174, 128, 128);
		contentPane.add(btnCalcular);
		
		JLabel lblNewLabel_2 = new JLabel("M\u00E9dia");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(60, 138, 48, 14);
		contentPane.add(lblNewLabel_2);
		
		txtMedia = new JTextField();
		txtMedia.setEditable(false);
		txtMedia.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtMedia.setBounds(162, 128, 79, 31);
		contentPane.add(txtMedia);
		txtMedia.setColumns(10);
		
		btnLimpar = new JButton("");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNota1.setText(null);
				txtNota2.setText(null);
				txtMedia.setText(null);
			}
		});
		btnLimpar.setToolTipText("Limpar campos");
		btnLimpar.setIcon(new ImageIcon(Media.class.getResource("/icones/apagar_128px.png")));
		btnLimpar.setBounds(172, 174, 128, 128);
		contentPane.add(btnLimpar);
		
		JButton btnNewButton = new JButton("Sobre");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(null, "Calculadora da Média ver. 1.0\nAutor: Jonathan", "Sobre", JOptionPane.DEFAULT_OPTION);
			}
		});
		btnNewButton.setBounds(119, 313, 67, 23);
		contentPane.add(btnNewButton);
	}
}
