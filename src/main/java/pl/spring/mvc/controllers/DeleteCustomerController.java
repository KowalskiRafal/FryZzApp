package pl.spring.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.spring.core.services.CustomerService;
import pl.spring.dto.CustomerDTO;

@Controller
@RequestMapping("/delete_customer")
public class DeleteCustomerController {

    private CustomerService customerService;

    public DeleteCustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public String deleteCustomer(
            @RequestParam(value = "singleCustomerId") Long id){
        customerService.deleteCustomer(customerService.getSingleCustomer(id));
        return "redirect:/display_customers";
    }
}
