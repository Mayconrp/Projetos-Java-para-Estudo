package br.com.sabium.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.sabium.classes.Emp_proj;
import br.com.sabium.classes.Project;
import br.com.sabium.crud.InterfaceCrud;
import br.com.sabium.hibernate.HibernateUtil;

import com.google.gson.Gson;

@SuppressWarnings({ "unchecked", "rawtypes" })
@Controller
@RequestMapping(value = "/projeto")
public class ProjetoController {

	@Autowired
	private InterfaceCrud interfaceCrud;

	@RequestMapping(value = "salvar", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity salvar(@RequestBody String jsonProjeto)
			throws Exception {
		Project projeto = new Gson().fromJson(jsonProjeto, Project.class);
		interfaceCrud.save(projeto);
		return new ResponseEntity(HttpStatus.CREATED);

	}

	@RequestMapping(value = "adicionar/{projeto}/funcionario/{funcionario}", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity adicionar(@PathVariable String projeto,
			@PathVariable String funcionario) throws Exception {
		List<Emp_proj> emp_projs = new ArrayList<Emp_proj>();

		int quantidade = getQuantidadeProjetoFuncionario(funcionario);

		if (quantidade < 2) {

			if (projeto.contains(",")) {

				String projetos[] = projeto.split(",");

				if ((quantidade + projetos.length) <= 2) {
					for (String proj : projetos) {
						Emp_proj emp_proj = new Emp_proj();
						emp_proj.setProj_id(Long.parseLong(proj));
						emp_proj.setEmp_id(Long.parseLong(funcionario));
						emp_projs.add(emp_proj);
					}
				}
			} else {
				Emp_proj emp_proj = new Emp_proj();
				emp_proj.setProj_id(Long.parseLong(projeto));
				emp_proj.setEmp_id(Long.parseLong(funcionario));
				emp_projs.add(emp_proj);
			}

			interfaceCrud.save(emp_projs);
		}
		return new ResponseEntity(HttpStatus.CREATED);

	}

	private int getQuantidadeProjetoFuncionario(String funcionario) {

		HibernateUtil.getCurrentSession().beginTransaction();
		Object quantidade = HibernateUtil
				.getCurrentSession()
				.createSQLQuery(
						"select count(1) from emp_proj  where emp_id = "
								+ funcionario).uniqueResult();
		return Integer.parseInt(quantidade.toString());
	}

}
