package pl.spring.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import java.awt.*;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping
public class SupportController {

    @Autowired
    ServletContext context;

    @GetMapping("/support")
    public String getSupport() {
        return "support";
    }

    @GetMapping("/doc")
    public String getDoc() {

        if (Desktop.isDesktopSupported()) {
            try {
                System.out.println(context.getRealPath("/"));
                File myFile = new File(context.getRealPath("/") + "/sources/Dokumentacja.pdf");
                Desktop.getDesktop().open(myFile);
            } catch (IOException ex) {}
        }
        return "redirect:/home";
    }
}
