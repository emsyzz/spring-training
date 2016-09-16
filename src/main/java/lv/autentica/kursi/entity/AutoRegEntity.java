package lv.autentica.kursi.entity;

import javax.persistence.*;

/**
 * Created by maksims.senko on 2016.09.13..
 */
@Entity
@Table(name = "auto_reg", schema = "public", catalog = "cars_db")
public class AutoRegEntity
{
    @Id
    @Column(name = "\"ID\"")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AutoRegSeqGen")
    @SequenceGenerator(name = "AutoRegSeqGen", sequenceName = "auto_reg_id_seq", allocationSize = 1)
    private Long id;

    @Basic
    @Column(name = "\"BRAND\"")
    private String brand;

    @Basic
    @Column(name = "\"NUMBER\"")
    private String number;

    @Basic
    @Column(name = "\"COLOR_ID\"")
    private Integer colorId;

    @Basic
    @Column(name = "\"KEEPER_ID\"")
    private Integer keeperId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AutoRegEntity that = (AutoRegEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (brand != null ? !brand.equals(that.brand) : that.brand != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        return result;
    }

}
