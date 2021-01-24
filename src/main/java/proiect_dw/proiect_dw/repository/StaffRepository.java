package proiect_dw.proiect_dw.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import proiect_dw.proiect_dw.model.STAFF;
import proiect_dw.proiect_dw.query.Querys;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StaffRepository {
    private static List<STAFF> staff = new ArrayList<>();

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<STAFF> getStaff() {
        return jdbcTemplate.query(Querys.GET_STAFF_SQL, new BeanPropertyRowMapper<>(STAFF.class));
    }

    public List<STAFF> adaugaStaff(STAFF s) {
        jdbcTemplate.update(Querys.ADAUGA_STAFF, s.getJob_id(), s.getStaff_name(), s.getBase_salary());
        jdbcTemplate.update(Querys.ADAUGA_STAFF_DW, s.getJob_id(), s.getJob_id(), s.getStaff_name(), s.getBase_salary());
        return getStaff();
    }

    public List<STAFF> updateStaff(STAFF s, int id) {
        jdbcTemplate.update(Querys.UPDATE_STAFF, s.getJob_id(), s.getStaff_name(), s.getBase_salary(), id);
        jdbcTemplate.update(Querys.UPDATE_STAFF_DW, s.getJob_id(), s.getJob_id(), s.getStaff_name(), s.getBase_salary(), id);
        return getStaff();
    }

    public List<STAFF> stergeAngajat(int id) {
        jdbcTemplate.update(Querys.STERGE_ANGAJAT, id);
        jdbcTemplate.update(Querys.STERGE_ANGAJAT_DW, id);
        return getStaff();
    }
}
