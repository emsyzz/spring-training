package lv.autentica.kursi.controller;


import javax.inject.Inject;

import lv.autentica.kursi.dao.FilmCatalogDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.*;


@Controller
public class HomeController {

	@Inject
	private FilmCatalogDAO filmCatalogDAO;

	@RequestMapping(value={"", "/", "/home"}, method = RequestMethod.GET)
	public String home(ModelMap model) {

		return "views/homepage";
	}

	@RequestMapping(value="/film-list", method = RequestMethod.GET)
	public String getFilmList(ModelMap model) {

		model.addAttribute("filmList",filmCatalogDAO.findAll());
		return "views/film-list";
	}

}