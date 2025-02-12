package ru.vsu.cs.trufanov.registrationservice.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegistrationPageController {

    @GetMapping("/registrations")
    @ResponseBody
    public String registrationPage() {
        return "registrations.html";
    }
}