package soumya.megatronix.portal2023.PortalRestAPI.Portal.Admin.Update.Tid.coding.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Model.coding.CodeQuestModel;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Model.coding.CodezenModel;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Model.coding.WebMindsModel;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Repository.coding.CodeQuestRepository;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Repository.coding.CodezenRepository;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Repository.coding.WebMindsRepository;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class CodingTidService {

    //    coding Repository
    @Autowired
    private CodezenRepository codezenRepository;
    @Autowired
    private CodeQuestRepository codeQuestRepository;
    @Autowired
    private WebMindsRepository webMindsRepository;


    @Async
    public CompletableFuture<CodezenModel> checkCodezenTid(
            String tid,
            boolean paid
    ) {
        Optional<CodezenModel> model = codezenRepository.findByTid(tid);
        if (model.isEmpty()) {
            throw new RuntimeException("No such TID found");
        } else {
            model.get().setPaid(paid);
            return CompletableFuture.completedFuture(codezenRepository.save(model.get()));
        }
    }

    @Async
    public CompletableFuture<CodeQuestModel> checkCodeQuestTid(
            String tid,
            boolean paid
    ) {
        Optional<CodeQuestModel> model = codeQuestRepository.findByTid(tid);
        if (model.isEmpty()) {
            throw new RuntimeException("No such TID found");
        } else {
            model.get().setPaid(paid);
            return CompletableFuture.completedFuture(codeQuestRepository.save(model.get()));
        }
    }

    @Async
    public CompletableFuture<WebMindsModel> checkWebMindsTid(
            String tid,
            boolean paid
    ) {
        Optional<WebMindsModel> model = webMindsRepository.findByTid(tid);
        if (model.isEmpty()) {
            throw new RuntimeException("No such TID found");
        } else {
            model.get().setPaid(paid);
            return CompletableFuture.completedFuture(webMindsRepository.save(model.get()));
        }
    }
}