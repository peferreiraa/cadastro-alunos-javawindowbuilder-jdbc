package model.dao;

import java.util.List;

import model.entities.Aluno;

public interface AlunoDao {
	
	void insert(Aluno obj);
	void update(Aluno obj);
	void deleteById(Integer id);
	List<Aluno> findById(Integer id);
	List<Aluno> findByName(String name);
	List<Aluno> findAll();
}
