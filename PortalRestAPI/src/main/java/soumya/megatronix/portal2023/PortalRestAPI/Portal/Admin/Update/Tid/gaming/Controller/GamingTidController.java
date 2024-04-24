package soumya.megatronix.portal2023.PortalRestAPI.Portal.Admin.Update.Tid.gaming.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.Admin.Update.Tid.gaming.Service.GamingTidService;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/admin/updateTid/gaming")
public class
GamingTidController {

    @Autowired
    private GamingTidService service;

    @Async
    @PutMapping("/bgmi/{tid}/{paid}")
    public CompletableFuture<ResponseEntity<?>> checkBgmiLanTid (
            @PathVariable("tid") String tid,
            @PathVariable("paid") Boolean paid
    ) {
        return CompletableFuture.completedFuture(service.checkBgmiLanTid(tid, paid))
                .thenApply(savedMember -> {
                    if (savedMember != null) {
                        return ResponseEntity.ok().body(savedMember);
                    } else {
                        return ResponseEntity.notFound().build();
                    }
                }).exceptionally(ex -> ResponseEntity.badRequest().body(ex.getMessage()));
    }

    @Async
    @PutMapping("/valorant/{tid}/{paid}")
    public CompletableFuture<ResponseEntity<?>> checkValorantLanTid(
            @PathVariable("tid") String tid,
            @PathVariable("paid") Boolean paid
    ) {
        return CompletableFuture.completedFuture(service.checkValorantLanTid(tid, paid))
                .thenApply(savedMember -> {
                    if (savedMember != null) {
                        return ResponseEntity.ok().body(savedMember);
                    } else {
                        return ResponseEntity.notFound().build();
                    }
                }).exceptionally(ex -> ResponseEntity.badRequest().body(ex.getMessage()));
    }

    @Async
    @PutMapping("/pes/{tid}/{paid}")
    public CompletableFuture<ResponseEntity<?>> checkPesLanTid (
            @PathVariable("tid") String tid,
            @PathVariable("paid") Boolean paid
    ) {
        return CompletableFuture.completedFuture(service.checkPesLanTid(tid, paid))
                .thenApply(savedMember -> {
                    if (savedMember != null) {
                        return ResponseEntity.ok().body(savedMember);
                    } else {
                        return ResponseEntity.notFound().build();
                    }
                }).exceptionally(ex -> ResponseEntity.badRequest().body(ex.getMessage()));
    }

}
