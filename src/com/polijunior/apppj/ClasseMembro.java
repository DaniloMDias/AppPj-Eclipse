package com.polijunior.apppj;

public class ClasseMembro {
	private long id;
	private String nome;
	private String celular;
	private String email;
	private String curso;
	
	public long getId(){
		return id;
	}
	
	public void setId(long id){
		this.id = id;
	}
	
	
	public String getNome(){
		return nome;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public String getCelular(){
		return celular;
	}
	public void setCelular(String celular){
		this.celular = celular;
	}
	
	public String getEmail(){
		return email;
	}
	public void setEmail(String email){
		this.email = email;
	}
	
	public String getCurso(){
		return curso;
	}
	
	public void setCurso(String curso){
		this.curso = curso;
	}
}
