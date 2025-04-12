package org.example.daos;

import org.example.entities.Author;
import org.example.entities.Book;
import org.example.staticdata.Genre;
import org.example.staticdata.Status;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class BookDao extends GenericDao<Book, Long> {
    private final Session session;
    private final AuthorDao authorDao;

    public BookDao(Session session, AuthorDao authorDao) {
        super(session, Book.class);
        this.session = session;
        this.authorDao = authorDao;
    }

    public Book findByID(Long id) {
        return super.findById(id);
    }


    public List<Book> findBooksByTitle(String bookTitle) {
        String query = "select b from Book b where LOWER(b.bookTitle) = :title";
        Query<Book> findBooksQuery = session.createQuery(query, Book.class);
        findBooksQuery.setParameter("title", bookTitle.toLowerCase());
        return findBooksQuery.getResultList();
    }


//    public List<Book> findAll(String title, String authorName, Genre genre) {
//        String searchByTitle = "select b from Book b where b.title like :title";
//        Query<Book>
//        StringBuilder queryBuilder = new StringBuilder("select b from Book b where 1=1");
//        if (title != null && !title.isEmpty()) {
//            queryBuilder.append(" and lower(b.bookTitle) like lower(:title)");
//        }
//        if (authorName != null && !authorName.isEmpty()) {
//            queryBuilder.append(" and lower(b.author.firstName || ' ' || b.author.lastName) like lower(:authorName)");
//        }
//        if (genre != null) {
//            queryBuilder.append(" and b.genre = :genre");
//        }
//        Query<Book> query = session.createQuery(queryBuilder.toString(), Book.class);
//        if (title != null && !title.isEmpty()) {
//            query.setParameter("title", "%" + title + "%");
//        }
//        if (authorName != null && !authorName.isEmpty()) {
//            query.setParameter("authorName", "%" + authorName + "%");
//        }
//        if (genre != null) {
//            query.setParameter("genre", genre);
//        }
//        return query.getResultList();
//    }
/// ................................................AI Suggested.........................................///
//    public List<Book> findBooksByTitleAndAuthor(String title, String authorFirstName, String authorLastName) {
//        // Base query from findAll
//        String baseQuery  = String.format("select e from %s e", Book.class.getSimpleName());
//
//        // Extend the query with filtering conditions
//String query = baseQuery + " where e.bookTitle = :title and e.author.firstName = :firstName and e.author.lastName = :lastName";
//
//        Query<Book> findBooksQuery = session.createQuery(query, Book.class);
//        findBooksQuery.setParameter("title", title);
//        findBooksQuery.setParameter("firstName", authorFirstName);
//        findBooksQuery.setParameter("lastName", authorLastName);
//
//        return findBooksQuery.getResultList();
//    }

    /// ................................................................................................///

    public Book create(Book book, Long authorId) {
        Author author = authorDao.findById(authorId);
        book.setAuthor(author);
        return super.save(book);
    }

    public Book update(Book book, Long bookId) {
        Book existingBook = super.findById(bookId);
        if (book.getBookTitle() != null)
            existingBook.setBookTitle(book.getBookTitle());
        if (book.getGenre() != null)
            existingBook.setGenre(book.getGenre());
        if (book.getQuantity() != null)
            existingBook.setQuantity(book.getQuantity());
        //Keshtu dhe per te tjerat,
        // all they need Try and Catch
        return super.save(existingBook);
    }

    //******************************************************************************************
//    public boolean isBookAvailableForBorrowing(Long bookId) {
//        // Retrieve the book by ID
//        Book book = super.findById(bookId);
//        if (book == null) {
//            throw new IllegalArgumentException("Book with ID " + bookId + " does not exist.");
//        }
//
//        // Query to count active reservations for the book
//        String reservationQuery = "select count(r) from Reservation r where r.book.bookId = :bookId and r.status = :status";
//        Long reservedCount = session.createQuery(reservationQuery, Long.class)
//                .setParameter("bookId", bookId)
//                .setParameter("status", Status.RESERVED)
//                .getSingleResult();
//
//        // Check if remaining quantity is greater than zero
//        int remainingQuantity = book.getQuantity() - reservedCount.intValue();
//        return remainingQuantity > 0;
//    }
    //*************************************************************************************************//

    //AI Simplified
    public boolean isBookAvailableForBorrowing(Long bookId) {
        Book book = super.findById(bookId);
        if (book == null) {
            throw new IllegalArgumentException("Book with ID " + bookId + " does not exist.");
        }

        Long reservedCount = session.createQuery(
                        "select count(r) from Reservation r where r.book.bookId = :bookId and r.status = :status", Long.class)
                .setParameter("bookId", bookId)
                .setParameter("status", Status.RESERVED)
                .getSingleResult();

        return book.getQuantity() > reservedCount;
    }
    /// *** Kujdes te implementohet pasi eshte Implementuar ReservationDao *** ///
//public Book delete (Book book, Long bookId){
//    Book existingBook = super.findById(bookId);

    public List<Book> findAll() {
        return super.findAll();
    }
}

