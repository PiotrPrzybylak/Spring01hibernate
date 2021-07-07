package pl.coderslab.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Controller
public class ValidationController {

    @Autowired
    private Validator validator;

    @GetMapping("/validate")
    @ResponseBody
    public String validate() {
        Person2 person2 = new Person2(null, "1234567890123456789012345678901234");
        Set<ConstraintViolation<Person2>> validate = validator.validate(person2);
        System.out.println(validate);

        if (validate.isEmpty()) {
            return "OK";
        } else {
            return "ERROR";
        }
    }
}
