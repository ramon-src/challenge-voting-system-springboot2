package setup;

import org.junit.Before;

import com.java.challenge.Loader;
import com.java.challenge.voting_system.domain.user.User;

public class SuiteTest {

	@Before
	public void initialize() {
		Loader.initDependencies();
		User user = new User();
		Loader.setUser(user);
	}
	
}