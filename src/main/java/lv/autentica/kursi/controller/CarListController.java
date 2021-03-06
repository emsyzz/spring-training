package lv.autentica.kursi.controller;

import lv.autentica.kursi.dao.*;
import lv.autentica.kursi.dto.*;
import lv.autentica.kursi.entity.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by maksims.senko on 2016.09.13..
 */
@Controller
public class CarListController {

    @Inject
    private AutoRegDAO autoRegDAO;

    @Inject
    private KeeperDAO keeperDAO;

    @Inject
    private ColorDAO colorDAO;

    @RequestMapping(value="/car-list", method = RequestMethod.GET)
    public String getCarList(ModelMap model) {

        List<AutoRegEntity> autoRegList = autoRegDAO.findAll();

        List<AutoRegDTO> autoRegDtoList = new ArrayList<>();

        for (AutoRegEntity autoRegEntity : autoRegList) {
            AutoRegDTO autoRegDto = new AutoRegDTO(autoRegEntity);

            autoRegDto.setKeeper(keeperDAO.getKeeperById(autoRegDto.getKeeperId().longValue()));
            autoRegDto.setColor(colorDAO.getColorById(autoRegDto.getColorId().longValue()));

            autoRegDtoList.add(autoRegDto);
        }

        model.addAttribute("carList", autoRegDtoList);

        return "views/car-list";
    }

    @RequestMapping(value="/delete-car", method = RequestMethod.GET)
    public String deleteCar(ModelMap model,
                                  @RequestParam("carId") Long carId) {

        AutoRegEntity car = autoRegDAO.getCarById(carId);
        autoRegDAO.delete(car);

        model.addAttribute("carDeletedMsg", "Ieraksts veiksmīgi izdzēsts!");
        return getCarList(model);
    }

    @RequestMapping(value="/add-car", method = RequestMethod.GET)
    public String addCar(ModelMap model) {

        model.addAttribute("carEntity", new AutoRegEntity());

        this.addCarFormAttributes(model);

        return "views/car-edit";
    }

    @RequestMapping(value="/edit-car", method = RequestMethod.GET)
    public String editCar(ModelMap model,
                          @RequestParam("carId") Long carId) {


        model.addAttribute("carEntity", autoRegDAO.getCarById(carId));

        this.addCarFormAttributes(model);

        return "views/car-edit";
    }

    @RequestMapping(value="/save-car", method = RequestMethod.POST)
    public String saveCar(ModelMap model,
                          @ModelAttribute("carEntity") AutoRegEntity carEntity) {

        autoRegDAO.save(carEntity);

        model.addAttribute("carSaveMsg", "Ieraksts veiksmīgi saglabāts!");

        this.addCarFormAttributes(model);

        return "views/car-edit";
    }

    private void addCarFormAttributes(ModelMap model)
    {
        model.addAttribute("keeperList", keeperDAO.findAll());

        model.addAttribute("colorList", colorDAO.findAll());
    }

}
