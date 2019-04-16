package pl.spring.data.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.spring.data.model.Customer;

import java.time.OffsetDateTime;
import java.util.List;


@Repository
@Transactional
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByVisitDateNotNull();
    List<Customer> findByVisitDateIsNull();
    Customer findCustomerByFirstNameAndLastName(String firstName, String lastName);
}
