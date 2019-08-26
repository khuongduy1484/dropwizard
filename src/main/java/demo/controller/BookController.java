package demo.controller;

import demo.message.request.BookForm;
import demo.message.response.ResponseMessage;
import demo.model.Author;
import demo.model.Book;
import demo.model.Category;
import demo.service.AuthorService;
import demo.service.BookService;
import demo.service.CategoryService;
import org.eclipse.jetty.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;


import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("book")
@Produces(MediaType.APPLICATION_JSON)
public class BookController {
  @Autowired
  BookService bookService;
  private CategoryService categoryService;

  @Inject
public BookController(CategoryService categoryService){
   this.categoryService = categoryService;
  }
  @Autowired
  AuthorService authorService;
  @POST
  @Path("/create")
  public Response createBook(BookForm bookForm){
    Category category = categoryService.findByName(bookForm.getCategory());

    Author author =authorService.findByName(bookForm.getAuthor());
    Book book = new Book(bookForm.getName(),bookForm.getContent(),bookForm.getProducer());
    book.setCategory(category);
    book.setAuthor(author);
    bookService.save(book);
    return Response.ok(new ResponseMessage("Publish book successfully ")).build();
  }

//  @PutMapping("/{id}")
//  public ResponseEntity<?>updateBook(@PathVariable("id") Long id,@RequestBody BookForm b){
//    Book book = bookService.findById(id);
//    Category category = categoryService.findByName(b.getCategory());
//    Author author = authorService.findByName(b.getAuthor());
//    book.setAuthor(author);
//    book.setCategory(category);
//    book.setName(b.getName());
//    book.setContent(b.getContent());
//    bookService.save(book);
//    return new ResponseEntity<>(new ResponseMessage("Update book successfully "), HttpStatus.OK);
//  }
//
//  @GetMapping
//  public ResponseEntity<List<Book>>fillAll(){
//    List<Book> books = bookService.findAll();
//    return new ResponseEntity<List<Book>>(books,HttpStatus.OK);
//  }
//
//  @GetMapping("{id}")
//  public ResponseEntity<?>book(@PathVariable("id") Long id){
//    Book book = bookService.findById(id);
//    return new ResponseEntity<>(book,HttpStatus.OK);
//  }
//
//  @DeleteMapping("{id}")
//  public ResponseEntity<?>deleteBook(@PathVariable("id") Long id){
//    Book book = bookService.findById(id);
//    bookService.remove(book);
//    return new ResponseEntity<>(new ResponseMessage("remove successfully"),HttpStatus.OK);
//  }

}
