package cNegocio;

import cDatos.NotaDatos;
import cEntidad.NotaEntidad;
import java.util.List;

public class NotaNegocio {
    private NotaDatos notaDatos;

    public NotaNegocio() {
        notaDatos = new NotaDatos();
    }

    public void registrarNota(String idAlumno, String materia, String nota1, String nota2, String nota3, String promedio, String fechaRegistro) {
        NotaEntidad nota = new NotaEntidad(idAlumno, materia, nota1, nota2, nota3, promedio, fechaRegistro);
        notaDatos.registrarNota(nota);
    }
    
    public List<NotaEntidad> listarNotas() {
        return notaDatos.listarNotas();
    }
    
    public void cancelarNota() {
        // No se requiere implementar nada aquí
    }
    
    public void eliminarNota(String idAlumno, String materia) {
    NotaDatos notaDatos = new NotaDatos();
    List<NotaEntidad> notas = notaDatos.listarNotas();

    for (NotaEntidad nota : notas) {
        if (nota.getIdAlumno().equals(idAlumno) && nota.getMateria().equals(materia)) {
            notas.remove(nota);
            break;
        }
    }

    // Actualizar archivo de datos
    notaDatos.actualizarNotas(notas);
}
    
}