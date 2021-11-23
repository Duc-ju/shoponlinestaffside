package model.book;

import java.sql.Date;

public class Book {

	private int id;
	private String IBSN;
	private String title;
	private String language;
	private Date publicationDate;
	private int numberOfPage;
	private Author author;
	private Category category;
	private Publisher publisher;
	public Book(int id, String iBSN, String title, String language, Date publicationDate, int numberOfPage,
			Author author, Category category, Publisher publisher) {
		super();
		this.id = id;
		IBSN = iBSN;
		this.title = title;
		this.language = language;
		this.publicationDate = publicationDate;
		this.numberOfPage = numberOfPage;
		this.author = author;
		this.category = category;
		this.publisher = publisher;
	}
	
	public Book(String iBSN, String title, String language, Date publicationDate, int numberOfPage, Author author,
			Category category, Publisher publisher) {
		super();
		this.IBSN = iBSN;
		this.title = title;
		this.language = language;
		this.publicationDate = publicationDate;
		this.numberOfPage = numberOfPage;
		this.author = author;
		this.category = category;
		this.publisher = publisher;
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIBSN() {
		return IBSN;
	}
	public void setIBSN(String iBSN) {
		IBSN = iBSN;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Date getPublicationDate() {
		return publicationDate;
	}
	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}
	public int getNumberOfPage() {
		return numberOfPage;
	}
	public void setNumberOfPage(int numberOfPage) {
		this.numberOfPage = numberOfPage;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Publisher getPublisher() {
		return publisher;
	}
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	
}