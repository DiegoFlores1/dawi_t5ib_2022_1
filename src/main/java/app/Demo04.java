package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo04 {
	
	public static void main(String[] args) {
		//obtener los datos de un usuario segun el codigo

		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = fabrica.createEntityManager();
		
		//empieza transaccion
		em.getTransaction().begin();

		Usuario u = em.find(Usuario.class, 5);
		
		//confirma transaccion
		em.getTransaction().commit();
		em.close();
	}
}
