package pe.edu.cibertec.evaluacionfinal_dawII_springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.evaluacionfinal_dawII_springcloud.service.PersonalService;

@RestController
@RequestMapping("/personal")
public class PersonalController {
    @Autowired
    private PersonalService personalService;

    @GetMapping("/verificar/{nomPersonal}")
    public ResponseEntity<String> verificarPersonal(@PathVariable String nomPersonal) {
        return ResponseEntity.ok(personalService.verificarPersonas(nomPersonal));
    }
}
