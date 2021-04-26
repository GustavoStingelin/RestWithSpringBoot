package br.com.stingelin.converter.mocks;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.stingelin.data.model.Book;
import br.com.stingelin.data.vo.v1.BookVO;

public class MockBook {

    public Book mockEntity() {
    	return mockEntity(0);
    }
    
    public BookVO mockVO() {
    	return mockVO(0);
    }
    
    public List<Book> mockEntityList() {
        List<Book> books = new ArrayList<Book>();
        for (int i = 0; i < 14; i++) {
            books.add(mockEntity(i));
        }
        return books;
    }

    public List<BookVO> mockVOList() {
        List<BookVO> books = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            books.add(mockVO(i));
        }
        return books;
    }
    
    private Book mockEntity(Integer number) {
    	Book book = new Book();
        book.setAuthor("Author Test" + number);
        book.setId(number.longValue());
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020 + number, 1, 1, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        book.setLaunch_date(calendar.getTime());
        book.setTitle("Title Test" + number);
        book.setPrice(150D * number.longValue());
        return book;
    }

    private BookVO mockVO(Integer number) {
    	BookVO book = new BookVO();
        book.setAuthor("Author Test" + number);
        book.setKey(number.longValue());
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020 + number, 1, 1, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        book.setLaunch_date(calendar.getTime());
        book.setTitle("Title Test" + number);
        book.setPrice(150D * number.longValue());
        return book;
    }
}
