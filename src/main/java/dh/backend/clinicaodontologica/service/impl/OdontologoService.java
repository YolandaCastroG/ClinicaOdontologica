package dh.backend.clinicaodontologica.service.impl;

import dh.backend.clinicaodontologica.dao.IDao;
import dh.backend.clinicaodontologica.model.Odontologo;
import dh.backend.clinicaodontologica.service.IOdontologoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdontologoService implements IOdontologoService {

    public OdontologoService(IDao<Odontologo> odontologoIDao) {
        this.odontologoIDao = odontologoIDao;
    }

    public IDao<Odontologo> getOdontologoIDao() {
        return odontologoIDao;
    }

    public void setOdontologoIDao(IDao<Odontologo> odontologoIDao) {
        this.odontologoIDao = odontologoIDao;
    }

    private IDao<Odontologo> odontologoIDao;

    public Odontologo registarOdontologo(Odontologo odontologo){
        return odontologoIDao.registrar(odontologo);
    }

    public Odontologo buscarUnOdontologo(Integer id){
        return odontologoIDao.buscarPorId(id);
    }
    public List<Odontologo> buscarTodosOdontologos(){
        return odontologoIDao.buscarTodos();
    }

    @Override
    public void actualizarOdontologo(Odontologo odontologo) {
        odontologoIDao.actualizar(odontologo);
    }

    @Override
    public void eliminarOdontologo(Integer id) {
        odontologoIDao.eliminar(id);
    }
}
