package soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Model.electrical;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.scheduling.annotation.Async;

@Entity
@Getter
@Setter
@Table(name = "electrical_1")
@NoArgsConstructor
@Async
public class Electrical1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
