package me.minkyoung.flower_bookmark.Service;

import me.minkyoung.flower_bookmark.Entity.Book;
import java.util.List;

public interface BookService {
    //전체 도서 목록을 조회하는 메서드
    List<Book> getAllBooks();

    //ID를 이용해 단일 도서를 조회하고, 없으면 예외를 던지는 메서드
    Book getBookById(Long id);

    // 전달 받은 Book 객체를 저장(생성)하는 메서드
    Book createBook(Book book);

    //기존 도서를 조회하 뒤, 전달된 내용으로 업데이트하는 메서드
    Book updateBook(Long id, Book book);

    // ID를 이용해 해당 도서를 삭제하는 메서드
    void deleteBook(Long id);

}
