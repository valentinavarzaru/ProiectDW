package proiect_dw.proiect_dw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;
import proiect_dw.proiect_dw.model.*;
import proiect_dw.proiect_dw.query.Querys;
import proiect_dw.proiect_dw.repository.*;

import java.util.List;

@Service
public class MainService {

//    Staff
    @Autowired
    private StaffRepository staffRepository;

    public List<STAFF> getStaff() {
        return staffRepository.getStaff();
    }
    public List<STAFF> getStaffById(int id) {
        return staffRepository.getStaffById(id);
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

//    Clients
    @Autowired
    private ClientsRepository clientsRepository;

    public List<CLIENTS> getClients() {
        return clientsRepository.getClients();
    }

    public List<CLIENTS> adaugaClient(CLIENTS s) {
        return clientsRepository.adaugaClient(s);
    }

    public List<CLIENTS> updateClient(CLIENTS s, int id) {
        return clientsRepository.updateClient(s, id);
    }

    public List<CLIENTS> stergeClient(int id) {
        return clientsRepository.stergeClient(id);
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

//    Salon Services

    @Autowired
    private SalServicesRepository salServicesRepository;

    public List<SALON_SERVICES> getSalServices() {
        return salServicesRepository.getSalServices();
    }

    public List<SALON_SERVICES> adaugaSalServ(SALON_SERVICES s, int idJob, double extra) {
        return salServicesRepository.adaugaSalServ(s, idJob, extra);
    }

    public List<SALON_SERVICES> updateSalServ(SALON_SERVICES s, int id) {
        return salServicesRepository.updateSalServ(s, id);
    }

    public List<SALON_SERVICES> stergeSalServ(int id) {
        return salServicesRepository.stergeSalServ(id);
    }

//    Others

    @Autowired
    private OthersRepository othersRepository;

    public List<SALON_SERVICE_CATEGORY> getCategories() {
        return othersRepository.getCategories();
    }

    public List<SALON_SERVICE_SUBCATEGORY> getSubcategories() {
        return othersRepository.getSubcategories();
    }

    public List<PROMOTIONS> getPromo() {
        return othersRepository.getPromo();
    }

    public List<STAFF_EXTRA_CHARGE> getExtraCharge() {
        return othersRepository.getExtraCharge();
    }

    public List<STAFF_JOB_TITLE> getJobs() {
        return othersRepository.getJobs();
    }

    public List<AGE_CATEGORY> getAgeCat() {
        return othersRepository.getAgeCat();
    }

    public List<PAYMENT_METHODS> getPayMet() {
        return othersRepository.getPayMet();
    }

    public List<PAYMENTS> getPayment() {
        return othersRepository.getPayment();
    }

//    Depozit
    @Autowired
    private DepozitRepository depozitRepository;

    public List<CLIENTS_DW> getClientsDw() {
        return depozitRepository.getClientsDw();
    }

    public List<PAYMENTS_DW> getPaymentsDw() {
        return depozitRepository.getPaymentsDw();
    }

    public List<PROMOTIONS_DW> getPromoDw() {
        return depozitRepository.getPromoDw();
    }

    public List<SALON_SERVICES_DW> getSalServDw() {
        return depozitRepository.getSalServDw();
    }

    public List<SERVICES_VALUE_DW> getServValueDw() {
        return depozitRepository.getServValueDw();
    }

    public List<STAFF_DW> getStaffDw() {
        return depozitRepository.getStaffDw();
    }

    public List<STAFF_JOB_TITLE_DW> getJobsDw() {
        return depozitRepository.getJobsDw();
    }

    public List<TIMP_DW> getTimpDw() {
        return depozitRepository.getTimpDw();
    }
}
