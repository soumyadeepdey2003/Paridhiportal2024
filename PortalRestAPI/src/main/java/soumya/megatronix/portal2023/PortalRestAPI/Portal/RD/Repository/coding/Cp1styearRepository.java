package soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Repository.coding;

import org.springframework.data.jpa.repository.JpaRepository;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Model.coding.Cp1styearModel;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Model.coding.CpAllyearModel;

import java.util.List;


public interface Cp1styearRepository extends JpaRepository<Cp1styearModel, Long> {
    List<CpAllyearModel> findBySelectedcodingevent(String selectedcodingevent);
}
