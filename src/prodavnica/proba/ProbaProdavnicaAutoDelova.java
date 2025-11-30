package prodavnica.proba;

import prodavnica.ProdavnicaAutoDelova;
import prodavnica.gume.Guma;
import prodavnica.gume.VrstaGume;

public class ProbaProdavnicaAutoDelova {

	public static void main(String[] args) {
		ProdavnicaAutoDelova pa = new ProdavnicaAutoDelova();
		
		Guma g1 = new Guma();
		g1.setMarka("Kleber");
		g1.setVrstaGume(VrstaGume.ZIMSKA);
		g1.setSirina(195);
		g1.setVisina(65);
		g1.setPrecnik(15);
		g1.setStanje(10);
		
		pa.unesiGumu(g1);
		
		Guma g2 = new Guma();
		g2.setMarka("Hankook");
		g2.setVrstaGume(VrstaGume.LETNJA);
		g2.setSirina(165);
		g2.setVisina(65);
		g2.setPrecnik(14);
		g2.setStanje(20);
		
		pa.unesiGumu(g2);
		
		Guma g3 = new Guma();
		g3.setMarka("Goodyear");
		g3.setVrstaGume(VrstaGume.SVE_SEZONE);
		g3.setSirina(185);
		g3.setVisina(60);
		g3.setPrecnik(15);
		g3.setStanje(2);
		
		pa.unesiGumu(g3);
		
		Guma[] spisakNabavke = pa.sastaviSpisakZaNabavku();
		
		for(int i=0;i<spisakNabavke.length;i++)
			System.out.println(spisakNabavke[i]);

	}

}
