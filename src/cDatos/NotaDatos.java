package cDatos;

import cEntidad.NotaEntidad;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NotaDatos {
    private List<NotaEntidad> notas;
    private String archivo = "notas.txt";

    public NotaDatos() {
        notas = new ArrayList<>();
    }

    public void registrarNota(NotaEntidad nota) {
        notas.add(nota);
        guardarArchivo();
    }

    private void guardarArchivo() {
        try (FileWriter writer = new FileWriter(archivo, true)) {
            for (NotaEntidad nota : notas) {
                writer.write(nota.getIdAlumno() + "," + nota.getMateria() + "," + nota.getNota1() + "," + nota.getNota2() + "," + nota.getNota3() + "," + nota.getPromedio() + "," + nota.getFechaRegistro() + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error al guardar archivo: " + e.getMessage());
        }
    }
    
    public List<NotaEntidad> listarNotas() {
        List<NotaEntidad> notas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine())!= null) {
                String[] campos = linea.split(",");
                NotaEntidad nota = new NotaEntidad(
                    campos[0],
                    campos[1],
                    campos[2],
                    campos[3],
                    campos[4],
                    campos[5],
                    campos[6]
                );
                notas.add(nota);
            }
        } catch (IOException e) {
            System.err.println("Error al leer archivo: " + e.getMessage());
        }
        return notas;
    }
    
    public void actualizarNotas(List<NotaEntidad> notas) {
    try (FileWriter writer = new FileWriter(archivo, false)) {
        for (NotaEntidad nota : notas) {
            writer.write(nota.getIdAlumno() + "," + nota.getMateria() + "," + nota.getNota1() + "," + nota.getNota2() + "," + nota.getNota3() + "," + nota.getPromedio() + "," + nota.getFechaRegistro() + "\n");
        }
    } catch (IOException e) {
        System.err.println("Error al guardar archivo: " + e.getMessage());
    }
}
}