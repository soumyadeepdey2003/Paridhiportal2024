package soumya.megatronix.portal2023.PortalRestAPI.Portal.Profile.mainprofile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.MRD.Model.MrdModel;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.MRD.Repository.MrdRepository;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.Profile.mainprofile.model.profileModel;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.Profile.mainprofile.repository.profilerepository;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Repository.civil.MegaArchRepository;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Repository.civil.SetuBandhanRepository;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Repository.civil.TrackOTeasureRepository;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Repository.coding.Cp1styearRepository;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Repository.coding.CpAllyearRepository;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Repository.coding.WebRepository;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Repository.electrical.Electrical1Repository;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Repository.electrical.Electrical2Repository;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Repository.gaming.Gaming_1Repository;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Repository.gaming.Gaming_2Repository;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Repository.gaming.Gaming_3Repository;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Repository.robotics.*;

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
    private MegaArchRepository megaArchRepository;
    @Autowired
    private SetuBandhanRepository setuBandhanRepository;
    @Autowired
    private TrackOTeasureRepository trackoteasureRepository;

    @Autowired
    private Cp1styearRepository cp1styearRepository;
    @Autowired
    private CpAllyearRepository cpAllyearRepository;
    @Autowired
    private WebRepository webRepository;

    @Autowired
    private Electrical1Repository electrical1Repository;
    @Autowired
    private Electrical2Repository electrical2Repository;

    @Autowired
    private Gaming_1Repository gaming1Repository;
    @Autowired
    private Gaming_2Repository gaming2Repository;
    @Autowired
    private Gaming_3Repository gaming3Repository;

    @Autowired
    private LFRRepository lfrRepository;
    @Autowired
    private RoboRaceRepository roboRaceRepository;
    @Autowired
    private RoboSoccerRepository roboSoccerRepository;
    @Autowired
    private War8KgRepository roboWar8kgRepository;
    @Autowired
    private War15KgRepository roboWar15kgRepository;

    @Async
    public CompletableFuture<profileModel> findProfile(String gid)throws Exception{
        Optional<MrdModel> mrdModel = mrdRepository.findByGid(gid);
        if(!mrdModel.isPresent()){
             throw new Exception("Invalid gid");
        }
        profileModel profile=profileRepository.findByGid(gid);
        if(profile==null){
            return addtoprofile(gid);
        }
        else
            return CompletableFuture.completedFuture(profile);
    }

    @Async
    public CompletableFuture<profileModel> addtoprofile(String gid){
            profileModel profile=new profileModel();

            MrdModel mrdModel = mrdRepository.findByGid(gid).get();

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
            profile.setMegaArchTid(megaArchRepository.findByGid(gid).get().getTid());
            profile.setSetuBandhanTid(setuBandhanRepository.findByGid(gid).get().getTid());
            profile.setTrackoteasureTid(trackoteasureRepository.findByGid(gid).get().getTid());
            //coding
            profile.setCp1styearTid(cp1styearRepository.findByGid(gid).get().getTid());
            profile.setCpAllyearTid(cpAllyearRepository.findByGid(gid).get().getTid());
            profile.setWebTid(webRepository.findByGid(gid).get().getTid());
            //electrical
            profile.setElectrical1Tid(electrical1Repository.findByGid(gid).get().getTid());
            profile.setElectrical2Tid(electrical2Repository.findByGid(gid).get().getTid());
            //gaming
            profile.setGaming1Tid(gaming1Repository.findByGid(gid).get().getTid());
            profile.setGaming2Tid(gaming2Repository.findByGid(gid).get().getTid());
            profile.setGaming3Tid(gaming3Repository.findByGid(gid).get().getTid());
            //robotics
            profile.setLFRTid(lfrRepository.findByGid(gid).get().getTid());
            profile.setRoboraceTid(roboRaceRepository.findByGid(gid).get().getTid());
            profile.setRoboSoccerTid(roboSoccerRepository.findByGid(gid).get().getTid());
            profile.setRoboWar8kgTid(roboWar8kgRepository.findByGid(gid).get().getTid());
            profile.setRoboWar15kgTid(roboWar15kgRepository.findByGid(gid).get().getTid());

            return CompletableFuture.completedFuture(profileRepository.save(profile));

    }


}
