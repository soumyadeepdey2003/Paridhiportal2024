package soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Model.robotics;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.scheduling.annotation.Async;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "Robotics_Combo")
@NoArgsConstructor
@Async
public class RoboticsComboModel {

    public RoboticsComboModel(String teamname, String gid1, String gid2, String gid3, String gid4, String gid5,
                         String number1) {
        this.teamname = teamname;
        this.gid1 = gid1;
        this.gid2 = gid2;
        this.gid3 = gid3;
        this.gid4 = gid4;
        this.gid5 = gid5;
        this.number1 = number1;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private String teamname;


    private String gid1;

    @Column(nullable = true)
    private String gid2;

    @Column(nullable = true)
    private String gid3;

    @Column(nullable = true)
    private String gid4;

    @Column(nullable = true)
    private String gid5;

    private String number1;
    private List<String>tid;
    private boolean played = false;
    private boolean paid = false;
}
