package com.example.springbootDemo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.springbootDemo.entities.Category;
import com.example.springbootDemo.entities.Order;
import com.example.springbootDemo.entities.OrderItem;
import com.example.springbootDemo.entities.Payment;
import com.example.springbootDemo.entities.Product;
import com.example.springbootDemo.entities.User;
import com.example.springbootDemo.enums.OrderStatus;
import com.example.springbootDemo.repositories.CategoryRepository;
import com.example.springbootDemo.repositories.OrderItemRepository;
import com.example.springbootDemo.repositories.OrderRepository;
import com.example.springbootDemo.repositories.ProductRepository;
import com.example.springbootDemo.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Games");
		Category cat2 = new Category(null, "Eletronics");
		Category cat3 = new Category(null, "Computers");
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		Product p1 = new Product(null, "CyberPunk 2077", "description", 50.00, "");
		Product p2 = new Product(null, "Headset K8", "description", 250.00, "");
		Product p3 = new Product(null, "PC Core i9", "description", 3000.00, "");
		p1.getCategories().add(cat1);
		p2.getCategories().add(cat2);
		p3.getCategories().add(cat2);
		p3.getCategories().add(cat3);
		productRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		User u1 = new User(null, "Joao Silva", "joao@email.com", "+5599999999", "password");
		User u2 = new User(null, "Jack Smith", "jack@email.com", "+1999999999", "password");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.CANCELED, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.SHIPPED, u1);
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3));
		
		Payment pay1 = new Payment(null, Instant.parse("2019-06-20T22:53:07Z"), o1);
		o1.setPayment(pay1);
		orderRepository.save(o1);
	}

}
