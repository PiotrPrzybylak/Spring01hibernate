package pl.coderslab.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PersonController {

    @GetMapping("/person")
    public String showForm(Model model) {
        model.addAttribute("person", new Person());
        return "form.jsp";
    }

    @PostMapping("/personold")
    public String addPerson(String login, String password, String email) {
        Person person = new Person(login, password, email);
        System.out.println(person);
    return "success.jsp";
}

    @PostMapping("/person")
    public String addPerson(Person person) {
//        Person person = new Person(login, password, email);
        System.out.println(person);
        return "form.jsp";
    }


}


