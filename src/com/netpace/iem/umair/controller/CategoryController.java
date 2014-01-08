package com.netpace.iem.umair.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.netpace.iem.umair.model.Category;
import com.netpace.iem.umair.repository.CategoryRepository;

@Controller
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	CategoryRepository categoryRepository;
	Category category;
	List<Category> categories;
	
	
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(ModelMap model) {
    	return new ModelAndView("category/index");
    }
    
	@RequestMapping(value="/getJson", method=RequestMethod.GET)
	@ResponseBody
	public String getJson() {
		categories = categoryRepository.findAll();

		Gson gson = new GsonBuilder()
				.excludeFieldsWithoutExposeAnnotation().create();
		String json = gson.toJson(categories);

		//System.out.println(json);
		
		return json;
	} 
	
	@RequestMapping(value="/edit", method=RequestMethod.POST)
	public String editCategory(		@RequestParam String oper,
									@RequestParam String id, 
									@RequestParam(required=false, defaultValue="") String name,
									@RequestParam(required=false) String description) {
		category = new Category();
		
		switch(oper) {
			case "del":
				categoryRepository
						.delete(Integer.parseInt(id));
				break;

			case "edit":
				category = categoryRepository.findOne(Integer.parseInt(id));

			case "add":
				category.setName(name);
				category.setDescription(description);
				categoryRepository.save(category);
			}
		
		return "category/index";
	}	
		
}
