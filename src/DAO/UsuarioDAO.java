package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import TO.UsuarioTO;
import Factory.ConnectionFactory;

public class UsuarioDAO {

	UsuarioTO to;

	public double saldo(UsuarioTO to) throws SQLException {

		String sqlSelect = "SELECT * FROM conta c WHERE c.conta = ?";

		double a = 1;

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {

			stm.setLong(1, to.getConta());

			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next())

					a = rs.getDouble("saldo");

			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}

		return a;

	}

	public UsuarioTO carregar(long conta) throws SQLException {
		to = new UsuarioTO();

		String sqlSelect = "SELECT agencia, conta, nome, saldo, senha FROM conta c WHERE c.conta = ?";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {

			stm.setLong(1, conta);

			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					to.setAgencia(rs.getLong("agencia"));
					to.setConta(rs.getLong("conta"));
					to.setNome(rs.getString("nome"));
					to.setSaldo(rs.getLong("saldo"));
					to.setSenha(rs.getString("senha"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return to;
	}

	public void efetuarSaque(UsuarioTO to, double vlrSacado) throws SQLException {

		double saldo = saldo(to);

		System.out.println(saldo);

		to.setSaldo(saldo - vlrSacado);

		System.out.println(to.getSaldo());

		String sqlUpdate = "UPDATE conta c SET c.saldo = ? WHERE c.conta = ?";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setDouble(1, to.getSaldo());
			stm.setLong(2, to.getConta());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
