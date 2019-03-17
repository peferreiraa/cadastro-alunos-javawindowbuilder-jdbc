package model.entities;

import java.util.Date;

public class Aluno {
	
	private Integer id;
	private String nome;
	private Date dataDeNascimento;
	private String nacionalidade;
	
	
	public Aluno() {
		
	}

	public Aluno(Integer id, String nome, Date dataDeNascimento, String nacionalidade) {
		this.nome = nome;
		this.dataDeNascimento = dataDeNascimento;
		this.nacionalidade = nacionalidade;
		this.id = id;
	}

	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	
	
	@Override
	public String toString() {
		return "Aluno: " + id + ", " + nome + ", " + dataDeNascimento + ", " + nacionalidade;
	}
	
	
	
	
}
