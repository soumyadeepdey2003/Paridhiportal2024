package soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Model.general;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.scheduling.annotation.Async;

@Entity
@Getter
@Setter
@Table(name = "carrom")
@NoArgsConstructor
@Async
public class Carrom {
    public Carrom(String gid1, String gid2, String number1) {
        this.gid1 = gid1;
        this.gid2 = gid2;
        this.number1 = number1;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "selectedgeneralevent" )
    private String selectedgeneralevent = "carrom";

    private String gid1;
    private String gid2;

    private String number1;
    private String tid;
    private boolean played=false;
    private boolean paid=false;
}