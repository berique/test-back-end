package se.vert.chuck.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import se.vert.chuck.model.ChuckModel;
import se.vert.chuck.service.ChuckService;

@RestController()
public class ChuckAPI {
    @Autowired
    private ChuckService chuckService;

    @RequestMapping(value = "/random", method = RequestMethod.GET)
    public ChuckModel random() {
        return chuckService.obtainRandom();
    }
}
