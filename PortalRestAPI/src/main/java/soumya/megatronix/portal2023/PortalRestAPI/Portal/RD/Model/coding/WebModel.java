package soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Model.coding;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.scheduling.annotation.Async;

@Entity
@Getter
@Setter
@Table(name = "web")
@NoArgsConstructor
@Async
public class WebModel {

    public WebModel(String teamname, Long gid1, Long gid2, String number1){
        this.teamname=teamname;
        this.gid1=gid1;
        this.gid2=gid2;
        this.number1 = number1;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = true)
    private String teamname;
    @Column(name = "selectedcodingevent" )
    private  String selectedcodingevent="web";
    private Long gid1;
    @Column(nullable = true)
    private Long gid2;

    private String number1;
    private String tid="paridhi"+id+"2002"+id+"05202024";
    private boolean played=false;
}
