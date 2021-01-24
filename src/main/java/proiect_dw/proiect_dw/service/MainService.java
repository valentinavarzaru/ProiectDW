package proiect_dw.proiect_dw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;
import proiect_dw.proiect_dw.model.APPOINTMENTS;
import proiect_dw.proiect_dw.model.APPOINTMENT_SERVICES;
import proiect_dw.proiect_dw.model.STAFF;
import proiect_dw.proiect_dw.query.Querys;
import proiect_dw.proiect_dw.repository.AppServicesRepository;
import proiect_dw.proiect_dw.repository.AppointmentsRepository;
import proiect_dw.proiect_dw.repository.StaffRepository;

import java.util.List;

@Service
public class MainService {

//    Staff
    @Autowired
    private StaffRepository staffRepository;

    public List<STAFF> getStaff() {
        return staffRepository.getStaff();
    }

    public List<STAFF> adaugaStaff(STAFF s) {
        return staffRepository.adaugaStaff(s);
    }

    public List<STAFF> updateStaff(STAFF s, int id) {
        return staffRepository.updateStaff(s, id);
    }

    public List<STAFF> stergeAngajat(int id) {
        return staffRepository.stergeAngajat(id);
    }

//    Appointments
    @Autowired
    private AppointmentsRepository appointmentsRepository;
public List<APPOINTMENTS> getProgr() {
    return appointmentsRepository.getProgr();
}

    public List<APPOINTMENTS> adaugaProgr(APPOINTMENTS p) {
        return appointmentsRepository.adaugaProgr(p);
    }

    public List<APPOINTMENTS> updateProgr(APPOINTMENTS p, int id) {
        return appointmentsRepository.updateProgr(p,id);
    }

    public List<APPOINTMENTS> stergeProgr(int id) {
        return appointmentsRepository.stergeProgr(id);
    }

//    Appointment Services
    @Autowired
    private AppServicesRepository appServicesRepository;

    public List<APPOINTMENT_SERVICES> getServ() {
        return appServicesRepository.getServ();
    }

    public List<APPOINTMENT_SERVICES> adaugaServ(APPOINTMENT_SERVICES p) {
        return appServicesRepository.adaugaServ(p);
    }

    public List<APPOINTMENT_SERVICES> stergeServ(int idApp, int idServ, int idStaff) {
        return appServicesRepository.stergeServ(idApp, idServ, idStaff);
    }


}
