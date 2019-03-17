package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Aluno obj) {
		// TODO Auto-generated method stub
		
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
