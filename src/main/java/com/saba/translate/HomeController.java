package com.saba.translate;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.saba.process.PhrasalLexicon;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private PhrasalLexicon phrasalLexicon;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	/*@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}*/
	
	@RequestMapping(value="/es/{input}", method= RequestMethod.GET)
	public String getEnglishTranslation(@PathVariable("input") String input,Locale locale, Model model){
		model.addAttribute("englishTranslation", phrasalLexicon.getTranslation(input));
		return "home";
	}
	
	@RequestMapping(value="/en/{input}", method= RequestMethod.GET)
	public String getSpanishTranslation(@PathVariable("input") String input,Locale locale, Model model){
		model.addAttribute("spanishTranslation", phrasalLexicon.getTranslationEtoF(input));
		return "spanishhome";
	}
	
}
