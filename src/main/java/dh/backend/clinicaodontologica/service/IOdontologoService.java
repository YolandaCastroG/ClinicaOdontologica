package dh.backend.clinicaodontologica.service;

import dh.backend.clinicaodontologica.model.Odontologo;
import java.util.List;

public interface IOdontologoService {
    Odontologo registarOdontologo(Odontologo odontologo);
    Odontologo buscarUnOdontologo(Integer id);
    List<Odontologo> buscarTodosOdontologos();
    void actualizarOdontologo(Odontologo odontologo);
    void eliminarOdontologo(Integer id);


}
