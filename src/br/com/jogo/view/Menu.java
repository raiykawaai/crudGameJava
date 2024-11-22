/**
 * 
 */
package br.com.jogo.view;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.jogo.bean.Jogador;
import br.com.jogo.bo.JogadorBo;
import br.com.jogo.exception.NaoEncontradoException;
import br.com.jogo.factory.ConnectionFactory;

/**
 * @author raiyi
 *
 */
public class Menu {
	
	
		public static void main (String[] args) throws ClassNotFoundException, SQLException, NaoEncontradoException {
		
			
		int menu = 0;
			
	    while (menu != 7){
	    	menu = Integer.parseInt(JOptionPane.showInputDialog(" ---------MENU---------"
					  + "\n1 - Cadastrar Jogador"
					  + "\n2 - Listar Jogador"
					  + "\n3 - Pesquisar por Código de Jogador"
					  + "\n4 - Editar Jogador"
					  + "\n5 - Remover Jogador"
					  + "\n6 - Pesquisar por Nickname de Jogador"
					  + "\n7 - Sair"
					  + "\n\nDigite a opção desejada: "));
	    	
	    	Connection conexao = null;
	    	
			
	    	conexao = ConnectionFactory.getConnection();
        	
			JogadorBo bo = new JogadorBo(conexao);
		    	
				switch (menu){

		            case 1:
		            	
		            	String nickname = JOptionPane.showInputDialog("Crie um nome para o jogador: ");
		          
		            	String typePlayer = null;
		            	int opcaoPersonagem = 0;
		            	opcaoPersonagem = Integer.parseInt(JOptionPane.showInputDialog("Digite o tipo de personagem: "
		            			+ "\nWraith (mulher)  máfia: Pacto de Varsóvia  			==>  1 "
		            			+ "\nRoze   (mulher)  máfia: Shadow             			==>  2 "
		            			+ "\nBale    (homem)  máfia: Spetsnaz           			==>  3 "
		            			+ "\nGaz     (homem)  máfia: Sas                			==>  4 "));
		            		
		            		switch (opcaoPersonagem){
	            		
		            			case 1:
				            		
				            			typePlayer = "Wraith";
				            			
				            		break;
				            	case 2:
				        
				            			typePlayer = "Roze";
				            			
				            		break;
				            	case 3:
				            			
				            			typePlayer = "Bale";
				            			
				            		break;
				            	case 4:
				            			
				           			     typePlayer = "Gaz";
				            		
				            		break;
				            	
		            		}	
	            		String modeGame = null;
				        int opcaoModoJogo = 0;
            			opcaoModoJogo  = Integer.parseInt(JOptionPane.showInputDialog("Digite o modo de jogo: "
            					   + "\nBattle Royale ==>  1"
            					   + "\nRessurgência  ==>  2"));
            			
		            		switch (opcaoModoJogo){
			            		
		            			case 1:
				            		
				            			modeGame = "Battle Royale";
				            			
				            		break;
				            	case 2:
				        
				            			modeGame = "Ressurgência";
				            			
				            		break;
		            		}
		            		
				        String armament = null;
						int opcaoArmamento = 0;
            			opcaoArmamento = Integer.parseInt(JOptionPane.showInputDialog("Digite o armamento: "
            	                + "\nFuzil de Assalto e Submetralhadora  ==>  1"
            	                + "\nSubmetralhadora  e Sniper           ==>  2"
            	                + "\nFuzil de Assalto e Escopeta         ==>  3"));
            				switch (opcaoArmamento){
	            		
		            			case 1:
				            			armament = "Fuzil de Assalto e Submetralhadora";
				            			
				            		break;
		            			case 2:
				            			armament = "Submetralhadora  e Sniper ";
				            			
				            		break;
		            			case 3:
		            				armament = "Fuzil de Assalto e Escopeta";
				            
				        			break;
            				}
		            	
		        		Jogador jogador = new Jogador(nickname, 0, typePlayer, modeGame, armament);
		        		
		        	
    	        		bo.cadastrarJogador(jogador);
    	        		System.out.println("Jogador cadastrado!");
		            	break;
		            case 2:
		            	List<Jogador> jogadores = bo.listarJogador();
		    
		                for(Jogador j: jogadores) {
		                	System.out.println(j);
		                }
		                break;
		            case 3:
		            	//teste os codigos de jogador do sql
		            	int codplay = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do jogador: "));
		            	System.out.println(bo.pesquisarCode(codplay));
		            	
		            	
		            	break;
		            case 4:
		            	
		            	int codigoPlay = Integer.parseInt(JOptionPane.showInputDialog("Digite o código de jogador: "));
		            	
		            	bo.pesquisarCode(codigoPlay);
		            	
		            	System.out.println(bo.pesquisarCode(codigoPlay));
		            	
		            	typePlayer = null;
		            	int opcaoPersonagem2 = 0;
		            	opcaoPersonagem2 = Integer.parseInt(JOptionPane.showInputDialog("Digite o tipo de personagem: "
		            			+ "\nWraith (mulher)  máfia: Pacto de Varsóvia  			==>  1 "
		            			+ "\nRoze   (mulher)  máfia: Shadow             			==>  2 "
		            			+ "\nBale    (homem)  máfia: Spetsnaz           			==>  3 "
		            			+ "\nGaz     (homem)  máfia: Sas                			==>  4 "));
		            		
		            		switch (opcaoPersonagem2){
	            		
		            			case 1:
				            		
				            			typePlayer = "Wraith";
				            			
				            		break;
				            	case 2:
				        
				            			typePlayer = "Roze";
				            			
				            		break;
				            	case 3:
				            			
				            			typePlayer = "Bale";
				            			
				            		break;
				            	case 4:
				            			
				           			     typePlayer = "Gaz";
				            		
				            		break;
		            		}	
		            		
	            		modeGame = null;
				        int opcaoModoJogo2 = 0;
            			opcaoModoJogo2  = Integer.parseInt(JOptionPane.showInputDialog("Digite o modo de jogo: "
            					   + "\nBattle Royale ==>  1"
            					   + "\nRessurgência  ==>  2"));
            			
		            		switch (opcaoModoJogo2){
			            		
		            			case 1:
				            		
				            			modeGame = "Battle Royale";
				            			
				            		break;
				            	case 2:
				        
				            			modeGame = "Ressurgência";
				            			
				            		break;
		            		}
		            		
				        armament = null;
						int opcaoArmamento2 = 0;
            			opcaoArmamento2 = Integer.parseInt(JOptionPane.showInputDialog("Digite o armamento: "
            	                + "\nFuzil de Assalto e Submetralhadora  ==>  1"
            	                + "\nSubmetralhadora  e Sniper           ==>  2"
            	                + "\nFuzil de Assalto e Escopeta         ==>  3"));
            				switch (opcaoArmamento2){
	            		
		            			case 1:
				            			armament = "Fuzil de Assalto e Submetralhadora";
				            			
				            		break;
		            			case 2:
				            			armament = "Submetralhadora  e Sniper ";
				            			
				            		break;
		            			case 3:
		            				armament = "Fuzil de Assalto e Escopeta";
				            
				        			break;
            				}
		            	
		        	    jogador = new Jogador(null, codigoPlay, typePlayer, modeGame, armament);
		    	        		
		    	        bo.editarJogador(jogador);
		    	        System.out.println("Jogador editado com sucesso!");
		        	    break;
		            case 5:
		             	int codigoJog = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do jogador para removê-lo: "));
		                bo.removerJogador(codigoJog);
		                System.out.println("Jogador removido!");
		                break;
		            case 6:
		            	
		            		String nic = JOptionPane.showInputDialog("Digite o nickname do jogador: ");
		            		
		            		bo.pesquisarNick(nic);
		            		System.out.println(bo.pesquisarNick(nic));
		         
		                break; 
		            	 
		    
		         }
		         conexao.close();
		         
				}
			

	    }
		
	    } 
		


	
	
	

