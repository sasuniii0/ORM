package entity;

import javax.persistence.*;

@Entity
@Table(name = "customer") // table name
public class Customer {
    @Id // primary key
 //   @GeneratedValue(strategy = GenerationType.AUTO) // int ekk wenna one auto generate kjrnkota
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Embedded
    private CustomerFullName name;

    @Column(name = "customer_email", nullable = false) // Specifies name and not null
    private String email;

    @Transient // non-persistent
    private String visaCardNumber;

    @Lob // storing large text or binary data
    private String description;

    private String phone;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CustomerFullName getName() {
        return name;
    }

    public void setName(CustomerFullName name) {
        this.name = name;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "email='" + email + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public Customer(String email, int id, CustomerFullName name, String phone) {
        this.email = email;
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public Customer() {
    }
}
