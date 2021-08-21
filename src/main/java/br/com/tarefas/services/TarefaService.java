package br.com.tarefas.services;

import java.util.List;
import java.util.Objects;

import br.com.tarefas.dao.TarefaDAO;
import br.com.tarefas.models.Tarefa;

public class TarefaService {
	
	private TarefaDAO tarefaDAO;

	public TarefaService() {
		tarefaDAO = new TarefaDAO();
	}
	
	public void save(Tarefa tarefa) throws Exception {
		validate(tarefa);
		tarefaDAO.save(tarefa);
	}
	
	public void update(Tarefa tarefa) throws Exception {
		validate(tarefa);
		tarefaDAO.update(tarefa);
	} 
	
	public void delete(Long id) {
		tarefaDAO.delete(id);
	}
	
	public Tarefa findById(Long id) {
		return tarefaDAO.findById(id);
	} 
	
	public List<Tarefa> findAll() {
		return tarefaDAO.findAll();
	}
	
	public void validate(Tarefa tarefa) throws Exception {
		if (Objects.isNull(tarefa.getTitulo()))
			throw new Exception("Título inválido!");
		else if (tarefa.getTitulo().isEmpty())
			throw new Exception("Título não pode ser vazio!");
		
		if (Objects.isNull(tarefa.getDescricao()))
			throw new Exception("Descrição inválida!");
		else if (tarefa.getDescricao().isEmpty())
			throw new Exception("Descricao não pode ser vazia!");
		
		if (Objects.isNull(tarefa.getPrioridade()))
			throw new Exception("Prioridade inválida!");
		else if (tarefa.getPrioridade().toString().isEmpty())
			throw new Exception("Prioridade não pode ser vazio!");
		
		if (Objects.isNull(tarefa.getDeadline()))
			throw new Exception("Data inválida!");
		
		if (Objects.isNull(tarefa.getResponsavel()))
			throw new Exception("Responsável inválido!");
		else if (tarefa.getResponsavel().getNome().isEmpty())
			throw new Exception("O campo nome do Responsável está vazio!");
	}
}
