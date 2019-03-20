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
import java.util.Date;
import java.util.List;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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

public class viewTelaDeAlunosCadastrados extends JFrame {

	private JPanel contentPaneAlunosCadastrados;
	private JTable tblAlunosCadastrados;
	private JTextField textPesquisaID;
	private JTextField textPesquisaPorNome;
	private JTextField textDeletar;
	private JTextField txtAtualizarNome;
	private JTextField txtAtualizarDataNascimento;
	private JTextField txtAtualizarNacionalidade;
	private JTextField txtId;
	
	public AlunoController controller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewTelaDeAlunosCadastrados frame = new viewTelaDeAlunosCadastrados();
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
	public viewTelaDeAlunosCadastrados() {
		setUndecorated(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				readJTable();
			}
		});
		setResizable(false);
		setMinimumSize(new Dimension(1029, 600));
		setMaximumSize(new Dimension(1029, 600));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		scrollPaneAlunosCadastrados.setBounds(0, 393, 1023, 178);
		contentPaneAlunosCadastrados.add(scrollPaneAlunosCadastrados);

		tblAlunosCadastrados = new JTable();
		tblAlunosCadastrados.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int line = tblAlunosCadastrados.getSelectedRow();
				txtId.setText(tblAlunosCadastrados.getValueAt(line, 0).toString());
				txtAtualizarNome.setText(tblAlunosCadastrados.getValueAt(line, 1).toString());
				txtAtualizarDataNascimento.setText(tblAlunosCadastrados.getValueAt(line, 2).toString());
				txtAtualizarNacionalidade.setText(tblAlunosCadastrados.getValueAt(line, 3).toString());
				
				textDeletar.setText((tblAlunosCadastrados.getValueAt(line, 0).toString()));
			}
		});
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
		lblPesquisaPorId.setFont(new Font("Consolas", Font.BOLD, 20));
		lblPesquisaPorId.setBounds(497, 77, 204, 38);
		contentPaneAlunosCadastrados.add(lblPesquisaPorId);

		textPesquisaID = new JTextField();
		textPesquisaID.setBackground(new Color(28,28,28));
		textPesquisaID.setFont(new Font("Consolas", Font.BOLD, 18));
		textPesquisaID.setForeground(Color.WHITE);
		textPesquisaID.setBorder(new MatteBorder(0, 0, 1, 0, (Color) SystemColor.textHighlight));
		textPesquisaID.setBounds(697, 85, 184, 20);
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
		btnPesquisarID.setBounds(904, 84, 89, 23);
		contentPaneAlunosCadastrados.add(btnPesquisarID);
		
		JLabel lblPesquisaNome = new JLabel("Consulta por nome");
		lblPesquisaNome.setForeground(Color.WHITE);
		lblPesquisaNome.setFont(new Font("Consolas", Font.BOLD, 20));
		lblPesquisaNome.setBounds(497, 147, 214, 38);
		contentPaneAlunosCadastrados.add(lblPesquisaNome);
		
		textPesquisaPorNome = new JTextField();
		textPesquisaPorNome.setBackground(new Color(28,28,28));
		textPesquisaPorNome.setFont(new Font("Consolas", Font.BOLD, 18));
		textPesquisaPorNome.setForeground(Color.WHITE);
		textPesquisaPorNome.setBorder(new MatteBorder(0, 0, 1, 0, (Color) SystemColor.textHighlight));
		textPesquisaPorNome.setColumns(10);
		textPesquisaPorNome.setBounds(697, 155, 184, 20);
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
		btnPesquisarNome.setBounds(904, 154, 89, 23);
		contentPaneAlunosCadastrados.add(btnPesquisarNome);
		
		JPanel pnlIAlunosCadastrados = new JPanel();
		pnlIAlunosCadastrados.setBorder(new MatteBorder(0, 0, 0, 2, (Color) SystemColor.textHighlight));
		pnlIAlunosCadastrados.setBackground(new Color(28, 28, 28));
		pnlIAlunosCadastrados.setForeground(Color.BLACK);
		pnlIAlunosCadastrados.setBounds(10, 41, 456, 327);
		contentPaneAlunosCadastrados.add(pnlIAlunosCadastrados);
		pnlIAlunosCadastrados.setLayout(null);
		
		JLabel lblNomeAtualizar = new JLabel("Nome");
		lblNomeAtualizar.setForeground(Color.WHITE);
		lblNomeAtualizar.setFont(new Font("Consolas", Font.BOLD, 20));
		lblNomeAtualizar.setBounds(20, 86, 73, 38);
		pnlIAlunosCadastrados.add(lblNomeAtualizar);
		
		txtAtualizarNome = new JTextField();
		txtAtualizarNome.setBackground(new Color(28,28,28));
		txtAtualizarNome.setFont(new Font("Consolas", Font.BOLD, 18));
		txtAtualizarNome.setForeground(Color.WHITE);
		txtAtualizarNome.setBorder(new MatteBorder(0, 0, 1, 0, (Color) SystemColor.textHighlight));
		txtAtualizarNome.setColumns(10);
		txtAtualizarNome.setBounds(245, 95, 184, 20);
		pnlIAlunosCadastrados.add(txtAtualizarNome);
		
		JLabel lblNascimento = new JLabel("Data de nascimento");
		lblNascimento.setForeground(Color.WHITE);
		lblNascimento.setFont(new Font("Consolas", Font.BOLD, 20));
		lblNascimento.setBounds(20, 135, 215, 38);
		pnlIAlunosCadastrados.add(lblNascimento);
		
		txtAtualizarDataNascimento = new JTextField();
		txtAtualizarDataNascimento.setBackground(new Color(28,28,28));
		txtAtualizarDataNascimento.setFont(new Font("Consolas", Font.BOLD, 18));
		txtAtualizarDataNascimento.setForeground(Color.WHITE);
		txtAtualizarDataNascimento.setBorder(new MatteBorder(0, 0, 1, 0, (Color) SystemColor.textHighlight));
		txtAtualizarDataNascimento.setColumns(10);
		txtAtualizarDataNascimento.setBounds(245, 144, 184, 20);
		pnlIAlunosCadastrados.add(txtAtualizarDataNascimento);
		
		JLabel lblNacionalidade = new JLabel("Nacionalidade");
		lblNacionalidade.setForeground(Color.WHITE);
		lblNacionalidade.setFont(new Font("Consolas", Font.BOLD, 20));
		lblNacionalidade.setBounds(20, 193, 165, 38);
		pnlIAlunosCadastrados.add(lblNacionalidade);
		
		txtAtualizarNacionalidade = new JTextField();
		txtAtualizarNacionalidade.setBackground(new Color(28,28,28));
		txtAtualizarNacionalidade.setFont(new Font("Consolas", Font.BOLD, 18));
		txtAtualizarNacionalidade.setForeground(Color.WHITE);
		txtAtualizarNacionalidade.setBorder(new MatteBorder(0, 0, 1, 0, (Color) SystemColor.textHighlight));
		txtAtualizarNacionalidade.setColumns(10);
		txtAtualizarNacionalidade.setBounds(245, 202, 184, 20);
		pnlIAlunosCadastrados.add(txtAtualizarNacionalidade);
		
		JLabel lblId = new JLabel("Id");
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("Consolas", Font.BOLD, 20));
		lblId.setBounds(20, 34, 73, 38);
		pnlIAlunosCadastrados.add(lblId);
		
		txtId = new JTextField();
		txtId.setForeground(SystemColor.textHighlight);
		txtId.setFont(new Font("Consolas", Font.BOLD, 20));
		txtId.setBackground(new Color(28,28,28));
		txtId.setBorder(new MatteBorder(0, 0, 1, 0, (Color) SystemColor.textHighlight));
		txtId.setEditable(false);
		txtId.setColumns(10);
		txtId.setBounds(245, 43, 184, 20);
		pnlIAlunosCadastrados.add(txtId);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Aluno obj = new Aluno();
				controller = new AlunoController();
				obj.setNome(txtAtualizarNome.getText());
				obj.setDataDeNascimento(new Date());
				obj.setNacionalidade(txtAtualizarNacionalidade.getText());
				obj.setId(Integer.parseInt(txtId.getText()));
				controller.updateStudent(obj);
			}
		});
		btnAtualizar.setBorder(null);
		btnAtualizar.setBackground(SystemColor.textHighlight);
		btnAtualizar.setBounds(190, 271, 89, 23);
		pnlIAlunosCadastrados.add(btnAtualizar);
		
		JLabel lblDeletarAluno = new JLabel("Deletar aluno ");
		lblDeletarAluno.setForeground(Color.WHITE);
		lblDeletarAluno.setFont(new Font("Consolas", Font.BOLD, 20));
		lblDeletarAluno.setBounds(497, 222, 168, 38);
		contentPaneAlunosCadastrados.add(lblDeletarAluno);
		
		textDeletar = new JTextField();
		textDeletar.setBackground(new Color(28,28,28));
		textDeletar.setFont(new Font("Consolas", Font.BOLD, 18));
		textDeletar.setForeground(Color.WHITE);
		textDeletar.setBorder(new MatteBorder(0, 0, 1, 0, (Color) SystemColor.textHighlight));
		textDeletar.setColumns(10);
		textDeletar.setBounds(697, 230, 184, 20);
		contentPaneAlunosCadastrados.add(textDeletar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller = new AlunoController();
				controller.deleteById(Integer.parseInt(textDeletar.getText()));
			}
		});
		btnDeletar.setBackground(SystemColor.textHighlight);
		btnDeletar.setBorder(null);
		btnDeletar.setBounds(904, 229, 89, 23);
		contentPaneAlunosCadastrados.add(btnDeletar);
		readJTable();
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 191, 255));
		panel.setBounds(0, 0, 1029, 28);
		contentPaneAlunosCadastrados.add(panel);
		panel.setLayout(null);
		
		JLabel lblFechar = new JLabel("");
		lblFechar.setBounds(989, 0, 30, 30);
		panel.add(lblFechar);
		lblFechar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
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
		controller = new AlunoController();

		for (Aluno p : controller.findById(id)) {
			model.addRow(new Object[] { p.getId(), p.getNome(), p.getDataDeNascimento(), p.getNacionalidade() });
		}
	}
	public void readForName(String name) {
		DefaultTableModel model = (DefaultTableModel) tblAlunosCadastrados.getModel();

		model.setRowCount(0);
		controller = new AlunoController();

		for (Aluno p : controller.finByName(name)) {
			model.addRow(new Object[] { p.getId(), p.getNome(), p.getDataDeNascimento(), p.getNacionalidade() });
		}
	}
}
