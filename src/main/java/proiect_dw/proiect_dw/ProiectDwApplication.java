package proiect_dw.proiect_dw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import proiect_dw.proiect_dw.model.PROMOTIONS;
import proiect_dw.proiect_dw.model.STAFF;

import java.util.List;

@SpringBootApplication
public class ProiectDwApplication implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(ProiectDwApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String sql = "select * from user_OLTP_dw.staff";
        List<STAFF> staff = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(STAFF.class));

        String sql2 = "select * from user_OLTP_dw.promotions";
        List<PROMOTIONS> promo = jdbcTemplate.query(sql2, BeanPropertyRowMapper.newInstance(PROMOTIONS.class));

//        promo.forEach(System.out :: println);
    }
}
