package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo05 {
	//elminar version 2 -> usando búsqueda
	public static void main(String[] args) {
		//eliminar un usuario
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = fabrica.createEntityManager();
		
		em.getTransaction().begin();

		Usuario u = em.find(Usuario.class, 5);
		if(u==null)
			System.err.println("Codigo no existe");
		else {					
		em.remove(u);
		System.err.println("Usuario eliminado");
		}
		
		//confirma transaccion
		em.getTransaction().commit();
		em.close();
	}
}

