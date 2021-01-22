package proiect_dw.proiect_dw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;
import proiect_dw.proiect_dw.model.STAFF;
import proiect_dw.proiect_dw.query.Querys;
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
}
