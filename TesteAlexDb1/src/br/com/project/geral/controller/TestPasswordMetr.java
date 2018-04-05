package br.com.project.geral.controller;

public class TestPasswordMetr {
	String senha = "aEC45a++";

	public void test() {
		CalculaPasswordMeter calculaPasswordMeter = new CalculaPasswordMeter(
				senha);
		System.out.println(calculaPasswordMeter.calcularPercentual());
		System.out.println(calculaPasswordMeter.descricaoForca());

	}

}
