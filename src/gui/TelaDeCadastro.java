package gui;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.ImageIcon;

public class TelaDeCadastro extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPaneCadastro;
	private JTextField textNome;
	private JLabel lblNascimento;
	private JLabel labelSexo;
	private JFormattedTextField txtSexo;
	private JLabel labelNacionalidade;
	private JFormattedTextField txtNacionalidade;
	private JPanel pnlCadastro;
	private JButton btnCadastrar;
	private JLabel lblCadastrar;
	private JLabel lblIconecadastro;
	private JLabel lblIconecadastro_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDeCadastro frame = new TelaDeCadastro();
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
	public TelaDeCadastro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1041, 608);
		contentPaneCadastro = new JPanel();
		contentPaneCadastro.setBackground(new Color(28,28,28));
		contentPaneCadastro.setBorder(new EmptyBorder(0, 3, 0, 0));
		setContentPane(contentPaneCadastro);
		contentPaneCadastro.setLayout(null);
		
		pnlCadastro = new JPanel();
		pnlCadastro.setForeground(new Color(0, 0, 0));
		pnlCadastro.setBorder(new MatteBorder(0, 1, 0, 0, (Color) new Color(102, 51, 255)));
		pnlCadastro.setBackground(new Color(28, 28, 28));
		pnlCadastro.setBounds(504, 57, 488, 406);
		contentPaneCadastro.add(pnlCadastro);
		pnlCadastro.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(82, 124, 67, 20);
		pnlCadastro.add(lblNome);
		lblNome.setForeground(new Color(255, 255, 255));
		lblNome.setFont(new Font("Consolas", Font.BOLD, 20));
		lblNome.setBackground(new Color(255, 255, 255));
		
		textNome = new JTextField();
		textNome.setForeground(new Color(255, 255, 255));
		textNome.setFont(new Font("Consolas", Font.BOLD, 21));
		textNome.setBackground(new Color(28,28,28));
		textNome.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(102, 51, 255)));
		textNome.setBounds(134, 124, 300, 20);
		pnlCadastro.add(textNome);
		textNome.setColumns(10);
		
		lblNascimento = new JLabel("Data de nascimento");
		lblNascimento.setBounds(82, 180, 217, 20);
		pnlCadastro.add(lblNascimento);
		lblNascimento.setForeground(Color.WHITE);
		lblNascimento.setFont(new Font("Consolas", Font.BOLD, 20));
		lblNascimento.setBackground(Color.WHITE);
		
		JFormattedTextField txtNascimento = new JFormattedTextField();
		txtNascimento.setForeground(new Color(255, 255, 255));
		txtNascimento.setFont(new Font("Consolas", Font.BOLD, 21));
		txtNascimento.setBackground(new Color(28,28,28));
		txtNascimento.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(102, 51, 255)));
		txtNascimento.setBounds(309, 180, 125, 20);
		pnlCadastro.add(txtNascimento);
		txtNascimento.setFocusLostBehavior(JFormattedTextField.REVERT);
		
		labelSexo = new JLabel("Sexo");
		labelSexo.setBounds(82, 234, 67, 20);
		pnlCadastro.add(labelSexo);
		labelSexo.setForeground(Color.WHITE);
		labelSexo.setFont(new Font("Consolas", Font.BOLD, 20));
		labelSexo.setBackground(Color.WHITE);
		
		txtSexo = new JFormattedTextField();
		txtSexo.setForeground(new Color(255, 255, 255));
		txtSexo.setFont(new Font("Consolas", Font.BOLD, 21));
		txtSexo.setBackground(new Color(28,28,28));
		txtSexo.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(102, 51, 255)));
		txtSexo.setBounds(258, 234, 176, 20);
		pnlCadastro.add(txtSexo);
		txtSexo.setFocusLostBehavior(JFormattedTextField.REVERT);
		
		txtNacionalidade = new JFormattedTextField();
		txtNacionalidade.setForeground(new Color(255, 255, 255));
		txtNacionalidade.setFont(new Font("Consolas", Font.BOLD, 21));
		txtNacionalidade.setBackground(new Color(28,28,28));
		txtNacionalidade.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(102, 51, 255)));
		txtNacionalidade.setBounds(216, 288, 220, 20);
		pnlCadastro.add(txtNacionalidade);
		txtNacionalidade.setFocusLostBehavior(JFormattedTextField.REVERT);
		
		labelNacionalidade = new JLabel("Nacionaidade");
		labelNacionalidade.setBounds(82, 288, 163, 20);
		pnlCadastro.add(labelNacionalidade);
		labelNacionalidade.setForeground(Color.WHITE);
		labelNacionalidade.setFont(new Font("Consolas", Font.BOLD, 20));
		labelNacionalidade.setBackground(Color.WHITE);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBorder(null);
		btnCadastrar.setBackground(new Color(102, 51, 255));
		btnCadastrar.setMargin(new Insets(0, 14, 0, 14));
		btnCadastrar.setFont(new Font("Consolas", Font.BOLD, 22));
		btnCadastrar.setBounds(186, 354, 192, 41);
		pnlCadastro.add(btnCadastrar);
		
		lblIconecadastro_1 = new JLabel("");
		lblIconecadastro_1.setIcon(new ImageIcon("F:\\ws-javaswing\\cadastro-alunos-javawindowbuilder-jdbc\\icons\\icons8_id_card_96px.png"));
		lblIconecadastro_1.setBounds(204, 11, 114, 83);
		pnlCadastro.add(lblIconecadastro_1);
		
		lblCadastrar = new JLabel("Tela de Cadastro");
		lblCadastrar.setForeground(new Color(255, 255, 255));
		lblCadastrar.setFont(new Font("Consolas", Font.BOLD, 40));
		lblCadastrar.setBounds(10, 201, 366, 115);
		contentPaneCadastro.add(lblCadastrar);
		
		lblIconecadastro = new JLabel("");
		lblIconecadastro.setIcon(new ImageIcon("F:\\ws-javaswing\\cadastro-alunos-javawindowbuilder-jdbc\\icons\\icons8_crowd_96px.png"));
		lblIconecadastro.setBounds(386, 201, 108, 123);
		contentPaneCadastro.add(lblIconecadastro);
	}
}
