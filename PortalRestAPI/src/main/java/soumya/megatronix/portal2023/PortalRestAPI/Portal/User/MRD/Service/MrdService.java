package soumya.megatronix.portal2023.PortalRestAPI.Portal.User.MRD.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.MRD.Model.MrdModel;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.MRD.Repository.MrdRepository;

import java.util.concurrent.CompletableFuture;

@Service
public class MrdService {

    @Autowired
    private MrdRepository MrdRepository;

    @Async
    public CompletableFuture<MrdModel> registerMember(MrdModel member) {
        CompletableFuture<MrdModel> mrd = CompletableFuture.completedFuture(MrdRepository.save(member));
        member.setGid("paridhi200002" + member.getId() + "02052" + member.getId() + "024");
        if(member.isEmailVerified()) {
            MrdRepository.save(member);
            return mrd;
        }else {
            throw new RuntimeException("Email not verified");
        }
    }
}
