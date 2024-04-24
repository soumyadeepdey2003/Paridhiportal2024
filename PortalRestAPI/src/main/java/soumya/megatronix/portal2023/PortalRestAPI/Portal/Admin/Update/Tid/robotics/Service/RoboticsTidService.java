package soumya.megatronix.portal2023.PortalRestAPI.Portal.Admin.Update.Tid.robotics.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Model.robotics.*;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Repository.robotics.*;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class RoboticsTidService {
    
    //    robotics
    @Autowired
    private LineTrekkerRepository lineTrekkerRepository;
    @Autowired
    private RoboKlassikerRepository roboKlassikerRepository;
    @Autowired
    private TriathlonRepository triathlonRepository;
    @Autowired
    private War8KgRepository war8KgRepository;
    @Autowired
    private War15KgRepository war15KgRepository;

    @Async
    public CompletableFuture<LineTrekkerModel> checkLineTrekkerTid(
            String tid,
            boolean paid
    ) {
        Optional<LineTrekkerModel> model = lineTrekkerRepository.findByTid(tid);
        if (model.isEmpty()) {
            throw new RuntimeException("No such TID found");
        } else {
            model.get().setPaid(paid);
            return CompletableFuture.completedFuture(lineTrekkerRepository.save(model.get()));
        }
    }

    @Async
    public CompletableFuture<RoboKlassikerModel> checkRoboKlassikerTid(
            String tid,
            boolean paid
    ) {
        Optional<RoboKlassikerModel> model = roboKlassikerRepository.findByTid(tid);
        if (model.isEmpty()) {
            throw new RuntimeException("No such TID found");
        } else {
            model.get().setPaid(paid);
            return CompletableFuture.completedFuture(roboKlassikerRepository.save(model.get()));
        }
    }

    @Async
    public CompletableFuture<TriathlonModel> checkTriathlonTid(
            String tid,
            boolean paid
    ) {
        Optional<TriathlonModel> model = triathlonRepository.findByTid(tid);
        if (model.isEmpty()) {
            throw new RuntimeException("No such TID found");
        } else {
            model.get().setPaid(paid);
            return CompletableFuture.completedFuture(triathlonRepository.save(model.get()));
        }
    }

    @Async
    public CompletableFuture<War8KgModel> checkWar8kgTid(
            String tid,
            boolean paid
    ) {
        Optional<War8KgModel> model = war8KgRepository.findByTid(tid);
        if (model.isEmpty()) {
            throw new RuntimeException("No such TID found");
        } else {
            model.get().setPaid(paid);
            return CompletableFuture.completedFuture(war8KgRepository.save(model.get()));
        }
    }

    @Async
    public CompletableFuture<War15KgModel> checkWar15KgTid(
            String tid,
            boolean paid
    ) {
        Optional<War15KgModel> model = war15KgRepository.findByTid(tid);
        if (model.isEmpty()) {
            throw new RuntimeException("No such TID found");
        } else {
            model.get().setPaid(paid);
            return CompletableFuture.completedFuture(war15KgRepository.save(model.get()));
        }
    }
}
