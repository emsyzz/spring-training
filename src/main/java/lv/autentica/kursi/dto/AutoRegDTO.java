package lv.autentica.kursi.dto;

import lv.autentica.kursi.entity.AutoRegEntity;
import lv.autentica.kursi.entity.ColorListEntity;
import lv.autentica.kursi.entity.KeeperListEntity;

/**
 * Created by maksims.senko on 2016.09.13..
 */
public class AutoRegDTO {

    private Long id;
    private String brand;
    private String number;
    private Integer colorId;
    private Integer keeperId;

    private ColorListEntity colorEnt;
    private KeeperListEntity keeperEnt;

    public AutoRegDTO(){

    }

    public AutoRegDTO(AutoRegEntity carEntity){
        id = carEntity.getId();
        brand = carEntity.getBrand();
        number = carEntity.getNumber();
        colorId = carEntity.getColorId();
        keeperId = carEntity.getKeeperId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getColorId() {
        return colorId;
    }

    public void setColorId(Integer colorId) {
        this.colorId = colorId;
    }

    public Integer getKeeperId() {
        return keeperId;
    }

    public void setKeeperId(Integer keeperId) {
        this.keeperId = keeperId;
    }

    public ColorListEntity getColorEnt() {
        return colorEnt;
    }

    public void setColorEnt(ColorListEntity colorEnt) {
        this.colorEnt = colorEnt;
    }

    public KeeperListEntity getKeeperEnt() {
        return keeperEnt;
    }

    public void setKeeperEnt(KeeperListEntity keeperEnt) {
        this.keeperEnt = keeperEnt;
    }
}
