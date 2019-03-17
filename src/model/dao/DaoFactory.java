package model.dao;

import model.dao.impl.AlunoDaoJDBC;

public class DaoFactory {
	
	public static AlunoDao createAlunoDao() {
		return new AlunoDaoJDBC();
	}
}	
