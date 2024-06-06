package dh.backend.clinicaodontologica.dao.impl;

import dh.backend.clinicaodontologica.dao.IDao;
import dh.backend.clinicaodontologica.db.H2Connection;
import dh.backend.clinicaodontologica.model.Odontologo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class OdontologoIDaoH2 implements IDao<Odontologo> {
    private static Logger LOGGER = LoggerFactory.getLogger(OdontologoIDaoH2.class);
    private static String SQL_INSERT = "INSERT INTO ODONTOLOGOS VALUES (DEFAULT,?,?,?)";
    private  static String SQL_SELECT_ID = "SELECT * FROM ODONTOLOGOS WHERE ID = ?";
    private static String SQL_SELECT_ALL = "SELECT * FROM ODONTOLOGOS";
    private static String SQL_UPDATE = "UPDATE ODONTOLOGOS SET MATRICULA=?, NOMBRE=?, APELLIDO=? WHERE ID=?";
    private static String SQL_DELETE = "DELETE FROM ODONTOLOGOS WHERE ID=?";

    @Override
    public Odontologo registrar (Odontologo odontologo) {
        Connection connection= null;
        Odontologo odontologoARetornar = null;
        try {
            connection = H2Connection.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1,odontologo.getMatricula());
            preparedStatement.setString(2, odontologo.getNombre());
            preparedStatement.setString(3, odontologo.getApellido());
            preparedStatement.executeUpdate();
            ResultSet resultSet= preparedStatement.getGeneratedKeys();
            while (resultSet.next()){
                Integer id = resultSet.getInt(1);
                odontologoARetornar = new Odontologo(id,odontologo.getMatricula(),
                        odontologo.getNombre(), odontologo.getApellido());
            }
            LOGGER.info("Odontologo registrado: "+ odontologoARetornar);
            connection.commit();
            connection.setAutoCommit(true);
        }catch (Exception e){
            if(connection!=null){
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    LOGGER.info(ex.getMessage());
                    ex.printStackTrace();
                }
            }
            LOGGER.info(e.getMessage());
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                LOGGER.info(e.getMessage());
                e.printStackTrace();
            }
        }
        return odontologoARetornar;
    }

    @Override
    public Odontologo buscarPorId(Integer id) {
        Connection connection = null;
        Odontologo odontologoEncontrado = null;
        try {
            connection = H2Connection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Integer idNuevo = resultSet.getInt(1);
                Integer matricula = resultSet.getInt(2);
                String nombre = resultSet.getString(3);
                String apellido = resultSet.getString(4);
                odontologoEncontrado = new Odontologo(idNuevo, matricula, nombre, apellido);
            }
            LOGGER.info("El odontologo encontrado es: "+ odontologoEncontrado);
        }catch (Exception e) {
            LOGGER.info(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                LOGGER.info(e.getMessage());
                e.printStackTrace();
            }
        }
        return odontologoEncontrado;
    }

    @Override
    public List<Odontologo> buscarTodos() {
        Connection connection = null;
        Odontologo odontologoObtenido = null;
        List<Odontologo> odontologos = new ArrayList<>();
        try{
            connection = H2Connection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL);
            while (resultSet.next()){
                odontologoObtenido = crearOdontologo(resultSet);
                odontologos.add(odontologoObtenido);
                LOGGER.info("Agregando odontologo: "+odontologoObtenido);
            }
        }catch (Exception e) {
            LOGGER.info(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                LOGGER.info(e.getMessage());
                e.printStackTrace();
            }
        }
        return odontologos;
    }

    @Override
    public void actualizar(Odontologo odontologo) {
        Connection connection = null;
        DomicilioDaoH2 domicilioDaoH2 = new DomicilioDaoH2();
        try{
            connection = H2Connection.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE);
            preparedStatement.setInt(1, odontologo.getMatricula());
            preparedStatement.setString(2, odontologo.getNombre());
            preparedStatement.setString(3, odontologo.getApellido());
            preparedStatement.setInt(4, odontologo.getId());
            preparedStatement.executeUpdate();
            LOGGER.info("Odontólogo actualizado: "+ odontologo);
            connection.commit();
            connection.setAutoCommit(true);
        }catch (Exception e){
            if(connection!=null){
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    LOGGER.info(ex.getMessage());
                    ex.printStackTrace();
                }
            }
            LOGGER.info(e.getMessage());
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                LOGGER.info(e.getMessage());
                e.printStackTrace();
            }
        }
    }

    @Override
    public void eliminar(Integer id) {
        Connection connection = null;
        try{
            connection = H2Connection.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            LOGGER.info("Odontólogo eliminado");
            connection.commit();
            connection.setAutoCommit(true);
        }catch (Exception e){
            if(connection!=null){
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    LOGGER.info(ex.getMessage());
                    ex.printStackTrace();
                }
            }
            LOGGER.info(e.getMessage());
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                LOGGER.info(e.getMessage());
                e.printStackTrace();
            }
        }
    }

    private Odontologo crearOdontologo(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(1);
        int matricula = resultSet.getInt(2);
        String nombre = resultSet.getString(3);
        String apellido = resultSet.getString(4);
        Odontologo odontologo = new Odontologo(id,matricula,nombre,apellido);
        return odontologo;
    }
}
