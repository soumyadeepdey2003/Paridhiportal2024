package soumya.megatronix.portal2023.PortalRestAPI.Portal.Admin.Update.Tid.civil.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Model.civil.MegaArchModel;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Model.civil.SetuBandhanModel;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Model.civil.TrackOTeasureModel;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Repository.civil.MegaArchRepository;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Repository.civil.SetuBandhanRepository;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Repository.civil.TrackOTeasureRepository;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class CivilTidService {

    //    civil Repository
    @Autowired
    private SetuBandhanRepository setuBandhanRepository;
    @Autowired
    private TrackOTeasureRepository trackOTeasureRepository;
    @Autowired
    private MegaArchRepository megaArchRepository;


    @Async
    public CompletableFuture<SetuBandhanModel> checkSetuBandhanTid(
            String tid,
            boolean paid
    ) {
        Optional<SetuBandhanModel> model = setuBandhanRepository.findByTid(tid);
        if (model.isEmpty()) {
            throw new RuntimeException("No such TID found");
        } else {
            model.get().setPaid(paid);
            return CompletableFuture.completedFuture(setuBandhanRepository.save(model.get()));
        }
    }

    @Async
    public CompletableFuture<TrackOTeasureModel> checkToTTid(
            String tid,
            boolean paid
    ) {
        Optional<TrackOTeasureModel> model = trackOTeasureRepository.findByTid(tid);
        if (model.isEmpty()) {
            throw new RuntimeException("No such TID found");
        } else {
            model.get().setPaid(paid);
            return CompletableFuture.completedFuture(trackOTeasureRepository.save(model.get()));
        }
    }

    @Async
    public CompletableFuture<MegaArchModel> checkMegaArchTid(
            String tid,
            boolean paid
    ) {
        Optional<MegaArchModel> model = megaArchRepository.findByTid(tid);
        if (model.isEmpty()) {
            throw new RuntimeException("No such TID found");
        } else {
            model.get().setPaid(paid);
            return CompletableFuture.completedFuture(megaArchRepository.save(model.get()));
        }
    }
}