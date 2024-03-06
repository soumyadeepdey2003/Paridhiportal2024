package soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Controller.coding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.*;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Model.coding.Cp1styearModel;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Model.coding.CpAllyearModel;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Repository.coding.CpAllyearRepository;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Service.coding.CpAllyearService;

import java.util.concurrent.CompletableFuture;

@RestController
@EnableAsync
@RequestMapping("/paridhi/event/coding")
public class CpAllyearController {

    @Qualifier("asyncExecutor")
    @Autowired
    private AsyncTaskExecutor asyncTaskExecutor;
    @Autowired
    private CpAllyearService service;

    @GetMapping("/allyearcp")
    @Async
    public CompletableFuture<ResponseEntity<CpAllyearModel>> CpAllyearForm() {
        CompletableFuture<CpAllyearModel> future = CompletableFuture.supplyAsync(() -> {
            // Here you can perform any necessary processing to prepare your data
            CpAllyearModel user = new CpAllyearModel();
            return user;
        }, asyncTaskExecutor);
        return future.thenApply(result -> ResponseEntity.ok().body(result))
                .exceptionally(ex-> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null));
    }

    @PostMapping("/allyearcp")
    @Async
    public CompletableFuture<ResponseEntity<?>> CpAllyearMember(@RequestBody CpAllyearModel member) {
        return service.CpAllyearRd(member).thenApply(savedMember -> {
            if (savedMember != null && savedMember.getTid() != null) {
                return ResponseEntity.ok().body(savedMember.getTid());
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        }).exceptionally(ex -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage()));
    }

    @GetMapping("/allyearcp/{gid}")
    @Async
    public CompletableFuture<ResponseEntity<?>> validateCpAllyear(@PathVariable("gid") String gid) {
        return service.checkgid(gid).thenApply(savedMember -> {
            if (savedMember != null && savedMember.getGid() != null) {
                return ResponseEntity.ok().body(savedMember.getName());
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        }).exceptionally(ex -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null));
    }

}