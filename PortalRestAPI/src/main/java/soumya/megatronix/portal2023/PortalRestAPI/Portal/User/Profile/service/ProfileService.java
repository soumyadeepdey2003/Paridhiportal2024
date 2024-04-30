package soumya.megatronix.portal2023.PortalRestAPI.Portal.User.Profile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.MRD.Model.MrdModel;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.MRD.Repository.MrdRepository;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.Profile.model.ProfileModel;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.Profile.repository.profilerepository;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Model.civil.MegaArchModel;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Model.civil.SetuBandhanModel;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Model.civil.TrackOTeasureModel;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Model.coding.CodeQuestModel;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Model.coding.CodezenModel;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Model.coding.WebMindsModel;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Model.electrical.ElectriQuest;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Model.electrical.Electrical2;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Model.gaming.BgmiLan;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Model.gaming.ValorantLan;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Model.gaming.PesLan;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Model.general.BingeQuiz;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Model.general.Carrom;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Model.general.TableTennis;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Model.robotics.*;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Service.civil.MegaArchService;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Service.civil.SetuBandhanService;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Service.civil.TrackOTeasureService;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Service.coding.CodeQuestService;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Service.coding.CodezenService;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Service.coding.WebMindsService;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Service.electrical.ElectriQuestService;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Service.electrical.Electrical2Service;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Service.gaming.BgmiLanService;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Service.gaming.ValorantLanService;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Service.gaming.PesLanService;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Service.general.BingeQuizService;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Service.general.CarromService;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Service.general.TableTennisService;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Service.robotics.*;


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
    private CodezenService codezenService;
    @Autowired
    private CodeQuestService codeQuestService;
    @Autowired
    private WebMindsService webMindsService;

    @Autowired
    private ElectriQuestService electriQuestService;
    @Autowired
    private Electrical2Service electrical2Service;

    @Autowired
    private BgmiLanService bgmiLanService;
    @Autowired
    private ValorantLanService valorantLanService;
    @Autowired
    private PesLanService pesLanService;

    @Autowired
    private BingeQuizService bingeQuizService;
    @Autowired
    private TableTennisService tableTennisService;
    @Autowired
    private CarromService carromService;

    @Autowired
    private LineTrekkerService lineTrekkerService;
    @Autowired
    private TriathlonService triathlonService;
    @Autowired
    private RoboKlassikerService roboKlassikerService;
    @Autowired
    private War8KgService roboWar8kgService;
    @Autowired
    private War15KgService roboWar15kgService;

    @Async
    public CompletableFuture<ProfileModel> findProfile(String gid)throws Exception{
        Optional<MrdModel> mrdModel = mrdRepository.findByGid(gid);
        if(!mrdModel.isPresent()){
            throw new Exception("Invalid gid");
        }
        ProfileModel profile = profileRepository.findByGid(gid);
        if(profile==null){
            CompletableFuture<ProfileModel> newProfile = addToProfile(gid);
            return CompletableFuture.completedFuture(profileRepository.save(newProfile.get()));
        }
        else {
            CompletableFuture<ProfileModel> newProfile = addToProfile(gid);

            profile.setMegaArchTid(newProfile.get().getMegaArchTid());
            profile.setSetuBandhanTid(newProfile.get().getSetuBandhanTid());
            profile.setTrackoteasureTid(newProfile.get().getTrackoteasureTid());

            profile.setCodezenTid(newProfile.get().getCodezenTid());
            profile.setCodeQuestTid(newProfile.get().getCodeQuestTid());
            profile.setWebMindsTid(newProfile.get().getWebMindsTid());

            profile.setElectriQuestTid(newProfile.get().getElectriQuestTid());
            profile.setElectrical2Tid(newProfile.get().getElectrical2Tid());

            profile.setBgmiLanTid(newProfile.get().getBgmiLanTid());
            profile.setValorantLanTid(newProfile.get().getValorantLanTid());
            profile.setPesLanTid(newProfile.get().getPesLanTid());

            profile.setBingeQuizTid(newProfile.get().getBingeQuizTid());
            profile.setTableTennisTid(newProfile.get().getTableTennisTid());
            profile.setCarromTid(newProfile.get().getCarromTid());

            profile.setLineTrekkerTid(newProfile.get().getLineTrekkerTid());
            profile.setTriathlonTid(newProfile.get().getTriathlonTid());
            profile.setRoboKlassikerTid(newProfile.get().getRoboKlassikerTid());
            profile.setRoboWar8kgTid(newProfile.get().getRoboWar8kgTid());
            profile.setRoboWar15kgTid(newProfile.get().getRoboWar15kgTid());
            profileRepository.save(profile);
            return CompletableFuture.completedFuture(profile);
        }
    }

    @Async
    public CompletableFuture<ProfileModel> addToProfile(String gid){
        Optional<MrdModel> optionalMrdModel = mrdRepository.findByGid(gid);

        if(optionalMrdModel.isPresent()) {
            MrdModel mrdModel = optionalMrdModel.get();
            ProfileModel profile=new ProfileModel();

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
            Optional<CodezenModel> CodezenServiceOptional = codezenService.findByGid(gid);
            if(CodezenServiceOptional.isPresent()) {
                profile.setCodezenTid(CodezenServiceOptional.get().getTid());
            } else {
                profile.setCodezenTid(null);
            }

            Optional<CodeQuestModel> CodeQuestServiceOptional = codeQuestService.findByGid(gid);
            if(CodeQuestServiceOptional.isPresent()) {
                profile.setCodeQuestTid(CodeQuestServiceOptional.get().getTid());
            } else {
                profile.setCodeQuestTid(null);
            }

            Optional<WebMindsModel> WebMindsMindsServiceOptional = webMindsService.findByGid(gid);
            if(WebMindsMindsServiceOptional.isPresent()) {
                profile.setWebMindsTid(WebMindsMindsServiceOptional.get().getTid());
            } else {
                profile.setWebMindsTid(null);
            }

            //electrical
            Optional<ElectriQuest> ElectriQuestServiceOptional = electriQuestService.findByGid(gid);
            if(ElectriQuestServiceOptional.isPresent()) {
                profile.setElectriQuestTid(ElectriQuestServiceOptional.get().getTid());
            } else {
                profile.setElectriQuestTid(null);
            }

            Optional<Electrical2> electrical2ServiceOptional = electrical2Service.findByGid(gid);
            if(electrical2ServiceOptional.isPresent()) {
                profile.setElectrical2Tid(electrical2ServiceOptional.get().getTid());
            } else {
                profile.setElectrical2Tid(null);
            }

            //gaming
            Optional<BgmiLan> bgmiLanServiceOptional = bgmiLanService.findByGid(gid);
            if(bgmiLanServiceOptional.isPresent()) {
                profile.setBgmiLanTid(bgmiLanServiceOptional.get().getTid());
            } else {
                profile.setBgmiLanTid(null);
            }

            Optional<ValorantLan> valorantLanServiceOptional = valorantLanService.findByGid(gid);
            if(valorantLanServiceOptional.isPresent()) {
                profile.setValorantLanTid(valorantLanServiceOptional.get().getTid());
            } else {
                profile.setValorantLanTid(null);
            }

            Optional<PesLan> pesLanServiceOptional = pesLanService.findByGid(gid);
            if(pesLanServiceOptional.isPresent()) {
                profile.setPesLanTid(pesLanServiceOptional.get().getTid());
            } else {
                profile.setPesLanTid(null);
            }

            //general
            Optional<BingeQuiz> bingeQuizOptional = bingeQuizService.findByGid(gid);
            if(bingeQuizOptional.isPresent())
                profile.setBingeQuizTid(bingeQuizOptional.get().getTid());
            else
                profile.setBingeQuizTid(null);

            Optional<TableTennis> tableTennisOptional = tableTennisService.findByGid(gid);
            if(tableTennisOptional.isPresent())
                profile.setTableTennisTid(tableTennisOptional.get().getTid());
            else
                profile.setTableTennisTid(null);

            Optional<Carrom> carromOptional = carromService.findByGid(gid);
            if(carromOptional.isPresent())
                profile.setCarromTid(carromOptional.get().getTid());
            else
                profile.setCarromTid(null);

            //robotics
            Optional<LineTrekkerModel> LineTrekkerServiceOptional = lineTrekkerService.findByGid(gid);
            if(LineTrekkerServiceOptional.isPresent()) {
                profile.setLineTrekkerTid(LineTrekkerServiceOptional.get().getTid());
            } else {
                profile.setLineTrekkerTid(null);
            }

            Optional<TriathlonModel> TriathlonServiceOptional = triathlonService.findByGid(gid);
            if (TriathlonServiceOptional.isPresent()) {
                profile.setTriathlonTid(TriathlonServiceOptional.get().getTid());
            } else {
                profile.setTriathlonTid(null);
            }

            Optional<RoboKlassikerModel> RoboKlassikerServiceOptional = roboKlassikerService.findByGid(gid);
            if (RoboKlassikerServiceOptional.isPresent()) {
                profile.setRoboKlassikerTid(RoboKlassikerServiceOptional.get().getTid());
            } else {
                profile.setRoboKlassikerTid(null);
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