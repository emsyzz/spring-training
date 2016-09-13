package lv.autentica.kursi.controller;


import javax.inject.Inject;

import lv.autentica.kursi.dao.AutoRegDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.*;


@Controller
public class HomeController {

	@Inject
	private AutoRegDAO autoRegDAO;

	@RequestMapping(value={"", "/", "/home"}, method = RequestMethod.GET)
	public String home(ModelMap model) {

		return "views/homepage";
	}

	@RequestMapping(value="/car-list", method = RequestMethod.GET)
	public String getFilmList(ModelMap model) {

		model.addAttribute("carList", autoRegDAO.findAll());
		return "views/car-list";
	}

}