package com.gft.clinicaveterinaria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.gft.clinicaveterinaria.init.InitData;
import com.gft.clinicaveterinaria.services.CachorroService;
import com.gft.clinicaveterinaria.services.ClienteService;
import com.gft.clinicaveterinaria.services.ConsultaService;
import com.gft.clinicaveterinaria.services.VeterinarioService;

@SpringBootApplication
//@EnableConfigurationProperties(SecurityConfig.class)

public class ClinicaVeterinariaApplication {

	public static void main(String[] args) {
		//SpringApplication.run(ClinicaVeterinariaApplication.class, args);

		ConfigurableApplicationContext configurableApplicationContext = SpringApplication
				.run(ClinicaVeterinariaApplication.class, args);
		ClienteService clienteService = configurableApplicationContext.getBean(ClienteService.class);
		CachorroService cachorroService = configurableApplicationContext.getBean(CachorroService.class);
		VeterinarioService veterinarioService = configurableApplicationContext.getBean(VeterinarioService.class);
		ConsultaService consultaService = configurableApplicationContext.getBean(ConsultaService.class);
		InitData initData = new InitData(cachorroService, clienteService, veterinarioService,consultaService);

		initData.popular();
	}

}
