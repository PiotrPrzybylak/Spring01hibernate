package pl.coderslab.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import pl.coderslab.app.springdata.BookDao;
import javax.validation.Valid;
import java.util.Arrays;
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
    public String addBook(@Valid Book book, BindingResult result) {
        if (result.hasErrors()) {
//            return "reditrect:/bookform";
            return "bookform.jsp";
        }
        bookDao.save(book);
        return "redirect:/books";
    }

    @GetMapping("/books")
    public String allBooks(Model model) {
        List<Book> all = bookDao.findAll();
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

    @GetMapping("/booksbytitle")
    public String allBooks(Model model, String title) {
        Book book = bookDao.findBookByTitle(title);

        model.addAttribute("books", Arrays.asList(book));
        return "books.jsp";
    }

    @GetMapping("/booksbycategory")
    public String allBooks(Model model, long categoryId) {
        List<Book> all = bookDao.findByCategoryId(categoryId);
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
