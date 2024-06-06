package dh.backend.clinicaodontologica.service;

import dh.backend.clinicaodontologica.model.Turno;

import java.util.List;

public interface ITurnoService {
    Turno registrar (Turno turno);
    Turno buscarPorId(Integer id);
    List<Turno> buscarTodos();
    void actualizarturno(Turno turno);
    void eliminarTurno(Integer id);
}
