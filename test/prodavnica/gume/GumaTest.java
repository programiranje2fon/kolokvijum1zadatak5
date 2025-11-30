package prodavnica.gume;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Modifier;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import test.TestUtil;

public class GumaTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;
	
	Guma instance;

	@Before
	public void setUp() throws Exception {
		instance = new Guma();
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
	public void atribut_marka() {
		assertTrue("U klasi nije definisan atribut marka", TestUtil.doesFieldExist(Guma.class, "marka"));
	}
	
	@Test
	public void atribut_marka_vidljivost() {
		assertTrue("Atribut marka nije privatan", TestUtil.hasFieldModifier(Guma.class, "marka", Modifier.PRIVATE));
	}

	@Test
	public void atribut_sirina() {
		assertTrue("U klasi nije definisan atribut sirina", TestUtil.doesFieldExist(Guma.class, "sirina"));
	}
	
	@Test
	public void atribut_sirina_vidljivost() {
		assertTrue("Atribut sirina nije privatan", TestUtil.hasFieldModifier(Guma.class, "sirina", Modifier.PRIVATE));
	}
	
	@Test
	public void atribut_visina() {
		assertTrue("U klasi nije definisan atribut visina", TestUtil.doesFieldExist(Guma.class, "visina"));
	}
	
	@Test
	public void atribut_visina_vidljivost() {
		assertTrue("Atribut visina nije privatan", TestUtil.hasFieldModifier(Guma.class, "visina", Modifier.PRIVATE));
	}

	@Test
	public void atribut_precnik() {
		assertTrue("U klasi nije definisan atribut precnik", TestUtil.doesFieldExist(Guma.class, "precnik"));
	}
	
	@Test
	public void atribut_precnik_vidljivost() {
		assertTrue("Atribut precnik nije privatan", TestUtil.hasFieldModifier(Guma.class, "precnik", Modifier.PRIVATE));
	}

	@Test
	public void atribut_stanje() {
		assertTrue("U klasi nije definisan atribut stanje", TestUtil.doesFieldExist(Guma.class, "stanje"));
	}
	
	@Test
	public void atribut_stanje_vidljivost() {
		assertTrue("Atribut stanje nije privatan", TestUtil.hasFieldModifier(Guma.class, "stanje", Modifier.PRIVATE));
	}
	
	@Test
	public void atribut_vrstaGume() {
		assertTrue("U klasi nije definisan atribut vrstaGume", TestUtil.doesFieldExist(Guma.class, "vrstaGume"));
	}
	
	@Test
	public void atribut_vrstaGume_vidljivost() {
		assertTrue("Atribut vrstaGume nije privatan", TestUtil.hasFieldModifier(Guma.class, "vrstaGume", Modifier.PRIVATE));
	}	
	
	@Test
	public void metoda_setMarka() {
		instance.setMarka("Michelin");
		
		assertEquals("Kada se unese marka Michelin, atribut ne dobija tu vrednost", "Michelin", instance.getMarka());
	}
	
	@Test
	public void metoda_setMarka_Null() {
		instance.setMarka(null);
		
		assertEquals("NE ispisuje se rec GRESKA u slucaju unosa NULL vrednosti", "GRESKA", outContent.toString().trim().toUpperCase());		
	}
	
	@Test
	public void metoda_setMarka_PrazanString() {
		instance.setMarka("");
		
		assertEquals("NE ispisuje se rec GRESKA u slucaju unosa NULL vrednosti", "GRESKA", outContent.toString().trim().toUpperCase());		
		assertEquals("Uneta je nedozvoljena vrednost (prazan String) u atribut marka", null, instance.getMarka());
	}

	@Test
	public void metoda_setVrstaGume() {
		instance.setVrstaGume(VrstaGume.LETNJA);
		
		assertEquals("Kada se unese letnja vrsta gume, atribut ne dobija tu vrednost", VrstaGume.LETNJA, instance.getVrstaGume());		
	}

	@Test
	public void metoda_setSirina() {
		instance.setSirina(185);

		assertEquals("Kada se unese sirina 185, atribut ne dobija tu vrednost", 185, instance.getSirina());			
	}
	
	@Test
	public void metoda_setSirina_PremalaSirina() {
		instance.setSirina(134);

		assertEquals("NE ispisuje se rec GRESKA u slucaju unosa premale sirine 134", "GRESKA", outContent.toString().trim().toUpperCase());		
		assertNotEquals("Kada se unese premala sirina 134, atribut greskom dobija tu vrednost", 134, instance.getSirina());			
	}
	
	@Test
	public void metoda_setSirina_PrevelikaSirina() {
		instance.setSirina(266);

		assertEquals("NE ispisuje se rec GRESKA u slucaju unosa prevelike sirine 266", "GRESKA", outContent.toString().trim().toUpperCase());		
		assertNotEquals("Kada se unese prevelika sirina 266, atribut greskom dobija tu vrednost", 266, instance.getSirina());			
	}

	@Test
	public void metoda_setVisina() {
		instance.setVisina(70);
		
		assertEquals("Kada se unese visina 70, atribut ne dobija tu vrednost", 70, instance.getVisina());					
	}
	
	@Test
	public void metoda_setVisina_Premala() {
		instance.setVisina(44);
		
		assertEquals("NE ispisuje se rec GRESKA u slucaju unosa premale visine 44", "GRESKA", outContent.toString().trim().toUpperCase());		
		assertNotEquals("Kada se unese premala visina 44, atribut greskom dobija tu vrednost", 44, instance.getVisina());			
	}
	
	@Test
	public void metoda_setVisina_Prevelika() {
		instance.setVisina(86);
		
		assertEquals("NE ispisuje se rec GRESKA u slucaju unosa prevelike visine 86", "GRESKA", outContent.toString().trim().toUpperCase());		
		assertNotEquals("Kada se unese prevelika visina 86, atribut greskom dobija tu vrednost", 86, instance.getVisina());			
	}

	@Test
	public void metoda_setPrecnik() {
		instance.setPrecnik(17);
		
		assertEquals("Kada se unese precnik 17, atribut ne dobija tu vrednost", 17, instance.getPrecnik());					
	}
	
	@Test
	public void metoda_setPrecnik_Premali() {
		instance.setPrecnik(12);
		
		assertEquals("NE ispisuje se rec GRESKA u slucaju unosa premalog precnika 12", "GRESKA", outContent.toString().trim().toUpperCase());		
		assertNotEquals("Kada se unese premali precnik 12, atribut greskom dobija tu vrednost", 12, instance.getPrecnik());			
	}
	
	@Test
	public void metoda_setPrecnik_Preveliki() {
		instance.setPrecnik(20);
		
		assertEquals("NE ispisuje se rec GRESKA u slucaju unosa prevelikog precnika 20", "GRESKA", outContent.toString().trim().toUpperCase());		
		assertNotEquals("Kada se unese preveliki precnik 20, atribut greskom dobija tu vrednost", 20, instance.getPrecnik());			
	}

	@Test
	public void metoda_setStanje() {
		instance.setStanje(34);
		
		assertEquals("Kada se unese stanje 34, atribut ne dobija tu vrednost", 34, instance.getStanje());							
	}
	
	@Test
	public void metoda_setStanje_Premalo() {
		instance.setStanje(-1);
		
		assertEquals("NE ispisuje se rec GRESKA u slucaju unosa premalog stanja -1", "GRESKA", outContent.toString().trim().toUpperCase());		
		assertNotEquals("Kada se unese premalo stanje -1, atribut greskom dobija tu vrednost", -1, instance.getStanje());			
	}

	@Test
	public void metoda_equals() {
		instance.setMarka("Michelin");
		instance.setVrstaGume(VrstaGume.ZIMSKA);
		instance.setSirina(205);
		instance.setVisina(65);
		instance.setPrecnik(16);
		instance.setStanje(34);
		
		Guma instance2 = new Guma();
		
		instance2.setMarka("Michelin");
		instance2.setVrstaGume(VrstaGume.ZIMSKA);
		instance2.setSirina(205);
		instance2.setVisina(65);
		instance2.setPrecnik(16);
		instance2.setStanje(2);
		
		assertTrue ("Ako se unesu gume:"+instance+" i "+instance2+" metoda equals bi trebalo da vrati true", instance.equals(instance2));
	}
	
	@Test
	public void metoda_equals_false() {
		instance.setMarka("Michelin");
		instance.setVrstaGume(VrstaGume.ZIMSKA);
		instance.setSirina(205);
		instance.setVisina(65);
		instance.setPrecnik(16);
		instance.setStanje(34);
		
		Guma instance2 = new Guma();
		
		instance2.setMarka("Michelin2");
		instance2.setVrstaGume(VrstaGume.LETNJA);
		instance2.setSirina(200);
		instance2.setVisina(60);
		instance2.setPrecnik(15);
		instance2.setStanje(34);
		
		assertFalse ("Ako se unesu gume:"+instance+" i "+instance2+" metoda equals bi trebalo da vrati false", instance.equals(instance2));
	}

	@Test
	public void metoda_toString() {
		instance.setMarka("Michelin");
		instance.setVrstaGume(VrstaGume.ZIMSKA);
		instance.setSirina(205);
		instance.setVisina(65);
		instance.setPrecnik(16);
		instance.setStanje(34);
		
		String s = instance.toString();
		
		assertTrue("NE vraca se marka", s.contains("Michelin"));		
		assertTrue("NE vraca se vrsta gume", s.contains("ZIMSKA"));
		assertTrue("NE vraca se sirina", s.contains("205"));
		assertTrue("NE vraca se visina", s.contains("65"));	
		assertTrue("NE vraca se precnik", s.contains("16"));
		assertTrue("NE vraca se stanje", s.contains("34"));		
	}

}
