package proiect_dw.proiect_dw.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;
import proiect_dw.proiect_dw.model.STAFF;
import proiect_dw.proiect_dw.query.Querys;

import java.sql.PreparedStatement;
import java.sql.Statement;
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
        return getStaff();
    }
//
//
//    public List<STAFF> adaugaStaff(STAFF s) {
//        jdbcTemplate.update(Querys.ADAUGA_STAFF, s.getJob_id(), s.getStaff_name(), s.getBase_salary());
//        return jdbcTemplate.query(Querys.GET_STAFF_SQL, new BeanPropertyRowMapper<>(STAFF.class));
//    }

}
