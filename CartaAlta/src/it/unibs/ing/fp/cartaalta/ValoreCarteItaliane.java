package it.unibs.ing.fp.cartaalta;

/**
 * ENUM per rappresentare le varie carte da gioco italiane
 * 
 * @author Stefano Valloncini
 * @see <https://github.com/xStevatt/FondamentiDiProgrammazione>
 */
public enum ValoreCarteItaliane implements ValoreCarta
{
	ASSO(13, "ASSO"),
	DUE(2, "DUE"),
	TRE(3, "TRE"),
	QUATTRO(4, "QUATTRO"),
	CINQUE(5, "CINQUE"),
	SEI(6, "SEI"),
	SETTE(7, "SETTE"),
	FANTE(8, "FANTE"),
	CAVALLO(9, "CAVALLO"),
	RE(10, "RE");
	
	int valore; 
	String nome; 
	
	private ValoreCarteItaliane(int valore, String nome)
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
