package com.tns.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.tns.entity.Book;

public class BookDaoImpl implements BookDao {
	
	public EntityManager entityManager;
	
	public BookDaoImpl() {
		entityManager = JPAUtil.getEntityManager();
		
	}
  @Override 
//no JPQL needed
public Book getBookById(int id) {
	  Book book = entityManager.find(Book.class, id);
	  return book;
  }
  
  @Override
  public List<Book> getBookByTitle(String title) //Android
  {
	  String qStr = "SELECT book FROM Book book WHERE book.title LIKE :ptitle";
	  TypedQuery<Book> query = entityManager.createQuery(qStr,Book.class);
	  query.setParameter("ptitle","%"+title+"%");//limit operator in sql
	  return query.getResultList();
	  
  }
  
  @Override
  public Long getBookCount() {
	  String qStr = "SELECT COUNT(book.id) FROM BOOK book";
	  TypedQuery<Long> query = entityManager.createQuery(qStr,Long.class);
	  Long count = query.getSingleResult();
	  return count;
  }
  
  @Override
  public List<Book> getAuthorBooks(String author){
	  String qStr ="SELECT book FROM book WHERE book.author=:pAuthor";
	  TypedQuery<Book> query = entityManager.createQuery(qStr,Book.class);
	  query.setParameter("pAuthor",author);
	  List<Book> bookList = query.getResultList();
	  return bookList;
	  }
  
  @Override
  public List<Book> getAllBooks() {
	  Query query = entityManager.createNamedQuery("getAllBooks");
	  @SuppressWarnings("unchecked")
	  List<Book> bookList = query.getResultList();
	  return bookList;
	  }
  @Override
  public List<Book> getBooksInPriceRange(double low,double high){
	  String qStr = "SELECT book FROM Book book WHERE book.price between:low and :high";
	  TypedQuery<Book> query = entityManager.createQuery(qStr,Book.class);
	  query.setParameter("low", low);
	  query.setParameter("high",high);
	  List<Book> bookList = query.getResultList();
	  return bookList;
	  
  }
}
