package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo03 {
	
	public static void main(String[] args) {
		//eliminar un usuario
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = fabrica.createEntityManager();
		
		//empieza transaccion
		em.getTransaction().begin();
		//proceso de Eliminacion de usuario
		//Forma 1. borrado lógico (No es borrado, solo cambia el estado, osea updt)
		//em.merge(u);
		
		//Forma 2. borrado físico (Necesita todos los datos)
		Usuario u = new Usuario(3,"Carla","Toro","U002@gmail.com",
				"10002","2000/01/15",2,1);
		em.remove(u);
		
		//confirma transaccion
		em.getTransaction().commit();
		em.close();
	}
}
