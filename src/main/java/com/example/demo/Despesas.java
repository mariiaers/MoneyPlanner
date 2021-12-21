package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "despesas")
public class Despesas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String data;
	
	@Column(nullable = false)
	private String tipo;
	
	@Column(nullable = false)
	private String descricao;
	
	@Column(nullable = false)
	private String valor;
	
	@Column(nullable = true)
	private String status;
	
	@Column(nullable = false)
	private String formapg;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFormapg() {
		return formapg;
	}

	public void setFormapg(String formapg) {
		this.formapg = formapg;
	}

	@Override
	public String toString() {
		return "Despesas [id=" + id + ", data=" + data + ", tipo=" + tipo + ", descricao=" + descricao + ", valor="
				+ valor + ", status=" + status + ", formapg=" + formapg + "]";
	}

}
