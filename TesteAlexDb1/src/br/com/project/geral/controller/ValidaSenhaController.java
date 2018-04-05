package br.com.project.geral.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.google.gson.Gson;

@Controller
public class ValidaSenhaController {

	@RequestMapping(value = "testedb1", method = RequestMethod.GET)
	public String testedb1() {
		return "testedb1";
	}

	@RequestMapping(value = "validarSenha", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody
	String validarSenha(@RequestParam String password) throws Exception {

		CalculaPasswordMeter calculaPasswordMeter = new CalculaPasswordMeter(
				password);

		ValidadorSenhaBean validadorSenhaBean = new ValidadorSenhaBean();
		validadorSenhaBean.setForca(calculaPasswordMeter.descricaoForca());
		validadorSenhaBean.setPercentual(calculaPasswordMeter
				.calcularPercentual());

		return new Gson().toJson(validadorSenhaBean, ValidadorSenhaBean.class);

	}

}
