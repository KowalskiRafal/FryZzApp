package pl.spring.mvc.controllers;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.spring.core.services.CustomerService;
import pl.spring.core.services.UserService;
import pl.spring.dto.CustomerDTO;
import pl.spring.dto.UserDTO;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/single_customer")
public class SingleCustomerController {

    private CustomerService customerService;
    private UserService userService;

    public SingleCustomerController(CustomerService customerService, UserService userService) {
        this.customerService = customerService;
        this.userService = userService;
    }

    @GetMapping
    public String getSingleCustomerPage(
            @RequestParam(required = false, value = "singleCustomerId") Long id,
            Model model, HttpSession session){
        CustomerDTO customerDTO;
        if (id != null) {
            customerDTO = customerService.getSingleCustomer(id);
        } else {
            id = (Long)session.getAttribute("customerId");
            customerDTO = customerService.getSingleCustomer(id);
        }
            model.addAttribute("customer", customerDTO);
        if (customerDTO.getAssignedHairdresser() != null && (
                customerDTO.getAssignedHairdresser().equals("jkowalki") ||
                customerDTO.getAssignedHairdresser().equals("jnowak") ||
                customerDTO.getAssignedHairdresser().equals("sgomez") ||
                customerDTO.getAssignedHairdresser().equals("a"))){
            UserDTO userDTO = new UserDTO();
            userDTO = userService.findByLogin(customerDTO.getAssignedHairdresser());
            model.addAttribute("user", userDTO);
        }
        return "single_customer";
    }
}
