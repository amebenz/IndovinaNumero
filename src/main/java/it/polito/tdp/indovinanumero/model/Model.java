package it.polito.tdp.indovinanumero.model;

import java.security.InvalidParameterException;

public class Model {

	private final int NMAX = 100;
	private final int TMAX = 8;
	private int segreto;
	private int tentativiFatti;
	private boolean inGioco = false;
	
	public Model(){
		this.inGioco=false;
		this.tentativiFatti=0;
	}
	
	

	public int getSegreto() {
		return segreto;
	}

	public int getTMAX() {
		return TMAX;
	}

	public int getTentativiFatti() {
		return tentativiFatti;
	}

	public void nuovaPartita() {
		this.segreto = (int)(Math.random() * NMAX) + 1;
    	this.tentativiFatti = 0;
    	this.inGioco = true; 
	}
	
	public int tentativo(int tentativo) {
		if(!inGioco)
			throw new IllegalStateException("La partita è già terminata!\n");
		
		if(!tentativoValido(tentativo))
			throw new InvalidParameterException("Inserisci numero tra 1 ed "+NMAX+"!\n");
		
		this.tentativiFatti ++;
		
		if(this.tentativiFatti==TMAX) {
			this.inGioco=false;
		}
		
		if(tentativo==this.segreto) {
			this.inGioco=false;
			return 0;
		}
		
		if(tentativo<this.segreto)
			return -1;
		else
			return 1;
		
	}
	
	private boolean tentativoValido(int tentativo) {
		if(tentativo<1 || tentativo > NMAX)
			return false;
		else
			return true;
	}
}
