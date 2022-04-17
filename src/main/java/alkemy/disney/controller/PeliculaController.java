package alkemy.disney.controller;

import alkemy.disney.dto.GeneroDTO;
import alkemy.disney.dto.PeliculaBasicDTO;
import alkemy.disney.dto.PeliculaDTO;
import alkemy.disney.entity.GeneroEntity;
import alkemy.disney.service.IGeneroService;
import alkemy.disney.service.IPeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies")
public class PeliculaController {

    @Autowired
    private IPeliculaService iPeliculaService;

    @PostMapping
    public ResponseEntity<PeliculaDTO> save(@RequestBody PeliculaDTO peliculaDTO){
        PeliculaDTO peliculaGuardada = iPeliculaService.save(peliculaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(peliculaGuardada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PeliculaDTO> update(@PathVariable Long id, @RequestBody PeliculaDTO peliculaDTO){
        PeliculaDTO result = iPeliculaService.update(id, peliculaDTO);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping
    public ResponseEntity<List<PeliculaBasicDTO>> getAll(){
        List<PeliculaBasicDTO> peliculaBasicDTOS = iPeliculaService.getAll();
        return ResponseEntity.ok().body(peliculaBasicDTOS);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        iPeliculaService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
