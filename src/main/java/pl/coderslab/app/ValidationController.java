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
        Book book = new Book();
        Set<ConstraintViolation<Book>> validate = validator.validate(book);
        System.out.println(validate);

        for (ConstraintViolation<Book> violation : validate) {
            System.out.println(violation.getPropertyPath() + " : " + violation.getMessage());
        }

        if (validate.isEmpty()) {
            return "OK";
        } else {
            return "ERROR";
        }
    }
}
