package br.com.sabium.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.sabium.classes.BeanConsultaProjetoFuncuinario;
import br.com.sabium.classes.Employee;
import br.com.sabium.crud.InterfaceCrud;
import br.com.sabium.hibernate.HibernateUtil;

import com.google.gson.Gson;

@Controller
@RequestMapping(value = "/funcionario")
public class FuncionarioController {

	@Autowired
	private InterfaceCrud<Employee> interfaceCrud;

	@RequestMapping(value = "salvar", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity salvar(@RequestBody String jsonFuncionario)
			throws Exception {
		Employee funcionario = new Gson().fromJson(jsonFuncionario,
				Employee.class);
		interfaceCrud.save(funcionario);
		return new ResponseEntity(HttpStatus.CREATED);

	}
 
	@RequestMapping(value = "listar", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public String listar() throws Exception {
       List<BeanConsultaProjetoFuncuinario> beanConsultaProjetoFuncuinarios = new ArrayList<BeanConsultaProjetoFuncuinario>();
		
		HibernateUtil.getCurrentSession().beginTransaction();

		StringBuilder select = new StringBuilder();

		select.append(" select * from ( ")
				.append("  select  a.emp_id, count(1) as quantidade from emp_proj a ")
				.append("  group by  a.emp_id) as f where f.quantidade > 1 ");
		
		List<Object[]> objects = (List<Object[]>) HibernateUtil.getCurrentSession().createSQLQuery(select.toString()).list();

		for (Object[] objeto : objects) {
			
			BeanConsultaProjetoFuncuinario e = new BeanConsultaProjetoFuncuinario();
			e.setFuncionario(Integer.valueOf(""+objeto[0]));
			e.setQtde_projetos(Integer.valueOf(""+objeto[1]));
			beanConsultaProjetoFuncuinarios.add(e);
		}
		
		return new Gson().toJson(beanConsultaProjetoFuncuinarios);
		
	}

}
