package workshop.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path={"/", "/index.html"})
public class DovController {

	@Autowired
	@Qualifier("instanceName")
	String instanceName;

	@Autowired
	@Qualifier("instanceHash")
	String instanceHash;

	@Autowired
	RandomImage randomImages;

	@GetMapping(produces="text/html")
	public String index(Model model, 
			@RequestParam(defaultValue="4", name="num") Integer num) {

		Object[] images = randomImages.getImages(num);

		model.addAttribute("instanceName", instanceName)
			.addAttribute("instanceHash", instanceHash)
			.addAttribute("images", images);

		return ("index");
	}
}

