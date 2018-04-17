package com.projeto.model.json;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class RetUserEvento {

	private String nomeUser;
	private String nomeEvento;
	private String emailUser;
	private String ftUser;
	private String ftEvento;

	public void setFtUser(String ftUser) {
		this.ftUser = ftUser;
	}

	public void setFtEvento(String ftEvento) {
		this.ftEvento = ftEvento;
	}

	private String local;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date data;
	private double preco;

	public String getEmailUser() {
		return emailUser;
	}

	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}

	public String getNomeUser() {
		return nomeUser;
	}

	public void setNomeUser(String nomeUser) {
		this.nomeUser = nomeUser;
	}

	public String getNomeEvento() {
		return nomeEvento;
	}

	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

}
