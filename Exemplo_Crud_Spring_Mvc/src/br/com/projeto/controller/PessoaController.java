package br.com.projeto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.projeto.classes.Pessoa;
import br.com.projeto.classes.PessoaBean;
import br.com.projeto.classes.TelefonePessoa;
import br.com.projeto.classes.TelefonePessoaBean;
import br.com.projeto.crud.ImplementacaoCrud;

import com.google.gson.Gson;

@Controller
@RequestMapping(value="/pessoa")
public class PessoaController extends ImplementacaoCrud<Pessoa>{


	@RequestMapping(value="salvar", method = RequestMethod.POST)
	public String salvar(Model model, Pessoa pessoa) throws Exception {

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("{");
		stringBuilder.append("\"id\":").append("\""+(pessoa.getId() != null ? pessoa.getId() : "")+"\",");
		stringBuilder.append("\"nome\":").append("\""+pessoa.getNome()+"\",");
		stringBuilder.append("\"endereco\":").append("\""+pessoa.getEndereco()+"\",");
		stringBuilder.append("\"telefonePessoas\":[").append(pessoa.getTelefonePessoasTemp()+"]");
		stringBuilder.append("}");
		
		PessoaBean  pessoaBean = new Gson().fromJson(stringBuilder.toString(), PessoaBean.class);
		
		for (TelefonePessoaBean bean : pessoaBean.getTelefonePessoas()) {
			TelefonePessoa telefonePessoa = new TelefonePessoa();
			telefonePessoa.setNumero(bean.getNumero());
			telefonePessoa.setPessoa(pessoa);
			
			pessoa.getTelefonePessoas().add(telefonePessoa);
		}
		
		pessoa = super.merge(pessoa);
		model.addAttribute("pessoa", pessoa);
 		return "pessoasalva";
	}

	
	
	@RequestMapping(value="iniciar", method = RequestMethod.POST)
	public String iniciar() {
		return "iniciar";
	}

}
