package lv.autentica.kursi.entity;

import javax.persistence.*;

/**
 * Created by maksims.senko on 2016.09.15..
 */
@Entity
@Table(name = "keeper_list", schema = "public", catalog = "cars_db")
public class KeeperListEntity {

    private Long id;
    private String name;
    private String personCode;

    @Id
    @Column(name = "\"ID\"")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @Basic
    @Column(name = "\"NAME\"")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Basic
    @Column(name = "\"PERSON_CODE\"")
    public String getPersonCode() {
        return personCode;
    }

    public void setPersonCode(String personCode) {
        this.personCode = personCode;
    }
}
