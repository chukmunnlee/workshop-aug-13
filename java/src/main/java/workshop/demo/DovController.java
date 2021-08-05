package workshop.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path={"/", "/index.html"})
public class DovController {

	@Autowired
	String instanceName;

	@Autowired
	String instanceHash;

	@GetMapping(produces="text/html")
	public String index(Model model) {

		model.addAttribute("instanceName", instanceName)
			.addAttribute("instanceHash", instanceHash);

		return ("index");
	}
}

