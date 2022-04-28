package alkemy.disney.controller;

import alkemy.disney.dto.GeneroDTO;
import alkemy.disney.dto.PeliculaBasicDTO;
import alkemy.disney.dto.PeliculaDTO;
import javax.validation.Valid;

import alkemy.disney.entity.PeliculaEntity;
import alkemy.disney.service.IPeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("movies")
public class PeliculaController {

    @Autowired
    private IPeliculaService iPeliculaService;

    @PostMapping//creacion de la pelicula sola
    public ResponseEntity<PeliculaDTO> save(@Valid @RequestBody PeliculaDTO peliculaDTO){
        PeliculaDTO peliculaGuardada = iPeliculaService.save(peliculaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(peliculaGuardada);
    }

    @PostMapping("/{idMovie}/character/{idCharacter}") //creacion de la pelicula con personaje
    public ResponseEntity<PeliculaDTO> addPersonaje(@PathVariable Long idPelicula,@Valid @PathVariable Long idPersonaje){
        PeliculaDTO peliculaDTO = iPeliculaService.addPersonaje2Pelicula(idPelicula, idPersonaje);
        return ResponseEntity.status(HttpStatus.CREATED).body(peliculaDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PeliculaDTO> update(@PathVariable Long id, @Valid @RequestBody PeliculaDTO peliculaDTO){
        PeliculaDTO result = iPeliculaService.update(id, peliculaDTO);
        return ResponseEntity.ok().body(result);
    }

    /*GetMapping//muestra los dto con datos basicos del punto 7
    public ResponseEntity<List<PeliculaBasicDTO>> getAll(){
        List<PeliculaBasicDTO> peliculaBasicDTOS = iPeliculaService.getAll();
        return ResponseEntity.ok().body(peliculaBasicDTOS);
    }*/

    /*@GetMapping
    public ResponseEntity<List<PeliculaDTO>> getAllData(){
        List<PeliculaDTO> peliculaDTOS = iPeliculaService.getAllData();
        return ResponseEntity.ok().body(peliculaDTOS);
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<PeliculaDTO> getDetails(@PathVariable Long id){
        PeliculaDTO peliculaDTO = iPeliculaService.getDetails(id);
        return ResponseEntity.ok(peliculaDTO);
    }

    @GetMapping
    public ResponseEntity<List<PeliculaDTO>> getDetailsByFilters(
            @RequestParam(required = false) String titulo,
            @RequestParam(required = false) Long generoId,
            @RequestParam(required = false, defaultValue = "ASC") String orden
    ){
            List<PeliculaDTO> peliculaDTOS = this.iPeliculaService.getDetailsByFilters(titulo, generoId, orden);
            return ResponseEntity.ok(peliculaDTOS);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        iPeliculaService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
