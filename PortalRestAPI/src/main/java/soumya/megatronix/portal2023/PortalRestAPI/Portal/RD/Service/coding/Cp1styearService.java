package soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Service.coding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.MRD.Model.MrdModel;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.MRD.Repository.MrdRepository;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Model.coding.Cp1styearModel;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Model.coding.CpAllyearModel;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Repository.coding.Cp1styearRepository;


import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class Cp1styearService {

    @Autowired
    private Cp1styearRepository coding;
    @Autowired
    private MrdRepository repo;
    @Async
    public CompletableFuture<Cp1styearModel> Cp1styearRd(Cp1styearModel member) {
        Optional<MrdModel> gid1 = repo.findByGid(member.getGid1());
        Optional<MrdModel> gid2 = Optional.ofNullable(member.getGid2()).flatMap(repo::findByGid);
        Optional<MrdModel> gid3 = Optional.ofNullable(member.getGid3()).flatMap(repo::findByGid);

        if (
                gid1.isPresent() &&
                        (gid2.isPresent() || member.getGid2() == null )&&
                        (gid3.isPresent() || member.getGid3() == null)
        ) {
            List<Cp1styearModel> list = coding.findAll();
            for (Cp1styearModel i : list) {
                if (
                        (
                                member.getGid1().equals(i.getGid1()) ||
                                        member.getGid1().equals(i.getGid2()) ||
                                        member.getGid1().equals(i.getGid3()) ||

                                        member.getGid1().equals(member.getGid2())||
                                        member.getGid1().equals(member.getGid3())
                        )||
                                (
                                        (member.getGid2() != null &&member.getGid2().equals(i.getGid1())) ||
                                                (member.getGid2() != null &&member.getGid2().equals(i.getGid2()) )||
                                                (member.getGid2() != null &&member.getGid2().equals(i.getGid3())) ||

                                                (member.getGid2() != null &&member.getGid2().equals(member.getGid1()))||
                                                (member.getGid2() != null &&member.getGid2().equals(member.getGid3()))
                                ) ||
                                (
                                        (member.getGid3() != null && member.getGid3().equals(i.getGid3())) ||
                                                (member.getGid3() != null &&member.getGid3().equals(i.getGid1())) ||
                                                (member.getGid3() != null &&member.getGid3().equals(i.getGid2()) ) ||

                                                (member.getGid3() != null &&member.getGid3().equals(member.getGid1()))||
                                                (member.getGid3() != null &&member.getGid3().equals(member.getGid2()))
                                )
                ) {
                    throw new RuntimeException("GID already exists.");
                }
            }
            if(
                    (
                            member.getGid1().equals(member.getGid2())||
                                    member.getGid1().equals(member.getGid3())
                    )||
                            (
                                    member.getGid2() != null &&member.getGid2().equals(member.getGid1())||
                                            member.getGid2() != null &&member.getGid2().equals(member.getGid3())
                            )||
                            (
                                    member.getGid3() != null &&member.getGid3().equals(member.getGid2())||
                                            member.getGid3() != null &&member.getGid3().equals(member.getGid1())
                            )
            ){
                throw new RuntimeException("GID already exists.");
            }
            else {
                CompletableFuture<Cp1styearModel> cp1st=CompletableFuture.completedFuture(coding.save(member));
                member.setTid("paridhi"+member.getId()+"2002"+member.getId()+"05202024");
                coding.save(member);
                return cp1st;
            }
        }
        throw new RuntimeException("GID not present");
    }

    @Async
    public CompletableFuture<MrdModel> checkgid(String gid){
        MrdModel cp=repo.getModelByGid(gid);
        if(cp!=null){
            for(Cp1styearModel i:coding.findAll()){
                if (
                        cp.getGid().equals(i.getGid1()) ||
                                cp.getGid().equals(i.getGid2()) ||
                                cp.getGid().equals(i.getGid3())
                ){
                    throw new RuntimeException("GID already exists.");
                }
            }

            return CompletableFuture.completedFuture(cp);
        }
        else {
            throw new RuntimeException("GID not present");
        }
    }
}