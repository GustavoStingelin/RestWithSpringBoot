package br.com.stingelin.converter;

import java.util.Calendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.stingelin.converter.mocks.MockBook;
import br.com.stingelin.data.model.Book;
import br.com.stingelin.data.vo.v1.BookVO;


public class DozerConverterBookTest {

    MockBook inputObject;

    @Before
    public void setUp() {
        inputObject = new MockBook();
    }

    @Test
    public void parseEntityToVOTest() {
        BookVO output = DozerConverter.parseObject(inputObject.mockEntity(), BookVO.class);
        Assert.assertEquals(Long.valueOf(0L), output.getKey());
        Assert.assertEquals("Author Test0", output.getAuthor());
        Assert.assertEquals("Title Test0", output.getTitle());
        Assert.assertEquals(Double.valueOf(150D * 0L), output.getPrice());
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020 + 0, 1, 1, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Assert.assertEquals(calendar.getTime(), output.getLaunch_date());
    }

    @Test
    public void parseEntityListToVOListTest() {
        List<BookVO> outputList = DozerConverter.parseListObjects(inputObject.mockEntityList(), BookVO.class);
        Calendar calendar = Calendar.getInstance();

        BookVO outputZero = outputList.get(0);
        Assert.assertEquals(Long.valueOf(0L), outputZero.getKey());
        Assert.assertEquals("Author Test0", outputZero.getAuthor());
        Assert.assertEquals("Title Test0", outputZero.getTitle());
        Assert.assertEquals(Double.valueOf(150D * 0L), outputZero.getPrice());
        calendar.set(2020 + 0, 1, 1, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Assert.assertEquals(calendar.getTime(), outputZero.getLaunch_date());
        


        BookVO outputSeven = outputList.get(7);
        Assert.assertEquals(Long.valueOf(7L), outputSeven.getKey());
        Assert.assertEquals("Author Test7", outputSeven.getAuthor());
        Assert.assertEquals("Title Test7", outputSeven.getTitle());
        Assert.assertEquals(Double.valueOf(150D * 7L), outputSeven.getPrice());
        calendar.set(2020 + 7, 1, 1, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Assert.assertEquals(calendar.getTime(), outputSeven.getLaunch_date());
        
        BookVO outputTwelve = outputList.get(12);
        Assert.assertEquals(Long.valueOf(12L), outputTwelve.getKey());
        Assert.assertEquals("Author Test12", outputTwelve.getAuthor());
        Assert.assertEquals("Title Test12", outputTwelve.getTitle());
        Assert.assertEquals(Double.valueOf(150D * 12L), outputTwelve.getPrice());
        calendar.set(2020 + 12, 1, 1, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Assert.assertEquals(calendar.getTime(), outputTwelve.getLaunch_date());
    }

    @Test
    public void parseVOToEntityTest() {
        Book output = DozerConverter.parseObject(inputObject.mockVO(), Book.class);
        Assert.assertEquals(Long.valueOf(0L), output.getId());
        Assert.assertEquals("Author Test0", output.getAuthor());
        Assert.assertEquals("Title Test0", output.getTitle());
        Assert.assertEquals(Double.valueOf(150D * 0L), output.getPrice());
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020 + 0, 1, 1, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Assert.assertEquals(calendar.getTime(), output.getLaunch_date());
    }

    @Test
    public void parserVOListToEntityListTest() {
        List<Book> outputList = DozerConverter.parseListObjects(inputObject.mockVOList(), Book.class);
        Calendar calendar = Calendar.getInstance();

        Book outputZero = outputList.get(0);
        Assert.assertEquals(Long.valueOf(0L), outputZero.getId());
        Assert.assertEquals("Author Test0", outputZero.getAuthor());
        Assert.assertEquals("Title Test0", outputZero.getTitle());
        Assert.assertEquals(Double.valueOf(150D * 0L), outputZero.getPrice());
        calendar.set(2020 + 0, 1, 1, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Assert.assertEquals(calendar.getTime(), outputZero.getLaunch_date());
        
        Book outputSeven = outputList.get(7);
        Assert.assertEquals(Long.valueOf(7L), outputSeven.getId());
        Assert.assertEquals("Author Test7", outputSeven.getAuthor());
        Assert.assertEquals("Title Test7", outputSeven.getTitle());
        Assert.assertEquals(Double.valueOf(150D * 7L), outputSeven.getPrice());
        calendar.set(2020 + 7, 1, 1, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Assert.assertEquals(calendar.getTime(), outputSeven.getLaunch_date());
        
        Book outputTwelve = outputList.get(12);
        Assert.assertEquals(Long.valueOf(12L), outputTwelve.getId());
        Assert.assertEquals("Author Test12", outputTwelve.getAuthor());
        Assert.assertEquals("Title Test12", outputTwelve.getTitle());
        Assert.assertEquals(Double.valueOf(150D * 12L), outputTwelve.getPrice());
        calendar.set(2020 + 12, 1, 1, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Assert.assertEquals(calendar.getTime(), outputTwelve.getLaunch_date());
    }
}
