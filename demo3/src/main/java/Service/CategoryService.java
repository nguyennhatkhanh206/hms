package Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Model.Category;
import Untils.MongoUntils;

@RestController
@RequestMapping(value="/cate")
public class CategoryService {
	
	@Autowired
	MongoUntils mongountils;
	
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String test()
	{
		return "ok";
	}
}
