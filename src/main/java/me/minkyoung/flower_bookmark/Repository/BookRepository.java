package me.minkyoung.flower_bookmark.Repository;

import me.minkyoung.flower_bookmark.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
