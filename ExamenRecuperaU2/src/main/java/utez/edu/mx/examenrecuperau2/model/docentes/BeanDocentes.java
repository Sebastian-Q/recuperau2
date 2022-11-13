package utez.edu.mx.examenrecuperau2.model.docentes;

public class BeanDocentes {
    Long id;
    String nombreD;
    String apellidoPaternoD;
    String apellidoMaternoD;
    String fechaNacimientoD;
    String curpD;
    Long numeroEmpleado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreD() {
        return nombreD;
    }

    public void setNombreD(String nombreD) {
        this.nombreD = nombreD;
    }

    public String getApellidoPaternoD() {
        return apellidoPaternoD;
    }

    public void setApellidoPaternoD(String apellidoPaternoD) {
        this.apellidoPaternoD = apellidoPaternoD;
    }

    public String getApellidoMaternoD() {
        return apellidoMaternoD;
    }

    public void setApellidoMaternoD(String apellidoMaternoD) {
        this.apellidoMaternoD = apellidoMaternoD;
    }

    public String getFechaNacimientoD() {
        return fechaNacimientoD;
    }

    public void setFechaNacimientoD(String fechaNacimientoD) {
        this.fechaNacimientoD = fechaNacimientoD;
    }

    public String getCurpD() {
        return curpD;
    }

    public void setCurpD(String curpD) {
        this.curpD = curpD;
    }

    public Long getNumeroEmpleado() {
        return numeroEmpleado;
    }

    public void setNumeroEmpleado(Long numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }
}
