package soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Repository.electrical;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Model.electrical.Electrical1;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Model.electrical.Electrical2;

import java.util.List;
import java.util.Optional;

@Repository
public interface Electrical2Repository extends JpaRepository<Electrical2, Long> {


    Optional<Electrical2> findByGid1(String gid);

    Optional<Electrical2> findByGid2(String gid);

    Optional<Electrical2> findByGid3(String gid);

    Optional<Electrical2> findByGid4(String gid);

    Optional<Electrical2> findByGid5(String gid);
}
