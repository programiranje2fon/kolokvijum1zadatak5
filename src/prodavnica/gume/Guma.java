package prodavnica.gume;

public class Guma {
	
	private String marka;
	
	private VrstaGume vrstaGume;
	
	private int sirina;
	
	private int visina;
	
	private int precnik;
	
	private int stanje;

	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		if (marka == null || marka.equals(""))
			System.out.println("GRESKA");
		else
			this.marka = marka;
	}

	public VrstaGume getVrstaGume() {
		return vrstaGume;
	}

	public void setVrstaGume(VrstaGume vrstaGume) {
		this.vrstaGume = vrstaGume;
	}

	public int getSirina() {
		return sirina;
	}

	public void setSirina(int sirina) {
		if (sirina < 135 || sirina > 265)
			System.out.println("GRESKA");
		else
			this.sirina = sirina;
	}

	public int getVisina() {
		return visina;
	}

	public void setVisina(int visina) {
		if (visina < 45 || visina > 85)
			System.out.println("GRESKA");
		else
			this.visina = visina;
	}

	public int getPrecnik() {
		return precnik;
	}

	public void setPrecnik(int precnik) {
		if (precnik < 13 || precnik > 19)
			System.out.println("GRESKA");
		else
			this.precnik = precnik;
	}

	public int getStanje() {
		return stanje;
	}

	public void setStanje(int stanje) {
		if (stanje < 0)
			System.out.println("GRESKA");
		else			
			this.stanje = stanje;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Guma))
			return false;
		
		Guma other = (Guma) obj;
		if (marka.equals(other.marka) && precnik == other.precnik &&
				sirina == other.sirina && visina == other.visina  &&
				vrstaGume == other.vrstaGume)
			return true;
		else
			return false;
	}

	@Override
	public String toString() {
		return "Guma [marka=" + marka + ", vrstaGume=" + vrstaGume + ", sirina=" + sirina + ", visina=" + visina
				+ ", precnik=" + precnik + ", stanje=" + stanje + "]";
	}
	
	

	

}
