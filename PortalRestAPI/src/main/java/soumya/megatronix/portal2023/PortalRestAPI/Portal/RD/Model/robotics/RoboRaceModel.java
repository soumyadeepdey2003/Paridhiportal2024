package soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Model.robotics;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.scheduling.annotation.Async;

@Entity
@Getter
@Setter
@Table(name = "robo_race")
@NoArgsConstructor
@Async
public class RoboRaceModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
