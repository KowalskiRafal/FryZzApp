package pl.spring.mvc.controllers;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.spring.core.services.CustomerService;
import pl.spring.dto.CustomerDTO;
import java.io.ByteArrayInputStream;


@Controller
@RequestMapping(value = "/pdf_report", produces = MediaType.APPLICATION_PDF_VALUE)
public class PDFGenerationController {


    private CustomerService customerService;

    public PDFGenerationController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping
    public ResponseEntity<InputStreamResource> customerBill(
            @RequestParam(value = "singleCustomerId") Long id){

        CustomerDTO customerDTO = customerService.getSingleCustomer(id);
        ByteArrayInputStream bis = customerService.customerBill(customerDTO);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=customerBILL.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));

    }
}
