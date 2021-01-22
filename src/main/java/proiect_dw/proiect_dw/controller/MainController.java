package proiect_dw.proiect_dw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proiect_dw.proiect_dw.model.STAFF;
import proiect_dw.proiect_dw.service.MainService;

import java.util.List;

@RestController
@RequestMapping("/oltp")
public class MainController {
    @Autowired
    private MainService mainService;

//    Staff
    @GetMapping("/getStaff")
    public ResponseEntity<List<STAFF>> getStaff() {
        return ResponseEntity.status(HttpStatus.OK).body(mainService.getStaff());
    }

    @PostMapping("/adaugaStaff")
    public ResponseEntity<List<STAFF>> adaugaStaff(@RequestBody STAFF s) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mainService.adaugaStaff(s));
    }
}
