package soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Repository.coding;

import org.springframework.data.jpa.repository.JpaRepository;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Model.coding.Cp1styearModel;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Model.coding.CpAllyearModel;

import java.util.List;
import java.util.Optional;


public interface Cp1styearRepository extends JpaRepository<Cp1styearModel, Long> {
    List<Cp1styearModel> findBySelectedcodingevent(String selectedcodingevent);

  Optional<Cp1styearModel> findByGid(String gid);

    Optional<Cp1styearModel> findByEmail(String email);
}
