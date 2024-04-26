package soumya.megatronix.portal2023.PortalRestAPI.Portal.Admin.CRD.gaming.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.Admin.CRD.gaming.Service.GamingCrdService;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("megatronix/paridhi/admin/crd/gaming")
public class GamingCrdController {

    @Autowired
    private GamingCrdService service;

    @Async
    @GetMapping("/bgmi-lan")
    public CompletableFuture<ResponseEntity<?>> bgmiLanCrd () {
        return CompletableFuture.completedFuture(service.getBgmiLanCrd())
                .thenApply(success -> {
                    if (success != null) {
                        return ResponseEntity.ok().body(success);
                    } else {
                        return ResponseEntity.notFound().build();
                    }
                }).exceptionally(ex -> ResponseEntity.badRequest().body(ex.getMessage()));
    }

    @Async
    @GetMapping("/valorant-lan")
    public CompletableFuture<ResponseEntity<?>> valorantLanCrd () {
        return CompletableFuture.completedFuture(service.getValorantLanCrd())
                .thenApply(success -> {
                    if (success != null) {
                        return ResponseEntity.ok().body(success);
                    } else {
                        return ResponseEntity.notFound().build();
                    }
                }).exceptionally(ex -> ResponseEntity.badRequest().body(ex.getMessage()));
    }

    @Async
    @GetMapping("/pes-lan")
    public CompletableFuture<ResponseEntity<?>> pesLanCrd () {
        return CompletableFuture.completedFuture(service.getPesLanCrd())
                .thenApply(success -> {
                    if (success != null) {
                        return ResponseEntity.ok().body(success);
                    } else {
                        return ResponseEntity.notFound().build();
                    }
                }).exceptionally(ex -> ResponseEntity.badRequest().body(ex.getMessage()));
    }

    @Async
    @PutMapping("/bgmi-lan/{tid}/{played}")
    public CompletableFuture<ResponseEntity<?>> updateBgmiLanCrd (
            @PathVariable("tid") String tid,
            @PathVariable("played") Boolean played
    ) {
        return CompletableFuture.completedFuture(service.updateBgmiLanCrd(tid, played))
                .thenApply(success -> {
                    if (success != null) {
                        return ResponseEntity.ok().body(success);
                    } else {
                        return ResponseEntity.notFound().build();
                    }
                }).exceptionally(ex -> ResponseEntity.badRequest().body(ex.getMessage()));
    }

    @Async
    @PutMapping("/valorant-lan/{tid}/{played}")
    public CompletableFuture<ResponseEntity<?>> updateValorantLanCrd (
            @PathVariable("tid") String tid,
            @PathVariable("played") Boolean played
    ) {
        return CompletableFuture.completedFuture(service.updateValorantLanCrd(tid, played))
                .thenApply(success -> {
                    if (success != null) {
                        return ResponseEntity.ok().body(success);
                    } else {
                        return ResponseEntity.notFound().build();
                    }
                }).exceptionally(ex -> ResponseEntity.badRequest().body(ex.getMessage()));
    }

    @Async
    @PutMapping("/pes-lan/{tid}/{played}")
    public CompletableFuture<ResponseEntity<?>> updatePesLanCrd (
            @PathVariable("tid") String tid,
            @PathVariable("played") Boolean played
    ) {
        return CompletableFuture.completedFuture(service.updatePesLanCrd(tid, played))
                .thenApply(success -> {
                    if (success != null) {
                        return ResponseEntity.ok().body(success);
                    } else {
                        return ResponseEntity.notFound().build();
                    }
                }).exceptionally(ex -> ResponseEntity.badRequest().body(ex.getMessage()));
    }
}
