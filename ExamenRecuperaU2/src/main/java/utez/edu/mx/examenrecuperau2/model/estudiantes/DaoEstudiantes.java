package utez.edu.mx.examenrecuperau2.model.estudiantes;

import utez.edu.mx.examenrecuperau2.model.Repository;
import utez.edu.mx.examenrecuperau2.model.docentes.DaoDocentes;
import utez.edu.mx.examenrecuperau2.model.evaluacion.BeanEvaluacion;
import utez.edu.mx.examenrecuperau2.util.ConnectionMySQL;
import utez.edu.mx.examenrecuperau2.util.Response;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoEstudiantes implements Repository<BeanEstudiantes> {
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    ConnectionMySQL client = new ConnectionMySQL();


    @Override
    public List<BeanEstudiantes> findAll() {
        List <BeanEstudiantes> estudiantes = new ArrayList<>();
        BeanEstudiantes estudian = null;
        BeanEvaluacion evaluacion = null;
        try{
            conn = client.getConnection();
            String query = "SELECT * FROM estudiantes;";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()){
                estudian = new BeanEstudiantes();
                evaluacion = new BeanEvaluacion();
                estudian.setId(rs.getLong("id"));
                estudian.setNombre(rs.getString("nombre"));
                estudian.setApellidoPaterno(rs.getString("apellidoPaterno"));
                estudian.setApellidoMaterno(rs.getString("apellidoMaterno"));
                estudian.setFechaNacimiento(rs.getString("fechaNacimiento"));
                estudian.setCurp(rs.getString("curp"));
                estudian.setMatricula(rs.getString("matricula"));
                estudian.setCalificacion(evaluacion);
            }
        }catch (SQLException e) {
            Logger.getLogger(DaoDocentes.class.getName()).log(Level.SEVERE, "Error -> findAll de Estudiantes" + e.getMessage());
        }finally {
            client.close(conn, ps, rs);
        }
        return estudiantes;
    }

    @Override
    public Response save(BeanEstudiantes object) {
        BeanEstudiantes estudian = new BeanEstudiantes();
        try{
            conn = client.getConnection();
            String query = "INSERT INTO estudiantes (nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, curp, matricula, calificacionT) VALUES (?,?,?,?,?,?,?);";
            ps = conn.prepareStatement(query);
            ps.setString(1, estudian.getNombre());
            ps.setString(2, estudian.getApellidoPaterno());
            ps.setString(3, estudian.getApellidoMaterno());
            ps.setString(4, estudian.getFechaNacimiento());
            ps.setString(5, estudian.getCurp());
            ps.setString(6, estudian.getMatricula());
            ps.setDouble(7, estudian.getCalificacion().getCalificacion());

            if (ps.executeUpdate() == 1){
                return new Response<BeanEstudiantes>(200,"Registro exitoso Estudiante", estudian, false);
            }else{
                return new Response<BeanEstudiantes>(400,"Error de registro Estudiante", estudian, true);
            }
        }catch (SQLException e) {
            Logger.getLogger(DaoDocentes.class.getName()).log(Level.SEVERE, "Error -> findAll" + e.getMessage());
            return new Response<>(400,"Error con el servidor",null,true);
        }finally {
            client.close(conn, ps, rs);
        }
    }

    @Override
    public Response update(BeanEstudiantes object) {
        BeanEstudiantes estudian = new BeanEstudiantes();
        try {
            conn = client.getConnection();
            String query = "UPDATE estudiantes SET nombre=?, apellidoPaterno=?, apellidoMaterno=?, fechaNacimiento=?, curp=?, matricula=? WHERE id=?";
            ps = conn.prepareStatement(query);
            ps.setString(1, estudian.getNombre());
            ps.setString(2, estudian.getApellidoPaterno());
            ps.setString(3, estudian.getApellidoMaterno());
            ps.setString(4, estudian.getFechaNacimiento());
            ps.setString(5, estudian.getCurp());
            ps.setString(6, estudian.getMatricula());
            ps.setLong(7, estudian.getId());
            if(ps.executeUpdate()==1){
                return new Response<>(200, "Actualizacion correcta Estudiante", estudian, false);
            }else{
                return new Response<>(400, "Actualizacion incorrecta Estudiante", estudian, true);
            }
        } catch (SQLException e) {
            Logger.getLogger(DaoDocentes.class.getName()).log(Level.SEVERE, "Error -> findAll" + e.getMessage());
            return new Response<>(400, "Error con el servidor", null, true);
        } finally {
            client.close(conn, ps, rs);
        }
    }

    @Override
    public Response calificacion(BeanEvaluacion object) {
        return null;
    }

    @Override
    public List<BeanEstudiantes> estudCalif() {
        List <BeanEstudiantes> estudiantesList = new ArrayList<>();
        BeanEstudiantes estudian = null;
        BeanEvaluacion evaluacion = null;
        try{
            conn = client.getConnection();
            String query = "SELECT nombre, calificacionT FROM estudiantes;";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()){
                estudian = new BeanEstudiantes();
                evaluacion = new BeanEvaluacion();
                estudian.setNombre(rs.getString("nombre"));
                estudian.setCalificacion(evaluacion);
            }
        }catch (SQLException e) {
            Logger.getLogger(DaoDocentes.class.getName()).log(Level.SEVERE, "Error -> estudCalif de Estudiantes" + e.getMessage());
        }finally {
            client.close(conn, ps, rs);
        }
        return estudiantesList;
    }

    @Override
    public Response promedio(BeanEstudiantes estudian) {
        /*BeanEvaluacion evaluacion = null;
        double calificaciones = 0;
        int x = 0;
        try{
            conn = client.getConnection();
            String query = "SELECT calificacionT FROM estudiantes;";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()){
                evaluacion = new BeanEvaluacion();
                estudian.setCalificacion(evaluacion);
                calificaciones = estudian.getCalificacion(rs.getDouble());
                x++;
            }
            double promedio = calificaciones/x;
            Logger.getLogger(DaoDocentes.class.getName()).log(Level.SEVERE, calificaciones +"";
        }catch (SQLException e) {
            Logger.getLogger(DaoDocentes.class.getName()).log(Level.SEVERE, "Error -> estudCalif de Estudiantes" + e.getMessage());
        }finally {
            client.close(conn, ps, rs);
        }*/
        return null;
    }

}
