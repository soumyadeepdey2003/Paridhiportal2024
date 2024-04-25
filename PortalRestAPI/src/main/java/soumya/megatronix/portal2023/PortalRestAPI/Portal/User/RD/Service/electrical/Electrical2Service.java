package soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Service.electrical;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.MRD.Model.MrdModel;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.MRD.Repository.MrdRepository;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Model.coding.CodeQuestModel;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Model.electrical.Electrical2;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Repository.electrical.Electrical2Repository;
import soumya.megatronix.portal2023.PortalRestAPI.Verification.Email.Service.EmailService;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class Electrical2Service {

    @Autowired
    private Electrical2Repository electrical;

    @Autowired
    private MrdRepository repo;

    @Autowired
    private EmailService emailService;

    @Async
    public CompletableFuture<Electrical2> Electrical2Rd(Electrical2 member) {
        Optional<MrdModel> gid1 = repo.findByGid(member.getGid1());
        Optional<MrdModel> gid2 = Optional.ofNullable(member.getGid2()).flatMap(repo::findByGid);
        if ( gid1.isPresent() &&
                (gid2.isPresent() || member.getGid2() == null )
        ) {
            List<Electrical2> list = electrical.findAll();
            for (Electrical2 i : list) {
                if (
                        (
                                member.getGid1().equals(i.getGid1()) ||
                                        member.getGid1().equals(i.getGid2()) ||

                                        member.getGid1().equals(member.getGid2())
                        )||
                                (
                                        (member.getGid2() != null &&member.getGid2().equals(i.getGid1())) ||
                                                (member.getGid2() != null &&member.getGid2().equals(i.getGid2()) )||

                                                (member.getGid2() != null &&member.getGid2().equals(member.getGid1()))
                                )
                ) {
                    throw new RuntimeException("GID already exists.");
                }
            }
            if(
                    (
                            member.getGid1().equals(member.getGid2())
                    )||
                            (
                                    (member.getGid2() != null &&member.getGid2().equals(member.getGid1()))
                            )
            )
                throw new RuntimeException("GID already exists");
            else {
                CompletableFuture<Electrical2> electrical2 = CompletableFuture.completedFuture(electrical.save(member));
                member.setTid("paridhi"+member.getId()+"2002"+member.getId()+"05202024");
                electrical.save(member);
                sendEmail(member.getTid());
                return electrical2;
            }
        }
        throw new RuntimeException("GID not present");
    }

    public CompletableFuture<MrdModel> checkgid(String gid) {
        MrdModel Electrical2 = repo.getModelByGid(gid);
        if (Electrical2 != null) {
            for (Electrical2 i : electrical.findAll()) {
                if (
                        Electrical2.getGid().equals(i.getGid1()) ||
                                Electrical2.getGid().equals(i.getGid2())
                ) {
                    throw new RuntimeException("GID already exists.");
                }
            }

            return CompletableFuture.completedFuture(Electrical2);
        } else {
            throw new RuntimeException("GID not present");
        }
    }

    public Optional<Electrical2> findByGid(String gid) {
        Optional<Electrical2> gid1 = electrical.findByGid1(gid);
        Optional<Electrical2> gid2 = electrical.findByGid2(gid);

        if(gid1.isPresent() && !gid2.isPresent()) {
            return gid1;
        } else if(!gid1.isPresent() && gid2.isPresent()) {
            return gid2;
        } else {
            return Optional.empty();
        }
    }

    @Async
    protected void sendEmail(String tid) {
        Optional<Electrical2> model = electrical.findByTid(tid);
        Optional<MrdModel> user1 = repo.findByGid(model.get().getGid1());
        Optional<MrdModel> user2 = repo.findByGid(model.get().getGid2());
        List<String> emails = new ArrayList<>();
        if (user1.isPresent() && user1.get().getEmail() != null && !user1.get().getEmail().isEmpty()) {
            emails.add(user1.get().getEmail());
        }
        if (user2.isPresent() && user2.get().getEmail() != null && !user2.get().getEmail().isEmpty()) {
            emails.add(user2.get().getEmail());
        }

        System.out.println(emails);
        emailService.sendEventRegistrationEmail(tid, "Electrical-2", "Team", emails.toArray(new String[0]));
    }
}
