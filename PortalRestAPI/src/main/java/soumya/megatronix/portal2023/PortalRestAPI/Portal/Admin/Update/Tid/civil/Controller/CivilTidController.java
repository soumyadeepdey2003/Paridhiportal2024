package soumya.megatronix.portal2023.PortalRestAPI.Portal.Admin.Update.Tid.civil.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.Admin.Update.Tid.civil.Service.CivilTidService;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/admin/updateTid/civil")
public class CivilTidController {

    @Autowired
    private CivilTidService service;

    @Async
    @PutMapping("/setu-bandhan/{tid}/{paid}")
    public CompletableFuture<ResponseEntity<?>> checkSetuBandhanTid(
            @PathVariable("tid") String tid,
            @PathVariable("paid") Boolean paid
    ) {
        return CompletableFuture.completedFuture(service.checkSetuBandhanTid(tid, paid))
                .thenApply(savedMember -> {
                    if (savedMember != null) {
                        return ResponseEntity.ok().body(savedMember);
                    } else {
                        return ResponseEntity.notFound().build();
                    }
                }).exceptionally(ex -> ResponseEntity.badRequest().body(ex.getMessage()));
    }

    @Async
    @PutMapping("/track-o-treausre/{tid}/{paid}")
    public CompletableFuture<ResponseEntity<?>> checkToTTid(
            @PathVariable("tid") String tid,
            @PathVariable("paid") Boolean paid
    ) {
        return CompletableFuture.completedFuture(service.checkToTTid(tid, paid))
                .thenApply(savedMember -> {
                    if (savedMember != null) {
                        return ResponseEntity.ok().body(savedMember);
                    } else {
                        return ResponseEntity.notFound().build();
                    }
                }).exceptionally(ex -> ResponseEntity.badRequest().body(ex.getMessage()));
    }

    @Async
    @PutMapping("/mega-arch/{tid}/{paid}")
    public CompletableFuture<ResponseEntity<?>> checkMegaArchTid(
            @PathVariable("tid") String tid,
            @PathVariable("paid") Boolean paid
    ) {
        return CompletableFuture.completedFuture(service.checkMegaArchTid(tid, paid))
                .thenApply(savedMember -> {
                    if (savedMember != null) {
                        return ResponseEntity.ok().body(savedMember);
                    } else {
                        return ResponseEntity.notFound().build();
                    }
                }).exceptionally(ex -> ResponseEntity.badRequest().body(ex.getMessage()));
    }

}
