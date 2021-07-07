package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.app.Skill;
import pl.coderslab.app.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Controller
public class TestController {

    @GetMapping("/")
    @ResponseBody
    public String test() {
        return "Siema ponownie!";
    }

    @GetMapping("/tes")
    public String test2() {
        return "test.jsp";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        Student student = new Student("Jan","Kowalski");
        model.addAttribute("student", student);
        return "test.jsp"; }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processForm(Student student) {
        System.out.println(student.getFirstName());
        return "success.jsp";
    }

    @ModelAttribute("skills")
    public List<String> checkOptions() {
        String[] a = new String[] {"java", "php", "ruby", "python"};
        return Arrays.asList(a);
    }

    @ModelAttribute("skills2")
    public Collection<Skill> skills() {
        List<Skill> skills = new ArrayList<Skill>();
        skills.add(new Skill(1, "Java"));
        skills.add(new Skill(2, "PHP"));
        skills.add(new Skill(3, "Ruby"));
        return skills;
    }












}
