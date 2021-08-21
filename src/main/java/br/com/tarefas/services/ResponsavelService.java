package br.com.tarefas.services;

import java.util.List;
import java.util.Objects;

import br.com.tarefas.dao.ResponsavelDAO;
import br.com.tarefas.models.Responsavel;
import br.com.tarefas.models.Tarefa;

public class ResponsavelService {
	
	private ResponsavelDAO responsavelDAO;

	public ResponsavelService() {
		responsavelDAO = new ResponsavelDAO();
	}
	
	public void save(Responsavel responsavel) throws Exception {
		validate(responsavel);
		responsavelDAO.save(responsavel);
	}
	
	public void update(Responsavel responsavel) throws Exception {
		validate(responsavel);
		responsavelDAO.update(responsavel);
	} 
	
	public void delete(Long id) {
		responsavelDAO.delete(id);
	}
	
	public Responsavel findById(Long id) {
		return responsavelDAO.findById(id);
	}
	
	public List<Responsavel> findAll() {
		return responsavelDAO.findAll();
	}
	
	public void validate(Responsavel responsavel) throws Exception {
		if (Objects.isNull(responsavel.getNome()))
			throw new Exception("Nome inválido!");
		else if (responsavel.getNome().isEmpty())
			throw new Exception("O campo Nome não pode ser vazio!");
	}
	

}
