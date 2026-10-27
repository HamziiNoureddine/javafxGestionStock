package com.hamzi.hnia.dz;


import com.hamzi.hnia.dz.Models.RolesType;
import com.hamzi.hnia.dz.Services.rolesService;
import javafx.application.Application;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static javafx.application.Application.launch;

@SpringBootApplication
public class SpringApplicationStock  {

	public static void main(String[] args) {
	launch(SpringFx.class,args);
	}

@Bean
CommandLineRunner start(rolesService rolesService){
		return args->{
		   System.out.println("commadlinerunner is executed");
		};
}

}
