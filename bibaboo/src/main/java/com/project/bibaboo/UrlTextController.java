package com.project.bibaboo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UrlTextController {
	
	@GetMapping("/alterList")
	public String list() {
		return"alter/alter-list";
	}
	
	@GetMapping("/alterDetail")
	public String detail() {
		return"alter/alter-detail";
	}
	
	@GetMapping("/areaTop5")
	public String top5() {
		return"alter/area-top5";
	}

}
