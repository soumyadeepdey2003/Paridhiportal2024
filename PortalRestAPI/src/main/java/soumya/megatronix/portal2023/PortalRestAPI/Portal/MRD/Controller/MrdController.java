package soumya.megatronix.portal2023.PortalRestAPI.Portal.MRD.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.*;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.MRD.Model.MrdModel;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.MRD.Repository.MrdRepository;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.MRD.Service.MrdService;

import java.util.concurrent.CompletableFuture;

@RestController
@EnableAsync
@RequestMapping("/paridhi")
public class MrdController {

    @Autowired
    private MrdService service;

    @Autowired
    private MrdRepository mrdRepository;

    @Autowired
    private AsyncTaskExecutor asyncTaskExecutor;

    @GetMapping("/registration")
    @Async
    public CompletableFuture<ResponseEntity<MrdModel>> registrationForm() {
        CompletableFuture<MrdModel> future = CompletableFuture.supplyAsync(() -> {
            // Here you can perform any necessary processing to prepare your data
            MrdModel user = new MrdModel();
            return user;
        }, asyncTaskExecutor);

        return future.thenApply(result -> ResponseEntity.ok().body(result))
                .exceptionally(ex -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null));
    }

    @PostMapping("/registration")
    @Async
    public CompletableFuture<ResponseEntity<?>> registerMember(@RequestBody MrdModel member) {

        return service.registerMember(member).thenApply(savedMember -> {
                    if (savedMember != null && savedMember.getGid() != null) {
                        return ResponseEntity.ok().body(savedMember.getGid());
                    } else {
                        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
                    }
                }).exceptionally(ex -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null));
    }




}
