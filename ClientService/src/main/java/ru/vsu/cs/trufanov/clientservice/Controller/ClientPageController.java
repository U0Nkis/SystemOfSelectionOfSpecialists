package ru.vsu.cs.trufanov.clientservice.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientPageController {

    @GetMapping("/clients")
    public String clientsPage() {
        return "clients"; // Возвращает страницу clients.html
    }
}
