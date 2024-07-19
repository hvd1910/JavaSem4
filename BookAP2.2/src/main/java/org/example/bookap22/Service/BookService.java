package org.example.bookap22.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.example.bookap22.Entity.Book;
import org.example.bookap22.Entity.Publisher;
import org.example.bookap22.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class BookService {
    //Tuỳ biến JPA bằng cách sử dụng:
    //EntityManager: về nhà đọc thêm cái này, JpaRepository mặc định ko hỗ trợ
    //BatchProcessing nếu muốn sử dụng thì cần tuỳ biến trong application
    @Autowired
    private BookRepository bookRepository;
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional//thực hiện 1 giáo dịch kiểu ACID
    public void batchInsertBooks(){
        Publisher publisher1 = entityManager.find(Publisher.class,1L);
        Publisher publisher2 = entityManager.find(Publisher.class,2L);

        Set<Publisher> publishers = new HashSet<>();
        publishers.add(publisher1);
        publishers.add(publisher2);

        for(int i = 0; i < 2000; i++){
            Book book = new Book();
            book.setName("Book" + i);
            book.setPublishers(publishers);
            entityManager.persist(book);
            if(i % 50 ==0){
                entityManager.flush();//release memory giai phong mem
                entityManager.clear();
            }
        }



    }



    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

}
