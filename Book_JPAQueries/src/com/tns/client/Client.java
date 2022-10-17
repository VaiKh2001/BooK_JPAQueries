package com.tns.client;

import com.tns.entity.Book;
import com.tns.service.BookService;
import com.tns.service.BookServiceImpl;

public class Client {
	public static void main(String[] args) {
		//method calls
		
		BookService service = new BookServiceImpl();
		
//		System.out.println("********* Listing Book With id 105*************");
//		System.out.println("Book with id 105:"+service.getBookById(105));
//		
//		
//		System.out.println("************Listing total number of books*********");
//		System.out.println("Total Books:"+service.getBookCount());
//		
//		
//		System.out.println("**************Listing All Books************");
//		for(Book book:service.getAllBooks()) {
//			System.out.println(book);
//			}
		
		
		System.out.println("******************Listing book written by Danny Coward********");
		for(Book book:service.getAuthorBooks("Danny Coward")) {
			
			System.out.println(book);
		}
		
		
		System.out.println("**************Listing book on Android***********");
				for(Book book:service.getBookByTitle("Android")) {
					
					System.out.println(book);
					
				}
		
				
	   System.out.println("*****************Listing All books between 500 and 600***************");
		
		for(Book book:service.getBooksInPriceRange(500, 600) ) {
			System.out.println(book);
		}
		
		
	}

}
