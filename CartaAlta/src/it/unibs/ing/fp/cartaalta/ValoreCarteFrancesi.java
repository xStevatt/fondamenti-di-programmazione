package it.unibs.ing.fp.cartaalta;

/**
 * ENUM per rappresentare le varie carte da gioco francesi
 * 
 * @author Stefano Valloncini
 * @see <https://github.com/xStevatt/FondamentiDiProgrammazione>
 */
public enum ValoreCarteFrancesi implements ValoreCarta
{
	ASSO(14, "ASSO"),
	DUE(2, "DUE"),
	TRE(3, "TRE"),
	QUATTRO(4, "QUATTRO"),
	CINQUE(5, "CINQUE"),
	SEI(6, "SEI"),
	SETTE(7, "SETTE"),
	OTTO(8, "OTTO"),
	NOVE(9, "NOVE"),
	DIECI(10, "DIECI"),
	JACK(11, "JACK"),
	DONNA(12, "DONNA"),
	RE(13, "RE");
	
	String nome;
	int valore; 
	
	private ValoreCarteFrancesi(int valore, String nome)
	{
		this.valore = valore; 
		this.nome = nome; 
	}
	
	public int getValore()
	{
		return valore; 
	}
	
	public String getNome()
	{
		return nome; 
	}
}
