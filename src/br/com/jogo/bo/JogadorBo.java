package br.com.jogo.bo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.jogo.bean.Jogador;
import br.com.jogo.dao.JogadorDao;
import br.com.jogo.exception.NaoEncontradoException;

/**
 * Classe com regras de negócio e validações
 * @author Gustavo
 *
 */
public class JogadorBo {
	
	private JogadorDao jogadorDao;

	/**
	 * Construtor que recebe a conexão
	 * @param conexao
	 */
	public JogadorBo(Connection conexao) {
		jogadorDao = new JogadorDao(conexao);
	}
	
	//cadastrar jogador
	
	/**
	 * Realiza o cadastro do jogador
	 * @param jogador
	 * @throws SQLException
	 */
	public void cadastrarJogador (Jogador jogador) throws SQLException{
		jogadorDao.cadastrarJogador(jogador);
	}
	
	//listar jogador
	
	/**
	 * Listar todos os jogadores
	 * @return
	 * @throws SQLException
	 */
	public List<Jogador> listarJogador() throws SQLException{
		return jogadorDao.listarJogador();
	}
	
	//pesquisar por codigo
	
	/**
	 * Pesquisa um jogador pela PK
	 * @param codePlayer PK do jogador
	 * @return
	 * @throws SQLException
	 * @throws NaoEncontradoException
	 */
	public Jogador pesquisarCode (int codePlayer) throws SQLException, NaoEncontradoException {
		Jogador jogador = jogadorDao.pesquisarCode(codePlayer);
		return jogador;
	}
	
	//editar jogador
	
	/**
	 * Edita o jogador
	 * @param jogador Jogador que será editado
	 * @throws SQLException
	 * @throws NaoEncontradoException
	 */
	public void editarJogador(Jogador jogador) throws SQLException, NaoEncontradoException {
		jogadorDao.editarJogador(jogador);
	}
	
	//remover jogador
	
	/**
	 * Remove um jogador pela PK
	 * @param codePlayer PK do jogador
	 * @throws SQLException
	 * @throws NaoEncontradoException
	 */
	public void removerJogador(int codePlayer) throws SQLException, NaoEncontradoException{
		jogadorDao.removerJogador(codePlayer);
	}
	
	//pesquisar por nickname
	
	/**
	 * Pesquisar jogador pela UN
	 * @param nickname UN do jogador
	 * @return
	 * @throws SQLException
	 * @throws NaoEncontradoException
	 */
	public Jogador pesquisarNick(String nickname) throws SQLException, NaoEncontradoException{
		Jogador jogador = jogadorDao.pesquisarNick(nickname);
		return jogador;
	}
}

