package org.example.daos;

import org.example.entities.Book;
import org.example.entities.Reservation;
import org.example.staticdata.Status;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ReservationDao extends GenericDao<Reservation, Long> {
    private final Session session;

    public ReservationDao(Session session) {
        super(session, Reservation.class);
        this.session = session;
    }

    public Reservation findByID(long Id) {
        return super.findById(Id);
    }


    public Reservation create(Reservation reservation) {
        return super.save(reservation);
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


}
