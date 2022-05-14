package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo01 {

	public static void main(String[] args) {
		//valores del nuevo usuario
		Usuario u = new Usuario(10,"Juan","Perez","jperez@gmail.com",
				"345","2000/01/15",1,1);
		
		//grabar en la tabla --> JPA
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = fabrica.createEntityManager();
		
		//empieza transaccion
		em.getTransaction().begin();
		//proceso de grabado en tabla
		em.persist(u);
		//confirma transaccion
		em.getTransaction().commit();
		em.close();
	}
	
}
