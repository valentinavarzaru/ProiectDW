package proiect_dw.proiect_dw.model;

public class CLIENTS_DW {
    private int client_id;
    private int client_age_category_id;
    private String age_category_name;
    private String client_first_name;
    private String client_last_name;
    private String client_gender;
    private String client_address;
    private int client_cell_phone;
    private String client_email;

    public CLIENTS_DW() {}

    public CLIENTS_DW(int client_id, int client_age_category_id, String age_category_name, String client_first_name, String client_last_name, String client_gender, String client_address, int client_cell_phone, String client_email) {
        this.client_id = client_id;
        this.client_age_category_id = client_age_category_id;
        this.age_category_name = age_category_name;
        this.client_first_name = client_first_name;
        this.client_last_name = client_last_name;
        this.client_gender = client_gender;
        this.client_address = client_address;
        this.client_cell_phone = client_cell_phone;
        this.client_email = client_email;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public int getClient_age_category_id() {
        return client_age_category_id;
    }

    public void setClient_age_category_id(int client_age_category_id) {
        this.client_age_category_id = client_age_category_id;
    }

    public String getAge_category_name() {
        return age_category_name;
    }

    public void setAge_category_name(String age_category_name) {
        this.age_category_name = age_category_name;
    }

    public String getClient_first_name() {
        return client_first_name;
    }

    public void setClient_first_name(String client_first_name) {
        this.client_first_name = client_first_name;
    }

    public String getClient_last_name() {
        return client_last_name;
    }

    public void setClient_last_name(String client_last_name) {
        this.client_last_name = client_last_name;
    }

    public String getClient_gender() {
        return client_gender;
    }

    public void setClient_gender(String client_gender) {
        this.client_gender = client_gender;
    }

    public String getClient_address() {
        return client_address;
    }

    public void setClient_address(String client_address) {
        this.client_address = client_address;
    }

    public int getClient_cell_phone() {
        return client_cell_phone;
    }

    public void setClient_cell_phone(int client_cell_phone) {
        this.client_cell_phone = client_cell_phone;
    }

    public String getClient_email() {
        return client_email;
    }

    public void setClient_email(String client_email) {
        this.client_email = client_email;
    }

    @Override
    public String toString() {
        return "CLIENTS_DW{" +
                "client_id=" + client_id +
                ", client_age_category_id=" + client_age_category_id +
                ", age_category_name='" + age_category_name + '\'' +
                ", client_first_name='" + client_first_name + '\'' +
                ", client_last_name='" + client_last_name + '\'' +
                ", client_gender='" + client_gender + '\'' +
                ", client_address='" + client_address + '\'' +
                ", client_cell_phone=" + client_cell_phone +
                ", client_email='" + client_email + '\'' +
                '}';
    }
}
