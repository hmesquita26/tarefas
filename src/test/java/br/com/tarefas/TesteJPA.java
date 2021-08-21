package br.com.tarefas;

import javax.persistence.Persistence;

public class TesteJPA {
	
	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("tarefas");
	}

}
