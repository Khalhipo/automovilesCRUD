/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Bueno
 */
public class AutomovilesCRUD {
    
        public static List<Automoviles> getAutomoviles() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_automovilesCRUD_war_1PU");
        EntityManager manager = factory.createEntityManager();
        String sql = "SELECT * FROM automoviles";
        Query q = manager.createNativeQuery(sql, Automoviles.class); //método para consultas en SQL
        List<Automoviles> autosBD = q.getResultList();

        return autosBD;
    }

    public static int actualizaAutomovil(Automoviles miAuto) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_automovilesCRUD_war_1PU");
        EntityManager manager = factory.createEntityManager();
        String sql = "UPDATE Automoviles a SET a.marca = :marca, a.modelo = :modelo, a.cv = :cv WHERE a.id = :id";
        Query q = manager.createQuery(sql, Automoviles.class);
        q.setParameter("id", miAuto.getId());
        q.setParameter("marca", miAuto.getMarca());
        q.setParameter("modelo", miAuto.getModelo());
        q.setParameter("cv", miAuto.getCv());
        manager.getTransaction().begin();
        int filasAfectadas = q.executeUpdate();
        manager.getTransaction().commit();
        manager.close();
        return filasAfectadas;
    }

    public static void insertaAutomovil(Automoviles automovil) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_automovilesCRUD_war_1PU");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        manager.merge(automovil);
        manager.getTransaction().commit();
    }

    public static int destroyAutomovil(int id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_automovilesCRUD_war_1PU");
        EntityManager manager = factory.createEntityManager();
        String sql = "DELETE from Automoviles a WHERE a.id = " + id;
        Query q = manager.createQuery(sql);
        manager.getTransaction().begin();
        int filasAfectadas = q.executeUpdate(); 
        manager.getTransaction().commit();
        return filasAfectadas;
    }

    public static Automoviles getAutomovil(int id) {  
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_automovilesCRUD_war_1PU");
        EntityManager manager = factory.createEntityManager();
        String sql = "SELECT a FROM Automoviles a WHERE a.id=" + id;
        Query q = manager.createQuery(sql, Automoviles.class); 
        Automoviles miAuto = (Automoviles) q.getSingleResult(); 
        manager.close();
        return miAuto;
    }
}
