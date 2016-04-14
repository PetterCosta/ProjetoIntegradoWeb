package Test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ //UsuarioDAOTest.class, 
	UsuarioTest.class, UsuarioTOTest.class, ConnectionFactoryTest.class })
public class AllTests {

}