package cNegocio;

import cEntidad.AlumnoEntidad;
import cDatos.AlumnoDatos;
import java.util.List;

public class AlumnoNegocio {

    private AlumnoDatos alumnoDatos;

    public AlumnoNegocio() {
        alumnoDatos = new AlumnoDatos();
    }

    public void registrarAlumno(int idAlumno, String nombreCompleto, String fechaNacimiento, String direccion, String telefono, String email) {
        AlumnoEntidad alumno = new AlumnoEntidad(idAlumno, nombreCompleto, fechaNacimiento, direccion, telefono, email);
        alumnoDatos.registrarAlumno(alumno);
    }

   public List<AlumnoEntidad> listarAlumnos() {
        return alumnoDatos.listarAlumnos();
    }
   
   public void cancelarAlumno() {
       
    }
   
   public void eliminarAlumno(int idAlumno) {
    AlumnoDatos alumnoDatos = new AlumnoDatos();
    List<AlumnoEntidad> alumnos = alumnoDatos.listarAlumnos();

    for (AlumnoEntidad alumno : alumnos) {
        if (alumno.getIdAlumno() == idAlumno) {
            alumnos.remove(alumno);
            break;
        }
    }

    // Actualizar archivo de datos
    alumnoDatos.actualizarAlumnos(alumnos);
}
   
 
    
   
}