package com.hoon.appting.entity;

import com.hoon.appting.dto.Sex;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by hoon on 2015-04-26.
 */
@Entity
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String mail;

    @Column(nullable = false)
    private String password;

    @Column(nullable = true)
    private String name;

    @Column(nullable = true)
    @Enumerated(EnumType.STRING)
    private Sex sex;

    private String phone;

    private String birthday;

    @Column(nullable = true)
    private String deviceRegId;

    @Column(nullable = true)
    private String phoneAuth;

    @Column(nullable = true)
    private Integer age = 0;

    @Column(nullable = true)
    private String kakaoId;

    private String address1;

    @Column(nullable = true)
    private String address2;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;

    //기본사항
    private String nickName;

    @Column(nullable = true)
    private String job;

    @Column(nullable = true)
    private String hobby;

    @Column(nullable = true)
    private String characterType;

    @Column(nullable = true)
    private String religion; //종교

    @Column(nullable = true)
    private String bloodType; //혈액형

    @Column(nullable = true)
    private String height;

    @Column(nullable = true)
    private String bodyType;


    @Column(nullable = true)
    private String selfIntroduction;
    @Column(nullable = true)
    private String idealType;
    @Column(nullable = true)
    private String myAppeal;
    //선택사항
    private String drinkAndSmoke;
    private String wantDate;
    private String firstPoint;
    private String image1;
    private String image2;
    private String image3;
    private String image4;

    private Date lastConnectDate;

    private Integer lastConnectCount;

    private boolean pushOk = true;

    private boolean connectOk = true;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getDeviceRegId() {
        return deviceRegId;
    }

    public void setDeviceRegId(String deviceRegId) {
        this.deviceRegId = deviceRegId;
    }

    public String getPhoneAuth() {
        return phoneAuth;
    }

    public void setPhoneAuth(String phoneAuth) {
        this.phoneAuth = phoneAuth;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getKakaoId() {
        return kakaoId;
    }

    public void setKakaoId(String kakaoId) {
        this.kakaoId = kakaoId;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getSelfIntroduction() {
        return selfIntroduction;
    }

    public void setSelfIntroduction(String selfIntroduction) {
        this.selfIntroduction = selfIntroduction;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getIdealType() {
        return idealType;
    }

    public void setIdealType(String idealType) {
        this.idealType = idealType;
    }

    public String getMyAppeal() {
        return myAppeal;
    }

    public void setMyAppeal(String myAppeal) {
        this.myAppeal = myAppeal;
    }

    public String getDrinkAndSmoke() {
        return drinkAndSmoke;
    }

    public void setDrinkAndSmoke(String drinkAndSmoke) {
        this.drinkAndSmoke = drinkAndSmoke;
    }

    public String getWantDate() {
        return wantDate;
    }

    public void setWantDate(String wantDate) {
        this.wantDate = wantDate;
    }

    public String getFirstPoint() {
        return firstPoint;
    }

    public void setFirstPoint(String firstPoint) {
        this.firstPoint = firstPoint;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public String getImage4() {
        return image4;
    }

    public void setImage4(String image4) {
        this.image4 = image4;
    }

    public String getCharacterType() {
        return characterType;
    }

    public void setCharacterType(String characterType) {
        this.characterType = characterType;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public Date getLastConnectDate() {
        return lastConnectDate;
    }

    public void setLastConnectDate(Date lastConnectDate) {
        this.lastConnectDate = lastConnectDate;
    }

    public Integer getLastConnectCount() {
        return lastConnectCount;
    }

    public void setLastConnectCount(Integer lastConnectCount) {
        this.lastConnectCount = lastConnectCount;
    }

    public boolean isPushOk() {
        return pushOk;
    }

    public void setPushOk(boolean pushOk) {
        this.pushOk = pushOk;
    }

    public boolean isConnectOk() {
        return connectOk;
    }

    public void setConnectOk(boolean connectOk) {
        this.connectOk = connectOk;
    }
}
