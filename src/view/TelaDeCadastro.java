package view;


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

import model.controller.AlunoController;
import model.entities.Aluno;

import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

public class TelaDeCadastro extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPaneCadastro;
	private JTextField textNome;
	private JLabel lblNascimento;
	private JLabel lblId;
	private JLabel labelNacionalidade;
	private JPanel pnlCadastro;
	private JButton btnCadastrar;
	private JLabel lblCadastrar;
	private JLabel lblIconecadastro;
	private JLabel lblIconecadastro_1;
	private JTextField textId;
	private JTextField textNacionalidade;

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
		setResizable(false);
		setMinimumSize(new Dimension(1029, 600));
		setMaximumSize(new Dimension(1029, 600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1029, 600);
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
		lblNome.setBounds(82, 177, 67, 20);
		pnlCadastro.add(lblNome);
		lblNome.setForeground(new Color(255, 255, 255));
		lblNome.setFont(new Font("Consolas", Font.BOLD, 20));
		lblNome.setBackground(new Color(255, 255, 255));
		
		textNome = new JTextField();
		textNome.setForeground(new Color(255, 255, 255));
		textNome.setFont(new Font("Consolas", Font.BOLD, 21));
		textNome.setBackground(new Color(28,28,28));
		textNome.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(102, 51, 255)));
		textNome.setBounds(142, 177, 292, 20);
		pnlCadastro.add(textNome);
		textNome.setColumns(10);
		
		lblNascimento = new JLabel("Data de nascimento");
		lblNascimento.setBounds(82, 233, 217, 20);
		pnlCadastro.add(lblNascimento);
		lblNascimento.setForeground(Color.WHITE);
		lblNascimento.setFont(new Font("Consolas", Font.BOLD, 20));
		lblNascimento.setBackground(Color.WHITE);
		
		JFormattedTextField txtNascimento = new JFormattedTextField();
		txtNascimento.setForeground(new Color(255, 255, 255));
		txtNascimento.setFont(new Font("Consolas", Font.BOLD, 21));
		txtNascimento.setBackground(new Color(28,28,28));
		txtNascimento.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(102, 51, 255)));
		txtNascimento.setBounds(309, 233, 125, 20);
		pnlCadastro.add(txtNascimento);
		txtNascimento.setFocusLostBehavior(JFormattedTextField.REVERT);
		
		lblId = new JLabel("ID");
		lblId.setBounds(82, 133, 67, 20);
		pnlCadastro.add(lblId);
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("Consolas", Font.BOLD, 20));
		lblId.setBackground(Color.WHITE);
		
		labelNacionalidade = new JLabel("Nacionaidade");
		labelNacionalidade.setBounds(82, 288, 163, 20);
		pnlCadastro.add(labelNacionalidade);
		labelNacionalidade.setForeground(Color.WHITE);
		labelNacionalidade.setFont(new Font("Consolas", Font.BOLD, 20));
		labelNacionalidade.setBackground(Color.WHITE);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Aluno obj = new Aluno();
				AlunoController controller = new AlunoController();
				obj.setId(Integer.parseInt(textId.getText()));
				obj.setNome(textNome.getText());
				obj.setDataDeNascimento(new Date());
				obj.setNacionalidade(textNacionalidade.getText());
				controller.insertStudent(obj);		
			}
		});
		btnCadastrar.setBorder(null);
		btnCadastrar.setBackground(new Color(102, 51, 255));
		btnCadastrar.setMargin(new Insets(0, 14, 0, 14));
		btnCadastrar.setFont(new Font("Consolas", Font.BOLD, 22));
		btnCadastrar.setBounds(186, 354, 192, 41);
		pnlCadastro.add(btnCadastrar);
		
		lblIconecadastro_1 = new JLabel("");
		lblIconecadastro_1.setIcon(new ImageIcon("F:\\ws-javaswing\\cadastro-alunos-javawindowbuilder-jdbc\\icons\\icons8_id_card_96px.png"));
		lblIconecadastro_1.setBounds(216, 11, 114, 83);
		pnlCadastro.add(lblIconecadastro_1);
		
		textId = new JTextField();
		textId.setForeground(Color.WHITE);
		textId.setFont(new Font("Consolas", Font.BOLD, 21));
		textId.setColumns(10);
		textId.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(102, 51, 255)));
		textId.setBackground(new Color(28, 28, 28));
		textId.setBounds(142, 133, 292, 20);
		pnlCadastro.add(textId);
		
		textNacionalidade = new JTextField();
		textNacionalidade.setForeground(Color.WHITE);
		textNacionalidade.setFont(new Font("Consolas", Font.BOLD, 21));
		textNacionalidade.setColumns(10);
		textNacionalidade.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(102, 51, 255)));
		textNacionalidade.setBackground(new Color(28, 28, 28));
		textNacionalidade.setBounds(225, 288, 209, 20);
		pnlCadastro.add(textNacionalidade);
		
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
