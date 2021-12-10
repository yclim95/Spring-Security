package com.knowyourneighborhood;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.knowyourneighborhood.exception.StoreNotFoundException;
import com.knowyourneighborhood.model.Store;

@Controller
public class StoreController {
	private static Logger logger = LoggerFactory.getLogger(StoreController.class);

	@Autowired
	private StoreService storeService;
	
	@GetMapping("/")
	public String welcome() {
	    return "index";
	}
	
	@GetMapping("/viewStore")
	public String viewStore(Model model) throws StoreNotFoundException {
		logger.debug("Logger: Store Controller - View All Store");
		List <Store> listStore = storeService.listAll();
		String view = "view-store";
		System.out.println("Get All Store Result from Controller " + listStore.toString() + " " + listStore.size());
		if (CollectionUtils.isEmpty(listStore)) {throw new StoreNotFoundException("Store Not Found!");}
		else {model.addAttribute("listStore", listStore);}
		return view;
	}
	
	@GetMapping("/stores")
	public String viewStoreParam(Model model, @RequestParam(required = false) String keyword){
		try {
			
		}catch(NullPointerException e){
			
		}finally {
			model.addAttribute("error_url_message","URL does not exist!");
		}
		return "view-store";
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
