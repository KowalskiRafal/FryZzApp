package pl.spring.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import pl.spring.data.model.User;
import pl.spring.data.repositories.UserRepository;
import pl.spring.dto.LoggedUserDTO;
import pl.spring.dto.UserDTO;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public boolean checkCredentials(String login, String password) {
        boolean existsUser = userRepository.checkIfUserExists(login, password);
        return existsUser;
    }


    public LoggedUserDTO getUser (String login, String password){
        LoggedUserDTO loggedUserDTO = null;
        User user = userRepository.getUserByLoginAndPassword(login, password);

        if (user != null) {
            loggedUserDTO = new LoggedUserDTO();
            loggedUserDTO.setId(user.getId());
            loggedUserDTO.setLogin(user.getLogin());
            loggedUserDTO.setFirstName(user.getFirstName());
            loggedUserDTO.setLastName(user.getLastName());
        }
        return loggedUserDTO;
    }

    public UserDTO findByLogin(String login){
        User user = userRepository.getUserByLogin(login);
        return convertToDTO(user);
    }

    private UserDTO convertToDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setLogin(user.getLogin());
        userDTO.setPassword(user.getPassword());
        return userDTO;
    }
}
