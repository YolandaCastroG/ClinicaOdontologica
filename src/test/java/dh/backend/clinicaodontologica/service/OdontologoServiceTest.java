package dh.backend.clinicaodontologica.service;

import dh.backend.clinicaodontologica.dao.impl.OdontologoIDaoH2;
import dh.backend.clinicaodontologica.model.Odontologo;
import dh.backend.clinicaodontologica.service.impl.OdontologoService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;



class OdontologoServiceTest {
    private static Logger LOGGER = LoggerFactory.getLogger(OdontologoServiceTest.class);
    private static OdontologoService odontologoService = new OdontologoService(new OdontologoIDaoH2());

    @BeforeAll
    static void crearTablas(){
        Connection connection = null;
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:~/ClinicaOdontologica;INIT=RUNSCRIPT FROM 'create.sql'", "sa", "sa");
        } catch (Exception e){
            e.printStackTrace();
            LOGGER.error(e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                LOGGER.error(e.getMessage());
            }
        }
    }

    @Test
    @DisplayName("Testear que un odontologo fue guardado")
    void testOdontologoGuardado(){
        Odontologo odontologo = new Odontologo(24, 849384, "Dario", "Mendoza");
        Odontologo odontologoGuardado = odontologoService.registarOdontologo(odontologo);

        assertNotNull(odontologoGuardado.getId());
    }

    @Test
    @DisplayName("Testear busqueda paciente por id")
    void testOdontologoPorId(){
        Integer id = 1;
        Odontologo odontologoEncontrado = odontologoService.buscarUnOdontologo(id);

        assertEquals(id, odontologoEncontrado.getId());
    }

    @Test
    @DisplayName("Testear busqueda todos los odontologos")
    void testBusquedaTodos() {
        Odontologo odontologo = new Odontologo(656, 343456456, "Lina", "Real");
        odontologoService.registarOdontologo(odontologo);

        List<Odontologo> odontologos = odontologoService.buscarTodosOdontologos();

        assertNotNull(odontologos);
        assertTrue(odontologos.size() != 0);
    }
}
