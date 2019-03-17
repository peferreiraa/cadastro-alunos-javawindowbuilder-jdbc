package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.AlunoDao;
import model.entities.Aluno;

public class AlunoDaoJDBC implements AlunoDao {

	private Connection conn;
	
	public AlunoDaoJDBC(Connection conn) {
		super();
		this.conn = conn;
	}

	@Override
	public void insert(Aluno obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"insert into alunos "
					+ "(id, nome, nascimento, nacionalidade) values (?, ?, ?, ?)");
			st.setInt(1, obj.getId());
			st.setString(2, obj.getNome());
			st.setDate(3, new java.sql.Date(obj.getDataDeNascimento().getTime()));
			st.setString(4, obj.getNacionalidade());
			
			int rowsAffected = st.executeUpdate();
			if(rowsAffected > 0) {
				System.out.println("Rows affected: " + rowsAffected);
			}else {
				throw new DbException("No rows affected");
			}
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public void update(Aluno obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"update alunos "
					+ "set nome = ?, nascimento = ?, nacionalidade = ? where id = ?");
			st.setString(1, obj.getNome());
			st.setDate(2, new java.sql.Date(obj.getDataDeNascimento().getTime()));
			st.setString(3, obj.getNacionalidade());
			st.setInt(4, obj.getId());
			st.executeUpdate();
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Aluno findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("select * from alunos "
					+ " where id = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			if(rs.next()) {
				Aluno obj = new Aluno();
				obj.setId(rs.getInt("id"));
				obj.setNome(rs.getString("nome"));
				obj.setDataDeNascimento(rs.getDate("nascimento"));
				obj.setNacionalidade(rs.getString("nacionalidade"));
				return obj;
			}
			return null;
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<Aluno> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("Select * from "
					+ "alunos order by nome");
			
			rs = st.executeQuery();
			
			List<Aluno> list = new ArrayList<>();
			while(rs.next()) {
				Aluno obj = new Aluno();
				obj.setNome(rs.getString("nome"));
				obj.setDataDeNascimento(rs.getDate("nascimento"));
				obj.setNacionalidade(rs.getString("nacionalidade"));
				list.add(obj);
			}
			return list;
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

}
