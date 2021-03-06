import java.util.*;

/**
 * Esta classe representa o placar de um jogo de Bozó. 
 * Permite que combinações de dados sejam alocadas às posições e mantém o escore de um jogador.
 * @author Breno Cunha Queiroz
 */
public class Placar {
	private int[] pontos = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
	/**
	 * Adiciona uma sequencia de dados em uma determinada posição do placar.
	 * @param posicao Posição a ser preenchida. 
	 * As posições 1 a 6 correspondem às quantidas de uns até seis, ou seja, as laterais do placar. 
	 * As outas posições são: 7 - full hand; 8 - sequencia; 9 - quadra; e 10 - quina
	 * @param dados um array de inteiros, de tamanho 5.
	 * Cada posição corresponde a um valor de um dado.
	 * Supões-se que cada dado pode ter valor entre 1 e 6.
	 * @throws IllegalArgumentException Se a posição estiver ocupada ou se for passado um valor de posição inválido, essa exceção é lançada. 
	 * Não é feita nenhuma verificação quanto ao tamanho do array nem quanto ao seu conteúdo.
	 */
	public void add(int posicao, int[] dados) throws java.lang.IllegalArgumentException {
		if(posicao<=0 || posicao>10 || pontos[posicao-1]!=-1)	
		{
			throw new IllegalArgumentException("Esta posição é inválida");
		}
		else
		{
			if(posicao<=6)
			{
				pontos[posicao-1] = 0;
				for(int i=0;i<dados.length;i++)
				{
					if(dados[i]==posicao)
					{
						pontos[posicao-1]+=posicao;
					}
				}
			}
			else
			{
				int[] somaDados= new int[6];
				for(int i=0;i<dados.length;i++)
				{
					somaDados[dados[i]-1]++;
				}
				switch(posicao)// Posicao sempre estará entre [7,10]
				{
					case 7:
						boolean iguais2 = false;// Dois dados mesmo número
						boolean iguais3 = false;// Tres dados mesmo número
						for(int i=0;i<6;i++)
						{
							if(somaDados[i]==2)
								iguais2=true;
							if(somaDados[i]==3)
								iguais3=true;
						}
						if(iguais2 && iguais3)
						{
							pontos[6]=15;
						}
						else
						{
							pontos[6]=0;
						}
						break;
					case 8:
						boolean dados1a5 = true;
						boolean dados2a6 = true;
						if(somaDados[0]!=0)
							dados1a5 = false;
						if(somaDados[5]!=0)
							dados2a6 = false;
						for(int i=0;i<6;i++)
						{
							if(somaDados[i]>=2)
							{
								dados1a5=false;
								dados2a6=false;
							}
						}
						if(dados1a5 || dados2a6)
						{
							pontos[7]=20;
						}
						else
						{
							pontos[7]=0;
						}
						break;
					case 9:
						boolean iguais4 = false;// Quatro dados mesmo número
						for(int i=0;i<6;i++)
						{
							if(somaDados[i]==4)
								iguais4=true;
						}
						if(iguais4)
						{
							pontos[8]=30;
						}
						else
						{
							pontos[8]=0;
						}
						break;
					case 10:
						boolean iguais5 = false;// Cinco dados mesmo número
						for(int i=0;i<6;i++)
						{
							if(somaDados[i]==5)
								iguais5=true;
						}
						if(iguais5)
						{
							pontos[9]=40;
						}
						else
						{
							pontos[9]=0;
						}
						break;
				}
			}
		}
	}

	/**
	 * Computa a soma dos valores obtidos, considerando apenas as posições que já estão ocupadas.
	 * @return O valor da soma.
	 */
	public int getScore() {
		int score = 0;
		for(int i=0;i<pontos.length;i++)
		{
			if(pontos[i]!=-1)
				score+=pontos[i];
		}
		return score;
	}

	/**
	 *A representação na forma de string, mostra o placar completo, 
	 indicando quais são as posições livres (com seus respectivos números) e o valor obtido nas posições já ocupadas. 
	 Por exemplo:
	 (1)    |   (7)    |   (4) 
	 --------------------------
	 (2)    |   20     |   (5) 
	 --------------------------
	 (3)    |   30     |   (6) 
	--------------------------
			|   (10)   |
			+----------+  
	mostra as posições 8 (sequencia) e 9 (quadra) ocupadas.
	 */
	@Override
	public String toString() {
		String str;
		String[] pontuacao = {"(1)","(2)","(3)","(4)","(5)","(6)","(7)","(8)","(9)","(10)"};

		// Converte pontuacao para string 
		for(int i=0;i<10;i++)
		{
			if(pontos[i]!=-1)
			{
				pontuacao[i] = Integer.toString(pontos[i]);
				pontuacao[i] += " ";
				if(pontos[i]<10)
					pontuacao[i] += " ";
				if(i==9)
					pontuacao[i] += " ";
			}
		}


		str = String.format("%s    |   %s    |   %s\n", pontuacao[0], pontuacao[6], pontuacao[3]);
		str+="--------------------------\n";
		str+= String.format("%s    |   %s    |   %s\n", pontuacao[1], pontuacao[7], pontuacao[4]);
		str+="--------------------------\n";
		str+= String.format("%s    |   %s    |   %s\n", pontuacao[2], pontuacao[8], pontuacao[5]);
		str+="--------------------------\n";
		str+= String.format("       |   %s   |      \n", pontuacao[9]);
		str+="       +----------+      \n";

		return str;
	}
}

