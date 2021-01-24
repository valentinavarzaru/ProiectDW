package proiect_dw.proiect_dw.query;

public class Querys {
    //Staff
    public final static String GET_STAFF_SQL = "select * from user_OLTP_dw.staff order by staff_id desc";
    public final static String ADAUGA_STAFF = "insert into user_OLTP_dw.staff(staff_id, job_id, staff_name, base_salary) values ((select max(staff_id) from user_OLTP_dw.staff ) + 1, ?, ?, ?)";
    public final static String ADAUGA_STAFF_DW = "insert into user_depozit_dw.staff_dw(staff_id, job_id, job_title, staff_name, base_salary) values ((select max(staff_id) from user_depozit_dw.staff_dw) + 1, ?, (select job_name \n" +
            "from user_OLTP_dw.staff_job_title j\n" +
            "where j.job_id = ?) , ?, ?)";
    public final static String UPDATE_STAFF = "update user_OLTP_dw.staff set job_id = ?, staff_name = ?, base_salary = ? where staff_id = ?";
    public final static String UPDATE_STAFF_DW = "update user_depozit_dw.staff_dw set job_id = ?, job_title = (select job_name \n" +
            "from user_OLTP_dw.staff_job_title j\n" +
            "where j.job_id = ?), staff_name = ?, base_salary = ?  where staff_id = ?";
    public final static String STERGE_ANGAJAT = "delete from user_OLTP_dw.staff where staff_id = ?";
    public final static String STERGE_ANGAJAT_DW = "delete from user_depozit_dw.staff_dw where staff_id = ?";

    //Appointments
    public final static String GET_progr_SQL = "select * from (select * from user_OLTP_dw.appointments order by appointment_id desc) where rownum<1001";
    public final static String ADAUGA_progr = "insert into user_OLTP_dw.appointments(appointment_id, client_id, appointment_date, appointment_time) values ((select max(appointment_id) from user_OLTP_dw.appointments ) + 1, ?, ?, ?)";
    public final static String UPDATE_progr = "update user_OLTP_dw.appointments set client_id = ?, appointment_date = ?, appointment_time = ? where appointment_id = ?";
    public final static String UPDATE_progr_DW = "update user_depozit_dw.services_value_dw set client_id = ?, appointment_date = ?  where appointment_id = ?";
    public final static String STERGE_progr = "delete from user_OLTP_dw.appointments where appointment_id = ?";
    public final static String STERGE_progr_serv = "delete from user_OLTP_dw.appointment_services where appointment_id = ?";
    public final static String STERGE_plata = "delete from user_OLTP_dw.payments where appointment_id = ?";
    public final static String STERGE_progr_DW = "delete from user_depozit_dw.services_value_dw where appointment_id = ?";

    //Appointment Services
    public final static String GET_serv_SQL = "select * from (select * from user_OLTP_dw.appointment_services order by appointment_id desc) where rownum<1001";
    public final static String ADAUGA_serv = "insert into user_OLTP_dw.appointment_services(appointment_id, salon_service_id, staff_id, service_price) values (?, ?, ?, ?)";
    public final static String Update_service_price =
            "update user_OLTP_dw.appointment_services\n" +
                    "set service_price  = \n" +
                    "(select salon_standard_price from user_OLTP_dw.SALON_SERVICES where salon_service_id = ?)\n" +
                    "+ \n" +
                    "(select charge_amount from user_OLTP_dw.STAFF_EXTRA_CHARGE where salon_service_id = ? and job_id = (select job_id from user_OLTP_dw.STAFF st where st.staff_id = ?))\n" +
                    "- trunc(\n" +
                    "(select promotion_discount from user_OLTP_dw.PROMOTIONS a, user_OLTP_dw.salon_services b\n" +
                    "where a.promotion_id = b.promotion_id and b.salon_service_id = ?)\n" +
                    "*(\n" +
                    "(select salon_standard_price from user_OLTP_dw.SALON_SERVICES\twhere salon_service_id = ?)\n" +
                    "+(select charge_amount from user_OLTP_dw.STAFF_EXTRA_CHARGE where salon_service_id = ?\n" +
                    "and job_id = (select job_id from user_OLTP_dw.STAFF st where st.staff_id = ?)))/100, 2)\n" +
                    " where appointment_id = ?  and staff_id = ? and salon_service_id = ?";
    public final static String ADAUGA_serv_dw = "insert into user_depozit_dw.services_value_dw \n" +
            "(select (select max(service_value_id) from user_depozit_dw.services_value_dw ) + 1,\n" +
            " a.client_id, s.salon_service_id, s.staff_id, st.job_id, a.appointment_date, payment_id, serv.promotion_id, a.appointment_id,\n" +
            "age_discount, promotion_discount, (extra.charge_amount + serv.salon_standard_price), s.service_price\n" +
            "from user_OLTP_dw.appointments a, user_OLTP_dw.appointment_services s, user_OLTP_dw.staff st, \n" +
            "user_OLTP_dw.payments p, user_OLTP_dw.salon_services serv, user_OLTP_dw.clients cli,\n" +
            "user_OLTP_dw.age_category age, user_OLTP_dw.promotions promo, user_OLTP_dw.staff_extra_charge extra\n" +
            "where a.appointment_id = ?\n" +
            "and st.staff_id = s.staff_id\n" +
            "and s.staff_id = ?\n" +
            "and a.appointment_id = p.appointment_id\n" +
            "and serv.salon_service_id = s.salon_service_id\n" +
            "and s.salon_service_id = ?\n" +
            "and a.client_id = cli.client_id\n" +
            "and cli.age_category_id = age.age_category_id\n" +
            "and serv.promotion_id = promo.promotion_id\n" +
            "and extra.job_id = st.job_id\n" +
            "and extra.salon_service_id =s.salon_service_id\n" +
            "and s.salon_service_id = ?\n" +
            "and rownum<2\n" +
            ")";

    public final static String ADAUGA_PLATA = "insert into user_OLTP_dw.payments values ((select max(payment_id) from user_OLTP_dw.payments ) + 1, (select max(appointment_id) from user_OLTP_dw.payments ) + 1, 3, 0, 0)";
    public final static String UPDATE_PRETURI_PLATA = "update user_OLTP_dw.payments set total_price = (select sum(service_price) from user_OLTP_dw.appointment_services\n" +
            "where appointment_id = ? ), final_price = \n" +
            "(select sum(service_price) from user_OLTP_dw.appointment_services where appointment_id = ?)- \n" +
            "trunc((select age_discount from user_OLTP_dw.AGE_CATEGORY a, user_OLTP_dw.CLIENTS c, user_OLTP_dw.APPOINTMENTS ap\n" +
            "where  a.age_category_id = c.AGE_CATEGORY_ID\n" +
            "and c.CLIENT_ID = ap.CLIENT_ID \n" +
            "and ap.APPOINTMENT_ID = ?)\n" +
            "* (select sum(service_price) from user_OLTP_dw.appointment_services where appointment_id = ?)/100, 2)\n" +
            "where APPOINTMENT_ID = ?";
    public final static String STERGE_serv = "delete from user_OLTP_dw.appointment_services where appointment_id = ? and salon_service_id = ? and staff_id  = ?)";
    public final static String STERGE_serv_DW = "delete from user_depozit_dw.services_value_dw where appointment_id = ? and salon_service_id = ? and staff_id  = ?)";



}
