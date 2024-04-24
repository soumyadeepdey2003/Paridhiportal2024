package soumya.megatronix.portal2023.PortalRestAPI.Portal.User.Profile.model;


import jakarta.annotation.Nullable;
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
public class ProfileModel {

        public ProfileModel(String name, String college, String year, String department, String roll, String email, String phoneNumber,String gid,
                            String megaArchTid, String setuBandhanTid, String TrackoteasureTid,
                            String codezenTid, String codeQuestTid, String webMindsTid,
                            String electriQuestTid, String electrical2Tid,
                            String bgmiLanTid, String valorantLanTid, String pesLanTid,
                            String bingeQuizTid, String tableTennisTid, String carromTid,
                            String lineTrekkerTid, String triathlonTid, String roboKlassikerTid, String roboWar8kgTid, String roboWar15kgTid){
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

            this.codezenTid=codezenTid;
            this.codeQuestTid=codeQuestTid;
            this.webMindsTid=webMindsTid;

            this.electriQuestTid=electriQuestTid;
            this.electrical2Tid=electrical2Tid;

            this.bgmiLanTid=bgmiLanTid;
            this.valorantLanTid=valorantLanTid;
            this.pesLanTid=pesLanTid;

            this.bingeQuizTid=bingeQuizTid;
            this.tableTennisTid=tableTennisTid;
            this.carromTid=carromTid;

            this.lineTrekkerTid=lineTrekkerTid;
            this.triathlonTid=triathlonTid;
            this.roboKlassikerTid=roboKlassikerTid;
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
        private String codezenTid;
        @Nullable
        private String codeQuestTid;
        @Nullable
        private String webMindsTid;

        //electrical
        @Nullable
        private String electriQuestTid;
        @Nullable
        private String electrical2Tid;

        //gaming
        @Nullable
        private String bgmiLanTid;
        @Nullable
        private String valorantLanTid;
        @Nullable
        private String pesLanTid;

        //general
        @Nullable
        private String bingeQuizTid;
        @Nullable
        private String tableTennisTid;
        @Nullable
        private String carromTid;

        //robotics
        @Nullable
        private String lineTrekkerTid;
        @Nullable
        private String triathlonTid;
        @Nullable
        private String roboKlassikerTid;
        @Nullable
        private String roboWar8kgTid;
        @Nullable
        private String roboWar15kgTid;



}
