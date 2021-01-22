package proiect_dw.proiect_dw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import proiect_dw.proiect_dw.model.STAFF;
import proiect_dw.proiect_dw.service.MainService;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class MainController {

    @GetMapping("/main")
    public String main(Model model) {
//        model.addAttribute("staffMembers", mainService.getStaff());
        return "index";
    }

    @GetMapping("/main/getStaff")
    public String getStaff(Model model) {
        model.addAttribute("staffMembers", mainService.getStaff());
        return "getStaff";
    }

    @Autowired
    private MainService mainService;

//    Staff
//    @GetMapping("/getStaff2")
//    public ResponseEntity<List<STAFF>> getStaff2() {
//        return ResponseEntity.status(HttpStatus.OK).body(mainService.getStaff());
//    }
//
//    @PostMapping("/adaugaStaff")
//    public ResponseEntity<List<STAFF>> adaugaStaff(@RequestBody STAFF s) {
//        return ResponseEntity.status(HttpStatus.CREATED).body(mainService.adaugaStaff(s));
//    }
}
