package Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Model.Usuario;

public class UsuarioTOTest {

	Usuario antes, depois;

	@Before
	public void setUp() throws Exception {
		antes = new Usuario(1);
		depois = new Usuario(1);

		antes.carrega();
		depois.carrega();
	}

	@Test
	public void testGets() {
		assertEquals("getAgencia()", antes.getAgencia(), depois.getAgencia());
		assertEquals("getConta()", antes.getConta(), depois.getConta());
		assertEquals("getNome()", antes.getNome(), depois.getNome());
		assertEquals("getSaldo()", antes.getSaldo(), depois.getSaldo(), 1);
		assertEquals("getSenha()", antes.getSenha(), depois.getSenha());
	}

	@Test
	public void testEquals() {
		assertEquals("Teste igualdade", antes, depois);
	}

}
