package ru.vsu.cs.trufanov.specialistservice.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ServicePageController {

    @GetMapping("/services")
    @ResponseBody
    public String servicesPage() {
        return "service.html";
    }
}
