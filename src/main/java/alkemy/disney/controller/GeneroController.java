package alkemy.disney.controller;

import alkemy.disney.dto.GeneroDTO;
import alkemy.disney.service.IGeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("generos")//la peticion http recibida en ese endpoint es atendida por este controlador
public class GeneroController {

    @Autowired
    private IGeneroService generoService;

    @PostMapping
    public ResponseEntity<GeneroDTO> save(@RequestBody GeneroDTO generoDTO){
        GeneroDTO generoGuardado = generoService.save(generoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(generoGuardado);
    }

    @GetMapping //Sólo para ver si cuando borro una pelicula borra tambien el genero
    public ResponseEntity<List<GeneroDTO>> getAll(){
        List<GeneroDTO> generoDTOSet = generoService.getAllGeneros();
        return ResponseEntity.ok().body(generoDTOSet);
    }
}
