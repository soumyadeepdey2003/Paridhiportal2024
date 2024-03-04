package soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Model.civil;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.scheduling.annotation.Async;

@Entity
@Getter
@Setter
@Table(name = "setu_bandhan")
@NoArgsConstructor
@Async
public class SetuBandhanModel {

    public SetuBandhanModel(String teamnname, Long gid1, Long gid2, Long gid3, Long gid4, Long gid5, String number1){
        this.teamname = teamnname;
        this.gid1=gid1;
        this.gid2=gid2;
        this.gid3=gid3;
        this.gid4=gid4;
        this.gid5=gid5;
        this.number1 = number1;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private String teamname;

    @Column(name = "selectedcivilevent" )
    private  String selectedcivilevent = "Setu Bandhan";

    private Long gid1;

    @Column(nullable = true)
    private Long gid2;

    @Column(nullable = true)
    private Long gid3;

    @Column(nullable = true)
    private Long gid4;

    @Column(nullable = true)
    private Long gid5;

    private String number1;
    private String tid="paridhi"+id+"2002"+id+"05202024";
    private boolean played=false;
}