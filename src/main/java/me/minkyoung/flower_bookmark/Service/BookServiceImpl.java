package me.minkyoung.flower_bookmark.Service;

import me.minkyoung.flower_bookmark.Dto.BookRequest;
import me.minkyoung.flower_bookmark.Dto.BookResponse;
import me.minkyoung.flower_bookmark.Repository.BookRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.minkyoung.flower_bookmark.Entity.Book;
import java.util.List;
import java.util.stream.Collectors;

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

    private BookResponse toResponse(Book book) {
        return BookResponse.builder()
                .id(book.getId())
                .title(book.getTitle())
                .publisher(book.getPublisher())
                .author(book.getAuthor())
                .price(book.getPrice())
                .stock_quantity(book.getStock_quantity())
                .image_url(book.getImage_url())
                .description(book.getDescription())
                .created_at(book.getCreatedAt())
                .updated_at(book.getUpdatedAt())
                .build();
    }

    @Override
    //전체 도서 목록을 조회하는 메서드
    public List<BookResponse> getAllBooks(){
        // 모든 엔터티 조회, 스트림으로 돌면서 toResponse() 호출
        return bookRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    //ID를 이용해 엔티티 조회(없으면 예외), toResponse()로 DTO 변환
    public BookResponse getBookById(Long id){
        Book book= bookRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("해당 도서는 찾을 수 없습니다."));
        return toResponse(book);
    }

    @Override
    // 전달 받은 Book 객체를 저장(생성)하는 메서드
    public BookResponse createBook(BookRequest request){
        Book entity = new Book();
        entity.setTitle(request.getTitle());
        entity.setAuthor(request.getAuthor());
        entity.setPublisher(request.getPublisher());
        entity.setPrice(request.getPrice());
        entity.setStock_quantity(request.getStock_quantity());
        entity.setDescription(request.getDescription());

        Book saved = bookRepository.save(entity);

        BookResponse response = new BookResponse();

        response.setId(saved.getId());
        response.setTitle(saved.getTitle());
        response.setPublisher(saved.getPublisher());
        response.setAuthor(saved.getAuthor());
        response.setPrice(saved.getPrice());
        response.setStock_quantity(saved.getStock_quantity());
        response.setImage_url(saved.getImage_url());
        response.setDescription(saved.getDescription());
        response.setCreated_at(saved.getCreatedAt());
        response.setUpdated_at(saved.getUpdatedAt());

        return response;
    }

    @Override
    //기존 도서를 조회하 뒤, 전달된 내용으로 업데이트하는 메서드
    public BookResponse updateBook(Long id,BookRequest request){
        Book existing = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("도서를 찾을 수 없습니다."));
        BeanUtils.copyProperties(request, existing, "id", "createdAt", "updatedAt");
        Book updated = bookRepository.save(existing);
        return toResponse(updated);
    }

    @Override
    // ID를 이용해 해당 도서를 삭제하는 메서드
    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }

}
