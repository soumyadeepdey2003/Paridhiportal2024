package soumya.megatronix.portal2023.PortalRestAPI.Portal.MRD.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.MRD.Model.MrdModel;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.MRD.Repository.MrdRepository;

import java.util.concurrent.CompletableFuture;

@Service
public class MrdService {

    @Autowired
    private MrdRepository MrdRepository;

    @Async
    public CompletableFuture<MrdModel> registerMember(MrdModel member) {

        return CompletableFuture.completedFuture(MrdRepository.save(member));
    }
}
