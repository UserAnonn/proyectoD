package alkemy.disney.controller;

import alkemy.disney.dto.PeliculaDTO;
import alkemy.disney.dto.PersonajeDT0;
import alkemy.disney.service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("characters")
public class PersonajeController {

    @Autowired
    private IPersonajeService iPersonajeService;

    @PostMapping
        public ResponseEntity<PersonajeDT0> save(@RequestBody PersonajeDT0 personajeDT0){
        PersonajeDT0 personajeGuardado = iPersonajeService.save(personajeDT0);
        return ResponseEntity.status(HttpStatus.CREATED).body(personajeGuardado);
    }
}
