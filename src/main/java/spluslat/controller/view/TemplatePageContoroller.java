package spluslat.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import spluslat.controller.api.SampleController;
import spluslat.data.CommonData;
import spluslat.service.SampleService;
import spluslat.utility.LoggerWrapper;

@Controller
public class TemplatePageContoroller {
    private LoggerWrapper logger = LoggerWrapper.getLogger(SampleController.class);
    @Autowired
    private SampleService sampleService;

    @GetMapping("/template")
    public String index(CommonData commonData) {
        logger.info(commonData, "template");
        return "template";
    }

    @GetMapping("/view_error")
    public String error(CommonData commonData) throws Exception {
        logger.info(commonData, "view_error");
        throw new Exception("ぬわーー");
    }
}
