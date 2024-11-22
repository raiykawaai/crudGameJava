package br.com.jogo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.jogo.bean.Jogador;
import br.com.jogo.exception.NaoEncontradoException;

/**
 * Classe responsável por realizar as operações com a tabela tb_jogador
 * @author Gustavo
 *
 */
public class JogadorDao {
	
	private Connection conexao;
	
	/**
	 * Construtor que recebe a conexão (injeção de dependencia)
	 * @param conexao
	 */
	public JogadorDao(Connection conexao) {
		this.conexao = conexao;
	}
	
	//cadastrar
	
	public void cadastrarJogador (Jogador jogador) throws SQLException{
		
		PreparedStatement stmt = conexao.prepareStatement("insert into tb_jogador (cd_jogador, "
				+ "nm_jogador, ds_type_jogador, ds_mode_game, ds_armament)"
				+ " values (sq_tb_jogador.nextval, ?, ?, ?, ?)");
		
		stmt.setString(1, jogador.getNickname());
		stmt.setString(2, jogador.getTypePlayer());
		stmt.setString(3, jogador.getModeGame());
		stmt.setString(4, jogador.getArmament());
		
		stmt.executeUpdate();
	}
	
	//listar
	
	
	public List<Jogador> listarJogador() throws SQLException{
		List<Jogador> lista = new ArrayList<Jogador>();
		
		
		PreparedStatement stmt = conexao.prepareStatement("select * from tb_jogador");
		ResultSet result = stmt.executeQuery();
			
			while(result.next()) {
				Jogador jogador = parse(result);
				lista.add(jogador);
			}
		
		return lista;
	}
	
	private Jogador parse(ResultSet result) throws SQLException {
		String nickname = result.getString("nm_jogador");
		int codePlayer = result.getInt("cd_jogador");
		String typePlayer = result.getString("ds_type_jogador");
		String modeGame = result.getString("ds_mode_game");
		String armament = result.getString("ds_armament");
		
		Jogador jogador = new Jogador(nickname, codePlayer, typePlayer, modeGame, armament);
		return jogador;
	}
	
	//pesquisar por código
	
	/**
	 * Pesquisa um jogador pela PK
	 * @param codePlayer PK do jogador
	 * @return Jogador com todas as informações
	 * @throws SQLException
	 * @throws NaoEncontradoException
	 */
	public Jogador pesquisarCode(int codePlayer) throws SQLException, NaoEncontradoException {
		PreparedStatement stmt = conexao.prepareStatement("select* from tb_jogador where cd_jogador = ?");
		
		stmt.setInt(1, codePlayer);
		
		ResultSet result = stmt.executeQuery();
		
		if (result.next()) {
			Jogador jogador = parse(result);
			
			return jogador;
		}else {
			throw new NaoEncontradoException("Código não encontrado!");
		}
	}
	
	/**
	 * Editar um jogador da tabela
	 * @param jogador Jogador que será editado no banco
	 * @throws SQLException
	 * @throws NaoEncontradoException
	 */
	public void editarJogador(Jogador jogador) throws SQLException, NaoEncontradoException{
		
		pesquisarCode(jogador.getCodePlayer());
		
		PreparedStatement stmt = conexao.prepareStatement("update tb_jogador set ds_type_jogador = ?, ds_mode_game = ?,"
				+ " ds_armament = ? where cd_jogador = ?");
		
		stmt.setString(1, jogador.getTypePlayer());
		stmt.setString(2, jogador.getModeGame());
		stmt.setString(3, jogador.getArmament());
		stmt.setInt(4, jogador.getCodePlayer());
		
		stmt.executeUpdate();
		
		stmt.close();	
		
	}
	
	/**
	 * Remove um jogador 
	 * @param codePlayer PK do jogador que será removido
	 * @throws SQLException
	 * @throws NaoEncontradoException
	 */
	public void removerJogador (int codePlayer) throws SQLException, NaoEncontradoException {
		
		pesquisarCode(codePlayer);
		
		PreparedStatement stmt = conexao.prepareStatement("delete from tb_jogador where cd_jogador = ?");
		
		stmt.setInt(1, codePlayer);
		
		stmt.executeUpdate();
	}
	
	//pesquisar por nickname
	
	/**
	 * Pesquisa um jogador pela UN
	 * @param nickname UN do jogador
	 * @return Jogador com todas as informações
	 * @throws SQLException
	 * @throws NaoEncontradoException
	 */
	public Jogador pesquisarNick (String nickname) throws SQLException, NaoEncontradoException {
		PreparedStatement stmt = conexao.prepareStatement("select* from tb_jogador where nm_jogador = ?");
		
		stmt.setString(1, nickname);
		
		ResultSet result = stmt.executeQuery();
		
		if (result.next()) {
			Jogador jogador = parse(result);
			
			return jogador;
		}else {
			throw new NaoEncontradoException("Nickname não encontrado!");
		}
	}
	
}