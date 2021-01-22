package proiect_dw.proiect_dw.query;

public class Querys {
    //Staff
    public final static String GET_STAFF_SQL = "select * from user_OLTP_dw.staff";
    public final static String ADAUGA_STAFF = "insert into user_OLTP_dw.staff(staff_id, job_id, staff_name, base_salary) values ((select max(staff_id) from user_OLTP_dw.staff ) + 1, ?, ?, ?)";

    public final static String TEST_DEPOZIT = "select * from user_depozit_dw.staff_dw";
}
