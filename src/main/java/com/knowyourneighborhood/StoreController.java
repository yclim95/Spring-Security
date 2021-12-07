package com.knowyourneighborhood;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.knowyourneighborhood.model.Store;

@Controller
public class StoreController {
	
	@Autowired
	private StoreService storeService;
	
	@GetMapping("/")
	public String welcome() {
	    return "index";
	}
	
	@GetMapping("/viewStore")
	public ModelAndView viewStore() {
		List <Store> listStore = storeService.listAll();
		ModelAndView mav = new ModelAndView("view-store");
		mav.addObject("listStore", listStore);
		return mav;
	}
	
	@GetMapping("/registerStore")
	public ModelAndView getRegisterStore(Map<String, Object> model) {
		// For later form Posting Purpose
		Store store = new Store();
		model.put("store", store);
		ModelAndView mav = new ModelAndView("store-register");
		return mav;
	}
	
	
	@PostMapping(value = "/save")
	public String saveStore(@ModelAttribute("store") Store store) {
		storeService.save(store);
		return "redirect:/viewStore";
	}
	
	@RequestMapping("/edit")
	public ModelAndView editStoreForm(@RequestParam long id) {
		ModelAndView mav = new ModelAndView("edit-store");
		Store store = storeService.get(id);
		mav.addObject("store", store);
		return mav;
	}
	
	@RequestMapping("/delete")
	public String deleteStoreForm(@RequestParam long id) {
		storeService.delete(id);
		return "redirect:/viewStore";
	}
	
	@RequestMapping("/search")
	public ModelAndView search(@RequestParam String keyword) {
		List<Store> result = storeService.search(keyword);
		ModelAndView mav = new ModelAndView("search");
		mav.addObject("result", result);
		return mav;
	}
}
