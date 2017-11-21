package entities;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.persistence.Entity;
import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.Session;

public class Princi {

	static HashMap<Integer, Actores> actores;

	public static void main(String[] args) {

		actores = new HashMap<>();

		Scanner sc = new Scanner(System.in);

		System.out.println("0- Mostrar");
		System.out.println("1- Borrar uno");
		System.out.println("2- Borrar Todo");
		System.out.println("3- Añadir uno");
		System.out.println("4- Volcar Datos");
		int caso = sc.nextInt();
		
			if(caso == 0){
				mostrar();
			}
			if(caso == 1){
				borrarUno();
			}
			if(caso == 2){
				borrarTodo();
			}
	}

	public static void borrarUno() {
		for (Actores a : actores.values()) {
			System.out.println(a.toString());
		}
	}

	public static void mostrar() {
	Session session;
	HibernateUtil util = new HibernateUtil();
//		
	session = util.getSessionFactory().openSession();

//		Query q = session.createQuery("select e from Actores e");
//		List results = q.list();
//
//		Iterator equiposIterator = results.iterator();
//
//		while (equiposIterator.hasNext()) {
//			Actores team = (Actores) equiposIterator.next();
//			actores.put(team.getCodigo(), team);
//		}
		
		Query q = session.createQuery("select e from Actores e");
		List results = q.list();
		Iterator actoresIterator = results.iterator();
		while (actoresIterator.hasNext()) {
			Actores Act = (Actores) actoresIterator.next();

			System.out.println("Nombre: " + Act.getNombre());
			System.out.println(" ");
			System.out.println("Fecha De Nacimiento: " + Act.getFNacimiento());
			System.out.println("Nacionalidad: " + Act.getNacionalidad());

}
	}

	public static void borrarTodo() {
		Session session;
		HibernateUtil util = new HibernateUtil();

		session = util.getSessionFactory().openSession();
		session.beginTransaction();

		Query q = session.createQuery("delete from Actores");
		q.executeUpdate();
		q = session.createQuery("delete from Peliculas");
		q.executeUpdate();
		session.getTransaction().commit();
	}

	public static void importar() {
		borrarTodo();
	}

}