package soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Service.coding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.MRD.Model.MrdModel;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.MRD.Repository.MrdRepository;
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
        Optional<MrdModel> gid1 = repo.findById(member.getGid1());
        Optional<MrdModel> gid2 = Optional.ofNullable(member.getGid2()).flatMap(repo::findById);

        if (gid1.isPresent() &&
                (gid2.isPresent() || member.getGid2() == null)) {
            List<CpAllyearModel> list = coding.findBySelectedcodingevent(member.getSelectedcodingevent());
            for (CpAllyearModel i : list) {
                if (member.getGid1().equals(i.getGid1()) ||
                        member.getGid1().equals(i.getGid2()) ||
                        member.getGid1().equals(member.getGid2())||
                        (member.getGid2() !=null && member.getGid2().equals(member.getGid1()))||
                        (member.getGid2() != null && member.getGid2().equals(i.getGid2()) ) ||
                        (member.getGid2() != null && member.getGid2().equals(i.getGid1()) )
                ) {
                    throw new RuntimeException("gid  already exists.");
                }
            }
            if(
                    member.getGid1().equals(member.getGid2()) ||
                            (member.getGid2()!=null && member.getGid2().equals(member.getGid1()))


            ){
                throw new RuntimeException("gid  already exists.");
            }
            else {
                return CompletableFuture.completedFuture(coding.save(member));
            }
        }
        throw new RuntimeException("gid  not present");
    }

}