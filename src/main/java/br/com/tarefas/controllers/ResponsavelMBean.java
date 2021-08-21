package br.com.tarefas.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.tarefas.models.Responsavel;
import br.com.tarefas.services.ResponsavelService;

@ManagedBean
@SessionScoped
public class ResponsavelMBean {
	
	private Responsavel responsavel;
	
	private ResponsavelService responsavelService;
	
	private List<Responsavel> listaResponsavel;

	public ResponsavelMBean() {
		responsavel = new Responsavel();
		responsavelService = new ResponsavelService();
		listaResponsavel = new ArrayList<>();
	}
	
	public String cadastrarResponsavel() {
		responsavel = new Responsavel();
		
		return "/formResponsavel.xhtml";
	}
	
	public String salvarResponsavel() throws Exception {
		try {
			responsavelService.save(responsavel);
			addMensagemSucesso("Responsável cadastrado com sucesso!");
			
			responsavel = new Responsavel();
		} catch (Exception e) {
			addMensagemErro(e.getMessage());
		}
		return null;
	}
	
	public String removerResposanvel(Long id) {
		responsavelService.delete(id);
		addMensagemSucesso("Responsável removido com sucesso!");
		
		return null;
	}

	public void addMensagemSucesso(String mensagem) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, ""));
	}
	
	public void addMensagemErro(String mensagem) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, ""));
	}

	public Responsavel getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}
	
	public List<Responsavel> getResponsaveis() {
		return responsavelService.findAll();
	}
	
	public List<Responsavel> getListaResponsavel() {
		return listaResponsavel;
	}

	public void setListaResponsavel(List<Responsavel> listaResponsavel) {
		this.listaResponsavel = listaResponsavel;
	}	

}
