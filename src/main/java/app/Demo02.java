package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo02 {
	
	public static void main(String[] args) {
		//actualizar los datos de un usuario
		Usuario u = new Usuario(3,"Carla","Toro","U002@gmail.com",
				"10002","2000/01/15",2,1);
		
		//grabar en la tabla --> JPA
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = fabrica.createEntityManager();
		
		//empieza transaccion
		em.getTransaction().begin();
		//proceso de Actualizar en tabla O inserta si no existe
		em.merge(u);
		//confirma transaccion
		em.getTransaction().commit();
		em.close();
	}

}
