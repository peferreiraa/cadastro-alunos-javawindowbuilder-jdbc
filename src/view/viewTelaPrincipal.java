package view;


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
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class viewTelaPrincipal extends JFrame {

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
					viewTelaPrincipal frame = new viewTelaPrincipal();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public viewTelaPrincipal() {
		setLocationRelativeTo(null);
		setUndecorated(true);
		setResizable(false);
		setMinimumSize(new Dimension(1029, 600));
		setMaximumSize(new Dimension(1029, 600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 981, 603);
		contentPanePrincipal = new JPanel();
		contentPanePrincipal.setMinimumSize(new Dimension(1029, 600));
		contentPanePrincipal.setMaximumSize(new Dimension(1029, 600));
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
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnLogin.setBackground(new Color(0,191,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnLogin.setBackground(new Color(0, 255, 255));
			}
		});
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewTelaDeMenu telaMenu = new viewTelaDeMenu();
				telaMenu.setVisible(true);
				dispose();
			}
		});
		
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
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 191, 255));
		panel.setBounds(0, 0, 1029, 28);
		contentPanePrincipal.add(panel);
		panel.setLayout(null);
		
		JLabel lblFechar = new JLabel("");
		lblFechar.setBounds(989, 0, 30, 30);
		panel.add(lblFechar);
		lblFechar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblFechar.setIcon(new ImageIcon("F:\\ws-javaswing\\cadastro-alunos-javawindowbuilder-jdbc\\icons\\icons8_delete_sign_30px_1.png"));
		
		JLabel lblMinimizar = new JLabel("");
		lblMinimizar.setBounds(949, 0, 30, 30);
		panel.add(lblMinimizar);
		lblMinimizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setExtendedState(ICONIFIED);
			}
		});
		lblMinimizar.setIcon(new ImageIcon("F:\\ws-javaswing\\cadastro-alunos-javawindowbuilder-jdbc\\icons\\icons8_minimize_window_30px_1.png"));
	}
}
