package soumya.megatronix.portal2023.PortalRestAPI.Portal.MRD.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.MRD.Model.MrdModel;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.MRD.Repository.MrdRepository;
import soumya.megatronix.portal2023.PortalRestAPI.Verification.Email.Service.EmailService;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class MrdService {

    @Autowired
    private MrdRepository MrdRepository;

    @Async
    public CompletableFuture<MrdModel> registerMember(MrdModel member) {
        CompletableFuture<MrdModel> mrd = CompletableFuture.completedFuture(MrdRepository.save(member));
        member.setGid("paridhi200002" + member.getId() + "02052" + member.getId() + "024");
        MrdRepository.save(member);
        return mrd;
    }
}
