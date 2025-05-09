package me.minkyoung.flower_bookmark.Service;

import me.minkyoung.flower_bookmark.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.minkyoung.flower_bookmark.Entity.Book;
import java.util.List;

@Service
@Transactional //트랜잭션의 시작, 끝 자동 관리
public class BookServiceImpl implements BookService {
    //Repository를 주입 받아 DB에 접근에 사용할 객체 생성
    private final BookRepository bookRepository;

    //생성자에서 Repository 객체를 주입 바ㄷ음
    @Autowired
    public BookServiceImpl(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @Override
    //전체 도서 목록을 조회하는 메서드
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    @Override
    //ID를 이용해 단일 도서를 조회하고, 없으면 예외를 던지는 메서드
    public Book getBookById(Long id){
        return bookRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("해당 도서는 찾을 수 없습니다."));
    }

    @Override
    // 전달 받은 Book 객체를 저장(생성)하는 메서드
    public Book createBook(Book book){
        return bookRepository.save(book);
    }

    @Override
    //기존 도서를 조회하 뒤, 전달된 내용으로 업데이트하는 메서드
    public Book updateBook(Long id,Book book){
        Book check= getBookById(id);
        check.setTitle(book.getTitle());
        check.setPublisher(book.getPublisher());
        check.setAuthor(book.getAuthor());
        check.setPrice(book.getPrice());
        check.setStock_quantity(book.getStock_quantity());
        check.setImage_url(book.getImage_url());
        check.setDescription(book.getDescription());
        return bookRepository.save(check);
    }

    @Override
    // ID를 이용해 해당 도서를 삭제하는 메서드
    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }

}
