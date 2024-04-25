package soumya.megatronix.portal2023.PortalRestAPI.Portal.User.RD.Model.electrical;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.scheduling.annotation.Async;

@Entity
@Getter
@Setter
@Table(name = "electrical_2")
@NoArgsConstructor
@Async
public class Electrical2 {
    public Electrical2(String gid1, String gid2, String number1){
        this.gid1=gid1;
        this.gid2=gid2;
        this.number1 = number1;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "selectedelectricalevent" )
    private  String selectedelectricalevent = "Electrical 2";

    private String gid1;

    @Column(nullable = true)
    private String gid2;

    private String number1;
    private String tid;
    private boolean played=false;
    private boolean paid=false;
}