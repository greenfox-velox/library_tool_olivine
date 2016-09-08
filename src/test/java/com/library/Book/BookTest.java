package com.library.Book;

import com.library.model.business.Book;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {

    Book greenfox = new Book("Big Bad Book", 2016, "Big Bad Wolf");

    @Test()
    public void testgetBookTitle(){
        assertEquals("getBookTitle should return title as a valid String", "Big Bad Book", greenfox.getBookTitle());
    }
    @Test()
    public void testgetbookPublishedIn(){
        assertEquals("getbookPublishedIn should return the year of publishing as a valid Integer", Integer.valueOf(2016) , greenfox.getBookPublishedIn());
    }
    @Test()
    public void testgetbookAuthor(){
        assertEquals("getbookAuthor should return the author of the book a valid String", "Big Bad Wolf", greenfox.getBookAuthor());
    }
    @Test()
    public void testgetbookEdition(){
        assertEquals("getbookEdition should an empty String" , "", greenfox.getBookEdition());
    }
    @Test()
    public void testgetbookCover(){
        assertEquals("getbookCover should an empty String" , "", greenfox.getBookCover());
    }
    @Test()
    public void testgetbookISBNno(){
        assertEquals("getbookISBNno should 0", Integer.valueOf(0), greenfox.getBookISBNno());
    }

    @Test()
    public void testgetbookFormat(){
        assertEquals("getbookFormat should return an empty String" , "", greenfox.getBookFormat());
    }

    @Test()
    public void testgetbookNumberOfPages(){
        assertEquals("getbookNumberOfPages should return 0" , Integer.valueOf(0), greenfox.getBookNumberOfPages());
    }

    @Test()
    public void testgetbookInLanguage(){
        assertEquals("getbookInLanguage should return 'English' as a valid String" , "English", greenfox.getBookInLanguage());
    }

    @Test()
    public void testgetbookDescription(){
        assertEquals("getbookDescription should return 'No description added yet' as a valid String" , "No description added yet", greenfox.getBookDescription());
    }

    @Test()
    public void testgetbookIsBorrowed(){
        assertEquals("getbookIsBorrowed should return false" , false, greenfox.getBookIsBorrowed());
    }
}
