package br.com.tarefas.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.tarefas.enums.EnumPrioridade;
import br.com.tarefas.models.Tarefa;
import br.com.tarefas.services.TarefaService;

@ManagedBean
@SessionScoped
public class TarefaMBean {
	
	private Tarefa tarefa;
	
	private List<Tarefa> tarefas;
	
	private TarefaService tarefaService;

	public TarefaMBean() {
		tarefa = new Tarefa();
		tarefas = new ArrayList<>();
		tarefaService = new TarefaService();
	} 
	
	public String cadastrarTarefa() {
		tarefa = new Tarefa();
		
		return "/formTarefa.xhtml";
	}
	
	public String listarTarefas() {
		tarefas  = new ArrayList<>();
		
		return "/index.xhtml";
	}
	
	public String salvarTarefa() throws Exception {
		try {
			tarefaService.save(tarefa);
			addMensagemSucesso("Tarefa cadastrada com sucesso.");
			
			tarefa = new Tarefa();
		} catch (Exception e) {
			addMensagemErro(e.getMessage());
		}
		return null;
	}
	
	public String removerTarefa(Long id) {
		tarefaService.delete(id);
		addMensagemSucesso("Tarefa removida com sucesso.");
		
		return null;
	}
	
	public void addMensagemErro(String mensagem) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, ""));
	}

	public void addMensagemSucesso(String mensagem) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, ""));
	}

	public Tarefa getTarefa() {
		return tarefa;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}

	public List<Tarefa> getTarefas() {
		return tarefas;
	}

	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}	
	
	public EnumPrioridade[] getPrioridades() {
		return EnumPrioridade.values();
	}

}
