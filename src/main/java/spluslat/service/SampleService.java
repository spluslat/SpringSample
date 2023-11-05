package spluslat.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spluslat.repository.SampleRepository;

@Service
public class SampleService {
	private Logger logger = LoggerFactory.getLogger(SampleService.class);
	@Autowired
	private SampleRepository rep;

	public String getMessage() {
		logger.info("getMessage");
		return "SampleServiceMessage";
	}

	public String getMessageException() {
		logger.info("getMessageException");
		throw new ClassCastException("互換性ないYO!!");
	}

	public String getValue() {
		logger.info("getValue");
		return rep.getValue();
	}
	public void error() throws Exception {
	    throw new Exception("ぬわーー");
	}
//
//	@Transactional(rollbackFor = Exception.class)
//	public String getValueException() throws SQLException {
//		logger.info("getValueException");
//		return rep.getValueException();
//	}
//
//	@Transactional(rollbackFor = Exception.class)
//	public String getValueExceptionTryCatch() {
//		logger.info("getValueExceptionTryCatch");
//		String value = "default value";
//		try {
//			value = rep.getValueException();
//		} catch (SQLException e) {
//			logger.info("getValueExceptionTryCatch-catch." + e.getMessage());
//		}
//		return value;
//	}
	
}
