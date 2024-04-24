package soumya.megatronix.portal2023.PortalRestAPI.Portal.Admin.Update.Tid.gaming.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Model.gaming.BgmiLan;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Model.gaming.ValorantLan;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Model.gaming.PesLan;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Repository.gaming.BgmiLanRepository;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Repository.gaming.ValorantLanRepository;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Repository.gaming.PesLanRepository;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class GamingTidService {
    
    //    gaming Repository
    @Autowired
    private BgmiLanRepository gaming1Repository;
    @Autowired
    private ValorantLanRepository gaming2Repository;
    @Autowired
    private PesLanRepository gaming3Repository;

    @Async
    public CompletableFuture<BgmiLan> checkBgmiLanTid(
            String tid,
            boolean paid
    ) {
        Optional<BgmiLan> model = gaming1Repository.findByTid(tid);
        if (model.isEmpty()) {
            throw new RuntimeException("No such TID found");
        } else {
            model.get().setPaid(paid);
            return CompletableFuture.completedFuture(gaming1Repository.save(model.get()));
        }
    }

    @Async
    public CompletableFuture<ValorantLan> checkValorantLanTid(
            String tid,
            boolean paid
    ) {
        Optional<ValorantLan> model = gaming2Repository.findByTid(tid);
        if (model.isEmpty()) {
            throw new RuntimeException("No such TID found");
        } else {
            model.get().setPaid(paid);
            return CompletableFuture.completedFuture(gaming2Repository.save(model.get()));
        }
    }

    @Async
    public CompletableFuture<PesLan> checkPesLanTid(
            String tid,
            boolean paid
    ) {
        Optional<PesLan> model = gaming3Repository.findByTid(tid);
        if (model.isEmpty()) {
            throw new RuntimeException("No such TID found");
        } else {
            model.get().setPaid(paid);
            return CompletableFuture.completedFuture(gaming3Repository.save(model.get()));
        }
    }
}
