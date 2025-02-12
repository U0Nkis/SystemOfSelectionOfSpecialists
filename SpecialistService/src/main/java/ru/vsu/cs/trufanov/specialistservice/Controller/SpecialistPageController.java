package ru.vsu.cs.trufanov.specialistservice.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SpecialistPageController {

    @GetMapping("/specialists")
    @ResponseBody
    public String specialistPage() {
        return "specialists.html";
    }
}
