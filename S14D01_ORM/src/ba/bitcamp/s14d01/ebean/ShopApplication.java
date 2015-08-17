package ba.bitcamp.s14d01.ebean;

import java.math.BigDecimal;

import org.avaje.agentloader.AgentLoader;

import ba.bitcamp.s14d01.ebean.models.Product;
import ba.bitcamp.s14d01.ebean.models.Purchase;
import ba.bitcamp.s14d01.ebean.models.User;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.EbeanServer;

public class ShopApplication {

	// statički blok se izvršava prilikom učitavanja klase u memoriju, dakle
	// prije pokretanja programa
	static {
		// radimo "enhancement" svih klasa u navedenom package-u
		AgentLoader.loadAgentFromClasspath("avaje-ebeanorm-agent",
				"debug=1;packages=ba.bitcamp.s14d01.ebean.models.**");
	}

	private static EbeanServer server = Ebean.getServer("h2");

	public static void main(String[] args) {
		// kreiranje novog zapisa o korisniku u bazu
		User first = new User();
		first.setFullName("Mujo Mujčinović");
		first.setEmail("mujo.mujcinovic@bitcamp.ba");
		first.setBalance(new BigDecimal(0));

		Ebean.save(first);

		// kreiranje novog zapisa o proizvodu
		Product monitor = new Product();
		monitor.setTitle("Monitor, Dell 28\"");
		monitor.setPrice(new BigDecimal("399.99"));
		monitor.setQuantity(0);

		Ebean.save(monitor);

		// update ranije spašenog proizvoda
		monitor.setQuantity(10);

		Ebean.save(monitor);
		System.out.println(monitor.getId());

		/* Nova kupovina: ubaciti u transakciju */
		Purchase firstUserPurchasedMonitor = new Purchase();
		firstUserPurchasedMonitor.setUser(first);
		firstUserPurchasedMonitor.setProduct(monitor);

		first.setBalance(first.getBalance().subtract(monitor.getPrice()));
		monitor.setQuantity(monitor.getQuantity() - 1);

		Ebean.save(firstUserPurchasedMonitor);

		/* Ispis ID-eva */
		System.out.println(first.getId());
		System.out.println(monitor.getId());
		System.out.println(firstUserPurchasedMonitor.getId());
	}

}
