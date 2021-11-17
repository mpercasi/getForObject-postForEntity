package com.example.apirestexercise;

import com.example.apirestexercise.entity.Customer;
import com.example.apirestexercise.entity.RealEstateProperty;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ApiRestExerciseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestExerciseApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception{
		return args -> {
			Customer c = new Customer();
			c.setName("Marcos");
			c.setDni("PECM776655GHTRFFB");

			//With getForObject ---------------------------------------------
			Customer customer = restTemplate.getForObject("http://localhost:8080/customers/1112", Customer.class);
			System.out.println(customer);

			//With postForEntity ---------------------------------------------
			ResponseEntity <Customer> customer2 = restTemplate.postForEntity("http://localhost:8080/customers", c, Customer.class);
			System.out.println(customer2);

			System.out.println("---------------------------------------------");
			System.out.println("---------------------------------------------");

			RealEstateProperty rspInstance = new RealEstateProperty();
			rspInstance.setAddress("Presita 11");
			rspInstance.setCode(1);
			rspInstance.setAmount(25000.02);

			//With getForEntity---------------------------------------------
			ResponseEntity<RealEstateProperty> rsp = restTemplate.getForEntity("http://localhost:8080/properties/2", RealEstateProperty.class);
			System.out.println(rsp.getBody());

			//With postForObject---------------------------------------------
			RealEstateProperty rsp2 = restTemplate.postForObject("http://localhost:8080/properties", rspInstance, RealEstateProperty.class);
			System.out.println(rsp2);
		};
	}



}
