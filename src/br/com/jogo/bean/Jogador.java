package br.com.jogo.bean;

public class Jogador {
	
	//Atributos
	
	private String nickname; //unique
	
	private int codePlayer; //chave primária
	
	private String typePlayer;
	
	private String modeGame;
	
	private String armament;
	
	
	//Construtor
	
	public Jogador() {}

	public Jogador(String nickname, int codePlayer, String typePlayer, String modeGame, String armament) {
		this.nickname = nickname;
		this.codePlayer = codePlayer;
		this.typePlayer = typePlayer;
		this.modeGame = modeGame;
		this.armament = armament;
	}

	@Override
	public String toString() {
		return nickname + "\n" + codePlayer + "\n" + typePlayer + "\n" + modeGame + "\n" + armament;
	}
	
	//Get&Set

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getCodePlayer() {
		return codePlayer;
	}

	public void setCodePlayer(int codePlayer) {
		this.codePlayer = codePlayer;
	}

	public String getTypePlayer() {
		return typePlayer;
	}

	public void setTypePlayer(String typePlayer) {
		this.typePlayer = typePlayer;
	}

	public String getModeGame() {
		return modeGame;
	}

	public void setModeGame(String modeGame) {
		this.modeGame = modeGame;
	}

	public String getArmament() {
		return armament;
	}

	public void setArmament(String armament) {
		this.armament = armament;
	}
	
	
	
	
	

}
