package ManyToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class Client {
	public static void main(String[] args) {

		Configuration cfg = new AnnotationConfiguration().configure("hibernate.cfg.xml").configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		Employer employer = new Employer();
		employer.setEmployer_name("Synechron");
		Employee emp = new Employee();
		emp.setEmployer(employer);
		emp.setName("Swapnil");
		emp.setEmployer(employer);
		Employee emp1 = new Employee();
		emp1.setEmployer(employer);
		emp1.setName("Sanjay");
		emp1.setEmployer(employer);
		s.save(emp1);
		s.save(emp);
		tx.commit();
		s.close();

	}
}
