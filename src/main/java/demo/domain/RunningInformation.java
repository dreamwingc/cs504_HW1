package demo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Random;

@Data
@Entity
@Table(name = "RUNNING_ANALYSIS")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RunningInformation {

    enum HealthWarningLevel{
        HIGH, NORMAL, LOW
    }

    private HealthWarningLevel healthWarningLevel;

    private String runningId;

    private double totalRunningTime;
    private int heartRate;

    @Id
    @GeneratedValue
    private Long userId;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "username", column = @Column(name = "userName")),
            @AttributeOverride(name = "address", column = @Column(name = "userAddress"))
    })
    private final UserInfo userInfo;

    @JsonIgnore
    private double latitude;

    @JsonIgnore
    private double longitude;

    @JsonIgnore
    private double runningDistance;

    @JsonIgnore
    private Date timestamp = new Date();

    public RunningInformation(){
        this.userInfo = null;
    }

    @JsonCreator
    public RunningInformation(@JsonProperty("userInfo") UserInfo userInfo){
        this.userInfo = userInfo;
    }

    @JsonIgnore
    public UserInfo getUserInfo() {
        return userInfo;
    }

    public String getUserName(){ return this.userInfo == null ? null : this.userInfo.getUsername(); }

    public String getUserAddress(){ return this.userInfo == null ? null : this.userInfo.getAddress(); }

    public void setHeartRate(int heartRate){
        int min = 60;
        int max = 200;

        this.heartRate = new Random().nextInt((max - min + 1)) + min;

        if (this.heartRate >= 60 && this.heartRate <= 75){
            this.healthWarningLevel = HealthWarningLevel.LOW;
        }else if (this.heartRate > 75 && this.heartRate <= 120){
            this.healthWarningLevel = HealthWarningLevel.NORMAL;
        } else{
            this.healthWarningLevel = HealthWarningLevel.HIGH;
        }
    }
}