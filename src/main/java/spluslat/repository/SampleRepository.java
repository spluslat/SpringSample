package spluslat.repository;

import java.sql.SQLException;

import org.springframework.stereotype.Repository;

@Repository
public class SampleRepository {
	public String getValue() {
		return "SampleRepositoryValue";
	}
	
	public String getValueException() throws SQLException {
		throw new SQLException("SQLエラーだよ!");
	}
}
