package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JTabbedPane;
import java.awt.ComponentOrientation;
import javax.swing.JScrollPane;

public class TelaDeAlunosCadastrados extends JFrame {

	private JPanel contentPaneAlunosCadastrados;
	private JTable tblAlunosCadastrados;

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
		
		JScrollPane scrollPaneAlunosCadastrados = new JScrollPane();
		scrollPaneAlunosCadastrados.setBounds(0, 339, 1023, 232);
		contentPaneAlunosCadastrados.add(scrollPaneAlunosCadastrados);
		
		tblAlunosCadastrados = new JTable();
		tblAlunosCadastrados.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Id", "Nome", "Nascimento", "Nacionalidade"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tblAlunosCadastrados.getColumnModel().getColumn(3).setPreferredWidth(92);
		scrollPaneAlunosCadastrados.setViewportView(tblAlunosCadastrados);
	}
}
