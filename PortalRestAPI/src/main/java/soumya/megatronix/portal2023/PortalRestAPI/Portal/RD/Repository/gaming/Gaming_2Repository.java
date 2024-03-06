package soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Repository.gaming;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Model.gaming.Gaming_2;

import java.util.List;

@Repository
public interface Gaming_2Repository extends JpaRepository<Gaming_2, Long> {
  List<Gaming_2> findBySelectedgamingevent(String selectedgamingevent);
}
