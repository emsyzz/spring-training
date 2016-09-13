package lv.autentica.kursi.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.*;


@Controller
public class HomeController {

	@RequestMapping(value={"", "/", "/home"}, method = RequestMethod.GET)
	public String home(ModelMap model) {

		return "views/homepage";
	}
}