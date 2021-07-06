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
    private final PublisherDao publisherDao;

    public BookController(BookDao bookDao, PublisherDao publisherDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
    }

    @GetMapping("/bookform")
    public String getBookForm(Book book) {
        return "bookform.jsp";
    }



    @PostMapping("/bookform")
    public String addBook(Book book) {
        bookDao.save(book);
        return "redirect:/books";
    }

    @GetMapping("/books")
    public String allBooks(Model model) {
        List<Book> all = bookDao.all();
        System.out.println(all);
        model.addAttribute("books", all);
        return "books.jsp";
    }


    @GetMapping("/booksbyrating")
    public String allBooks(Model model, int rating) {
        List<Book> all = bookDao.findAllByRating(rating);
        System.out.println(all);
        model.addAttribute("books", all);
        return "books.jsp";
    }


    @ModelAttribute("ratings")
    public List<String> ratings() {
        return List.of("0", "1", "3");
    }

    @ModelAttribute("publishers")
    public List<Publisher> publishers() {
        return publisherDao.all();
    }

}
