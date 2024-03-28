package soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Service.gaming;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.MRD.Model.MrdModel;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.MRD.Repository.MrdRepository;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Model.gaming.Gaming_2;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Repository.gaming.Gaming_2Repository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class Gaming_2Service {
    @Autowired
    private Gaming_2Repository gaming;

    @Autowired
    private MrdRepository repo;

    @Async
    public CompletableFuture<Gaming_2> gaming2Rd(Gaming_2 member) {
        Optional<MrdModel> gid1 = repo.findByGid(member.getGid1());
        Optional<MrdModel> gid2 = Optional.ofNullable(member.getGid2()).flatMap(repo::findByGid);
        Optional<MrdModel> gid3 = Optional.ofNullable(member.getGid3()).flatMap(repo::findByGid);
        Optional<MrdModel> gid4 = Optional.ofNullable(member.getGid4()).flatMap(repo::findByGid);
        Optional<MrdModel> gid5 = Optional.ofNullable(member.getGid5()).flatMap(repo::findByGid);
        if ( gid1.isPresent() &&
                (gid2.isPresent() || member.getGid2() == null )&&
                (gid3.isPresent() || member.getGid3() == null)  &&
                (gid4.isPresent() || member.getGid4() == null)  &&
                (gid5.isPresent() || member.getGid5() == null)
        ) {
            List<Gaming_2> list = gaming.findAll();
            for (Gaming_2 i : list) {
                if (
                        (
                                member.getGid1().equals(i.getGid1()) ||
                                        member.getGid1().equals(i.getGid2()) ||
                                        member.getGid1().equals(i.getGid3()) ||
                                        member.getGid1().equals(i.getGid4()) ||
                                        member.getGid1().equals(i.getGid5()) ||

                                        member.getGid1().equals(member.getGid2())||
                                        member.getGid1().equals(member.getGid3())||
                                        member.getGid1().equals(member.getGid4())||
                                        member.getGid1().equals(member.getGid5())
                        )||
                                (
                                        (member.getGid2() != null &&member.getGid2().equals(i.getGid1())) ||
                                                (member.getGid2() != null &&member.getGid2().equals(i.getGid2()) )||
                                                (member.getGid2() != null &&member.getGid2().equals(i.getGid3())) ||
                                                (member.getGid2() != null &&member.getGid2().equals(i.getGid4()) )||
                                                (member.getGid2() != null &&member.getGid2().equals(i.getGid5())) ||

                                                (member.getGid2() != null &&member.getGid2().equals(member.getGid1()))||
                                                (member.getGid2() != null &&member.getGid2().equals(member.getGid3()))||
                                                (member.getGid2() != null &&member.getGid2().equals(member.getGid4()))||
                                                (member.getGid2() != null &&member.getGid2().equals(member.getGid5()))
                                )||

                                (
                                        (
                                                (member.getGid3() != null && member.getGid3().equals(i.getGid3())) ||
                                                        (member.getGid3() != null &&member.getGid3().equals(i.getGid1())) ||
                                                        (member.getGid3() != null &&member.getGid3().equals(i.getGid2()) )||
                                                        (member.getGid3() != null &&member.getGid3().equals(i.getGid4())) ||
                                                        (member.getGid3() != null &&member.getGid3().equals(i.getGid5()))) ||

                                                (member.getGid3() != null &&member.getGid3().equals(member.getGid1()))||
                                                (member.getGid3() != null &&member.getGid3().equals(member.getGid2()))||
                                                (member.getGid3() != null &&member.getGid3().equals(member.getGid4()))||
                                                (member.getGid3() != null &&member.getGid3().equals(member.getGid5())
                                                )
                                )||

                                (
                                        (
                                                (member.getGid4() != null && member.getGid4().equals(i.getGid3())) ||
                                                        (member.getGid4() != null && member.getGid4().equals(i.getGid1()) )||
                                                        (member.getGid4() != null && member.getGid4().equals(i.getGid2())) ||
                                                        (member.getGid4() != null && member.getGid4().equals(i.getGid4())) ||
                                                        (member.getGid4() != null && member.getGid4().equals(i.getGid5()) )||

                                                        ( member.getGid4() != null && member.getGid4().equals(member.getGid1()))||
                                                        (member.getGid4() != null && member.getGid4().equals(member.getGid2()))||
                                                        (member.getGid4() != null && member.getGid4().equals(member.getGid3()))||
                                                        (member.getGid4() != null && member.getGid4().equals(member.getGid5()))
                                        )
                                )||

                                (
                                        (
                                                (member.getGid5() != null && member.getGid5().equals(i.getGid3())) ||
                                                        (member.getGid5() != null && member.getGid5().equals(i.getGid1())) ||
                                                        (member.getGid5() != null && member.getGid5().equals(i.getGid2())) ||
                                                        (member.getGid5() != null && member.getGid5().equals(i.getGid4())) ||
                                                        (member.getGid5() != null && member.getGid5().equals(i.getGid5()))||

                                                        (member.getGid5() != null && member.getGid5().equals(member.getGid1()))||
                                                        (member.getGid5() != null && member.getGid5().equals(member.getGid2()))||
                                                        (member.getGid5() != null && member.getGid5().equals(member.getGid3()))||
                                                        (member.getGid5() != null && member.getGid5().equals(member.getGid4()))
                                        )
                                )
                ) {
                    throw new RuntimeException("GID already exists.");
                }
            }
            if(
                    (
                            member.getGid1().equals(member.getGid2())||
                                    member.getGid1().equals(member.getGid3())||
                                    member.getGid1().equals(member.getGid4())||
                                    member.getGid1().equals(member.getGid5())
                    )||
                            (
                                    (member.getGid2() != null &&member.getGid2().equals(member.getGid1()))||
                                            (member.getGid2() != null &&member.getGid2().equals(member.getGid3()))||
                                            (member.getGid2() != null &&member.getGid2().equals(member.getGid4()))||
                                            (member.getGid2() != null &&member.getGid2().equals(member.getGid5()))
                            )||
                            (
                                    (member.getGid3() != null &&member.getGid3().equals(member.getGid2()))||
                                            (member.getGid3() != null &&member.getGid3().equals(member.getGid1()))||
                                            (member.getGid3() != null &&member.getGid3().equals(member.getGid4()))||
                                            (member.getGid3() != null &&member.getGid3().equals(member.getGid5()))
                            )||
                            (
                                    (member.getGid4() != null && member.getGid4().equals(member.getGid2()))||
                                            (member.getGid4() != null && member.getGid4().equals(member.getGid1()))||
                                            (member.getGid4() != null && member.getGid4().equals(member.getGid3()))||
                                            (member.getGid4() != null && member.getGid4().equals(member.getGid5()))
                            )
            )
                throw new RuntimeException("GID already exists");
            else {
                CompletableFuture<Gaming_2> gaming2 = CompletableFuture.completedFuture(gaming.save(member));
                member.setTid("paridhi"+member.getId()+"2002"+member.getId()+"05202024");
                gaming.save(member);
                return gaming2;
            }
        }
        throw new RuntimeException("GID not present");
    }

    public CompletableFuture<MrdModel> checkgid(String gid) {
        MrdModel gaming2 = repo.getModelByGid(gid);
        if (gaming2 != null) {
            for (Gaming_2 i : gaming.findAll()) {
                if (
                        gaming2.getGid().equals(i.getGid1()) ||
                                gaming2.getGid().equals(i.getGid2()) ||
                                gaming2.getGid().equals(i.getGid3()) ||
                                gaming2.getGid().equals(i.getGid4()) ||
                                gaming2.getGid().equals(i.getGid5())
                ) {
                    throw new RuntimeException("GID already exists.");
                }
            }

            return CompletableFuture.completedFuture(gaming2);
        } else {
            throw new RuntimeException("GID not present");
        }
    }

    public Optional<Gaming_2> findByGid (String gid) {
        Optional<Gaming_2> gid1 = gaming.findByGid1(gid);
        Optional<Gaming_2> gid2 = gaming.findByGid2(gid);
        Optional<Gaming_2> gid3 = gaming.findByGid3(gid);
        Optional<Gaming_2> gid4 = gaming.findByGid4(gid);
        Optional<Gaming_2> gid5 = gaming.findByGid5(gid);

        if(gid1.isPresent() && !gid2.isPresent() && !gid3.isPresent() && !gid4.isPresent() && !gid5.isPresent()) {
            return gid1;
        } else if(!gid1.isPresent() && gid2.isPresent() && !gid3.isPresent() && !gid4.isPresent() && !gid5.isPresent()) {
            return gid2;
        } else if(!gid1.isPresent() && !gid2.isPresent() && gid3.isPresent() && !gid4.isPresent() && !gid5.isPresent()) {
            return gid3;
        } else if(!gid1.isPresent() && !gid2.isPresent() && !gid3.isPresent() && gid4.isPresent() && !gid5.isPresent()) {
            return gid4;
        } else if(!gid1.isPresent() && !gid2.isPresent() && !gid3.isPresent() && !gid4.isPresent() && gid5.isPresent()) {
            return gid5;
        } else {
            return Optional.empty();
        }
    }
}
