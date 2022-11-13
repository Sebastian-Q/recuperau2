package utez.edu.mx.examenrecuperau2.model.docentes;


import utez.edu.mx.examenrecuperau2.model.Repository;
import utez.edu.mx.examenrecuperau2.model.estudiantes.BeanEstudiantes;
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

public class DaoDocentes  implements Repository<BeanDocentes> {
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    ConnectionMySQL client = new ConnectionMySQL();


    @Override
    public List<BeanDocentes> findAll() {
        List<BeanDocentes> docentes = new ArrayList<>();
        BeanDocentes docent = null;
        try{
            conn = client.getConnection();
            String query = "SELECT * FROM docentes;";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()){
                docent = new BeanDocentes();
                docent.setId(rs.getLong("id"));
                docent.setNombreD(rs.getNString("nombreD"));
                docent.setApellidoPaternoD(rs.getNString("apellidoPaternoD"));
                docent.setApellidoMaternoD(rs.getNString("apellidoMaternoD"));
                docent.setFechaNacimientoD(rs.getNString("fechaNacimientoD"));
                docent.setCurpD(rs.getNString("curpD"));
                docent.setNumeroEmpleado(rs.getLong("numeroEmpleado"));
            }
        }catch (SQLException e) {
            Logger.getLogger(DaoDocentes.class.getName()).log(Level.SEVERE, "Error -> findAll de Docentes" + e.getMessage());
        }finally {
            client.close(conn, ps, rs);
        }
        return docentes;
    }

    @Override
    public Response save(BeanDocentes object) {
        BeanDocentes docent = new BeanDocentes();
        try{
            conn = client.getConnection();
            String query = "INSERT INTO docentes (nombreD, apellidoPaternoD, apellidoMaternoD, fechaNacimientoD, curpD, numeroEmpleado) VALUES (?,?,?,?,?,?);";
            ps = conn.prepareStatement(query);
            ps.setString(1, docent.getNombreD());
            ps.setString(2, docent.getApellidoPaternoD());
            ps.setString(3, docent.getApellidoMaternoD());
            ps.setString(4, docent.getFechaNacimientoD());
            ps.setString(5, docent.getCurpD());
            ps.setLong(6, docent.getNumeroEmpleado());
            if (ps.executeUpdate() == 1){
                return new Response<BeanDocentes>(200,"Registro exitoso Docente", docent, false);
            }else{
                return new Response<BeanDocentes>(400,"Error de registro Docente", docent, true);
            }
        }catch (SQLException e) {
            Logger.getLogger(DaoDocentes.class.getName()).log(Level.SEVERE, "Error -> Save Docente" + e.getMessage());
            return new Response<>(400,"Error con el servidor",null,true);
        }finally {
            client.close(conn, ps, rs);
        }
    }

    @Override
    public Response update(BeanDocentes object) {
        BeanDocentes docent = new BeanDocentes();
        try {
            conn = client.getConnection();
            String query = "UPDATE docentes SET nombreD=?, apellidoPaternoD=?, apellidoMaternoD=?, fechaNacimientoD=?, curpD=?, numeroEmpleado=? WHERE id=?";
            ps = conn.prepareStatement(query);
            ps.setString(1, docent.getNombreD());
            ps.setString(2, docent.getApellidoPaternoD());
            ps.setString(3, docent.getApellidoMaternoD());
            ps.setString(4, docent.getFechaNacimientoD());
            ps.setString(5, docent.getCurpD());
            ps.setLong(6, docent.getNumeroEmpleado());
            ps.setLong(7, docent.getId());
            if(ps.executeUpdate()==1){
                return new Response<>(200, "Actualizacion correcta Docente", docent, false);
            }else{
                return new Response<>(400, "Actualizacion incorrecta Docente", docent, true);
            }
        } catch (SQLException e) {
            Logger.getLogger(DaoDocentes.class.getName()).log(Level.SEVERE, "Error -> update Docente" + e.getMessage());
            return new Response<>(400, "Error con el servidor", null, true);
        }finally {
            client.close(conn, ps, rs);
        }
    }

    @Override
    public Response calificacion(BeanEvaluacion object) {
        BeanEvaluacion evaluacion = new BeanEvaluacion();
        try{
            conn = client.getConnection();
            String query = "INSERT INTO evaluaciones (calificacion, materia) VALUES (?,?);";
            ps = conn.prepareStatement(query);
            ps.setDouble(1, evaluacion.getCalificacion());
            ps.setString(2, evaluacion.getMateria());
            if (ps.executeUpdate() == 1){
                return new Response<BeanEvaluacion>(200,"Exitoso Calificacion", evaluacion, false);
            }else{
                return new Response<BeanEvaluacion>(400,"Error Calificacion", evaluacion, true);
            }
        }catch (SQLException e) {
            Logger.getLogger(DaoDocentes.class.getName()).log(Level.SEVERE, "Error -> Calificacion" + e.getMessage());
            return new Response<>(400,"Error con el servidor",null,true);
        }finally {
            client.close(conn, ps, rs);
        }
    }

    @Override
    public List<BeanDocentes> estudCalif() {
        return null;
    }

    @Override
    public Response promedio(BeanDocentes object) {
        return null;
    }

}