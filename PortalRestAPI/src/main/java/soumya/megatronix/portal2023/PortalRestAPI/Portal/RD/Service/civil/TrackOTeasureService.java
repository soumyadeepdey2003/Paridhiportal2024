package soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Service.civil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.MRD.Model.MrdModel;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.MRD.Repository.MrdRepository;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Model.civil.TrackOTeasureModel;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Repository.civil.TrackOTeasureRepository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class TrackOTeasureService {

    @Autowired
    private TrackOTeasureRepository civil;

    @Autowired
    private MrdRepository repo;

    @Async
    public CompletableFuture<TrackOTeasureModel> trackOTreasureRd(TrackOTeasureModel member) {
        Optional<MrdModel> gid1 = repo.findByGid(member.getGid1());
        Optional<MrdModel> gid2 = Optional.ofNullable(member.getGid2()).flatMap(repo::findByGid);
        Optional<MrdModel> gid3 = Optional.ofNullable(member.getGid3()).flatMap(repo::findByGid);
        Optional<MrdModel> gid4 = Optional.ofNullable(member.getGid4()).flatMap(repo::findByGid);
        if ( gid1.isPresent() &&
                (gid2.isPresent() || member.getGid2() == null) &&
                (gid3.isPresent() || member.getGid3() == null) &&
                (gid4.isPresent() || member.getGid4() == null)
        ) {
            List<TrackOTeasureModel> list = civil.findAll();
            for (TrackOTeasureModel i : list) {
                if (
                        (
                                member.getGid1().equals(i.getGid1()) ||
                                        member.getGid1().equals(i.getGid2()) ||
                                        member.getGid1().equals(i.getGid3()) ||
                                        member.getGid1().equals(i.getGid4()) ||

                                        member.getGid1().equals(member.getGid2())||
                                        member.getGid1().equals(member.getGid3())||
                                        member.getGid1().equals(member.getGid4())
                        )||
                                (
                                        (member.getGid2() != null &&member.getGid2().equals(i.getGid1())) ||
                                                (member.getGid2() != null &&member.getGid2().equals(i.getGid2()) )||
                                                (member.getGid2() != null &&member.getGid2().equals(i.getGid3())) ||
                                                (member.getGid2() != null &&member.getGid2().equals(i.getGid4()) )||

                                                (member.getGid2() != null &&member.getGid2().equals(member.getGid1()))||
                                                (member.getGid2() != null &&member.getGid2().equals(member.getGid3()))||
                                                (member.getGid2() != null &&member.getGid2().equals(member.getGid4()))
                                )||

                                (
                                        (
                                                (member.getGid3() != null && member.getGid3().equals(i.getGid3())) ||
                                                        (member.getGid3() != null &&member.getGid3().equals(i.getGid1())) ||
                                                        (member.getGid3() != null &&member.getGid3().equals(i.getGid2()) )||
                                                        (member.getGid3() != null &&member.getGid3().equals(i.getGid4())) ||

                                                        (member.getGid3() != null &&member.getGid3().equals(member.getGid1()))||
                                                        (member.getGid3() != null &&member.getGid3().equals(member.getGid2()))||
                                                        (member.getGid3() != null &&member.getGid3().equals(member.getGid4()))
                                        )
                                )||

                                (
                                        (
                                                (member.getGid4() != null && member.getGid4().equals(i.getGid3())) ||
                                                        (member.getGid4() != null && member.getGid4().equals(i.getGid1()) )||
                                                        (member.getGid4() != null && member.getGid4().equals(i.getGid2())) ||
                                                        (member.getGid4() != null && member.getGid4().equals(i.getGid4())) ||

                                                        ( member.getGid4() != null && member.getGid4().equals(member.getGid1()))||
                                                        (member.getGid4() != null && member.getGid4().equals(member.getGid2()))||
                                                        (member.getGid4() != null && member.getGid4().equals(member.getGid3()))
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
                                    member.getGid1().equals(member.getGid4())
                    )||
                            (
                                    (member.getGid2() != null &&member.getGid2().equals(member.getGid1()))||
                                            (member.getGid2() != null &&member.getGid2().equals(member.getGid3()))||
                                            (member.getGid2() != null &&member.getGid2().equals(member.getGid4()))
                            )||
                            (
                                    (member.getGid3() != null &&member.getGid3().equals(member.getGid2()))||
                                            (member.getGid3() != null &&member.getGid3().equals(member.getGid1()))||
                                            (member.getGid3() != null &&member.getGid3().equals(member.getGid4()))
                            )||
                            (
                                    (member.getGid4() != null && member.getGid4().equals(member.getGid2()))||
                                            (member.getGid4() != null && member.getGid4().equals(member.getGid1()))||
                                            (member.getGid4() != null && member.getGid4().equals(member.getGid3()))
                            )
            )
                throw new RuntimeException("GID already exists");
            else {
                CompletableFuture<TrackOTeasureModel> trackOTreasure = CompletableFuture.completedFuture(civil.save(member));
                member.setTid("paridhi"+member.getId()+"2002"+member.getId()+"05202024");
                civil.save(member);
                return trackOTreasure;
            }
        }
        throw new RuntimeException("GID not present");
    }

    public CompletableFuture<MrdModel> checkgid(String gid) {
        MrdModel trackOTreasure = repo.getModelByGid(gid);
        if (trackOTreasure != null) {
            for (TrackOTeasureModel i : civil.findAll()) {
                if (
                        trackOTreasure.getGid().equals(i.getGid1()) ||
                                trackOTreasure.getGid().equals(i.getGid2()) ||
                                trackOTreasure.getGid().equals(i.getGid3()) ||
                                trackOTreasure.getGid().equals(i.getGid4())
                ) {
                    throw new RuntimeException("GID already exists.");
                }
            }

            return CompletableFuture.completedFuture(trackOTreasure);
        } else {
            throw new RuntimeException("GID not present");
        }
    }

    public Optional<TrackOTeasureModel> findByGid(String gid) {
        Optional<TrackOTeasureModel> gid1 = civil.findByGid1(gid);
        Optional<TrackOTeasureModel> gid2 = civil.findByGid2(gid);
        Optional<TrackOTeasureModel> gid3 = civil.findByGid3(gid);
        Optional<TrackOTeasureModel> gid4 = civil.findByGid4(gid);

        if(gid1.isPresent() && !gid2.isPresent() && !gid3.isPresent() && !gid4.isPresent()) {
            return gid1;
        } else if(!gid1.isPresent() && gid2.isPresent() && !gid3.isPresent() && !gid4.isPresent()) {
            return gid2;
        } else if(!gid1.isPresent() && !gid2.isPresent() && gid3.isPresent() && !gid4.isPresent()) {
            return gid3;
        } else if(!gid1.isPresent() && !gid2.isPresent() && !gid3.isPresent() && gid4.isPresent()) {
            return gid4;
        } else {
            return Optional.empty();
        }
    }
}

