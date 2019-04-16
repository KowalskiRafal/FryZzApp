package pl.spring.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.spring.data.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(nativeQuery = true,
            value = "SELECT CASE WHEN count(*) >= 1 THEN 'true' ELSE 'false' END " +
                    "FROM users WHERE login = ?1 AND password = ?2")
    Boolean checkIfUserExists(String login, String password);

    User getUserByLoginAndPassword(String login, String password);
    User getUserByLogin(String login);
    //User getByFirstNameAndAndLastName(String firstName, String lastName);
}
