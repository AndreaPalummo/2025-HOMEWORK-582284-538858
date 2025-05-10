package it.uniroma3.diadia;

public class IOSimulator implements IO{
	private static final int GRANDEZZA_SEQUENZA_DEFAULT = 100;
	
	private String[] output;
	private String[] input;
	private int indiceOutput;
	private int indiceInput;

	public IOSimulator(){
		this.output = new String[GRANDEZZA_SEQUENZA_DEFAULT];
		this.input = new String[GRANDEZZA_SEQUENZA_DEFAULT];
		this.indiceInput=0;
		this.indiceOutput=0;
	}

	@Override
	public void mostraMessaggio(String messaggio) {
		this.output[indiceOutput++] = messaggio;
	}

	@Override
	public String leggiRiga() {
		return this.input[indiceInput++];
	}
	
	public String getOutput() {
		return this.toString();
	}
	
	public void setInput(String...parametri) {
		this.input= parametri;
	}
	
	public boolean hasParola(String parolaDaCercare) {
		boolean trovata=false;
		for(int i=0;i<this.getOutput().length();i++) {
			String cavia=this.output[i];
			if(cavia!= null && cavia.equals(parolaDaCercare))
				trovata=true;
			
		}
		return trovata;
	}
	
	public String toString() {
		StringBuilder risultato = new StringBuilder();
		for(int i=0;i<this.output.length;i++)
			if(this.output[i]!=null)
					risultato.append(this.output[i]);
		return risultato.toString();
	}
	

}