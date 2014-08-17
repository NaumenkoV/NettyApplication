package org.springframework.nettyapplication.mvc;

/**
 * Created by Вадим on 16.08.2014.
 */

import org.springframework.nettyapplication.netty.PrintStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    MainService mainService = MainServiceImpl.getMainService();
    PrintStatus printStatus = new PrintStatus();
    final String redirectUrl = "redirect:http://";

	@RequestMapping("/hello")
	@ResponseBody
	public String sayHello() throws InterruptedException {
        Thread.sleep(10000);
		return "Hello world";
	}

    @RequestMapping("/redirect")
    public String redirect(@RequestParam("url") String url)
    {
        mainService.putURLRedirection(url);
        return redirectUrl + url;
    }

    @RequestMapping("/status")
    @ResponseBody
    public String getStatus() {
        return printStatus.getResult();
    }

}
