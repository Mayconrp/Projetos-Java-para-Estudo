package br.com.project.geral.controller;

/**
 * 
 * @author alex
 */
public class ValidadorSenhaBean {

	private int percentual;
	private String forca;

	public void setForca(String forca) {
		this.forca = forca;
	}

	public void setPercentual(int percentual) {
		this.percentual = percentual;
	}

	public String getForca() {
		return forca;
	}

	public int getPercentual() {
		return percentual;
	}

}
