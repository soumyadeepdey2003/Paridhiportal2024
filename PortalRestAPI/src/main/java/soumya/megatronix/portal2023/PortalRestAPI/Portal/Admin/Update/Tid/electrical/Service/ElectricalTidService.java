package soumya.megatronix.portal2023.PortalRestAPI.Portal.Admin.Update.Tid.electrical.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Model.electrical.ElectriQuest;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Model.electrical.Electrical2;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Repository.electrical.ElectriQuestRepository;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Repository.electrical.Electrical2Repository;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class ElectricalTidService {
    
    //    electrical Repository
    @Autowired
    private ElectriQuestRepository electriQuestRepository;
    @Autowired
    private Electrical2Repository electrical2Repository;

    @Async
    public CompletableFuture<ElectriQuest> checkElectriQeustTid(
            String tid,
            boolean paid
    ) {
        Optional<ElectriQuest> model = electriQuestRepository.findByTid(tid);
        if (model.isEmpty()) {
            throw new RuntimeException("No such TID found");
        } else {
            model.get().setPaid(paid);
            return CompletableFuture.completedFuture(electriQuestRepository.save(model.get()));
        }
    }

    @Async
    public CompletableFuture<Electrical2> checkElectrical2Tid(
            String tid,
            boolean paid
    ) {
        Optional<Electrical2> model = electrical2Repository.findByTid(tid);
        if (model.isEmpty()) {
            throw new RuntimeException("No such TID found");
        } else {
            model.get().setPaid(paid);
            return CompletableFuture.completedFuture(electrical2Repository.save(model.get()));
        }
    }
}
