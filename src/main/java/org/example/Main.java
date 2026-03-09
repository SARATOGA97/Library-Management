package org.example;

import org.example.config.HibernateUtils;
import org.example.daos.AuthorDao;
import org.example.daos.BookDao;
import org.example.daos.MemberDao;
import org.example.daos.ReservationDao;
import org.example.entities.Author;
import org.example.entities.Book;
import org.example.entities.Member;
import org.example.entities.Reservation;
import org.example.staticdata.Genre;
import org.example.staticdata.Status;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        HibernateUtils hibernateUtils = new HibernateUtils();
        SessionFactory sessionFactory = hibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        AuthorDao authorDao = new AuthorDao(session);
        BookDao bookDao = new BookDao(session, authorDao);
        MemberDao memberDao = new MemberDao(session);
        Book updatedBook = new Book();
        Member updatedMember=new Member();
        ReservationDao reservationDao = new ReservationDao(session,bookDao,memberDao);
        Reservation updatedReservation=new Reservation();

        ///*---------------* MENAXHIMI I AUTOREVE *----------------///

        // 1) *---------------* Krijimi i Informacionit për Autorët *----------------//

//        Author author=new Author();
//        author.setFirstName("Leo");
//        author.setLastName("Tolstoi");
//        author.setBio("Shkrimtar, Lindur me 28.08.1828, Rusi");
        //        authorDao.save(author);
        //authorDao.create(author); //perdor create ne vend te save

        // 2) *----------------* Fshirja e Autorëve *--------------------//
//        authorDao.delete(5L);
        // 3) *------------* Listimi i Librave sipas Autorit  *-----------//

//        List<Book> books = authorDao.findBooksByAuthor("Ismail", "Kadare");
//        System.out.println("Number of books found: " + books.size());
//        books.forEach(book -> System.out.println("Book Title: " + book.getBookTitle()));


        ///*---------------* MENAXHIMI I LIBRAVE *----------------///

        // 1) *------------* Krijimi i Librave të Rinj *-----------//
//        Book book=new Book();
//        book.setBookTitle("To Kill a Mockingbird,");
//        book.setGenre(Genre.FICTION);
//        book.setPublishedDate(LocalDate .of(1960, 01, 1));
//        book.setQuantity(2);
////        book.setAuthor(authorDao.findByID(7L)); perdorim reshtin me posht me Create
//        bookDao.create(book,9L);
//         List<Book> books = bookDao.findAll();
//         books.forEach(books1 -> System.out.println(books1));
//        books.forEach(books1 -> System.out.println(books1.getBookTitle() + " | " + books1.getAuthor().getFirstName() + " " + books1.getAuthor().getLastName()));
//          System.out.println(books);
        // 2) *------------* Përditësimi i Informacionit të Librave *-----------//

//          updatedBook.setBookTitle("Keshtjella");
//          updatedBook.setGenre(Genre.HISTORY);
//          updatedBook.setQuantity(6);
//          bookDao.update(updatedBook, 1L);

        // 3) *------------* Fshirja e Librave  *-----------//

//        bookDao.delete(L);

        // 4) *------------* Kërkimi i Librave   *-----------//
//        List<Book> books = bookDao.findBooksByTitle("Keshtjella");
//        System.out.println("Number of books found: " + books.size());
//        books.forEach(book -> System.out.println("Title: " + book.getBookTitle() +
//                ", Author: " + book.getAuthor().getFirstName() + " " + book.getAuthor().getLastName() +
//                ", Genre: " + book.getGenre()));

        // 5) *------------* Kontrollimi i Disponueshmërisë së Librave    *-----------//
//        boolean isAvailable = bookDao.isBookAvailableForBorrowing(4L);
//        if (isAvailable) {
//            System.out.println("The book is available for borrowing.");
//        } else {
//            System.out.println("The book is not available for borrowing.");
//        }

        ///*---------------* MENAXHIMI I ANETAREVE *----------------///

        // 1) *---------------* Regjistrimi i Anëtarëve të Rinj *----------------//

