package Test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import Model.Usuario;

public class UsuarioTest {
	Usuario antes, depois;

	@Before
	public void setUp() throws Exception {
		antes = new Usuario(1);
		depois = new Usuario(1);
		
		antes.carrega();
		depois.carrega();
	}

	@Test
	public void testCarrega() throws SQLException {

		depois.carrega();

		System.out
				.println(antes.getAgencia() + " " + antes.getConta() + antes.getNome() + antes.getSaldo() + antes.getSenha());
		System.out.println(
				depois.getAgencia() + " " + depois.getConta() + depois.getNome() + depois.getSaldo() + depois.getSenha());
		assertEquals("Teste carregamento", antes, depois);
	}

	@Test
	public void testSaque() throws SQLException {

		antes.atualiza();

		System.out
				.println(antes.getAgencia() + " " + antes.getConta() + antes.getNome() + antes.getSaldo() + antes.getSenha());
		System.out.println(
				depois.getAgencia() + " " + depois.getConta() + depois.getNome() + depois.getSaldo() + depois.getSenha());

		assertEquals("Teste saque", antes, depois);

	}

}
