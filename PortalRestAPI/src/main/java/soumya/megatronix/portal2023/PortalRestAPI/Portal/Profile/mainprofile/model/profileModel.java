package soumya.megatronix.portal2023.PortalRestAPI.Portal.Profile.mainprofile.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.scheduling.annotation.Async;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Async
@Getter
@Setter
@Table(name = "profile")
@NoArgsConstructor
public class profileModel {

        public profileModel(String name, String college, String year, String department, String roll, String email, String phoneNumber,String gid,
                            String megaArchTid, String setuBandhanTid, String TrackoteasureTid,
                            String cp1styearTid, String cpAllyearTid, String webTid,
                            String electrical1Tid, String electrical2Tid,
                            String gaming1Tid, String gaming2Tid, String gaming3Tid,
                            String LFRTid, String roboraceTid, String roboSoccerTid, String roboWar8kgTid, String roboWar15kgTid){
            this.name=name;
            this.college=college;
            this.year=year;
            this.department=department;
            this.roll=roll;
            this.email=email;
            this.phoneNumber=phoneNumber;
            this.gid=gid;

            this.megaArchTid=megaArchTid;
            this.setuBandhanTid=setuBandhanTid;
            this.TrackoteasureTid=TrackoteasureTid;

            this.cp1styearTid=cp1styearTid;
            this.cpAllyearTid=cpAllyearTid;
            this.webTid=webTid;

            this.electrical1Tid=electrical1Tid;
            this.electrical2Tid=electrical2Tid;

            this.gaming1Tid=gaming1Tid;
            this.gaming2Tid=gaming2Tid;
            this.gaming3Tid=gaming3Tid;

            this.LFRTid=LFRTid;
            this.roboraceTid=roboraceTid;
            this.roboSoccerTid=roboSoccerTid;
            this.roboWar8kgTid=roboWar8kgTid;
            this.roboWar15kgTid=roboWar15kgTid;


        }


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(nullable = false)
        private String name;

        @Column(nullable = false)
        private String college;

        @Column(nullable = false)
        private String year;

        @Column(nullable = false)
        private String department;

        @Column(nullable = false)
        private String roll;

        @Column(nullable = false)
        @NotBlank(message = "Email is required")
        @Email(message = "Invalid email format")
        private String email;

        @NotBlank(message = "Phone number is required")
        @Pattern(regexp = "^[6-9]\\d{9}$", message = "Invalid Indian phone number")
        private String phoneNumber;

        private String gid;

        //civil
        private String megaArchTid;
        private String setuBandhanTid;
        private String TrackoteasureTid;

        //coding
        private String cp1styearTid;
        private String cpAllyearTid;
        private String webTid;

        //electrical
        private String electrical1Tid;
        private String electrical2Tid;

        //gaming
        private String gaming1Tid;
        private String gaming2Tid;
        private String gaming3Tid;

        //robotics
        private String LFRTid;
        private String roboraceTid;
        private String roboSoccerTid;
        private String roboWar8kgTid;
        private String roboWar15kgTid;



}
