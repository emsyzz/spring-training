package lv.autentica.kursi.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "keeper_list", schema = "public", catalog = "cars_db")
public class KeeperEntity
{
    @Id
    @Column(name = "\"ID\"")
    private Long id;

    @Basic
    @Column(name = "\"NAME\"")
    private String name;

    @Basic
    @Column(name = "\"PERSON_CODE\"")
    private String personCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPersonCode() {
        return personCode;
    }

    public void setPersonCode(String personCode) {
        this.personCode = personCode;
    }

    @OneToMany(targetEntity = AutoRegEntity.class, mappedBy = "\"KEEPER_ID\"")
    public List<AutoRegEntity> getAutoRegEntities() {

        List<AutoRegEntity> list = new ArrayList<>();

        return list;
    }

    public void setAutoRegEntities(List<AutoRegEntity> list) {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KeeperEntity that = (KeeperEntity) o;

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
