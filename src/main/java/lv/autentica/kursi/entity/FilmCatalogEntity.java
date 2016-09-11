package lv.autentica.kursi.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by maksims.senko on 2016.09.10..
 */
@Entity
@Table(name = "film_catalog", schema = "public", catalog = "films")
public class FilmCatalogEntity implements Serializable{
    private Long id;
    private String filmName;
    private String genres;

    @Id
    @Column(name = "ID", nullable = false, insertable = true, updatable = true)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Id
    @Column(name = "FILM_NAME", nullable = false, insertable = true, updatable = true, length = 200)
    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    @Basic
    @Column(name = "GENRES", nullable = false, insertable = true, updatable = true, length = 200)
    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FilmCatalogEntity that = (FilmCatalogEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (filmName != null ? !filmName.equals(that.filmName) : that.filmName != null) return false;
        if (genres != null ? !genres.equals(that.genres) : that.genres != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = filmName != null ? filmName.hashCode() : 0;
        result = 31 * result + (genres != null ? genres.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }
}
