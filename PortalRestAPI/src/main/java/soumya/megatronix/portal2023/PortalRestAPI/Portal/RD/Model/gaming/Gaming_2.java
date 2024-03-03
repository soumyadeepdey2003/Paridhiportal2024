package soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Model.gaming;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.scheduling.annotation.Async;

@Entity
@Getter
@Setter
@Table(name = "gaming_2")
@NoArgsConstructor
@Async
public class Gaming_2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
