package spluslat.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import spluslat.data.CommonData;
import spluslat.utility.LoggerWrapper;

@RestController
public class SampleController {
	private LoggerWrapper logger = LoggerWrapper.getLogger(SampleController.class);
	@Data
	class SampleResponse {
		private String id;
		private String message;
	}

	@GetMapping("hello")
	public ResponseEntity<SampleResponse> hello(@RequestParam(name = "name", defaultValue = "Guest") String name, CommonData commonData) {
		logger.debug(commonData, "hello." + name);
		var res = new SampleResponse();
		res.setId("1");
		res.setMessage("Hello, World!" + name);
		return ResponseEntity.ok(res);
	}
	
	@GetMapping("res_error")
    public ResponseEntity<SampleResponse> resError(@RequestParam(name = "name", defaultValue = "Guest") String name, CommonData commonData) throws Exception {
	    commonData.setCustom2(123456789);
        logger.debug(commonData, "resError." + name);
        throw new Exception("ぬわーー");
    }
}
