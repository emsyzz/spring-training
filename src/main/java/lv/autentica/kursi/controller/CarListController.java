package lv.autentica.kursi.controller;

import lv.autentica.kursi.dao.AutoRegDAO;
import lv.autentica.kursi.dao.AutoRegDAOImpl;
import lv.autentica.kursi.entity.AutoRegEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;


/**
 * Created by maksims.senko on 2016.09.13..
 */
@Controller
public class CarListController {

    @Inject
    private AutoRegDAO autoRegDAO;

    @RequestMapping(value="/car-list", method = RequestMethod.GET)
    public ModelAndView getCarList() {

        return  new ModelAndView("views/car-list","carList",autoRegDAO.findAll());
    }

    @RequestMapping(value="/delete-car", method = RequestMethod.GET)
    public ModelAndView deleteCar(ModelMap model,
                                  @RequestParam("carId") Long carId) {

        AutoRegEntity car = autoRegDAO.getCarById(carId);
        autoRegDAO.delete(car);

        model.addAttribute("carDeletedMsg", "Ieraksts veiksmīgi izdzēsts!");
        return getCarList();
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

        autoRegDAO.save(carEntity);
        model.addAttribute("carSaveMsg", "Ieraksts veiksmīgi saglabāts!");
        return "views/car-edit";
    }
}
