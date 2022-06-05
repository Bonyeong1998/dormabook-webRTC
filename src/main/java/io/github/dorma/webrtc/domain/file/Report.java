package io.github.dorma.webrtc.domain.file;

import io.github.dorma.webrtc.domain.team.StudyRoom;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
@Component
public class Report {

    // 자동 인덱스 증가
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportNo;

    // 학습실 번호(인덱스)
    @ManyToOne(targetEntity = StudyRoom.class)
    @JoinColumn(name = "studyroomNo", nullable = false)
    private StudyRoom studyroom;

    // 파일 원본 이름
    @Column(nullable = false)
    private String reportFilename;

    // 파일 경로
    @Column(nullable = false)
    private String reportFileroute;

    // 저장 파일명
    @Column(nullable = false)
    private String reportSavefilename;

    @Builder
    public Report(Long reportNo, StudyRoom studyroom, String reportFilename, String reportFileroute, String reportSavefilename) {
        this.reportNo = reportNo;
        this.studyroom = studyroom;
        this.reportFilename = reportFilename;
        this.reportFileroute = reportFileroute;
        this.reportSavefilename = reportSavefilename;
    }
}