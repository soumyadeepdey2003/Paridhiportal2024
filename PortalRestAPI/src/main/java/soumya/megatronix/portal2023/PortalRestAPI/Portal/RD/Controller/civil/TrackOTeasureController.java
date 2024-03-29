package soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Controller.civil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.*;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Model.civil.TrackOTeasureModel;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Service.civil.TrackOTeasureService;

import java.util.concurrent.CompletableFuture;

@RestController
@EnableAsync
@RequestMapping("/megatronix/paridhi/event/civil")
public class TrackOTeasureController {

    @Qualifier("asyncExecutor")
    @Autowired
    private AsyncTaskExecutor asyncTaskExecutor;

    @Autowired
    private TrackOTeasureService service;

    @GetMapping("/tot")
    @Async
    public CompletableFuture<ResponseEntity<TrackOTeasureModel>> totForm() {
        CompletableFuture<TrackOTeasureModel> future = CompletableFuture.supplyAsync(() -> {
            // Here you can perform any necessary processing to prepare your data
            TrackOTeasureModel user = new TrackOTeasureModel();
            return user;
        }, asyncTaskExecutor);
        return future.thenApply(result -> ResponseEntity.ok().body(result))
                .exceptionally(ex-> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null));
    }

    @PostMapping("/tot")
    @Async
    public CompletableFuture<ResponseEntity<?>> totMember(@RequestBody TrackOTeasureModel member) {
        return service.trackOTreasureRd(member).thenApply(savedMember -> {
            if (savedMember != null && savedMember.getTid() != null) {
                return ResponseEntity.ok().body(savedMember.getTid());
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        }).exceptionally(ex -> {
            // Log the exception or handle it in some other way
            System.err.println("An error occurred: " + ex.getMessage());
            // Return a default value
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(ex.getMessage());
        });
    }

    @GetMapping("/tot/{gid}")
    @Async
    public CompletableFuture<ResponseEntity<?>> validateToT(@PathVariable("gid") String gid) {
        return service.checkgid(gid).thenApply(savedMember -> {
            if (savedMember != null && savedMember.getGid() != null) {
                return ResponseEntity.ok().body(savedMember.getName());
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        }).exceptionally(ex -> {
            // Log the exception or handle it in some other way
            System.err.println("An error occurred: " + ex.getMessage());
            // Return a default value
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(ex.getMessage());
        });
    }
}