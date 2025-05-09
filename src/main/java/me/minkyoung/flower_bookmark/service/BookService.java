package me.minkyoung.flower_bookmark.service;

import me.minkyoung.flower_bookmark.dto.BookRequest;
import me.minkyoung.flower_bookmark.dto.BookResponse;

import java.util.List;

public interface BookService {
    //전체 도서 목록을 조회하는 메서드
    List<BookResponse> getAllBooks();

    //ID를 이용해 단일 도서를 조회하고, 없으면 예외를 던지는 메서드
    BookResponse getBookById(Long id);

    // 전달 받은 Book 객체를 저장(생성)하는 메서드
    BookResponse createBook(BookRequest request);

    //기존 도서를 조회하 뒤, 전달된 내용으로 업데이트하는 메서드
    BookResponse updateBook(Long id, BookRequest request);

    // ID를 이용해 해당 도서를 삭제하는 메서드
    void deleteBook(Long id);

}
