package com.supero.biblioteca.dto;

public class LivroFilterDTO {

	private String termo;
	private Integer anoPublicacaoInicio;
	private Integer anoPublicacaoFim;

	public Integer getAnoPublicacaoInicio() {
		return anoPublicacaoInicio;
	}

	public void setAnoPublicacaoInicio(Integer anoPublicacaoInicio) {
		this.anoPublicacaoInicio = anoPublicacaoInicio;
	}

	public Integer getAnoPublicacaoFim() {
		return anoPublicacaoFim;
	}

	public void setAnoPublicacaoFim(Integer anoPublicacaoFim) {
		this.anoPublicacaoFim = anoPublicacaoFim;
	}

	public String getTermo() {
		return termo;
	}

	public void setTermo(String termo) {
		this.termo = termo;
	}

}
