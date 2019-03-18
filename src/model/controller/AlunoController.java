package model.controller;

import java.util.List;

import model.dao.AlunoDao;
import model.dao.DaoFactory;
import model.entities.Aluno;

public class AlunoController {
	
	private AlunoDao dao = DaoFactory.createAlunoDao();
	
	public List<Aluno> findAll(){
		return dao.findAll();
	}
	
	public void insertStudent(Aluno obj) {
		dao.insert(obj);
	}
	
	public void updateStudent(Aluno obj) {
		dao.update(obj);
	}
	
	public void deleteStudent(Integer id) {
		dao.deleteById(id);
	}
	
	public List<Aluno> findById(Integer id) {
		return dao.findById(id);
		
	}
	
	public List<Aluno> finByName(String name){
		return dao.findByName(name);
	}
}
