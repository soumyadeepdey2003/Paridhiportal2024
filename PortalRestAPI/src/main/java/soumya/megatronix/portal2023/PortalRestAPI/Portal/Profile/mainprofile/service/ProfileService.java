package soumya.megatronix.portal2023.PortalRestAPI.Portal.Profile.mainprofile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.MRD.Model.MrdModel;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.MRD.Repository.MrdRepository;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.Profile.mainprofile.model.profileModel;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.Profile.mainprofile.repository.profilerepository;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Model.civil.*;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Model.coding.*;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Model.electrical.*;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Model.gaming.*;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Model.robotics.*;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Service.civil.*;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Service.coding.*;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Service.electrical.*;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Service.gaming.*;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Service.robotics.*;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
@Async
public class ProfileService {
    @Autowired
    private profilerepository profileRepository;

    @Autowired
    private MrdRepository mrdRepository;

    @Autowired
    private MegaArchService megaArchService;
    @Autowired
    private SetuBandhanService setuBandhanService;
    @Autowired
    private TrackOTeasureService trackoteasureService;

    @Autowired
    private Cp1styearService cp1styearService;
    @Autowired
    private CpAllyearService cpAllyearService;
    @Autowired
    private WebService webService;

    @Autowired
    private Electrical1Service electrical1Service;
    @Autowired
    private Electrical2Service electrical2Service;

    @Autowired
    private Gaming_1Service gaming1Service;
    @Autowired
    private Gaming_2Service gaming2Service;
    @Autowired
    private Gaming_3Service gaming3Service;

    @Autowired
    private LFRService lfrService;
    @Autowired
    private RoboRaceService roboRaceService;
    @Autowired
    private RoboSoccerService roboSoccerService;
    @Autowired
    private War8KgService roboWar8kgService;
    @Autowired
    private War15KgService roboWar15kgService;

    @Async
    public CompletableFuture<profileModel> findProfile(String gid)throws Exception{
        Optional<MrdModel> mrdModel = mrdRepository.findByGid(gid);
        if(!mrdModel.isPresent()){
            throw new Exception("Invalid gid");
        }
        profileModel profile=profileRepository.findByGid(gid);
        if(profile==null){
            CompletableFuture<profileModel> profilenew= addtoprofile(gid);
            return CompletableFuture.completedFuture(profileRepository.save(profilenew.get()));
        }
        else {
            CompletableFuture<profileModel> newProfile = addtoprofile(gid);
            profile.setMegaArchTid(newProfile.get().getMegaArchTid());
            profile.setSetuBandhanTid(newProfile.get().getSetuBandhanTid());
            profile.setTrackoteasureTid(newProfile.get().getTrackoteasureTid());
            profile.setCp1styearTid(newProfile.get().getCp1styearTid());
            profile.setCpAllyearTid(newProfile.get().getCpAllyearTid());
            profile.setWebTid(newProfile.get().getWebTid());
            profile.setElectrical1Tid(newProfile.get().getElectrical1Tid());
            profile.setElectrical1Tid(newProfile.get().getElectrical2Tid());
            profile.setGaming1Tid(newProfile.get().getGaming1Tid());
            profile.setGaming2Tid(newProfile.get().getGaming2Tid());
            profile.setGaming3Tid(newProfile.get().getGaming3Tid());
            profile.setLFRTid(newProfile.get().getLFRTid());
            profile.setRoboraceTid(newProfile.get().getRoboraceTid());
            profile.setRoboSoccerTid(newProfile.get().getRoboSoccerTid());
            profile.setRoboWar8kgTid(newProfile.get().getRoboWar8kgTid());
            profile.setRoboWar15kgTid(newProfile.get().getRoboWar15kgTid());
            profileRepository.save(profile);
            return CompletableFuture.completedFuture(profile);
        }
    }

