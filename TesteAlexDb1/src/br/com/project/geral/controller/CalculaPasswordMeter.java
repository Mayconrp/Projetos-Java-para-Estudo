package br.com.project.geral.controller;

import java.util.HashSet;
import java.util.Set;

public class CalculaPasswordMeter {
	private String senha = "aEC45a++";

	public CalculaPasswordMeter(String senha) {
		this.senha = senha;
	}

	public String descricaoForca() {
		int percentual = calcularPercentual();
		String forca = "";
		if (percentual >= 0 && percentual <= 20) {
			forca = "Muito Fraca";
		} else if (percentual > 20 && percentual <= 40) {
			forca = "Fraca";
		} else if (percentual > 40 && percentual <= 60) {
			forca = "Boa";
		} else if (percentual > 60 && percentual <= 80) {
			forca = "Forte";
		} else if (percentual > 80) { 
			forca = "Muito Forte";
		}

		return forca;
	}

	public int calcularPercentual() {
		int calculoFinal = 0;

		// Soma
		calculoFinal += (getValorNumeroCaracteres(senha));
		calculoFinal += (getValorLetrasMaiuscula(senha));
		calculoFinal += (getValorLetrasMinuscula(senha));
		calculoFinal += (getValorNumeros(senha));
		calculoFinal += (getValorSimbolos(senha));
		calculoFinal += (getValorMediaNumeroLetras(senha));
		calculoFinal += (getValorRequeridos(senha));

		// Diminui
		calculoFinal -= (getValorSomenteLetra(senha));
		calculoFinal -= (getValorSomenteNumero(senha));
		calculoFinal -= (getValorLetrasRepetidas(senha));
		calculoFinal -= (getValorMaiusculaConsecutiva(senha));
		calculoFinal -= (getValorMinusculaConsecutiva(senha));
		calculoFinal -= (getValorNumerosConsecutiva(senha));
		calculoFinal -= (getValorLetrasSequenciais(senha));
		calculoFinal -= (getValorNumeroSequenciais(senha));
		calculoFinal -= (getValorSimbolosSequenciais(senha));

		if (calculoFinal < 0) {
			calculoFinal = 0;
		} else if (calculoFinal > 100) {
			calculoFinal = 100;
		}

		return calculoFinal;
	}

	private int getValorNumeroCaracteres(String senha) {
		return senha.length() * 4;
	}

	private int getValorLetrasMaiuscula(String senha) {
		int retorno = 0;
		for (int i = 0; i < senha.length(); i++) {
			char unidade = senha.charAt(i);
			if (Character.isUpperCase(unidade)) {
				retorno++;
			}

		}
		return (senha.length() - retorno) * 2;
	}

	private int getValorLetrasMinuscula(String senha) {
		int retorno = 0;
		for (int i = 0; i < senha.length(); i++) {
			char unidade = senha.charAt(i);
			if (Character.isLowerCase(unidade)) {
				retorno++;
			}

		}
		return (senha.length() - retorno) * 2;
	}

	private int getValorNumeros(String senha) {
		int retorno = 0;
		for (int i = 0; i < senha.length(); i++) {
			char unidade = senha.charAt(i);
			if (Character.isDigit(unidade)) {
				retorno++;
			}

		}
		return retorno * 4;
	}

	private int getValorSimbolos(String senha) {
		int retorno = 0;
		for (int i = 0; i < senha.length(); i++) {
			char unidade = senha.charAt(i);
			if (!Character.isLetter(unidade) && !Character.isDigit(unidade)) {
				retorno++;
			}

		}
		return retorno * 6;
	}

	private int getValorMediaNumeroLetras(String senha) {
		int retorno = 0;
		for (int i = 0; i < senha.length(); i++) {
			char unidade = senha.charAt(i);
			if ((!Character.isLetter(unidade) && !Character.isDigit(unidade))
					|| Character.isDigit(unidade)) {
				retorno++;
			}

		}

		if (((retorno - 1) * 2) > 0) {
			return (retorno - 1) * 2;

		} else
			return 0;

	}

