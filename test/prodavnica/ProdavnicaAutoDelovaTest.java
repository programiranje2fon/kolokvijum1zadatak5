package prodavnica;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Modifier;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import prodavnica.gume.Guma;
import prodavnica.gume.VrstaGume;
import test.TestUtil;

public class ProdavnicaAutoDelovaTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;
	
	ProdavnicaAutoDelova instance;
	
	@Before
	public void setUp() throws Exception {
		instance = new ProdavnicaAutoDelova();
		System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@After
	public void tearDown() throws Exception {
		instance = null;
		System.setOut(originalOut);
	    System.setErr(originalErr);
	}

	@Test
	public void atribut_ponudaGuma() {
		assertTrue("U klasi nije definisan atribut ponudaGuma", TestUtil.doesFieldExist(ProdavnicaAutoDelova.class, "ponudaGuma"));
	}
	
	@Test
	public void atribut_ponudaGuma_vidljivost() {
		assertTrue("Atribut ponudaGuma nije privatan", TestUtil.hasFieldModifier(ProdavnicaAutoDelova.class, "ponudaGuma", Modifier.PRIVATE));
	}
	
	@Test (timeout = 2000)
	public void konstruktor_ProdavnicaAutoDelova() {
		Guma[] niz = (Guma[])TestUtil.getFieldValue(instance, "ponudaGuma");
		
		assertNotNull("konstruktor ne inicijalizuje niz uopste", niz);
		assertEquals("konstruktor ne inicijalizuje niz na kapacitet 200", 200, niz.length);		
	}

	@Test (timeout = 2000)
	public void metoda_pretrazi() {
		Guma g1 = new Guma();
		g1.setMarka("Kleber");
		g1.setVrstaGume(VrstaGume.ZIMSKA);
		g1.setSirina(195);
		g1.setVisina(65);
		g1.setPrecnik(15);
		g1.setStanje(10);
		
		instance.unesiGumu(g1);
		
		Guma g2 = new Guma();
		g2.setMarka("Hankook");
		g2.setVrstaGume(VrstaGume.LETNJA);
		g2.setSirina(185);
		g2.setVisina(65);
		g2.setPrecnik(15);
		g2.setStanje(20);
		
		instance.unesiGumu(g2);
		
		Guma g3 = new Guma();
		g3.setMarka("Goodyear");
		g3.setVrstaGume(VrstaGume.LETNJA);
		g3.setSirina(185);
		g3.setVisina(65);
		g3.setPrecnik(15);
		g3.setStanje(2);
		
		instance.unesiGumu(g3);
		
		Guma g4 = new Guma();
		g4.setMarka("Barum");
		g4.setVrstaGume(VrstaGume.SVE_SEZONE);
		g4.setSirina(185);
		g4.setVisina(65);
		g4.setPrecnik(15);
		g4.setStanje(2);
		
		instance.unesiGumu(g4);
		
		instance.pretrazi(VrstaGume.LETNJA, 185, 65, 15);
		
		String s = outContent.toString();
		assertTrue("Ako se unesu gume "+ g1 + System.lineSeparator() +
		 g2 + System.lineSeparator()  + g3 + System.lineSeparator() +
		 g4 + System.lineSeparator() + " i pretrazuju samo letnje 185/65/15, metoda "+
		 "ne ispisuje Hankook gumu", s.contains("Hankook"));
		
		assertTrue("Ako se unesu gume "+ g1 + System.lineSeparator() +
				 g2 + System.lineSeparator()  + g3 + System.lineSeparator() +
				 g4 + System.lineSeparator() + " i pretrazuju samo letnje 185/65/15, metoda "+
				 "ne ispisuje Goodyear gumu", s.contains("Hankook"));
	}
	
	@Test (timeout = 2000)
	public void metoda_pretrazi_Nema() {
		Guma g1 = new Guma();
		g1.setMarka("Kleber");
		g1.setVrstaGume(VrstaGume.ZIMSKA);
		g1.setSirina(195);
		g1.setVisina(65);
		g1.setPrecnik(15);
		g1.setStanje(10);
		
		instance.unesiGumu(g1);
		
		Guma g2 = new Guma();
		g2.setMarka("Hankook");
		g2.setVrstaGume(VrstaGume.LETNJA);
		g2.setSirina(185);
		g2.setVisina(65);
		g2.setPrecnik(15);
		g2.setStanje(20);
		
		instance.unesiGumu(g2);
		
		Guma g3 = new Guma();
		g3.setMarka("Goodyear");
		g3.setVrstaGume(VrstaGume.LETNJA);
		g3.setSirina(185);
		g3.setVisina(65);
		g3.setPrecnik(15);
		g3.setStanje(2);
		
		instance.unesiGumu(g3);
		
		Guma g4 = new Guma();
		g4.setMarka("Barum");
		g4.setVrstaGume(VrstaGume.SVE_SEZONE);
		g4.setSirina(185);
		g4.setVisina(65);
		g4.setPrecnik(15);
		g4.setStanje(2);
		
		instance.unesiGumu(g3);
		
		instance.pretrazi(VrstaGume.ZIMSKA, 185, 65, 15);
		
		assertEquals("Ako se unesu gume "+ g1 + System.lineSeparator() +
		 g2 + System.lineSeparator()  + g3 + System.lineSeparator() +
		 g4 + System.lineSeparator() + " i pretrazuju samo zimske 185/65/15, metoda "+
		 "bi trebalo da ispise NEMA", "NEMA", outContent.toString().trim());
	}

	@Test (timeout = 2000)
	public void metoda_unesiGumu() {
		Guma g1 = new Guma();
		g1.setMarka("Kleber");
		g1.setVrstaGume(VrstaGume.ZIMSKA);
		g1.setSirina(195);
		g1.setVisina(65);
		g1.setPrecnik(15);
		g1.setStanje(10);
		
		instance.unesiGumu(g1);
		
		Guma[] niz = (Guma[])TestUtil.getFieldValue(instance, "ponudaGuma");
		
		assertTrue("Kad se unosi guma koja ne postoji, ne unosi je na prvo slobodno mesto", g1 == niz[0]);
		
		for (int i=1; i<niz.length;i++)
			assertEquals("Metoda greskom unosi novu gumu i na sva preostala prazna mesta", null, niz[i]);
	}
	
	@Test (timeout = 2000)
	public void metoda_unesiGumu_DveSlicne() {
		Guma g1 = new Guma();
		g1.setMarka("Kleber");
		g1.setVrstaGume(VrstaGume.ZIMSKA);
		g1.setSirina(195);
		g1.setVisina(65);
		g1.setPrecnik(15);
		g1.setStanje(10);
		
		instance.unesiGumu(g1);
		
		Guma g2 = new Guma();
		g2.setMarka("Kleber");
		g2.setVrstaGume(VrstaGume.LETNJA);
		g2.setSirina(195);
		g2.setVisina(65);
		g2.setPrecnik(15);
		g2.setStanje(10);
		
		instance.unesiGumu(g2);

		Guma[] niz = (Guma[])TestUtil.getFieldValue(instance, "ponudaGuma");
		
		assertTrue("Kad se unose dve slicne gume \n"+g1+System.lineSeparator()
		+g2+System.lineSeparator()+" metoda ne unosi prvu gumu na prvo slobodno mesto", g1 == niz[0]);
		
		assertTrue("Kad se unose dve slicne gume \n"+g1+System.lineSeparator()
		+g2+System.lineSeparator()+" metoda ne unosi drugu gumu na drugo slobodno mesto", g2 == niz[1]);

		for (int i=2; i<niz.length;i++)
			assertEquals("Metoda greskom unosi novu gumu i na sva preostala prazna mesta", null, niz[i]);
	}
	
	@Test (timeout = 2000)
	public void metoda_unesiGumu_DveSlicne2() {
		Guma g1 = new Guma();
		g1.setMarka("Kleber");
		g1.setVrstaGume(VrstaGume.ZIMSKA);
		g1.setSirina(195);
		g1.setVisina(65);
		g1.setPrecnik(15);
		g1.setStanje(10);
		
		instance.unesiGumu(g1);
		
		Guma g2 = new Guma();
		g2.setMarka("Hankook");
		g2.setVrstaGume(VrstaGume.ZIMSKA);
		g2.setSirina(195);
		g2.setVisina(65);
		g2.setPrecnik(15);
		g2.setStanje(10);
		
		instance.unesiGumu(g2);

		Guma[] niz = (Guma[])TestUtil.getFieldValue(instance, "ponudaGuma");
		
		assertTrue("Kad se unose dve slicne gume \n"+g1+System.lineSeparator()
		+g2+System.lineSeparator()+" metoda ne unosi prvu gumu na prvo slobodno mesto", g1 == niz[0]);
		
		assertTrue("Kad se unose dve slicne gume \n"+g1+System.lineSeparator()
		+g2+System.lineSeparator()+" metoda ne unosi drugu gumu na drugo slobodno mesto", g2 == niz[1]);

		for (int i=2; i<niz.length;i++)
			assertEquals("Metoda greskom unosi novu gumu i na sva preostala prazna mesta", null, niz[i]);
	}

	@Test (timeout = 2000)
	public void metoda_unesiGumu_VecPostoji() {
		Guma g1 = new Guma();
		g1.setMarka("Kleber");
		g1.setVrstaGume(VrstaGume.ZIMSKA);
		g1.setSirina(195);
		g1.setVisina(65);
		g1.setPrecnik(15);
		g1.setStanje(10);
		
		instance.unesiGumu(g1);
		
		Guma g2 = new Guma();
		g2.setMarka("Hankook");
		g2.setVrstaGume(VrstaGume.LETNJA);
		g2.setSirina(185);
		g2.setVisina(65);
		g2.setPrecnik(15);
		g2.setStanje(20);
		
		instance.unesiGumu(g2);
		
		Guma g3 = new Guma();
		g3.setMarka("Hankook");
		g3.setVrstaGume(VrstaGume.LETNJA);
		g3.setSirina(185);
		g3.setVisina(65);
		g3.setPrecnik(15);
		g3.setStanje(13);

		instance.unesiGumu(g3);

		Guma[] niz = (Guma[])TestUtil.getFieldValue(instance, "ponudaGuma");
		
		assertEquals("Kad se unosi guma koja vec postoji "+g2+" i doda jos 13 komada, metoda greskom ne povecava stanje", 33, niz[1].getStanje());
		assertEquals("Metoda greskom menja stanje i drugih guma", 10, niz[0
		                                                                  ].getStanje());
		
		for (int i=2; i<niz.length;i++)
			assertEquals("Metoda greskom unosi novu gumu i na sva preostala prazna mesta", null, niz[i]);
	}

	@Test (timeout = 2000)
	public void metoda_sastaviSpisakZaNabavku() {
		Guma g1 = new Guma();
		g1.setMarka("Kleber");
		g1.setVrstaGume(VrstaGume.ZIMSKA);
		g1.setSirina(195);
		g1.setVisina(65);
		g1.setPrecnik(15);
		g1.setStanje(10);
		
		instance.unesiGumu(g1);
		
		Guma g2 = new Guma();
		g2.setMarka("Hankook");
		g2.setVrstaGume(VrstaGume.LETNJA);
		g2.setSirina(185);
		g2.setVisina(65);
		g2.setPrecnik(15);
		g2.setStanje(20);
		
		instance.unesiGumu(g2);
		
		Guma g3 = new Guma();
		g3.setMarka("Goodyear");
		g3.setVrstaGume(VrstaGume.LETNJA);
		g3.setSirina(185);
		g3.setVisina(65);
		g3.setPrecnik(15);
		g3.setStanje(2);
		
		instance.unesiGumu(g3);
		
		Guma g4 = new Guma();
		g4.setMarka("Barum");
		g4.setVrstaGume(VrstaGume.SVE_SEZONE);
		g4.setSirina(185);
		g4.setVisina(65);
		g4.setPrecnik(15);
		g4.setStanje(2);
		
		instance.unesiGumu(g4);
		
		Guma[] spisak = instance.sastaviSpisakZaNabavku();
		
		assertNotNull("Ako se unesu gume "+ g1 + System.lineSeparator() +
				 g2 + System.lineSeparator()  + g3 + System.lineSeparator() +
				 g4 + System.lineSeparator() + " i sastavi spisak za nabavku, metoda "+
				 "ne vraca niz duzine 2 vec NULL niz", spisak);
		assertEquals("Ako se unesu gume "+ g1 + System.lineSeparator() +
				 g2 + System.lineSeparator()  + g3 + System.lineSeparator() +
				 g4 + System.lineSeparator() + " i sastavi spisak za nabavku, metoda "+
				 "ne vraca niz duzine 2", 2, spisak.length);
		assertTrue("Ako se unesu gume "+ g1 + System.lineSeparator() +
				 g2 + System.lineSeparator()  + g3 + System.lineSeparator() +
				 g4 + System.lineSeparator() + " i sastavi spisak za nabavku, metoda "+
				 "ne vraca gumu Goodyear u tom nizu iako je stanje 2", spisak[0]==g3 || spisak[1]==g3);
		
		assertTrue("Ako se unesu gume "+ g1 + System.lineSeparator() +
				 g2 + System.lineSeparator()  + g3 + System.lineSeparator() +
				 g4 + System.lineSeparator() + " i sastavi spisak za nabavku, metoda "+
				 "ne vraca gumu Barum u tom nizu iako je stanje 2", spisak[0]==g4 || spisak[1]==g4);	
	}
	
	@Test (timeout = 2000)
	public void metoda_sastaviSpisakZaNabavku_PrazanSpisak() {
		Guma g1 = new Guma();
		g1.setMarka("Kleber");
		g1.setVrstaGume(VrstaGume.ZIMSKA);
		g1.setSirina(195);
		g1.setVisina(65);
		g1.setPrecnik(15);
		g1.setStanje(10);
		
		instance.unesiGumu(g1);
		
		Guma g2 = new Guma();
		g2.setMarka("Hankook");
		g2.setVrstaGume(VrstaGume.LETNJA);
		g2.setSirina(185);
		g2.setVisina(65);
		g2.setPrecnik(15);
		g2.setStanje(20);
		
		instance.unesiGumu(g2);
		
		Guma g3 = new Guma();
		g3.setMarka("Goodyear");
		g3.setVrstaGume(VrstaGume.LETNJA);
		g3.setSirina(185);
		g3.setVisina(65);
		g3.setPrecnik(15);
		g3.setStanje(3);
		
		instance.unesiGumu(g3);
		
		Guma g4 = new Guma();
		g4.setMarka("Barum");
		g4.setVrstaGume(VrstaGume.SVE_SEZONE);
		g4.setSirina(185);
		g4.setVisina(65);
		g4.setPrecnik(15);
		g4.setStanje(3);
		
		instance.unesiGumu(g4);
		
		Guma[] spisak = instance.sastaviSpisakZaNabavku();
		
		assertNull("Ako se unesu gume "+ g1 + System.lineSeparator() +
				 g2 + System.lineSeparator()  + g3 + System.lineSeparator() +
				 g4 + System.lineSeparator() + " i sastavi spisak za nabavku, metoda "+
				 "greskom ne vraca NULL niz", spisak);
	}

}
