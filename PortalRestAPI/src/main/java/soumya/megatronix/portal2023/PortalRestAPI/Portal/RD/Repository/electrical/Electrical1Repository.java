package soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Repository.electrical;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Model.electrical.Electrical1;

import java.util.List;

@Repository
public interface Electrical1Repository extends JpaRepository<Electrical1, Long> {
  List<Electrical1> findBySelectedelectricalevent(String selectedelectricalevent);
}