    @Async
    public CompletableFuture<profileModel> addtoprofile(String gid){
        Optional<MrdModel> optionalMrdModel = mrdRepository.findByGid(gid);

        if(optionalMrdModel.isPresent()) {
            MrdModel mrdModel = optionalMrdModel.get();
            profileModel profile=new profileModel();

            //mrdmodel
            profile.setName(mrdModel.getName());
            profile.setCollege(mrdModel.getCollege());
            profile.setYear(mrdModel.getYear());
            profile.setDepartment(mrdModel.getDepartment());
            profile.setRoll(mrdModel.getRoll());
            profile.setEmail(mrdModel.getEmail());
            profile.setPhoneNumber(mrdModel.getPhoneNumber());
            profile.setGid(mrdModel.getGid());

            //civil
            Optional<MegaArchModel> megaArchServiceOptional = megaArchService.findByGid(gid);
            if(megaArchServiceOptional.isPresent()) {
                profile.setMegaArchTid(megaArchServiceOptional.get().getTid());
            } else {
                profile.setMegaArchTid(null);
            }

            Optional<SetuBandhanModel> setuBandhanServiceOptional = setuBandhanService.findByGid(gid);
            if(setuBandhanServiceOptional.isPresent()) {
                profile.setSetuBandhanTid(setuBandhanServiceOptional.get().getTid());
            } else {
                profile.setSetuBandhanTid(null);
            }

            Optional<TrackOTeasureModel> trackoteasureServiceOptional = trackoteasureService.findByGid(gid);
            if(trackoteasureServiceOptional.isPresent()) {
                profile.setTrackoteasureTid(trackoteasureServiceOptional.get().getTid());
            } else {
                profile.setTrackoteasureTid(null);
            }

            //coding
            Optional<Cp1styearModel> cp1styearServiceOptional = cp1styearService.findByGid(gid);
            if(cp1styearServiceOptional.isPresent()) {
                profile.setCp1styearTid(cp1styearServiceOptional.get().getTid());
            } else {
                profile.setCp1styearTid(null);
            }

            Optional<CpAllyearModel> cpAllyearServiceOptional = cpAllyearService.findByGid(gid);
            if(cpAllyearServiceOptional.isPresent()) {
                profile.setCpAllyearTid(cpAllyearServiceOptional.get().getTid());
            } else {
                profile.setCpAllyearTid(null);
            }

            Optional<WebModel> webServiceOptional = webService.findByGid(gid);
            if(webServiceOptional.isPresent()) {
                profile.setWebTid(webServiceOptional.get().getTid());
            } else {
                profile.setWebTid(null);
            }

            //electrical
            Optional<Electrical1> electrical1ServiceOptional = electrical1Service.findByGid(gid);
            if(electrical1ServiceOptional.isPresent()) {
                profile.setElectrical1Tid(electrical1ServiceOptional.get().getTid());
            } else {
                profile.setElectrical1Tid(null);
            }

            Optional<Electrical2> electrical2ServiceOptional = electrical2Service.findByGid(gid);
            if(electrical2ServiceOptional.isPresent()) {
                profile.setElectrical2Tid(electrical2ServiceOptional.get().getTid());
            } else {
                profile.setElectrical2Tid(null);
            }

            //gaming
            Optional<Gaming_1> gaming1ServiceOptional = gaming1Service.findByGid(gid);
            if(gaming1ServiceOptional.isPresent()) {
                profile.setGaming1Tid(gaming1ServiceOptional.get().getTid());
            } else {
                profile.setGaming1Tid(null);
            }

            Optional<Gaming_2> gaming2ServiceOptional = gaming2Service.findByGid(gid);
            if(gaming2ServiceOptional.isPresent()) {
                profile.setGaming2Tid(gaming2ServiceOptional.get().getTid());
            } else {
                profile.setGaming2Tid(null);
            }

            Optional<Gaming_3> gaming3ServiceOptional = gaming3Service.findByGid(gid);
            if(gaming3ServiceOptional.isPresent()) {
                profile.setGaming3Tid(gaming3ServiceOptional.get().getTid());
            } else {
                profile.setGaming3Tid(null);
            }

            //robotics
            Optional<LFRModel> lfrServiceOptional = lfrService.findByGid(gid);
            if(lfrServiceOptional.isPresent()) {
                profile.setLFRTid(lfrServiceOptional.get().getTid());
            } else {
                profile.setLFRTid(null);
            }

            Optional<RoboRaceModel> roboRaceServiceOptional = roboRaceService.findByGid(gid);
            if (roboRaceServiceOptional.isPresent()) {
                profile.setRoboraceTid(roboRaceServiceOptional.get().getTid());
            } else {
                profile.setRoboraceTid(null);
            }

            Optional<RoboSoccerModel> roboSoccerServiceOptional = roboSoccerService.findByGid(gid);
            if (roboSoccerServiceOptional.isPresent()) {
                profile.setRoboSoccerTid(roboSoccerServiceOptional.get().getTid());
            } else {
                profile.setRoboSoccerTid(null);
            }

            Optional<War8KgModel> roboWar8kgServiceOptional = roboWar8kgService.findByGid(gid);
            if (roboWar8kgServiceOptional.isPresent()) {
                profile.setRoboWar8kgTid(roboWar8kgServiceOptional.get().getTid());
            } else {
                profile.setRoboWar8kgTid(null);
            }

            Optional<War15KgModel> roboWar15kgServiceOptional = roboWar15kgService.findByGid(gid);
            if (roboWar15kgServiceOptional.isPresent()) {
                profile.setRoboWar15kgTid(roboWar15kgServiceOptional.get().getTid());
            } else {
                profile.setRoboWar15kgTid(null);
            }

            return CompletableFuture.completedFuture(profile);
        }
        else
            return null;
    }
}