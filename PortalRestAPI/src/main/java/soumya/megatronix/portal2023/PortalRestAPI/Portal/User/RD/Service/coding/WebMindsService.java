package soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Service.coding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.MRD.Model.MrdModel;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.MRD.Repository.MrdRepository;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Model.coding.WebMindsModel;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Repository.coding.WebMindsRepository;


import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class WebMindsService {

    @Autowired
    private WebMindsRepository coding;
    @Autowired
    private MrdRepository repo;

    @Async
    public CompletableFuture<WebMindsModel> WebMindsRd(WebMindsModel member) {
        Optional<MrdModel> gid1 = repo.findByGid(member.getGid1());
        Optional<MrdModel> gid2 = Optional.ofNullable(member.getGid2()).flatMap(repo::findByGid);
        if (
                gid1.isPresent() &&
                        (gid2.isPresent() || member.getGid2() == null )
        ) {
            List<WebMindsModel> list = coding.findAll();
            for (WebMindsModel i : list) {
                if (
                        (
                                member.getGid1().equals(i.getGid1()) ||
                                member.getGid1().equals(i.getGid2())||
                                member.getGid1().equals(member.getGid2())

                        )||
                        (
                                (member.getGid2() != null &&member.getGid2().equals(i.getGid1())) ||
                                (member.getGid2() != null &&member.getGid2().equals(i.getGid2()) ))||
                                (member.getGid2() != null && member.getGid2().equals(i.getGid1())
                        )

                ) {
                    throw new RuntimeException("GID already exists.");
                }
            }
            if (
                    (
                            member.getGid1().equals(member.getGid2())
                    )||
                    (
                            member.getGid2() != null && member.getGid2().equals(member.getGid1())
                    )
            ) {
                throw new RuntimeException("GID already exists.");
            }
            else {
                CompletableFuture<WebMindsModel> webMinds = CompletableFuture.completedFuture(coding.save(member));
                member.setTid("paridhi"+member.getId()+"2002"+member.getId()+"05202024");
                coding.save(member);
                return webMinds;
            }
        }
        throw new RuntimeException("GID not present");
    }

    @Async
    public CompletableFuture<MrdModel> checkGid(String gid) {
        MrdModel cp = repo.getModelByGid(gid);
        if (cp != null) {
            for (WebMindsModel i : coding.findAll()) {
                if (
                        cp.getGid().equals(i.getGid1()) ||
                                cp.getGid().equals(i.getGid2())

                ) {
                    throw new RuntimeException("GID already exists.");
                }
            }

            return CompletableFuture.completedFuture(cp);
        } else {
            throw new RuntimeException("GID not present");
        }
    }

    public Optional<WebMindsModel> findByGid(String gid) {
        Optional<WebMindsModel> gid1 = coding.findByGid1(gid);
        Optional<WebMindsModel> gid2 = coding.findByGid2(gid);

        if (gid1.isPresent() && !gid2.isPresent()) {
            return gid1;
        } else if (!gid1.isPresent() && gid2.isPresent()) {
            return gid2;
        } else {
            return Optional.empty();
        }
    }
}