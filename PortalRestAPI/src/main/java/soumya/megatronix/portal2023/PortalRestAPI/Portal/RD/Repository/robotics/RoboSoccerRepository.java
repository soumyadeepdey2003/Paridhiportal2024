package soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Repository.robotics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Model.robotics.RoboSoccerModel;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoboSoccerRepository extends JpaRepository<RoboSoccerModel, Long> {


    Optional<RoboSoccerModel> findByGid1(String gid);

    Optional<RoboSoccerModel> findByGid2(String gid);

    Optional<RoboSoccerModel> findByGid3(String gid);

    Optional<RoboSoccerModel> findByGid4(String gid);

    Optional<RoboSoccerModel> findByGid5(String gid);
}
