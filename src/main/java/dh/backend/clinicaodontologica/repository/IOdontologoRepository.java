package dh.backend.clinicaodontologica.repository;

import dh.backend.clinicaodontologica.entity.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IOdontologoRepository extends JpaRepository<Odontologo, Integer> {
    //Buscar odontologos por apellido
    @Query("Select o from Odontologo o where o.apellido = ?1")
    List<Odontologo> buscarPorApellido(String apellido);

    //Buscar odontologos por nombre
    @Query("Select o from Odontologo o where LOWER(o.nombre) LIKE LOWER(CONCAT('%',:nombre,'%'))")
    List<Odontologo> findByNombreLike(@Param("nombre") String nombre);
}