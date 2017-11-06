package OneToMany;

import java.util.HashSet;
import java.util.Set;

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
		Team team = new Team("Barcelona");
		Set<Player> players = new HashSet<Player>();
		Player p1 = new Player("Messi");
		Player p2 = new Player("Xavi");
		p1.setTeam(team); p2.setTeam(team);
		players.add(p1);
		players.add(p2);
		team.setPlayers(players);
		s.save(team);
		tx.commit();
		s.close();

	}

}
