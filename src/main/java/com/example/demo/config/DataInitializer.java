package com.example.demo.config;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.model.Category;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initData(AuthorRepository authorRepository, 
                                    BookRepository bookRepository, 
                                    CategoryRepository categoryRepository) {
        return args -> {
            // Crear autores
            Author author1 = new Author(null, "Gabriel García Márquez", "Manolito@UES.com", null);
            Author author2 = new Author(null, "J.K. Rowling", "Andresito@UES.com", null);
            
            authorRepository.save(author1);
            authorRepository.save(author2);

            // Crear categorías
            Category category1 = new Category(null, "Ficción", null);
            Category category2 = new Category(null, "Magia", null);
            Category category3 = new Category(null, "Realismo Mágico", null);
            
            categoryRepository.save(category1);
            categoryRepository.save(category2);
            categoryRepository.save(category3);

            // Crear libros
            Book book1 = new Book(null, "Cien años de soledad", 1967, author1, Set.of(category1, category3));
            Book book2 = new Book(null, "Harry Potter y la piedra filosofal", 1997, author2, Set.of(category1, category2));
            
            bookRepository.save(book1);
            bookRepository.save(book2);
        };
    }
}