package soumya.megatronix.portal2023.PortalRestAPI.Portal.Admin.CRD.robotics.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.Admin.CRD.robotics.Service.RoboticsCrdService;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("megatronix/paridhi/admin/crd/robotics")
public class RoboticsCrdController {

    @Autowired
    private RoboticsCrdService service;

    @Async
    @GetMapping("/line-trekker")
    public CompletableFuture<ResponseEntity<?>> lineTrekkerCrd () {
        return CompletableFuture.completedFuture(service.getLineTrekkerCrd())
                .thenApply(success -> {
                    if (success != null) {
                        return ResponseEntity.ok().body(success);
                    } else {
                        return ResponseEntity.notFound().build();
                    }
                }).exceptionally(ex -> ResponseEntity.badRequest().body(ex.getMessage()));
    }

    @Async
    @GetMapping("/robo-klassiker")
    public CompletableFuture<ResponseEntity<?>> roboKlassikerCrd () {
        return CompletableFuture.completedFuture(service.getRoboKlassikerCrd())
                .thenApply(success -> {
                    if (success != null) {
                        return ResponseEntity.ok().body(success);
                    } else {
                        return ResponseEntity.notFound().build();
                    }
                }).exceptionally(ex -> ResponseEntity.badRequest().body(ex.getMessage()));
    }

    @Async
    @GetMapping("/triathlon")
    public CompletableFuture<ResponseEntity<?>> triathlonCrd () {
        return CompletableFuture.completedFuture(service.getTriathlonCrd())
                .thenApply(success -> {
                    if (success != null) {
                        return ResponseEntity.ok().body(success);
                    } else {
                        return ResponseEntity.notFound().build();
                    }
                }).exceptionally(ex -> ResponseEntity.badRequest().body(ex.getMessage()));
    }

    @Async
    @GetMapping("/war-8kg")
    public CompletableFuture<ResponseEntity<?>> war8kgCrd () {
        return CompletableFuture.completedFuture(service.getWar8KgCrd())
                .thenApply(success -> {
                    if (success != null) {
                        return ResponseEntity.ok().body(success);
                    } else {
                        return ResponseEntity.notFound().build();
                    }
                }).exceptionally(ex -> ResponseEntity.badRequest().body(ex.getMessage()));
    }

    @Async
    @GetMapping("/war-15kg")
    public CompletableFuture<ResponseEntity<?>> war15KgCrd () {
        return CompletableFuture.completedFuture(service.getWar15KgCrd())
                .thenApply(success -> {
                    if (success != null) {
                        return ResponseEntity.ok().body(success);
                    } else {
                        return ResponseEntity.notFound().build();
                    }
                }).exceptionally(ex -> ResponseEntity.badRequest().body(ex.getMessage()));
    }

    @Async
    @PutMapping("/line-trekker/{tid}/{played}")
    public CompletableFuture<ResponseEntity<?>> updateLineTrekkerCrd (
            @PathVariable("tid") String tid,
            @PathVariable("played") Boolean played
    ) {
        return CompletableFuture.completedFuture(service.updateLineTrekkerCrd(tid, played))
                .thenApply(success -> {
                    if (success != null) {
                        return ResponseEntity.ok().body(success);
                    } else {
                        return ResponseEntity.notFound().build();
                    }
                }).exceptionally(ex -> ResponseEntity.badRequest().body(ex.getMessage()));
    }

    @Async
    @PutMapping("/robo-klassiker/{tid}/{played}")
    public CompletableFuture<ResponseEntity<?>> updateRoboKlassikerCrd (
            @PathVariable("tid") String tid,
            @PathVariable("played") Boolean played
    ) {
        return CompletableFuture.completedFuture(service.updateRoboKlassikerCrd(tid, played))
                .thenApply(success -> {
                    if (success != null) {
                        return ResponseEntity.ok().body(success);
                    } else {
                        return ResponseEntity.notFound().build();
                    }
                }).exceptionally(ex -> ResponseEntity.badRequest().body(ex.getMessage()));
    }

    @Async
    @PutMapping("/triathlon/{tid}/{played}")
    public CompletableFuture<ResponseEntity<?>> updateTriathlonCrd (
            @PathVariable("tid") String tid,
            @PathVariable("played") Boolean played
    ) {
        return CompletableFuture.completedFuture(service.updateTriathlonCrd(tid, played))
                .thenApply(success -> {
                    if (success != null) {
                        return ResponseEntity.ok().body(success);
                    } else {
                        return ResponseEntity.notFound().build();
                    }
                }).exceptionally(ex -> ResponseEntity.badRequest().body(ex.getMessage()));
    }

    @Async
    @PutMapping("/war-8kg/{tid}/{played}")
    public CompletableFuture<ResponseEntity<?>> updateWar8KgCrd (
            @PathVariable("tid") String tid,
            @PathVariable("played") Boolean played
    ) {
        return CompletableFuture.completedFuture(service.updateWar8KgCrd(tid, played))
                .thenApply(success -> {
                    if (success != null) {
                        return ResponseEntity.ok().body(success);
                    } else {
                        return ResponseEntity.notFound().build();
                    }
                }).exceptionally(ex -> ResponseEntity.badRequest().body(ex.getMessage()));
    }

    @Async
    @PutMapping("/war-15kg/{tid}/{played}")
    public CompletableFuture<ResponseEntity<?>> updateWar15KgCrd (
            @PathVariable("tid") String tid,
            @PathVariable("played") Boolean played
    ) {
        return CompletableFuture.completedFuture(service.updateWar15KgCrd(tid, played))
                .thenApply(success -> {
                    if (success != null) {
                        return ResponseEntity.ok().body(success);
                    } else {
                        return ResponseEntity.notFound().build();
                    }
                }).exceptionally(ex -> ResponseEntity.badRequest().body(ex.getMessage()));
    }
}
