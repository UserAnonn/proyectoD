package alkemy.disney.controller;

import alkemy.disney.dto.PeliculaBasicDTO;
import alkemy.disney.dto.PeliculaDTO;
import alkemy.disney.dto.PersonajeBasicDTO;
import alkemy.disney.dto.PersonajeDT0;
import alkemy.disney.service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("characters")
public class PersonajeController {

    @Autowired
    private IPersonajeService iPersonajeService;

    @PostMapping
        public ResponseEntity<PersonajeDT0> save(@Valid @RequestBody PersonajeDT0 personajeDT0){
        PersonajeDT0 personajeGuardado = iPersonajeService.save(personajeDT0);
        return ResponseEntity.status(HttpStatus.CREATED).body(personajeGuardado);
    }

    @GetMapping
    public ResponseEntity<List<PersonajeBasicDTO>> getAll(){
        List<PersonajeBasicDTO> peliculaBasicDTOS = iPersonajeService.getAll();
        return ResponseEntity.ok().body(peliculaBasicDTOS);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonajeDT0> update(@PathVariable Long id, @RequestBody PersonajeDT0 personajeDT0){
        PersonajeDT0 result = iPersonajeService.update(id, personajeDT0);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        iPersonajeService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
