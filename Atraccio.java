package portAventura_atraccions;

public class Atraccio implements Comparable<Atraccio> {
	//private int idAtraccio;
	private ENomAtraccio nomAtraccio;
	private ESeguretatAtraccio seguretatAtraccio;
	private int quantitatGent;
	private double alturaMin;
	
	public Atraccio(ENomAtraccio nomAtraccio,int quantitatGent, double alturaMin) {
		//this.idAtraccio = idAtraccio;
		this.nomAtraccio = nomAtraccio;
		this.quantitatGent = quantitatGent;
		this.alturaMin = alturaMin;
                atraccioSeguretat();
	}

	public ENomAtraccio getNomAtraccio() {
		return nomAtraccio;
	}

	public void setNomAtraccio(ENomAtraccio nomAtraccio) {
		this.nomAtraccio = nomAtraccio;
	}

	public ESeguretatAtraccio getSeguretatAtraccio() {
		return seguretatAtraccio;
	}

	public void setSeguretatAtraccio(ESeguretatAtraccio seguretatAtraccio) {
		this.seguretatAtraccio = seguretatAtraccio;
	}

	public int getQuantitatGent() {
		return quantitatGent;
	}

	public void setQuantitatGent(int quantitatGent) {
		this.quantitatGent = quantitatGent;
	}
	
	public double getAlturaMin() {
		return alturaMin;
	}

	public void setAlturaMin(double alturaMin) {
		this.alturaMin = alturaMin;
	}

	@Override
	public String toString() {
		return "Atraccio [nomAtraccio=" + nomAtraccio + ", seguretatAtraccio="
				+ seguretatAtraccio + ", quantitatGent=" + quantitatGent + "]";
	}

    /**
     * Aquest mètode s'encarrega d'assignar el tipus de seguretat a cada nom d'atracció.
     */
	private void atraccioSeguretat() {
		switch (nomAtraccio) {
		case DRAGON_KHAN:
			this.seguretatAtraccio = ESeguretatAtraccio.PROTECCIO_TOTAL;
			break;
		case SHAMBHALA:
			this.seguretatAtraccio = ESeguretatAtraccio.PROTECCIO_PARCIAL;
			break;
		case TUTUKI_SPLASH:
			this.seguretatAtraccio = ESeguretatAtraccio.SENSE_PROTECCIO;
			break;
		case HURAKAN_CONDOR:
			this.seguretatAtraccio = ESeguretatAtraccio.PROTECCIO_TOTAL;
			break;
		case STAMPIDA:
			this.seguretatAtraccio = ESeguretatAtraccio.PROTECCIO_PARCIAL;
			break;
			default:
				this.seguretatAtraccio = ESeguretatAtraccio.PROTECCIO_PARCIAL;
		}
	}
	
	//CompareTo que s'utilitza al main per a la ordenació de les atraccions.
	@Override
	public int compareTo(Atraccio a){
		int result=0;
		if(this.quantitatGent<a.quantitatGent) {
			result = -1;
		}else if(this.quantitatGent>a.quantitatGent) {
			result = 1;
		}else {
			if(this.quantitatGent<a.quantitatGent) {
				result=-1;
			}else if(this.quantitatGent>a.quantitatGent){
				result=1;
			}else {
				result=0;
			}
		}
		return result;
	}
}
