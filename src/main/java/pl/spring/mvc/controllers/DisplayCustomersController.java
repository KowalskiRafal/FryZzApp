package pl.spring.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.spring.core.services.CustomerService;
import pl.spring.core.services.UserService;
import pl.spring.dto.CustomerDTO;
import pl.spring.dto.LoggedUserDTO;

import javax.servlet.http.HttpSession;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping
public class DisplayCustomersController {

    private CustomerService customerService;
    private UserService userService;

    @Autowired
    public DisplayCustomersController(CustomerService customerService, UserService userService) {
        this.customerService = customerService;
        this.userService = userService;
    }

    @GetMapping("/display_customers")
    public String displayAllCustomers(Model model, HttpSession session){
        if (session.getAttribute("user") == null) {
            return "401";
        }
        List<CustomerDTO> customers = customerService.getAllCustomers();
        model.addAttribute("customersList", customers);
        return "customers";
    }

    @GetMapping("/arranged")
    public String displayOnlyArrangedCustomers(Model model, HttpSession session){
        if (session.getAttribute("user") == null) {
            return "401";
        }
        List<CustomerDTO> customers = customerService.getArrangedCustomers();
        model.addAttribute("customersList", customers);
        return "arranged_customers";
    }

    @GetMapping("/not_arranged")
    public String displayOnlyNotArrangedCustomers(Model model, HttpSession session){
        if (session.getAttribute("user") == null) {
            return "401";
        }
        List<CustomerDTO> customers = customerService.getNotArrangedCustomers();
        model.addAttribute("customersList", customers);
        return "not_arranged_customers";
    }

    @GetMapping("/your_arranged")
    public String displayOnlyYourArrangedCustomers(Model model, HttpSession session){
        if (session.getAttribute("user") == null) {
            return "401";
        }
        List<CustomerDTO> customers = customerService.getArrangedCustomers();
        List<CustomerDTO> yourCustomers = new LinkedList<>();
        LoggedUserDTO user = (LoggedUserDTO)session.getAttribute("user");
        for(CustomerDTO customer : customers){
            if (customer.getAssignedHairdresser().equals(user.getLogin())){
                yourCustomers.add(customer);
            }
        }

        model.addAttribute("customersList", yourCustomers);
        model.addAttribute("userToDisplay", user);
        return "arranged_customers";
    }
}
