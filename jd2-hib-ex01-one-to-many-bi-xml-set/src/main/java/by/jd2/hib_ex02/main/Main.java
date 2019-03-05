package by.jd2.hib_ex02.main;


import java.text.ParseException;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import by.jd2.hib_ex02.bean.Task;
import by.jd2.hib_ex02.bean.User;

public class Main {

	public static void main(String[] args) throws ParseException {
		
		//retrieveUserAndUserTasks();
		retrieveUserTasksAndUser();

	}
	

	public static void retrieveUserAndUserTasks() {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		session.beginTransaction();

		int userId = 8;
		User user= session.get(User.class, userId);		
		
		System.out.println("User: " + user.getUserDetail().getCity());
		
		Set<Task> tasks = user.getTasks();
		
		System.out.println("---- " + tasks.size());
		
		for(Task task : tasks) {
			System.out.println(task.getIdTask() + " - " + task.getTitle());
		}
		
		session.getTransaction().commit();

		session.close();
		factory.close();
	}
	
	
	public static void retrieveUserTasksAndUser() {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		session.beginTransaction();

		int taskId = 5;
		Task task = session.get(Task.class, taskId);		
		
		System.out.println("Task: " + task.getTitle() + ", " + task.getUser().getFirstName());
		
		session.getTransaction().commit();

		session.close();
		factory.close();
	}



}
