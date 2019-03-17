package application;

import java.sql.Connection;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import db.DB;
import model.dao.AlunoDao;
import model.dao.DaoFactory;
import model.dao.impl.AlunoDaoJDBC;
import model.entities.Aluno;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		AlunoDao alunoDao = DaoFactory.createAlunoDao();
		Aluno aluno;
		
		System.out.println("Enter id for delete: ");
		int id = sc.nextInt();
		alunoDao.deleteById(1);
		
		sc.close();
		DB.closeConnection();
	}

}
