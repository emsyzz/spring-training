package lv.autentica.kursi.entity;

import javax.persistence.*;

/**
 * Created by maksims.senko on 2016.09.13..
 */
@Entity
@Table(name = "keeper_list", schema = "public", catalog = "cars_db")
public class KeeperListEntity {
    private Long id;
    private String name;
    private String personCode;

    @Id
    @Column(name = "\"ID\"", nullable = false, insertable = true, updatable = true)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "\"NAME\"", nullable = false, insertable = true, updatable = true, length = 200)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "\"PERSON_CODE\"", nullable = false, insertable = true, updatable = true, length = 12)
    public String getPersonCode() {
        return personCode;
    }

    public void setPersonCode(String personCode) {
        this.personCode = personCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KeeperListEntity that = (KeeperListEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (personCode != null ? !personCode.equals(that.personCode) : that.personCode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (personCode != null ? personCode.hashCode() : 0);
        return result;
    }
}
