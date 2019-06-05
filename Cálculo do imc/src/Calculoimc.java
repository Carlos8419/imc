import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calculoimc extends JFrame {

	private JPanel contentPane;
	private JTextField txtPeso;
	private JTextField txtAltura;
	private JTextField txtImc;
	private JLabel lblStatus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculoimc frame = new Calculoimc();
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
	public Calculoimc() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Calculoimc.class.getResource("/icone/imc.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541, 454);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCalcular = new JButton("");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcular();
			}
		});
		btnCalcular.setIcon(new ImageIcon(Calculoimc.class.getResource("/icone/imc.png")));
		btnCalcular.setBounds(277, 66, 69, 71);
		contentPane.add(btnCalcular);
		
		JButton btnLimpar = new JButton("");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setIcon(new ImageIcon(Calculoimc.class.getResource("/icone/limpar.png")));
		btnLimpar.setBounds(356, 66, 69, 71);
		contentPane.add(btnLimpar);
		
		txtPeso = new JTextField();
		txtPeso.setBounds(55, 11, 96, 17);
		contentPane.add(txtPeso);
		txtPeso.setColumns(10);
		
		JLabel lblPeso = new JLabel("Peso");
		lblPeso.setBounds(10, 13, 48, 14);
		contentPane.add(lblPeso);
		
		txtAltura = new JTextField();
		txtAltura.setBounds(55, 39, 96, 20);
		contentPane.add(txtAltura);
		txtAltura.setColumns(10);
		
		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setBounds(10, 42, 48, 14);
		contentPane.add(lblAltura);
		
		JLabel lblImc = new JLabel("IMC");
		lblImc.setBounds(10, 79, 48, 14);
		contentPane.add(lblImc);
		
		lblStatus = new JLabel("");
		lblStatus.setIcon(new ImageIcon(Calculoimc.class.getResource("/icone/tabela_imc.jpg")));
		lblStatus.setBounds(38, 132, 478, 271);
		contentPane.add(lblStatus);
		
		txtImc = new JTextField();
		txtImc.setBounds(55, 76, 96, 20);
		contentPane.add(txtImc);
		txtImc.setColumns(10);
	}
	
	//Método para calcular o IMC
	private void calcular() {
		DecimalFormat formatador = new DecimalFormat("0.00");
		double peso, altura, imc;
		peso = Double.parseDouble(txtPeso.getText().replace(",","."));
		altura = Double.parseDouble(txtAltura.getText().replace(",","."));
		imc = peso / (altura * altura);
		txtImc.setText(formatador.format(imc));
		if (imc < 18.5) {
			//Esse comando abaixo muda a imagem do icone 
			lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/tabela_imc_abaixo.jpg")));
		}else if (imc >= 18.5 && imc < 25) {
			lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/tabela_imc_normal.jpg")));
		}else if (imc > 25 && imc < 30) {
			lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/tabela_imc_acima.jpg")));
		}else {
			lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/tabela_imc_obeso.jpg")));
				
	}
		
	}
	//Esse comando abaixo limpa os campos e as imagens da tabela IMC
	private void limpar () {
		txtPeso.setText(null);
		txtAltura.setText(null); 
		txtImc.setText(null);
		lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/tabela_imc.jpg")));
	}


}









