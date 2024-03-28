package soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Repository.gaming;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Model.gaming.Gaming_1;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Model.gaming.Gaming_2;

import java.util.List;
import java.util.Optional;

@Repository
public interface Gaming_2Repository extends JpaRepository<Gaming_2, Long> {

    Optional<Gaming_2> findByGid1(String gid);

    Optional<Gaming_2> findByGid2(String gid);

    Optional<Gaming_2> findByGid3(String gid);

    Optional<Gaming_2> findByGid4(String gid);

    Optional<Gaming_2> findByGid5(String gid);
}
