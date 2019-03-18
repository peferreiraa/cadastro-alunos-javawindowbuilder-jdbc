package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.controller.AlunoController;
import model.entities.Aluno;

import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JTabbedPane;
import java.awt.ComponentOrientation;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.List;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				readJTable();
			}
		});
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
		scrollPaneAlunosCadastrados.setFont(new Font("Consolas", Font.BOLD, 11));
		scrollPaneAlunosCadastrados.setBackground(Color.WHITE);
		scrollPaneAlunosCadastrados.setBounds(0, 339, 1023, 232);
		contentPaneAlunosCadastrados.add(scrollPaneAlunosCadastrados);
		
		tblAlunosCadastrados = new JTable();
		tblAlunosCadastrados.setSelectionBackground(Color.WHITE);
		tblAlunosCadastrados.setFont(new Font("Tahoma", Font.BOLD, 11));
		tblAlunosCadastrados.setBackground(Color.LIGHT_GRAY);
		tblAlunosCadastrados.setModel(new DefaultTableModel(
			new Object[][] {
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
		readJTable();
		
	}
	
	public void readJTable() {
			DefaultTableModel model = (DefaultTableModel) tblAlunosCadastrados.getModel();
			
			model.setRowCount(0);
			AlunoController controller = new AlunoController();
			
			for(Aluno p: controller.findAll()) {
				model.addRow(new Object[] {
						p.getId(),
						p.getNome(),
						p.getDataDeNascimento(),
						p.getNacionalidade()
				});
			}
			
		}
}
