package soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Model.civil;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.scheduling.annotation.Async;

@Entity
@Getter
@Setter
@Table(name = "ToT")
@NoArgsConstructor
@Async
public class TrackOTeasureModel {
    public TrackOTeasureModel(String gid1, String gid2, String gid3, String gid4, String number1){
        this.gid1=gid1;
        this.gid2=gid2;
        this.gid3=gid3;
        this.gid4=gid4;
        this.number1 = number1;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private String teamname;

    @Column(name = "selectedcivilevent" )
    private  String selectedcivilevent = "Track O Treasure";

    private String gid1;

    @Column(nullable = true)
    private String gid2;

    @Column(nullable = true)
    private String gid3;

    @Column(nullable = true)
    private String gid4;

    private String number1;
    private String tid;
    private boolean played=false;

    private boolean paid=false;
}