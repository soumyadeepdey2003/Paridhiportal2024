package soumya.megatronix.portal2023.PortalRestAPI.Portal.Profile.mainprofile.model;


import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.scheduling.annotation.Async;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
        @Nullable
        private String megaArchTid;
        @Nullable
        private String setuBandhanTid;
        @Nullable
        private String TrackoteasureTid;

        //coding
        @Nullable
        private String cp1styearTid;
        @Nullable
        private String cpAllyearTid;
        @Nullable
        private String webTid;

        //electrical
        @Nullable
        private String electrical1Tid;
        @Nullable
        private String electrical2Tid;

        //gaming
        @Nullable
        private String gaming1Tid;
        @Nullable
        private String gaming2Tid;
        @Nullable
        private String gaming3Tid;

        //robotics
        @Nullable
        private String LFRTid;
        @Nullable
        private String roboraceTid;
        @Nullable
        private String roboSoccerTid;
        @Nullable
        private String roboWar8kgTid;
        @Nullable
        private String roboWar15kgTid;



}
