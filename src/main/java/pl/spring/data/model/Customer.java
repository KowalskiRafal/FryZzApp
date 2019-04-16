package pl.spring.data.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "firstName")
    private String firstName;

    @Column(nullable = false, name = "lastName")
    private String lastName;

    @Column(nullable = false, name = "telephoneNumber")
    private String telephoneNumber;

    @Column(name = "visitDate")
    @Temporal(TemporalType.DATE)
    private Date visitDate;

    @Column(name = "visitTime")
    @Temporal(TemporalType.TIME)
    @DateTimeFormat(pattern = "HH:mm:ss")
    private Date visitTime;

    @Column(name = "assignedHairdresser")
    private String assignedHairdresser;

    @Column(name = "additionalInfo")
    private String additionalInfo;

    @Column(name = "comments")
    private String comments;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    public String getAssignedHairdresser() {
        return assignedHairdresser;
    }

    public void setAssignedHairdresser(String assignedHairdresser) {
        this.assignedHairdresser = assignedHairdresser;
    }

    public String getInfo() {
        return additionalInfo;
    }

    public void setInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", visitDate='" + visitDate + '\'' +
                ", visitTime='" + visitTime + '\'' +
                ", additionalInfo='" + additionalInfo + '\'' +
                '}';

    }
}

