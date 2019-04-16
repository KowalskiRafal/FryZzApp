package pl.spring.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.spring.core.services.CustomerService;
import pl.spring.dto.CustomerDTO;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/add_customer")
public class AddCustomerController {

    private CustomerService customerService;

    @Autowired
    public AddCustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public String getAddCustomerPage(HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "401";
        }
        return "add_customer";
    }

    @PostMapping
    public String addCustomer(CustomerDTO customerDTO, HttpSession session) {
        customerService.addCustomer(customerDTO);
        customerDTO = customerService.getSingleCustomer(customerDTO.getFirstName(), customerDTO.getLastName());
        session.setAttribute("customerId", customerDTO.getId());
        return "added_customer";
    }
}