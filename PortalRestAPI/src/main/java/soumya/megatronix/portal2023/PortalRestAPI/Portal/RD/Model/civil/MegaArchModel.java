package soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Model.civil;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.scheduling.annotation.Async;

@Entity
@Getter
@Setter
@Table(name = "mega_arch")
@NoArgsConstructor
@Async
public class MegaArchModel {

<<<<<<< HEAD
    public MegaArchModel(String teamnname, Long gid1, Long gid2, Long gid3, Long gid4, Long gid5, String number1){
        this.teamname = teamnname;
=======
    public MegaArchModel(Long gid1, Long gid2, Long gid3, Long gid4, Long gid5, String number1){
>>>>>>> 4c2fc980c5f75e44f7f2cf08efc591bdb1ab963b
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

<<<<<<< HEAD
    @Column(nullable = true)
    private String teamname;
=======
>>>>>>> 4c2fc980c5f75e44f7f2cf08efc591bdb1ab963b

    @Column(name = "selectedcivilevent" )
    private  String selectedcivilevent = "Mega Arch";

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