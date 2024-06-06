package dh.backend.clinicaodontologica.controller;

import dh.backend.clinicaodontologica.model.Odontologo;
import dh.backend.clinicaodontologica.service.IOdontologoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologo")
public class OdontologoController {

    public IOdontologoService odontologoService;

    public OdontologoController(IOdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    @PostMapping
    public ResponseEntity<Odontologo> registrarOdontologo(@RequestBody Odontologo odontologo){
        Odontologo odontologoARetornar = odontologoService.registarOdontologo(odontologo);
        if(odontologoARetornar == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body(odontologoARetornar);
        }
    }

    @GetMapping
    public ResponseEntity<List<Odontologo>> buscarTodos(){
        return ResponseEntity.ok(odontologoService.buscarTodosOdontologos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> buscarOdontologoPorId(@PathVariable Integer id){
        Odontologo odontologo = odontologoService.buscarUnOdontologo(id);
        if(odontologo != null){
            return ResponseEntity.ok(odontologo);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping
    public ResponseEntity<String> actualizarOdontologo(@RequestBody Odontologo odontologo){
        Odontologo odontologoABuscar = odontologoService.buscarUnOdontologo(odontologo.getId());
        if(odontologoABuscar != null){
            odontologoService.actualizarOdontologo(odontologo);
            return ResponseEntity.ok("{\"message\": \"Odontologo modificado\"}");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarOdontologo(@PathVariable Integer id){
        Odontologo odontologoABuscar = odontologoService.buscarUnOdontologo(id);
        if(odontologoABuscar != null){
            odontologoService.eliminarOdontologo(id);
            return ResponseEntity.ok("{\"message\": \"Odontologo eliminado\"}");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
