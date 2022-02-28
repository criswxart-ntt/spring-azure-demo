package controllers;

import com.cursos.model.Curso;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CursosController {

    private List<Curso> cursos;

    @PostConstruct //Se inicializa despues de haber ejecutado el constructor
    public void init() {
        cursos = new ArrayList<>();
        cursos.add(new Curso("Spring", 25, "tarde"));
        cursos.add(new Curso("Spring Boot", 25, "tarde"));
        cursos.add(new Curso("Java", 45, "mañana"));
        cursos.add(new Curso("Python", 48, "tarde"));
        cursos.add(new Curso("C++", 2, "mediodia"));
        cursos.add(new Curso("prueba", 78, "tarde"));
    }

    @GetMapping(value = "cursos", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Curso> getCursos(){
        return cursos;
    }

    @GetMapping(value = "cursos/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Curso> buscarCursos(@PathVariable("name") String nombre){
        List<Curso> aux = new ArrayList<>();
        for(Curso c:cursos){
            if(c.getNombre().contains(nombre)){
                aux.add(c);
            }
        }
        return aux;
    }

    @GetMapping(value = "curso", produces = MediaType.APPLICATION_JSON_VALUE)
    public Curso getCurso(){
        return new Curso("Java",100,"mañana");
    }


}
