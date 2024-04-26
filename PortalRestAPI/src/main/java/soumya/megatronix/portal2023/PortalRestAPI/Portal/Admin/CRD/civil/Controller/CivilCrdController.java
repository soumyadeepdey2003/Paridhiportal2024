package soumya.megatronix.portal2023.PortalRestAPI.Portal.Admin.CRD.civil.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.Admin.CRD.civil.Service.CivilCrdService;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Model.civil.MegaArchModel;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Model.civil.SetuBandhanModel;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("megatronix/paridhi/admin/crd/civil")
public class CivilCrdController {

    @Autowired
    private CivilCrdService service;

    @Async
    @GetMapping("/setu-bandhan")
    public CompletableFuture<ResponseEntity<?>> setuBandhanCrd () {
        return CompletableFuture.completedFuture(service.getSetuBandhanCRD())
                .thenApply(success -> {
                    if (success != null) {
                        return ResponseEntity.ok().body(success);
                    } else {
                        return ResponseEntity.notFound().build();
                    }
                }).exceptionally(ex -> ResponseEntity.badRequest().body(ex.getMessage()));
    }

    @Async
    @GetMapping("/tot")
    public CompletableFuture<ResponseEntity<?>> totCrd () {
        return CompletableFuture.completedFuture(service.getToTCRD())
                .thenApply(success -> {
                    if (success != null) {
                        return ResponseEntity.ok().body(success);
                    } else {
                        return ResponseEntity.notFound().build();
                    }
                }).exceptionally(ex -> ResponseEntity.badRequest().body(ex.getMessage()));
    }

    @Async
    @GetMapping("/mega-arch")
    public CompletableFuture<ResponseEntity<?>> megaArchCrd () {
        return CompletableFuture.completedFuture(service.getMegaArchCRD())
                .thenApply(success -> {
                    if (success != null) {
                        return ResponseEntity.ok().body(success);
                    } else {
                        return ResponseEntity.notFound().build();
                    }
                }).exceptionally(ex -> ResponseEntity.badRequest().body(ex.getMessage()));
    }

    @Async
    @PutMapping("/setu-bandhan/{tid}/{played}")
    public CompletableFuture<ResponseEntity<?>> updateSetuBandhanCrd (
            @PathVariable("tid") String tid,
            @PathVariable("played") Boolean played
    ) {
        return CompletableFuture.completedFuture(service.updateSetuBandhanCRD(tid, played))
                .thenApply(success -> {
                    if (success != null) {
                        return ResponseEntity.ok().body(success);
                    } else {
                        return ResponseEntity.notFound().build();
                    }
                }).exceptionally(ex -> ResponseEntity.badRequest().body(ex.getMessage()));
    }

    @Async
    @PutMapping("/tot/{tid}/{played}")
    public CompletableFuture<?> updateToTCrd (
            @PathVariable("tid") String tid,
            @PathVariable("played") Boolean played
    ) {
        return CompletableFuture.completedFuture(service.updateToTCRD(tid, played))
                .thenApply(success -> {
                    if (success != null) {
                        return ResponseEntity.ok().body(success);
                    } else {
                        return ResponseEntity.notFound().build();
                    }
                }).exceptionally(ex -> ResponseEntity.badRequest().body(ex.getMessage()));
    }

    @Async
    @PutMapping("/mega-arch/{tid}/{played}")
    public CompletableFuture<?> updateMegaArchCrd (
            @PathVariable("tid") String tid,
            @PathVariable("played") Boolean played
    ) {
        return CompletableFuture.completedFuture(service.updateMegaArchCRD(tid, played))
                .thenApply(success -> {
                    if (success != null) {
                        return ResponseEntity.ok().body(success);
                    } else {
                        return ResponseEntity.notFound().build();
                    }
                }).exceptionally(ex -> ResponseEntity.badRequest().body(ex.getMessage()));
    }
}
