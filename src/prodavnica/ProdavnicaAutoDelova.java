package prodavnica;

import prodavnica.gume.Guma;
import prodavnica.gume.VrstaGume;

public class ProdavnicaAutoDelova {
	
	private Guma[] ponudaGuma;
	
	public ProdavnicaAutoDelova() {
		ponudaGuma = new Guma[200];
	}
	
	public void pretrazi(VrstaGume vrsta, int sirina, int visina, int precnik) {
		int brojac = 0;
		
		for (int i=0;i<ponudaGuma.length;i++)
			if (ponudaGuma[i] != null && ponudaGuma[i].getVrstaGume() == vrsta &&
			ponudaGuma[i].getSirina() == sirina && ponudaGuma[i].getVisina() == visina &&
			ponudaGuma[i].getPrecnik() == precnik) {
				System.out.println( ponudaGuma[i] );
				brojac++;
			}
		
		if (brojac == 0) System.out.println("NEMA");
	}
	
	public void unesiGumu(Guma g) {
		//Prvo se trazi ista ta guma i, ako se nadje, dodaje na stanje i prekida metoda
		for (int i=0;i<ponudaGuma.length;i++)
			if (ponudaGuma[i] != null && ponudaGuma[i].equals(g)) {
				int novoStanje = ponudaGuma[i].getStanje() + g.getStanje();
				ponudaGuma[i].setStanje(novoStanje);
				return;
			}
		
		//Ako se doslo do ove tacke, znaci da ne postoji ista guma i dodaje se kao nova
		for (int i=0;i<ponudaGuma.length;i++)
			if (ponudaGuma[i] == null) {
				ponudaGuma[i] = g;
				return;
			}
	
	}
	
	public Guma[] sastaviSpisakZaNabavku() {
		int brojac = 0;
		
		//Prebrojavanje koliko ima marki/modela guma koje treba naruciti
		for (int i=0;i<ponudaGuma.length;i++)
			if (ponudaGuma[i] != null && ponudaGuma[i].getStanje() <= 2) 
				brojac++;
		
		//Ako nema nijedna, metoda vraca null
		if (brojac == 0) return null;
		
		//Inicijalizuje se povratni niz na tacan kapacitet i popunjava
		Guma[] spisak = new Guma[brojac];
		
		brojac = 0;
		
		for (int i=0;i<ponudaGuma.length;i++)
			if (ponudaGuma[i] != null && ponudaGuma[i].getStanje() <= 2) {
				spisak[brojac] = ponudaGuma[i];
				brojac++;
			}				

		return spisak;		
	}

}
