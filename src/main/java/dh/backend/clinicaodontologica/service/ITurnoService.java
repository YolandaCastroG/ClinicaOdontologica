package dh.backend.clinicaodontologica.service;

import dh.backend.clinicaodontologica.dto.request.TurnoRequestDto;
import dh.backend.clinicaodontologica.dto.response.TurnoResponseDto;

import java.util.List;

public interface ITurnoService {
    TurnoResponseDto registrar (TurnoRequestDto turnoRequestDto);
    TurnoResponseDto buscarPorId(Integer id);
    List<TurnoResponseDto> buscarTodos();
    void actualizarTurno(Integer id, TurnoRequestDto turnoRequestDto);
    void eliminarTurno(Integer id);
}
