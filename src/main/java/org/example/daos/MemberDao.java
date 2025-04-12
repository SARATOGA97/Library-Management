package org.example.daos;


import org.example.entities.Member;
import org.hibernate.Session;

public class MemberDao extends GenericDao<Member, Long> {
    private final Session session;

    public MemberDao(Session session) {
        super(session, Member.class);
        this.session = session;
    }

    public Member findByID(long id) {
        return super.findById(id);
    }

    public Member create(Member member) {
        return super.save(member);
    }

    public Member update(Member member, Long memberId) {
        Member existingMember = findByID(memberId);

        if (member.getContactInfo() != null) {
            existingMember.setContactInfo(member.getContactInfo());
        }

        return super.save(existingMember);
    }

    }
