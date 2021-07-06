package pl.coderslab.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BookController {

    private BookDao bookDao;

    public BookController(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @GetMapping("/bookform")
    public String getBookForm(Book book) {
        return "bookform.jsp";
    }



    @PostMapping("/bookform")
    @ResponseBody
    public String addBook(Book book) {
        bookDao.save(book);
        return "Success!";
    }


    @ModelAttribute("ratings")
    public List<String> ratings() {
        return List.of("0", "1", "3");
    }

}
