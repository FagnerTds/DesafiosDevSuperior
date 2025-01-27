package com.fagnertds.desafios;

import com.fagnertds.desafios.entities.Order;
import com.fagnertds.desafios.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class DesafiosApplication implements CommandLineRunner {

	@Autowired
	private OrderService orderService;
	public static void main(String[] args) {
		SpringApplication.run(DesafiosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("digite o código: ");
		Integer codigo = sc.nextInt();
		System.out.print("digite o Preço do produto: ");
		Double price = sc.nextDouble();
		System.out.print("Digite o desconto: ");
		Double discount = sc.nextDouble();

		Order order = new Order(codigo,price,discount);

		System.out.printf("Pedido Código: %d%n", order.getCode());
		System.out.printf("Valor total: %.2f", orderService.total(order));

	}
}
