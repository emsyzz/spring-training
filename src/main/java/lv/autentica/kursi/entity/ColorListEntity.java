package lv.autentica.kursi.entity;

import javax.persistence.*;

/**
 * Created by maksims.senko on 2016.09.13..
 */
@Entity
@Table(name = "color_list", schema = "public", catalog = "cars_db")
public class ColorListEntity  {
    private Long id;
    private String colorName;

    @Id
    @Column(name = "\"ID\"", nullable = false, insertable = true, updatable = true)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "\"COLOR_NAME\"", nullable = false, insertable = true, updatable = true, length = 50)
    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ColorListEntity that = (ColorListEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (colorName != null ? !colorName.equals(that.colorName) : that.colorName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (colorName != null ? colorName.hashCode() : 0);
        return result;
    }
}