//        Member member = new Member();
//        member.setFirstName("Flavio");
//        member.setLastName("Xhelaj");
//        member.setMembershipDate(LocalDate.now());
//        member.setContactInfo("F.Xhelaj@mobilje.com");
//        memberDao.create(member);
//        memberDao.delete(1L);

        // 2) *---------------* Përditësimi i Informacionit të Anëtarëve *----------------//

//        updatedMember.setContactInfo("e.beqiraj@weatherfod.com");
//        memberDao.update(updatedMember,5L);

        // 3) *---------------* Shfaqja e Historikut të Rezervimeve *----------------//

        //Shfaqja e Historikut të Rezervimeve Të gjenden të gjitha rezervimet e kryera nga një anëtar specifik.//

        //AI Generated
//        List<Reservation> reservations = reservationDao.findAllReservationsByMemberId(3L);
//        reservations.forEach(reservation -> {
//            System.out.println("-----------------------------------");
//            System.out.println("Member ID: " + reservation.getMember().getMemberId());
//            System.out.println("-----------------------------------");
//            System.out.println("Member Name: " + reservation.getMember().getFirstName() + " " + reservation.getMember().getLastName());
//            System.out.println("Reservation ID: " + reservation.getReservationId());
//            System.out.println("Book Title: " + reservation.getBook().getBookTitle());
//            System.out.println("Reservation Date: " + reservation.getReservationDate());
//            System.out.println("Return Date: " + reservation.getReturnDate());
//            System.out.println("Status: " + reservation.getStatus());
//            System.out.println("**********************************");
//        });

        ///*---------------* MENAXHIMI I REZERVIMEVE *----------------///

        // 1) *---------------* Krijimi i Rezervimeve *----------------//

//        Reservation reservation = new Reservation();
//        reservation.setMember(memberDao.findByID(3L));
//        reservation.setBook(bookDao.findByID(1L));
//        reservation.setReservationDate(LocalDate.now());//duhen implementuar ne DAO
//        reservation.setReturnDate(LocalDate.now().plusDays(30));//duhen implementuar ne DAO
//        reservation.setStatus(Status.RESERVED);//duhen implementuar ne DAO
//        reservationDao.create(reservation);
        System.out.println(reservationDao.closeReservation(10L));
        // 1.1) *---------------* Fshirja e Rezervimeve *----------------//
//        reservationDao.delete(L);

        // 2) *---------------* Përditësimi i Statusit të Rezervimeve *----------------//
//        updatedReservation.setStatus(Status.CANCELLED);
//        reservationDao.update(updatedReservation,11L);

        // 3) *---------------* Kërkimi i Rezervimeve *----------------//
//        List<Reservation> reservations = reservationDao.findAllReservationsByStatus(Status.CANCELLED);
//        reservations.forEach(reservation -> {
//            System.out.println("-----------------------------------");
//            System.out.println("Reservation ID: " + reservation.getReservationId());
//            System.out.println("-----------------------------------");
//            System.out.println("Member Name: " + reservation.getMember().getFirstName() + " " + reservation.getMember().getLastName());
//            System.out.println("Member ID: " + reservation.getMember().getMemberId());
//            System.out.println("Book Title: " + reservation.getBook().getBookTitle());
//            System.out.println("Reservation Date: " + reservation.getReservationDate());
//            System.out.println("Return Date: " + reservation.getReturnDate());
//            System.out.println("Status: " + reservation.getStatus());
//            System.out.println("**********************************");
//        });

        ///*---------------* SSHTESA TE VECANTA *----------------///

        // 1) *---------------* Gjenerimi i Raporteve *----------------//
                          // XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX //

        // 2) *---------------* Statistikat e Disponueshmërisë *----------------//
                              // XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX //

        // 3) *---------------* Menaxhimi i Gjobave *----------------//
                   //  XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX //




    }
}