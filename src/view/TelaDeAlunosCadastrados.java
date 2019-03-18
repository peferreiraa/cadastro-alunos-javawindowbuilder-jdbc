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
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import javax.swing.ImageIcon;

public class TelaDeAlunosCadastrados extends JFrame {

	private JPanel contentPaneAlunosCadastrados;
	private JTable tblAlunosCadastrados;
	private JTextField textPesquisaID;
	private JTextField textPesquisaPorNome;
	private JTextField textDeletar;

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
		scrollPaneAlunosCadastrados.setBorder(null);
		scrollPaneAlunosCadastrados.setFont(new Font("Consolas", Font.BOLD, 11));
		scrollPaneAlunosCadastrados.setBackground(Color.WHITE);
		scrollPaneAlunosCadastrados.setBounds(0, 344, 1023, 227);
		contentPaneAlunosCadastrados.add(scrollPaneAlunosCadastrados);

		tblAlunosCadastrados = new JTable();
		tblAlunosCadastrados.setSelectionBackground(Color.WHITE);
		tblAlunosCadastrados.setFont(new Font("Consolas", Font.BOLD, 14));
		tblAlunosCadastrados.setBackground(Color.LIGHT_GRAY);
		tblAlunosCadastrados.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "Id", "Nome", "Nascimento", "Nacionalidade" }) {
					boolean[] columnEditables = new boolean[] { false, false, false, false };

					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
		tblAlunosCadastrados.getColumnModel().getColumn(3).setPreferredWidth(92);
		scrollPaneAlunosCadastrados.setViewportView(tblAlunosCadastrados);

		JLabel lblPesquisaPorId = new JLabel("Consulta por ID");
		lblPesquisaPorId.setForeground(Color.WHITE);
		lblPesquisaPorId.setFont(new Font("Consolas", Font.BOLD, 22));
		lblPesquisaPorId.setBounds(430, 61, 214, 38);
		contentPaneAlunosCadastrados.add(lblPesquisaPorId);

		textPesquisaID = new JTextField();
		textPesquisaID.addKeyListener(new KeyAdapter() {
			/*@Override
			public void keyTyped(KeyEvent e) {
				readJTable();
				int id = Integer.parseInt(textPesquisaID.getText());
				readForId(id);
				
			}*/
		});
		textPesquisaID.setBounds(675, 70, 184, 20);
		contentPaneAlunosCadastrados.add(textPesquisaID);
		textPesquisaID.setColumns(10);
		
		JButton btnPesquisarID = new JButton("Consultar");
		btnPesquisarID.setBorder(null);
		btnPesquisarID.setBackground(SystemColor.textHighlight);
		btnPesquisarID.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int id = Integer.parseInt(textPesquisaID.getText());
				readForId(id);
			}
		});
		btnPesquisarID.setBounds(869, 69, 89, 23);
		contentPaneAlunosCadastrados.add(btnPesquisarID);
		
		JLabel lblPesquisaNome = new JLabel("Consulta por nome");
		lblPesquisaNome.setForeground(Color.WHITE);
		lblPesquisaNome.setFont(new Font("Consolas", Font.BOLD, 22));
		lblPesquisaNome.setBounds(430, 131, 214, 38);
		contentPaneAlunosCadastrados.add(lblPesquisaNome);
		
		textPesquisaPorNome = new JTextField();
		textPesquisaPorNome.setColumns(10);
		textPesquisaPorNome.setBounds(675, 140, 184, 20);
		contentPaneAlunosCadastrados.add(textPesquisaPorNome);
		
		JButton btnPesquisarNome = new JButton("Consultar");
		btnPesquisarNome.setBorder(null);
		btnPesquisarNome.setBackground(SystemColor.textHighlight);
		btnPesquisarNome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				readForName(textPesquisaPorNome.getText());
			}
		});
		btnPesquisarNome.setBounds(869, 139, 89, 23);
		contentPaneAlunosCadastrados.add(btnPesquisarNome);
		
		JPanel pnlIAlunosCadastrados = new JPanel();
		pnlIAlunosCadastrados.setBorder(new MatteBorder(0, 0, 0, 2, (Color) SystemColor.textHighlight));
		pnlIAlunosCadastrados.setBackground(new Color(28, 28, 28));
		pnlIAlunosCadastrados.setForeground(Color.BLACK);
		pnlIAlunosCadastrados.setBounds(35, 41, 379, 292);
		contentPaneAlunosCadastrados.add(pnlIAlunosCadastrados);
		pnlIAlunosCadastrados.setLayout(null);
		
		JLabel lblConsultar = new JLabel("Consultar");
		lblConsultar.setBounds(47, 21, 161, 40);
		pnlIAlunosCadastrados.add(lblConsultar);
		lblConsultar.setFont(new Font("Consolas", Font.BOLD, 24));
		lblConsultar.setForeground(Color.WHITE);
		
		JLabel lblAtualizar = new JLabel("Atualizar");
		lblAtualizar.setBounds(47, 127, 161, 40);
		pnlIAlunosCadastrados.add(lblAtualizar);
		lblAtualizar.setFont(new Font("Consolas", Font.BOLD, 24));
		lblAtualizar.setForeground(Color.WHITE);
		
		JLabel lblDeletar = new JLabel("Deletar");
		lblDeletar.setBounds(47, 228, 161, 40);
		pnlIAlunosCadastrados.add(lblDeletar);
		lblDeletar.setFont(new Font("Consolas", Font.BOLD, 24));
		lblDeletar.setForeground(Color.WHITE);
		
		JLabel lblIconConsultar = new JLabel("");
		lblIconConsultar.setIcon(new ImageIcon("F:\\ws-javaswing\\cadastro-alunos-javawindowbuilder-jdbc\\icons\\icons8_window_search_100px.png"));
		lblIconConsultar.setBounds(243, 11, 97, 67);
		pnlIAlunosCadastrados.add(lblIconConsultar);
		
		JLabel lblIconAtualizar = new JLabel("");
		lblIconAtualizar.setIcon(new ImageIcon("F:\\ws-javaswing\\cadastro-alunos-javawindowbuilder-jdbc\\icons\\icons8_save_as_96px.png"));
		lblIconAtualizar.setBounds(243, 114, 97, 67);
		pnlIAlunosCadastrados.add(lblIconAtualizar);
		
		JLabel lblIconeDeletar = new JLabel("");
		lblIconeDeletar.setIcon(new ImageIcon("F:\\ws-javaswing\\cadastro-alunos-javawindowbuilder-jdbc\\icons\\icons8_delete_forever_96px_2.png"));
		lblIconeDeletar.setBounds(243, 214, 97, 67);
		pnlIAlunosCadastrados.add(lblIconeDeletar);
		
		JLabel lblDeletarAluno = new JLabel("Deletar aluno ");
		lblDeletarAluno.setForeground(Color.WHITE);
		lblDeletarAluno.setFont(new Font("Consolas", Font.BOLD, 22));
		lblDeletarAluno.setBounds(430, 223, 214, 38);
		contentPaneAlunosCadastrados.add(lblDeletarAluno);
		
		textDeletar = new JTextField();
		textDeletar.setColumns(10);
		textDeletar.setBounds(675, 232, 184, 20);
		contentPaneAlunosCadastrados.add(textDeletar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setBackground(SystemColor.textHighlight);
		btnDeletar.setBorder(null);
		btnDeletar.setBounds(869, 231, 89, 23);
		contentPaneAlunosCadastrados.add(btnDeletar);
		readJTable();
		

	}

	public void readJTable() {
		DefaultTableModel model = (DefaultTableModel) tblAlunosCadastrados.getModel();

		model.setRowCount(0);
		AlunoController controller = new AlunoController();

		for (Aluno p : controller.findAll()) {
			model.addRow(new Object[] { p.getId(), p.getNome(), p.getDataDeNascimento(), p.getNacionalidade() });
		}

	}
	
	public void readForId(Integer id) {
		DefaultTableModel model = (DefaultTableModel) tblAlunosCadastrados.getModel();

		model.setRowCount(0);
		AlunoController controller = new AlunoController();

		for (Aluno p : controller.findById(id)) {
			model.addRow(new Object[] { p.getId(), p.getNome(), p.getDataDeNascimento(), p.getNacionalidade() });
		}
	}
	public void readForName(String name) {
		DefaultTableModel model = (DefaultTableModel) tblAlunosCadastrados.getModel();

		model.setRowCount(0);
		AlunoController controller = new AlunoController();

		for (Aluno p : controller.finByName(name)) {
			model.addRow(new Object[] { p.getId(), p.getNome(), p.getDataDeNascimento(), p.getNacionalidade() });
		}
	}
}
