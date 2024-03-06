package soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Repository.electrical;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Model.electrical.Electrical2;

import java.util.List;

@Repository
public interface Electrical2Repository extends JpaRepository<Electrical2, Long> {
  List<Electrical2> findBySelectedelectricalevent(String selectedelectricalevent);
}
