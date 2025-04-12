package org.example.daos;

import org.example.entities.Author;
import org.example.entities.Book;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class AuthorDao extends GenericDao<Author,Long> {
    private final Session session;
    public AuthorDao(Session session ) {
        super(session, Author.class);
        this.session=session;
    }
        public Author findByID(Long id){
        return super.findById(id);
   }
    public List<Book> findBooksByAuthor(String authorFirstName, String authorLastName) {
        String query = "select b from Book b where LOWER(b.author.firstName) = :firstName and LOWER(b.author.lastName) = :lastName";
        Query<Book> findBooksQuery = session.createQuery(query, Book.class);
        findBooksQuery.setParameter("firstName", authorFirstName.toLowerCase());
        findBooksQuery.setParameter("lastName", authorLastName.toLowerCase());
        return findBooksQuery.getResultList();
    }
     public Author create (Author author){
        return super.save(author);


     }
//     public Author delete (Author id){
//        return super.delete(Author id);
//     }


}
