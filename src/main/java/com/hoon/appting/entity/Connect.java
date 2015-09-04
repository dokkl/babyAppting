package com.hoon.appting.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by hoon on 2015-08-11.
 */
@Entity
@Table(name = "connect")
public class Connect {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date connectDay = new Date();

    /*@Column(nullable = false)
    private String myMail;

    private String targetMail;*/

    private String myResponse;

    private String targetResponse;

    private boolean viewed;

    private Long myPoint;

    private String temp1;
    private String temp2;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "my_id")
    private Member myMember;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "target_id")
    private Member targetMember;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getConnectDay() {
        return connectDay;
    }

    public void setConnectDay(Date connectDay) {
        this.connectDay = connectDay;
    }

    public String getMyResponse() {
        return myResponse;
    }

    public void setMyResponse(String myResponse) {
        this.myResponse = myResponse;
    }

    public String getTargetResponse() {
        return targetResponse;
    }

    public void setTargetResponse(String targetResponse) {
        this.targetResponse = targetResponse;
    }

    public boolean isViewed() {
        return viewed;
    }

    public void setViewed(boolean viewed) {
        this.viewed = viewed;
    }

    public Long getMyPoint() {
        return myPoint;
    }

    public void setMyPoint(Long myPoint) {
        this.myPoint = myPoint;
    }

    public String getTemp1() {
        return temp1;
    }

    public void setTemp1(String temp1) {
        this.temp1 = temp1;
    }

    public String getTemp2() {
        return temp2;
    }

    public void setTemp2(String temp2) {
        this.temp2 = temp2;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public Member getMyMember() {
        return myMember;
    }

    public void setMyMember(Member myMember) {
        this.myMember = myMember;
    }

    public Member getTargetMember() {
        return targetMember;
    }

    public void setTargetMember(Member targetMember) {
        this.targetMember = targetMember;
    }
}
