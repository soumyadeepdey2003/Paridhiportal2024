package soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Service.civil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.MRD.Model.MrdModel;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.MRD.Repository.MrdRepository;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Model.civil.SetuBandhanModel;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Repository.civil.SetuBandhanRepository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class SetuBandhanService {

  @Autowired
  private SetuBandhanRepository civil;

  @Autowired
  private MrdRepository repo;

  @Async
  public CompletableFuture<SetuBandhanModel> setuBandhanRd(SetuBandhanModel member) {
    Optional<MrdModel> gid1 = repo.findByGid(member.getGid1());
    Optional<MrdModel> gid2 = Optional.ofNullable(member.getGid2()).flatMap(repo::findByGid);
    Optional<MrdModel> gid3 = Optional.ofNullable(member.getGid3()).flatMap(repo::findByGid);
    Optional<MrdModel> gid4 = Optional.ofNullable(member.getGid4()).flatMap(repo::findByGid);
    Optional<MrdModel> gid5 = Optional.ofNullable(member.getGid5()).flatMap(repo::findByGid);
    if ( gid1.isPresent() &&
        (gid2.isPresent() || member.getGid2() == null )&&
        (gid3.isPresent() || member.getGid3() == null)  &&
        (gid4.isPresent() || member.getGid4() == null)  &&
        (gid5.isPresent() || member.getGid5() == null)
    ) {
      List<SetuBandhanModel> list = civil.findBySelectedcivilevent(member.getSelectedcivilevent());
      for (SetuBandhanModel i : list) {
        if (
            (
                member.getGid1().equals(i.getGid1()) ||
                    member.getGid1().equals(i.getGid2()) ||
                    member.getGid1().equals(i.getGid3()) ||
                    member.getGid1().equals(i.getGid4()) ||
                    member.getGid1().equals(i.getGid5()) ||

                    member.getGid1().equals(member.getGid2())||
                    member.getGid1().equals(member.getGid3())||
                    member.getGid1().equals(member.getGid4())||
                    member.getGid1().equals(member.getGid5())
            )||
                (
                    (member.getGid2() != null &&member.getGid2().equals(i.getGid1())) ||
                        (member.getGid2() != null &&member.getGid2().equals(i.getGid2()) )||
                        (member.getGid2() != null &&member.getGid2().equals(i.getGid3())) ||
                        (member.getGid2() != null &&member.getGid2().equals(i.getGid4()) )||
                        (member.getGid2() != null &&member.getGid2().equals(i.getGid5())) ||

                        (member.getGid2() != null &&member.getGid2().equals(member.getGid1()))||
                        (member.getGid2() != null &&member.getGid2().equals(member.getGid3()))||
                        (member.getGid2() != null &&member.getGid2().equals(member.getGid4()))||
                        (member.getGid2() != null &&member.getGid2().equals(member.getGid5()))
                )||

                (
                    (
                        (member.getGid3() != null && member.getGid3().equals(i.getGid3())) ||
                            (member.getGid3() != null &&member.getGid3().equals(i.getGid1())) ||
                            (member.getGid3() != null &&member.getGid3().equals(i.getGid2()) )||
                            (member.getGid3() != null &&member.getGid3().equals(i.getGid4())) ||
                            (member.getGid3() != null &&member.getGid3().equals(i.getGid5()))) ||

                        (member.getGid3() != null &&member.getGid3().equals(member.getGid1()))||
                        (member.getGid3() != null &&member.getGid3().equals(member.getGid2()))||
                        (member.getGid3() != null &&member.getGid3().equals(member.getGid4()))||
                        (member.getGid3() != null &&member.getGid3().equals(member.getGid5())
                        )
                )||

                (
                    (
                        (member.getGid4() != null && member.getGid4().equals(i.getGid3())) ||
                            (member.getGid4() != null && member.getGid4().equals(i.getGid1()) )||
                            (member.getGid4() != null && member.getGid4().equals(i.getGid2())) ||
                            (member.getGid4() != null && member.getGid4().equals(i.getGid4())) ||
                            (member.getGid4() != null && member.getGid4().equals(i.getGid5()) )||

                            ( member.getGid4() != null && member.getGid4().equals(member.getGid1()))||
                            (member.getGid4() != null && member.getGid4().equals(member.getGid2()))||
                            (member.getGid4() != null && member.getGid4().equals(member.getGid3()))||
                            (member.getGid4() != null && member.getGid4().equals(member.getGid5()))
                    )
                )||

                (
                    (
                        (member.getGid5() != null && member.getGid5().equals(i.getGid3())) ||
                            (member.getGid5() != null && member.getGid5().equals(i.getGid1())) ||
                            (member.getGid5() != null && member.getGid5().equals(i.getGid2())) ||
                            (member.getGid5() != null && member.getGid5().equals(i.getGid4())) ||
                            (member.getGid5() != null && member.getGid5().equals(i.getGid5()))||

                            (member.getGid5() != null && member.getGid5().equals(member.getGid1()))||
                            (member.getGid5() != null && member.getGid5().equals(member.getGid2()))||
                            (member.getGid5() != null && member.getGid5().equals(member.getGid3()))||
                            (member.getGid5() != null && member.getGid5().equals(member.getGid4()))
                    )
                )
        ) {
          throw new RuntimeException("GID already exists.");
        }
      }
      if(
          (
              member.getGid1().equals(member.getGid2())||
                  member.getGid1().equals(member.getGid3())||
                  member.getGid1().equals(member.getGid4())||
                  member.getGid1().equals(member.getGid5())
          )||
              (
                  (member.getGid2() != null &&member.getGid2().equals(member.getGid1()))||
                      (member.getGid2() != null &&member.getGid2().equals(member.getGid3()))||
                      (member.getGid2() != null &&member.getGid2().equals(member.getGid4()))||
                      (member.getGid2() != null &&member.getGid2().equals(member.getGid5()))
              )||
              (
                  (member.getGid3() != null &&member.getGid3().equals(member.getGid2()))||
                      (member.getGid3() != null &&member.getGid3().equals(member.getGid1()))||
                      (member.getGid3() != null &&member.getGid3().equals(member.getGid4()))||
                      (member.getGid3() != null &&member.getGid3().equals(member.getGid5()))
              )||
              (
                  (member.getGid4() != null && member.getGid4().equals(member.getGid2()))||
                      (member.getGid4() != null && member.getGid4().equals(member.getGid1()))||
                      (member.getGid4() != null && member.getGid4().equals(member.getGid3()))||
                      (member.getGid4() != null && member.getGid4().equals(member.getGid5()))
              )
      )
        throw new RuntimeException("GID already exists");
      else {
        CompletableFuture<SetuBandhanModel> setuBandhan = CompletableFuture.completedFuture(civil.save(member));
        member.setTid("paridhi"+member.getId()+"2002"+member.getId()+"05202024");
        civil.save(member);
        return setuBandhan;
      }
    }
    throw new RuntimeException("GID not present");
  }

  public CompletableFuture<MrdModel> checkgid(String gid) {
    MrdModel setuBandhan = repo.getModelByGid(gid);
    if (setuBandhan != null) {
      for (SetuBandhanModel i : civil.findAll()) {
        if (
            setuBandhan.getGid().equals(i.getGid1()) ||
                setuBandhan.getGid().equals(i.getGid2()) ||
                setuBandhan.getGid().equals(i.getGid3()) ||
                setuBandhan.getGid().equals(i.getGid4()) ||
                setuBandhan.getGid().equals(i.getGid5())
        ) {
          throw new RuntimeException("GID already exists.");
        }
      }

      return CompletableFuture.completedFuture(setuBandhan);
    } else {
      throw new RuntimeException("GID not present");
    }
  }
}
