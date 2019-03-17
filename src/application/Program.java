package application;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import db.DB;
import model.dao.AlunoDao;
import model.dao.DaoFactory;
import model.dao.impl.AlunoDaoJDBC;
import model.entities.Aluno;

public class Program {

	public static void main(String[] args) {
		
		AlunoDao alunoDao = DaoFactory.createAlunoDao();
		
		//Aluno aluno = alunoDao.findById(1);

		Aluno novoAluno = new Aluno("jose", new Date(), "Brasil");
		alunoDao.insert(novoAluno);
		System.out.println("Insert: " + novoAluno.getNome());
		
		DB.closeConnection();
	}

}
