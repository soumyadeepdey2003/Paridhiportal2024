package soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Service.coding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.MRD.Model.MrdModel;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.MRD.Repository.MrdRepository;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Model.coding.Cp1styearModel;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Model.coding.CpAllyearModel;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Repository.coding.CpAllyearRepository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class CpAllyearService {
    @Autowired
    private CpAllyearRepository coding;
    @Autowired
    private MrdRepository repo;

    @Async
    public CompletableFuture<CpAllyearModel> CpAllyearRd(CpAllyearModel member) {
        Optional<MrdModel> gid1 = repo.findByGid(member.getGid1());
        Optional<MrdModel> gid2 = Optional.ofNullable(member.getGid2()).flatMap(repo::findByGid);

        if (gid1.isPresent() &&
                (gid2.isPresent() || member.getGid2() == null)) {
            List<CpAllyearModel> list = coding.findAll();
            for (CpAllyearModel i : list) {
                if (member.getGid1().equals(i.getGid1()) ||
                        member.getGid1().equals(i.getGid2()) ||
                        member.getGid1().equals(member.getGid2())||
                        (member.getGid2() !=null && member.getGid2().equals(member.getGid1()))||
                        (member.getGid2() != null && member.getGid2().equals(i.getGid2()) ) ||
                        (member.getGid2() != null && member.getGid2().equals(i.getGid1()) )
                ) {
                    throw new RuntimeException("GID already exists.");
                }
            }
            if(
                    member.getGid1().equals(member.getGid2()) ||
                            (member.getGid2()!=null && member.getGid2().equals(member.getGid1()))
            ){
                throw new RuntimeException("GID already exists.");
            }
            else {
                CompletableFuture<CpAllyearModel> cpall=CompletableFuture.completedFuture(coding.save(member));
                member.setTid("paridhi"+member.getId()+"2002"+member.getId()+"05202024");
                coding.save(member);
                return cpall;
            }
        }
        throw new RuntimeException("GID not present");
    }

    @Async
    public CompletableFuture<MrdModel> checkgid(String gid) {
        MrdModel cp = repo.getModelByGid(gid);
        if (cp != null) {
            for (CpAllyearModel i : coding.findAll()) {
                if (cp.getGid().equals(i.getGid1()) || cp.getGid().equals(i.getGid2())) {
                    throw new RuntimeException("GID already exists.");
                }
            }

            return CompletableFuture.completedFuture(cp);
        } else {
            throw new RuntimeException("GID not present");
        }
    }
    public Optional<CpAllyearModel> findByGid(String gid) {
        Optional<CpAllyearModel> gid1 = coding.findByGid1(gid);
        Optional<CpAllyearModel> gid2 = coding.findByGid2(gid);

        if (gid1.isPresent() && !gid2.isPresent()) {
            return gid1;
        } else if (!gid1.isPresent() && gid2.isPresent()) {
            return gid2;
        } else {
            return Optional.empty();
        }
    }
}