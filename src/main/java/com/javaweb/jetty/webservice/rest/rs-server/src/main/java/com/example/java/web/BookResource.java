package com.example.java.web;

import io.swagger.annotations.ApiOperation;

import javax.ws.rs.*;
import java.util.*;

@Path("books")
@Produces("application/json")

public class BookResource {

    Map<String, Book> bookMap = new HashMap<String, Book>();

    public BookResource() {
        bookMap.put("123456", new Book("Java Development", "Computer", "123456", "James Gosling"));
        bookMap.put("789011", new Book(".Net Development", "Computer", "789011", "Silver"));
    }

    @GET
    @Path("{isbn}")
    @ApiOperation(value="get details of book", consumes = "application/json")
    public Book getDetails(@PathParam("isbn") String isbn) {
        return bookMap.get(isbn);
    }

    @GET
    @Path("search")
    public Book[] search(@QueryParam("author") String author){
        Collection<Book> allBooks = bookMap.values();
        List<Book> result = new ArrayList<Book>();
        for(Book book:allBooks){
            if(book.getAuthor().contains(author)){
                result.add(book);
            }
        }
        return result.toArray(new Book[0]);
    }


}
