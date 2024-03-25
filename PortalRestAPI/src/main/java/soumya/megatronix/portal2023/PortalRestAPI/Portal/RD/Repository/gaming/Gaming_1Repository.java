package soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Repository.gaming;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Model.gaming.Gaming_1;

import java.util.List;
import java.util.Optional;

@Repository
public interface Gaming_1Repository extends JpaRepository<Gaming_1, Long> {
    Optional<Gaming_1> findByGid(String gid);
}
