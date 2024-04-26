package cDatos;

import cEntidad.AlumnoEntidad;
import java.io.BufferedReader;
import java.io.FileReader;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AlumnoDatos {
    private List<AlumnoEntidad> alumnos;
    private String archivo = "alumnos.txt";

    public AlumnoDatos() {
        alumnos = new ArrayList<>();
    }

    public void registrarAlumno(AlumnoEntidad alumno) {
        alumnos.add(alumno);
        guardarArchivo();
    }


    private void guardarArchivo() {
        try (FileWriter writer = new FileWriter(archivo, true)) {
            for (AlumnoEntidad alumno : alumnos) {
                writer.write(alumno.getIdAlumno() + "," + alumno.getNombreCompleto() + "," + alumno.getFechaNacimiento() + "," + alumno.getDireccion() + "," + alumno.getTelefono() + "," + alumno.getEmail() + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error al guardar archivo: " + e.getMessage());
        }
    }
    
    public List<AlumnoEntidad> listarAlumnos() {
        List<AlumnoEntidad> alumnos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine())!= null) {
                String[] campos = linea.split(",");
                AlumnoEntidad alumno = new AlumnoEntidad(
                    Integer.parseInt(campos[0]),
                    campos[1],
                    campos[2],
                    campos[3],
                    campos[4],
                    campos[5]
                );
                alumnos.add(alumno);
            }
        } catch (IOException e) {
            System.err.println("Error al leer archivo: " + e.getMessage());
        }
        return alumnos;
    }
    
      
    public void actualizarAlumnos(List<AlumnoEntidad> alumnos) {
    try (FileWriter writer = new FileWriter(archivo, false)) {
        for (AlumnoEntidad alumno : alumnos) {
            writer.write(alumno.getIdAlumno() + "," + alumno.getNombreCompleto() + "," + alumno.getFechaNacimiento() + "," + alumno.getDireccion() + "," + alumno.getTelefono() + "," + alumno.getEmail() + "\n");
        }
    } catch (IOException e) {
        System.err.println("Error al guardar archivo: " + e.getMessage());
    }
}
    
}