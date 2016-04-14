package Model;

import java.sql.SQLException;

import DAO.UsuarioDAO;
import TO.UsuarioTO;

public class Usuario {
	private String nome;
	private String senha;
	private long conta;
	private long agencia;
	private double saldo;

	public Usuario(){
		
		
	}
	public Usuario(long conta) {
		super();
		this.conta = conta;
	}

	public Usuario(long agencia, long conta, String senha){
		this.agencia= agencia;
		this.conta = conta;
		this.senha = senha;
		
		
	}
	public Usuario(long agencia, long conta){
		this.agencia= agencia;
		this.conta = conta;
	}
	
	public Usuario(String nome, String senha, long conta, long agencia, double saldo) {
		super();
		this.nome = nome;
		this.senha = senha;
		this.conta = conta;
		this.agencia = agencia;
		this.saldo = saldo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public long getConta() {
		return conta;
	}

	public void setConta(long conta) {
		this.conta = conta;
	}

	public long getAgencia() {
		return agencia;
	}

	public void setAgencia(long agencia) {
		this.agencia = agencia;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public void carrega() throws SQLException {
		UsuarioDAO dao = new UsuarioDAO();
		UsuarioTO to = dao.carregar(getConta());

		setAgencia(to.getAgencia());
		setConta(to.getConta());
		setNome(to.getNome());
		setSaldo(to.getSaldo());
		setSenha(to.getSenha());

	}
	public void efetuarSaque(double vlrSacado) throws SQLException {
		UsuarioDAO dao = new UsuarioDAO();
		UsuarioTO to = dao.carregar(getConta());
		dao.efetuarSaque(to, vlrSacado);
		setSaldo(to.getSaldo());
	}

	public void atualiza() throws SQLException {

		UsuarioDAO dao = new UsuarioDAO();
		UsuarioTO to = new UsuarioTO();

		to.setSaldo(saldo);
		to.setConta(conta);

		dao.efetuarSaque(to, 10); // Colocado 10 em hard code pois ainda não
									// tenho como pegar o valor através de
									// janela
	}

	public double saldo() throws SQLException {
		UsuarioTO to = new UsuarioTO();
		UsuarioDAO dao = new UsuarioDAO();

		return dao.saldo(to);

	}
	public void autenticar(){
		
		
	}
	public void transferir(long agencia, long conta, double valor){
		
		
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (conta != other.conta)
			return false;
		if (agencia != other.agencia)
			return false;
		if (saldo != other.saldo)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	/*
	 * public void efetuarSaque(double vlrSacado) { UsuarioDAO dao = new
	 * UsuarioDAO(); UsuarioTO to = new UsuarioTO(); to.setSaldo(saldo);
	 * to.setConta(conta); try { dao.efetuarSaque(to, vlrSacado); } catch
	 * (SQLException e) { e.printStackTrace(); } }
	 */

}
