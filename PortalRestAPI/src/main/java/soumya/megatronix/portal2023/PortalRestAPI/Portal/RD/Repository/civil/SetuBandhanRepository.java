package soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Repository.civil;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Model.civil.MegaArchModel;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Model.civil.SetuBandhanModel;

import java.util.List;

@Repository
public interface SetuBandhanRepository extends JpaRepository<SetuBandhanModel, Long> {
  List<SetuBandhanModel> findBySelectedcivilevent(String selectedcivilevent);
}