	private int getValorRequeridos(String senha) {
		int retorno = 0;
		for (int i = 0; i < senha.length(); i++) {
			char unidade = senha.charAt(i);
			if ((!Character.isLetter(unidade) && !Character.isDigit(unidade))
					|| Character.isDigit(unidade)) {
				retorno++;
			}

		}
		return (retorno) * 2;
	}

	private int getValorSomenteLetra(String senha) {
		int retorno = 0;
		for (int i = 0; i < senha.length(); i++) {
			char unidade = senha.charAt(i);
			if (Character.isLetter(unidade)) {
				retorno++;
			}

		}

		if (retorno == senha.length()) {
			return retorno;
		}
		return 0;
	}

	private int getValorSomenteNumero(String senha) {
		int retorno = 0;
		for (int i = 0; i < senha.length(); i++) {
			char unidade = senha.charAt(i);
			if ((!Character.isLetter(unidade) && !Character.isDigit(unidade))
					|| Character.isDigit(unidade)) {
				retorno++;
			}

		}

		if (retorno == senha.length()) {
			return retorno;
		}
		return 0;
	}

	private int getValorLetrasRepetidas(String senha) {
		Set<String> lista = new HashSet<String>();
		int retorno = 0;
		for (int i = 0; i < senha.length(); i++) {
			char unidade = senha.charAt(i);

			if (lista.contains("" + unidade)) {
				retorno++;
			} else {
				lista.add("" + unidade);
			}

		}
		return retorno * senha.length();
	}

	private int getValorMaiusculaConsecutiva(String senha) {
		int retorno = 0;
		for (int i = 0; i < senha.length(); i++) {
			char unidade = senha.charAt(i);

			if (Character.isLetter(unidade) && !Character.isDigit(unidade)
					&& !Character.isDigit(unidade)
					&& Character.isUpperCase(unidade)) {
				retorno++;
			}
		}
		return retorno * 2;
	}

	private int getValorMinusculaConsecutiva(String senha) {
		int retorno = 0;
		for (int i = 0; i < senha.length(); i++) {
			char unidade = senha.charAt(i);

			if (Character.isLetter(unidade) && !Character.isDigit(unidade)
					&& !Character.isDigit(unidade)
					&& Character.isLowerCase(unidade)) {
				retorno++;
			}
		}
		return retorno * 2;
	}

	private int getValorNumerosConsecutiva(String senha) {
		int retorno = 0;
		for (int i = 0; i < senha.length(); i++) {
			char unidade = senha.charAt(i);

			if (!Character.isLetter(unidade) && Character.isDigit(unidade)) {
				retorno++;
			}
		}
		return retorno * 2;
	}

	private int getValorLetrasSequenciais(String senha) {
		int retorno = 0;
		for (int i = 0; i < senha.length(); i++) {
			char unidade = senha.charAt(i);

			if (Character.isLetter(unidade) && !Character.isDigit(unidade)
					&& !Character.isDigit(unidade)) {
				if (i > 1) {
					if (senha.charAt(i) == senha.charAt(i - 1)) {
						retorno++;
					}
				}
			}
		}
		return retorno * 3;
	}

	private int getValorNumeroSequenciais(String senha) {
		int retorno = 0;
		for (int i = 0; i < senha.length(); i++) {
			char unidade = senha.charAt(i);

			if (!Character.isLetter(unidade) && Character.isDigit(unidade)) {
				if (i > 1) {
					if (senha.charAt(i) == senha.charAt(i - 1)) {
						retorno++;
					}
				}
			}
		}
		return retorno * 3;
	}

	private int getValorSimbolosSequenciais(String senha) {
		int retorno = 0;
		for (int i = 0; i < senha.length(); i++) {
			char unidade = senha.charAt(i);

			if (!Character.isLetter(unidade) && !Character.isDigit(unidade)) {
				if (i > 1) {
					if (senha.charAt(i) == senha.charAt(i - 1)) {
						retorno++;
					}
				}
			}
		}
		return retorno * 3;
	}

}
