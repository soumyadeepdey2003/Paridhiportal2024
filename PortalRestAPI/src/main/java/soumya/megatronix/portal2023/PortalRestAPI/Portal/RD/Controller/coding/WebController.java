package soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Controller.coding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.*;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Model.coding.WebModel;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Repository.coding.WebRepository;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Service.coding.WebService;

import java.util.concurrent.CompletableFuture;

@RestController
@EnableAsync
@RequestMapping("/paridhi/event/coding")
public class WebController {

    @Autowired
    private AsyncTaskExecutor asyncTaskExecutor;

    @Autowired
    private WebService service;

    @GetMapping("/web")
    @Async
    public CompletableFuture<ResponseEntity<WebModel>> webForm() {
        CompletableFuture<WebModel> future = CompletableFuture.supplyAsync(() -> {
            // Here you can perform any necessary processing to prepare your data
            WebModel user = new WebModel();
            return user;
        }, asyncTaskExecutor);
        return future.thenApply(result -> ResponseEntity.ok().body(result))
                .exceptionally(ex-> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null));
    }

    @PostMapping("/web")
    @Async
    public CompletableFuture<ResponseEntity<?>> webMember(@RequestBody WebModel member) {
        return service.webRd(member).thenApply(savedMember -> {
            if (savedMember != null && savedMember.getTid() != null) {
                return ResponseEntity.ok().body(savedMember.getTid());
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        }).exceptionally(ex -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null));
    }

    @GetMapping("/web/{gid}")
    @Async
<<<<<<< HEAD
    public CompletableFuture<ResponseEntity<?>> validateWeb(@RequestParam("gid") String gid) {
        return service.checkgid(gid).thenApply(savedMember -> {
=======
    public CompletableFuture<ResponseEntity<?>> validateWeb(@PathVariable("gid") String gid) {
        return service.chackgid(gid).thenApply(savedMember -> {
>>>>>>> 4c2fc980c5f75e44f7f2cf08efc591bdb1ab963b
            if (savedMember != null && savedMember.getGid() != null) {
                return ResponseEntity.ok().body(savedMember.getName());
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        }).exceptionally(ex -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage()));
    }
}
