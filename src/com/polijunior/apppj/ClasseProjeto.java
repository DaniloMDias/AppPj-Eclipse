package com.polijunior.apppj;

public class ClasseProjeto {
	private long id;
	private String cliente;
	private String telefone;
	private String email;
	private String descricao;
	private String conheceu;
	private String atendente;
	
//	public ClasseProjeto(int id, String cliente, String telefone, String email, String descricao, String conheceu, String atendente){
//		super();
//		this._id = id;
//		this.cliente = cliente;
//		this.telefone = telefone;
//		this.email = email;
//		this.descricao = descricao;
//		this.conheceu = conheceu;
//		this.atendente = atendente;
//	}
	

	public long getId(){
		return id;
	}
	
	public void setId(long id){
		this.id = id;
	}
	
	
	public String getCliente(){
		return cliente;
	}
	
	public void setCliente(String cliente){
		this.cliente = cliente;
	}
	
	public String getTelefone(){
		return telefone;
	}
	public void setTelefone(String telefone){
		this.telefone = telefone;
	}
	
	public String getEmail(){
		return email;
	}
	public void setEmail(String email){
		this.email = email;
	}
	
	public String getDescricao(){
		return descricao;
	}
	
	public void setDescricao(String descricao){
		this.descricao = descricao;
	}
	
	public String getConheceu(){
		return conheceu;
	}
	
	public void setConheceu(String conheceu){
		this.conheceu = conheceu;
	}
	
	public String getAtendente(){
		return atendente;
	}
	
	public void setAtendente(String atendente){
		this.atendente = atendente;
	}
	
}
