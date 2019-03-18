package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.Color;

public class TelaDeAlunosCadastrados extends JFrame {

	private JPanel contentPaneAlunosCadastrados;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDeAlunosCadastrados frame = new TelaDeAlunosCadastrados();
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
	public TelaDeAlunosCadastrados() {
		setResizable(false);
		setMinimumSize(new Dimension(1029, 600));
		setMaximumSize(new Dimension(1029, 600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPaneAlunosCadastrados = new JPanel();
		contentPaneAlunosCadastrados.setBackground(new Color(28, 28, 28));
		contentPaneAlunosCadastrados.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneAlunosCadastrados);
		contentPaneAlunosCadastrados.setLayout(null);
	}

}
