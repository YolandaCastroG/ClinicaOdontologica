package dh.backend.clinicaodontologica;

import dh.backend.clinicaodontologica.db.H2Connection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClinicaOdontologicaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClinicaOdontologicaApplication.class, args);
		H2Connection.crearTablas();
	}
}
