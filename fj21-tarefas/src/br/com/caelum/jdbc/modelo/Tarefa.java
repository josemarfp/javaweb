package br.com.caelum.jdbc.modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class Tarefa {
	private Long id;
	
	@NotNull(message="{tarefa.descricao.vazia}")
	@Size(min=5, message="{tarefa.descricao.pequena}")
	private String descricao;
	
	private boolean finalizado;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private LocalDate dataFinalizacao;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public boolean getFinalizado() {
		return finalizado;
	}
	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}
	public LocalDate getDataFinalizacao() {
		return dataFinalizacao;
	}
	public String getDataFinalizacaoFormatada() {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String formattedString = (dataFinalizacao != null) ? dataFinalizacao.format(formatter) : "";
		return formattedString;
	}
	public void setDataFinalizacao(LocalDate dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}
	
}