package com.pureboyz.todolist.index.act;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class IndexAct
{
	@RequestMapping(value= {"", "/"})
	public String Index()
	{
		return "/Index";
	}
}
