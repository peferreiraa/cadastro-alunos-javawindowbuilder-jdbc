package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class viewTelaDeMenu extends JFrame {

	private JPanel contentPaneMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewTelaDeMenu frame = new viewTelaDeMenu();
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
	public viewTelaDeMenu() {
		setResizable(false);
		setMinimumSize(new Dimension(1029, 600));
		setMaximumSize(new Dimension(1029, 600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 989, 537);
		contentPaneMenu = new JPanel();
		contentPaneMenu.setBackground(new Color(28,28,28));
		contentPaneMenu.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneMenu);
		contentPaneMenu.setLayout(null);
		
		JPanel pnlMenu = new JPanel();
		pnlMenu.setBorder(new MatteBorder(0, 2, 0, 0, (Color) new Color(0, 191, 255)));
		pnlMenu.setBackground(new Color(28, 28, 28));
		pnlMenu.setBounds(397, 99, 298, 375);
		contentPaneMenu.add(pnlMenu);
		pnlMenu.setLayout(null);
		
		JLabel lblMenuIconeCadastrar = new JLabel("");
		lblMenuIconeCadastrar.setBounds(97, 87, 115, 117);
		pnlMenu.add(lblMenuIconeCadastrar);
		lblMenuIconeCadastrar.setIcon(new ImageIcon("F:\\ws-javaswing\\cadastro-alunos-javawindowbuilder-jdbc\\icons\\icons8_student_registration_filled_100px_4.png"));
		
		JButton btnMenuCadastrarAluno = new JButton("Cadastrar Aluno");
		btnMenuCadastrarAluno.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				viewTelaDeCadastro telaCadastro = new viewTelaDeCadastro();
				telaCadastro.setVisible(true);
			}
		});
		btnMenuCadastrarAluno.setBackground(new Color(0, 191, 255));
		btnMenuCadastrarAluno.setBorder(null);
		btnMenuCadastrarAluno.setBounds(48, 239, 227, 44);
		pnlMenu.add(btnMenuCadastrarAluno);
		btnMenuCadastrarAluno.setFont(new Font("Consolas", Font.BOLD, 18));
		
		JPanel pnlMenuConsultaDelete = new JPanel();
		pnlMenuConsultaDelete.setBorder(new MatteBorder(0, 2, 0, 0, (Color) new Color(0, 191, 255)));
		pnlMenuConsultaDelete.setLayout(null);
		pnlMenuConsultaDelete.setBackground(new Color(28, 28, 28));
		pnlMenuConsultaDelete.setBounds(705, 99, 298, 375);
		contentPaneMenu.add(pnlMenuConsultaDelete);
		
		JLabel lblMenuConsultaDelete = new JLabel("");
		lblMenuConsultaDelete.setIcon(new ImageIcon("F:\\ws-javaswing\\cadastro-alunos-javawindowbuilder-jdbc\\icons\\icons8_zoom_in_100px.png"));
		lblMenuConsultaDelete.setBounds(102, 81, 115, 117);
		pnlMenuConsultaDelete.add(lblMenuConsultaDelete);
		
		JButton btnConsultaDelete = new JButton("Consultar cadastros");
		btnConsultaDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				viewTelaDeAlunosCadastrados alunosCadastros = new viewTelaDeAlunosCadastrados();
				alunosCadastros.setVisible(true);
			}
		});
		btnConsultaDelete.setBackground(new Color(0, 191, 255));
		btnConsultaDelete.setBorder(null);
		btnConsultaDelete.setFont(new Font("Consolas", Font.BOLD, 19));
		btnConsultaDelete.setBounds(38, 238, 230, 44);
		pnlMenuConsultaDelete.add(btnConsultaDelete);
		
		JLabel lblMenu = new JLabel("Tela de Menu");
		lblMenu.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 191, 255)));
		lblMenu.setForeground(new Color(245, 255, 250));
		lblMenu.setFont(new Font("Consolas", Font.BOLD, 32));
		lblMenu.setBounds(47, 211, 221, 47);
		contentPaneMenu.add(lblMenu);
		
		JLabel lblIconemenu = new JLabel("");
		lblIconemenu.setIcon(new ImageIcon("F:\\ws-javaswing\\cadastro-alunos-javawindowbuilder-jdbc\\icons\\icons8_checklist_100px.png"));
		lblIconemenu.setBounds(278, 189, 100, 80);
		contentPaneMenu.add(lblIconemenu);
	}
}
