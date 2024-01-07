package com.example.java.web;

import org.apache.cxf.jaxrs.client.WebClient;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.MappingJsonFactory;

import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;

public class Consumer {
    public static void main(String[] args) throws IOException {
        WebClient client = WebClient.create("http://localhost:9003/");
        client.accept("application/json");
        MappingJsonFactory factory = new MappingJsonFactory();
        Response response = client.path("books/123456").get();
        JsonParser parser = factory.createJsonParser((InputStream)response.getEntity());
        Book book= parser.readValueAs(Book.class);
//        Book book = client.path("books/123456").get(Book.class);
        System.out.println(book);



    }
}
