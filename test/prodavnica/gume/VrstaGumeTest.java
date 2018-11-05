package prodavnica.gume;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VrstaGumeTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void enum_Letnja() {
		assertEquals(VrstaGume.LETNJA, VrstaGume.LETNJA);
	}
	
	@Test
	public void enum_Zimska() {
		assertEquals(VrstaGume.ZIMSKA, VrstaGume.ZIMSKA);
	}
	
	@Test
	public void enum_SveSezone() {
		assertEquals(VrstaGume.SVE_SEZONE, VrstaGume.SVE_SEZONE);
	}

}
