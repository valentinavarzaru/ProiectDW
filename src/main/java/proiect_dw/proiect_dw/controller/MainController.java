package proiect_dw.proiect_dw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import proiect_dw.proiect_dw.model.APPOINTMENTS;
import proiect_dw.proiect_dw.model.APPOINTMENT_SERVICES;
import proiect_dw.proiect_dw.model.STAFF;
import proiect_dw.proiect_dw.service.MainService;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private MainService mainService;

    @GetMapping("/main")
    public String main(Model model) {
        return "index";
    }

    @GetMapping("/main/getStaff")
    public String getStaff(Model model) {
        model.addAttribute("staffMembers", mainService.getStaff());
        return "getStaff";
    }

    @PostMapping("/adaugaStaff")
    public String adaugaStaff(@RequestBody STAFF s, Model model) {
        mainService.adaugaStaff(s);
        model.addAttribute("staffMembers", mainService.getStaff());
        return "getStaff";
    }

    @PostMapping("/updateStaff")
    public String updateStaff(@RequestBody STAFF s, @RequestParam int id, Model model) {
        mainService.updateStaff(s,id);
        model.addAttribute("staffMembers", mainService.getStaff());
        return "getStaff";
    }

    @GetMapping("/stergeAngajat/{idStaff}")
    public String stergeAngajat(@PathVariable int idStaff, Model model) {
        mainService.stergeAngajat(idStaff);
        model.addAttribute("staffMembers", mainService.getStaff());
        return "getStaff";
    }

//    Appointments

    @GetMapping("/main/getProgr")
    public String getProgr(Model model) {
        model.addAttribute("Programari", mainService.getProgr());
        return "getProgr";
    }

    @PostMapping("/adaugaProgr")
    public String adaugaProgr(@RequestBody APPOINTMENTS s, Model model) {
        mainService.adaugaProgr(s);
        model.addAttribute("Programari", mainService.getProgr());
        return "getProgr";
    }

    @PostMapping("/updateProgr")
    public String updateProgr(@RequestBody APPOINTMENTS s, @RequestParam int id, Model model) {
        mainService.updateProgr(s,id);
        model.addAttribute("Programari", mainService.getProgr());
        return "getProgr";
    }

    @GetMapping("/stergeProgr/{idProgr}")
    public String stergeProgr(@PathVariable int idProgr, Model model) {
        mainService.stergeProgr(idProgr);
        model.addAttribute("Programari", mainService.getProgr());
        return "getProgr";
    }

//    Appointment Services

    @GetMapping("/main/getAppServ")
    public String getAppServ(Model model) {
        model.addAttribute("AppServices", mainService.getServ());
        return "getAppServ";
    }

    @PostMapping("/adaugaAppServ")
    public String adaugaAppServ(@RequestBody APPOINTMENT_SERVICES s, Model model) {
        mainService.adaugaServ(s);
        model.addAttribute("AppServices", mainService.getServ());
        return "getAppServ";
    }

    @GetMapping("/stergeAppServ/{idApp}/{idServ}/{idStaff}")
    public String stergeAppServ(@PathVariable("idApp") int idApp, @PathVariable("idServ") int idServ, @PathVariable("idStaff") int idStaff, Model model) {
        mainService.stergeServ(idApp, idServ, idStaff);
        model.addAttribute("AppServices", mainService.getServ());
        return "getAppServ";
    }

}
