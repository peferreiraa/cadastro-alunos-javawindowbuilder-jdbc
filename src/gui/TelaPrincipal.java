package gui;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.Insets;
import javax.swing.JPasswordField;

public class TelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPanePrincipal;
	private JTextField textUsuario;
	private JPasswordField passwordSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 981, 603);
		contentPanePrincipal = new JPanel();
		contentPanePrincipal.setBackground(new Color(28,28,28));
		contentPanePrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanePrincipal);
		contentPanePrincipal.setLayout(null);
		
		JPanel jplTelaPrincipal = new JPanel();
		jplTelaPrincipal.setBorder(new MatteBorder(0, 2, 0, 0, (Color) new Color(255, 255, 255)));
		jplTelaPrincipal.setBackground(new Color(28,28,28));
		jplTelaPrincipal.setBounds(530, 81, 387, 377);
		contentPanePrincipal.add(jplTelaPrincipal);
		jplTelaPrincipal.setLayout(null);
		
		JLabel lblUsurio = new JLabel("Usu\u00E1rio");
		lblUsurio.setForeground(new Color(255, 255, 255));
		lblUsurio.setFont(new Font("Consolas", Font.BOLD, 23));
		lblUsurio.setBounds(96, 113, 114, 27);
		jplTelaPrincipal.add(lblUsurio);
		
		textUsuario = new JTextField();
		textUsuario.setFont(new Font("Consolas", Font.BOLD, 15));
		textUsuario.setForeground(new Color(255, 255, 255));
		textUsuario.setCaretColor(new Color(0, 0, 0));
		textUsuario.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 255, 255)));
		textUsuario.setBackground(new Color(28,28,28));
		textUsuario.setBounds(96, 143, 189, 27);
		jplTelaPrincipal.add(textUsuario);
		textUsuario.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setForeground(new Color(255, 255, 255));
		lblSenha.setFont(new Font("Consolas", Font.BOLD, 23));
		lblSenha.setBounds(96, 188, 92, 33);
		jplTelaPrincipal.add(lblSenha);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBorder(null);
		btnLogin.setBackground(new Color(0, 255, 255));
		btnLogin.setMargin(new Insets(0, 14, 0, 14));
		btnLogin.setFont(new Font("Consolas", Font.BOLD, 20));
		btnLogin.setBounds(96, 279, 189, 40);
		jplTelaPrincipal.add(btnLogin);
		
		passwordSenha = new JPasswordField();
		passwordSenha.setForeground(new Color(255, 255, 255));
		passwordSenha.setFont(new Font("Consolas", Font.BOLD, 15));
		passwordSenha.setCaretColor(new Color(0, 0, 0));
		passwordSenha.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 255, 255)));
		passwordSenha.setBackground(new Color(28,28,28));
		passwordSenha.setBounds(96, 216, 189, 27);
		jplTelaPrincipal.add(passwordSenha);
		
		JLabel lblTelaInicialDe = new JLabel("...Tela Inicial De Teste");
		lblTelaInicialDe.setForeground(new Color(255, 255, 255));
		lblTelaInicialDe.setFont(new Font("Consolas", Font.PLAIN, 28));
		lblTelaInicialDe.setBounds(50, 249, 397, 53);
		contentPanePrincipal.add(lblTelaInicialDe);
		
		JLabel lblIconTest = new JLabel("");
		lblIconTest.setIcon(new ImageIcon("F:\\ws-javaswing\\cadastro-alunos-javawindowbuilder-jdbc\\icons\\icons8_idea_50px.png"));
		lblIconTest.setBounds(432, 230, 50, 72);
		contentPanePrincipal.add(lblIconTest);
	}
}
