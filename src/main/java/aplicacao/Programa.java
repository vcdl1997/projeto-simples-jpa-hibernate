package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		
//		Pessoa p1 = new Pessoa(null, "Carlos da Silva", "carlos@gmail.com");
//		Pessoa p2 = new Pessoa(null, "Joaquim da Silva", "joaquim@gmail.com");
//		Pessoa p3 = new Pessoa(null, "Maria da Silva", "maria@gmail.com");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();

		/*
		 * Em consultas simples n�o � necess�rio a utiliza��o do getTransaction()
		*/
		em.getTransaction().begin(); //Iniciando a transa��o no Banco
		
		Pessoa p1 = em.find(Pessoa.class, 2);  // Busca um elemento no banco com base na classe e no id
		System.out.println(p1.toString());
		
		em.remove(p1); // Remove o elemento com base em um elemento que j� est� sendo manipulado pelo EntityManager
		
//		em.persist(p1); // Inserindo um novo registro no banco
//		em.persist(p2); // Inserindo um novo registro no banco
//		em.persist(p3); // Inserindo um novo registro no banco
		
		em.getTransaction().commit(); // Efetivando as mudan�as no banco
		
		System.out.println("Pronto");
		
		em.close();
		emf.close();
	}

}
