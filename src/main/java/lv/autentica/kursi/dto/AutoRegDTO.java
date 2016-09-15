package lv.autentica.kursi.dto;

import lv.autentica.kursi.entity.AutoRegEntity;
import lv.autentica.kursi.entity.KeeperEntity;
import lv.autentica.kursi.entity.ColorEntity;

/**
 * Created by emsii on 15/09/16.
 */
public class AutoRegDTO
{
    private Long id;
    private String brand;
    private String number;
    private Integer colorId;
    private Integer keeperId;

    private KeeperEntity keeper;

    private ColorEntity color;

    public AutoRegDTO()
    {

    }

    public AutoRegDTO(AutoRegEntity autoRegEntity)
    {
        setId(autoRegEntity.getId());
        setBrand(autoRegEntity.getBrand());
        setNumber(autoRegEntity.getNumber());
        setColorId(autoRegEntity.getColorId());
        setKeeperId(autoRegEntity.getKeeperId());

    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getBrand()
    {
        return brand;
    }

    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    public String getNumber()
    {
        return number;
    }

    public void setNumber(String number)
    {
        this.number = number;
    }

    public Integer getColorId()
    {
        return colorId;
    }

    public void setColorId(Integer colorId)
    {
        this.colorId = colorId;
    }

    public Integer getKeeperId()
    {
        return keeperId;
    }

    public void setKeeperId(Integer keeperId)
    {
        this.keeperId = keeperId;
    }

    public KeeperEntity getKeeper()
    {
        return keeper;
    }

    public void setKeeper(KeeperEntity keeper)
    {
        this.keeper = keeper;
    }

    public ColorEntity getColor()
    {
        return color;
    }

    public void setColor(ColorEntity color)
    {
        this.color = color;
    }
}
