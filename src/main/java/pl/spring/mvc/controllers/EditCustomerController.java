package pl.spring.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.spring.core.services.CustomerService;
import pl.spring.dto.CustomerDTO;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping
public class EditCustomerController {

    private CustomerService customerService;

    @Autowired
    public EditCustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/edit_customer")
    public String getEditCustomerPage(
            @RequestParam(value = "singleCustomerId") Long id,
            Model model, HttpSession session){
        if (session.getAttribute("user") == null) {
            return "401";
        }
        CustomerDTO customerDTO = customerService.getSingleCustomer(id);
        model.addAttribute("customer", customerDTO);
        return "edit_customer";
    }

    @PostMapping("/edit_customer")
    public String getEditCustomerPage(CustomerDTO customerDTO, HttpSession session){
        customerService.editCustomer(customerDTO);
        session.setAttribute("customerId", customerDTO.getId());
        return "redirect:/single_customer";
    }

    @GetMapping("/edit_visit")
    public String getEditVisit(
            @RequestParam(value = "singleCustomerId") Long id,
            Model model, HttpSession session){
        if (session.getAttribute("user") == null) {
            return "401";
        }
        CustomerDTO customerDTO = customerService.getSingleCustomer(id);
        model.addAttribute("customer", customerDTO);
        return "edit_visit";
    }

    @PostMapping("/edit_visit")
    public String editVisit(CustomerDTO customerDTO, HttpSession session){
        customerService.editCustomer(customerDTO);
        session.setAttribute("customerId", customerDTO.getId());
        return "redirect:/single_customer";
    }

    @GetMapping("/add_visit")
    public String getAddVisit(
            @RequestParam(value = "singleCustomerId") Long id,
            Model model, HttpSession session){
        if (session.getAttribute("user") == null) {
            return "401";
        }
        CustomerDTO customerDTO = customerService.getSingleCustomer(id);
        model.addAttribute("customer", customerDTO);
        return "add_visit";
    }

    @PostMapping("/add_visit")
    public String addVisit(CustomerDTO customerDTO, HttpSession session){
        customerService.editCustomer(customerDTO);
        session.setAttribute("customerId", customerDTO.getId());
        return "redirect:/single_customer";
    }

    @GetMapping("/edit_info")
    public String getEditInfo(
            @RequestParam(value = "singleCustomerId") Long id,
            Model model, HttpSession session){
        if (session.getAttribute("user") == null) {
            return "401";
        }
        CustomerDTO customerDTO = customerService.getSingleCustomer(id);
        model.addAttribute("customer", customerDTO);
        return "edit_info";
    }

    @PostMapping("/edit_info")
    public String editInfo(CustomerDTO customerDTO, HttpSession session){
        customerService.editCustomer(customerDTO);
        session.setAttribute("customerId", customerDTO.getId());
        return "redirect:/single_customer";
    }

    @GetMapping("/edit_comments")
    public String getComments(
            @RequestParam(value = "singleCustomerId") Long id,
            Model model, HttpSession session){
        if (session.getAttribute("user") == null) {
            return "401";
        }
        CustomerDTO customerDTO = customerService.getSingleCustomer(id);
        model.addAttribute("customer", customerDTO);
        return "edit_comments";
    }

    @PostMapping("/edit_comments")
    public String Comments(CustomerDTO customerDTO, HttpSession session){
        customerService.editCustomer(customerDTO);
        session.setAttribute("customerId", customerDTO.getId());
        return "redirect:/single_customer";
    }

    @GetMapping("/cancel_visit")
    public String getCancelVisit(
            @RequestParam(value = "singleCustomerId") Long id,
            Model model, HttpSession session){
        if (session.getAttribute("user") == null) {
            return "401";
        }
        CustomerDTO customerDTO = customerService.getSingleCustomer(id);
        model.addAttribute("customer", customerDTO);
        return "cancel_visit";
    }

    @PostMapping("/cancel_visit")
    public String cancelVisit(CustomerDTO customerDTO, HttpSession session){
        customerDTO.setVisitTime(null);
        customerDTO.setVisitDate(null);
        customerDTO.setAssignedHairdresser(null);
        customerService.editCustomer(customerDTO);
        session.setAttribute("customerId", customerDTO.getId());
        return "redirect:/single_customer";
    }
}
