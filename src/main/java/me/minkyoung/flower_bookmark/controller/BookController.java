package me.minkyoung.flower_bookmark.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import me.minkyoung.flower_bookmark.dto.BookRequest;
import me.minkyoung.flower_bookmark.dto.BookResponse;
import me.minkyoung.flower_bookmark.entity.Book;
import me.minkyoung.flower_bookmark.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
@CrossOrigin(origins = "http://localhost:3000")
public class BookController {
    //service를 주입받아 요청 처리에 사용할 객체 생성
    private final BookService bookService;

    //생성자에서 service 객체를 주입 받음
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<BookResponse>> getAllBooks() {
        List<BookResponse> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> getBookById(@PathVariable Long id) {
        BookResponse book = bookService.getBookById(id);
        return ResponseEntity.ok(book);
    }

    //관리자 도서 추가
    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<BookResponse> createBook(@Valid @RequestBody BookRequest book) {
        BookResponse createdBook = bookService.createBook(book);
        return ResponseEntity.ok(createdBook);
    }

    //관리자 도서 수정
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<BookResponse> updateBook(@PathVariable Long id, @RequestBody BookRequest book) {
        BookResponse updatedBook = bookService.updateBook(id, book);
        return ResponseEntity.ok(updatedBook);
    }

    //관리자 도서 삭제
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Book> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page<BookResponse>> list(
            @RequestParam(required = false, defaultValue = "")String keyword,
            Pageable pageable)
    {
        Page<BookResponse> page = bookService.searchBooks(keyword, pageable);
        return ResponseEntity.ok(page);
    }

}
