package org.example.daos;

import org.example.entities.Book;
import org.example.entities.Member;
import org.example.entities.Reservation;
import org.example.staticdata.Status;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.List;

public class ReservationDao extends GenericDao<Reservation, Long> {
    private final Session session;
    private final BookDao bookDao;
    private final MemberDao memberDao;


    public ReservationDao(Session session, BookDao bookDao, MemberDao memberDao) {
        super(session, Reservation.class);
        this.session = session;
        this.bookDao = bookDao;
        this.memberDao = memberDao;

    }

    public Reservation findByID(long Id) {
        return super.findById(Id);
    }


    public Reservation create(Reservation reservation, Long bookId, Long memberId) {
        Book book = bookDao.findById(bookId);
        if (book == null) {
            throw new IllegalArgumentException("Book not found with ID: " + bookId);
        }
        if(book.getQuantity()<1) {
            throw new IllegalArgumentException("Book is not available for reservation.");
        }
        book.setQuantity(book.getQuantity()-1);
        bookDao.save(book);
        reservation.setBook(book);
        Member member= memberDao.findById(memberId);
        reservation.setMember(member);
        reservation.setReservationDate(LocalDate.now());
        reservation.setReturnDate(LocalDate.now().plusDays(30));
        reservation.setStatus(Status.RESERVED);

        return super.save(reservation);
    }
    public Reservation closeReservation(Long reservationId){
        Reservation reservation = this.findByID(reservationId);
        if(reservation==null){
            throw new IllegalArgumentException("Reservation does not Exist" + reservationId);
        }
        Book book =reservation.getBook();
        book.setQuantity(book.getQuantity()+1);
        bookDao.save(book);
//        if(reservation.getReturnDate().isBefore(LocalDate.now())){
//
//        }
        reservation.setReturnDate(LocalDate.now());
        reservation.setStatus(Status.RETURNED);
        return  super.save(reservation);

    }

    public List<Reservation> findAllReservationsByMemberId(Long memberId) {
        String query = "select r from Reservation r where r.member.memberId = :memberId";
        Query<Reservation> findReservationsQuery = session.createQuery(query, Reservation.class);
        findReservationsQuery.setParameter("memberId", memberId);
        return findReservationsQuery.getResultList();
    }
    public List<Reservation> findAllReservationsByStatus(Status status) {
        String query = "select r from Reservation r where r.status = :status";
        Query<Reservation> findReservationsQuery = session.createQuery(query, Reservation.class);
        findReservationsQuery.setParameter("status", status);
        return findReservationsQuery.getResultList();
    }

    public Reservation update(Reservation reservation, Long reservationId) {
        Reservation existingReservation = super.findById(reservationId);
        if (reservation.getStatus() != null)
            existingReservation.setStatus(reservation.getStatus());
        return super.save(existingReservation);
    }


//    public List<Reservation> findAllReservationsByBookId(Long bookId) {
//        String query = "select r from Reservation r where r.member.memberId = :memberId";
//        Query<Reservation> findReservationsQuery = session.createQuery(query, Reservation.class);
//        findReservationsQuery.setParameter("memberId", memberId);
//        return findReservationsQuery.getResultList();
//    }
}
