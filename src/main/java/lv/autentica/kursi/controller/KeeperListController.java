package lv.autentica.kursi.controller;

import lv.autentica.kursi.dao.*;
import lv.autentica.kursi.dto.AutoRegDTO;
import lv.autentica.kursi.entity.AutoRegEntity;
import lv.autentica.kursi.entity.ColorEntity;
import lv.autentica.kursi.entity.KeeperEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;


@Controller
public class KeeperListController
{

    @Inject
    private KeeperDAO keeperDAO;

    @RequestMapping(value="/keeper-list", method = RequestMethod.GET)
    public String getKeeperList(ModelMap model,
                                @RequestParam(value = "noCars",
                                              defaultValue = "false",
                                              required = false) boolean findWithoutCars) {

        List<KeeperEntity> keeperList;

        if (findWithoutCars) {
            keeperList = keeperDAO.getKeepersWithoutCars();
        } else {
            keeperList = keeperDAO.findAll();
        }

        model.addAttribute("onlyWithoutCars", findWithoutCars);
        model.addAttribute("keeperList", keeperList);

        return "views/keeper-list";
    }

    @RequestMapping(value="/keeper-list/no-cars", method = RequestMethod.GET)
    public String getKeeperListWithoutCars(ModelMap model) {

        List<KeeperEntity> keeperList = keeperDAO.findAll();

        model.addAttribute("keeperList", keeperList);

        return "views/keeper-list";
    }
/*
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

        return "views/car-edit";
    }

    @RequestMapping(value="/edit-car", method = RequestMethod.GET)
    public String editCar(ModelMap model,
                          @RequestParam("carId") Long carId) {

        model.addAttribute("carEntity", autoRegDAO.getCarById(carId));

        return "views/car-edit";
    }

    @RequestMapping(value="/save-car", method = RequestMethod.POST)
    public String saveCar(ModelMap model,
                          @ModelAttribute("carEntity") AutoRegEntity carEntity) {

        if (null == carEntity.getId()) {

        }

        autoRegDAO.save(carEntity);
        model.addAttribute("carSaveMsg", "Ieraksts veiksmīgi saglabāts!");
        return "views/car-edit";
    }*/
}
