package org.sid;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.sid.dao.ContactRepository;
import org.sid.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiRestContactsApplication implements CommandLineRunner {
	@Autowired
	private ContactRepository contactRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ApiRestContactsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		DateFormat df=new SimpleDateFormat("dd/MM/yyy");
		contactRepository.save(new Contact("Ambidina", "Moussa", df.parse("12/09/1988"),"moussa@gmail.com", 0661010465, "mouss.png"));
		contactRepository.save(new Contact("Petrucci", "Thomas", df.parse("09/08/1992"),"thomas@gmail.com", 0661010465, "thom.png"));
		contactRepository.save(new Contact("Sunner", "Sema", df.parse("10/04/1993"),"sema@gmail.com", 0661010465, "sem.png"));
		contactRepository.save(new Contact("Testu", "Jennifer", df.parse("13/07/1994"),"jennifer@gmail.com", 0661010465, "jenn.png"));
		contactRepository.findAll().forEach(c->{
			System.out.println(c.getNom());
		});
	}

}

