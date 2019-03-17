package application;

import java.sql.Connection;
import java.util.List;

import db.DB;
import model.dao.AlunoDao;
import model.dao.DaoFactory;
import model.dao.impl.AlunoDaoJDBC;
import model.entities.Aluno;

public class Program {

	public static void main(String[] args) {
		
		AlunoDao alunoDao = DaoFactory.createAlunoDao();
		
		Aluno aluno = alunoDao.findById(1);

		List<Aluno> list = alunoDao.findAll();
		for(Aluno obj : list) {
			System.out.println(obj);
		}
		
		DB.closeConnection();
	}

}
