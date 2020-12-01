import org.junit.Assert;
import org.junit.Test;

public class VonatTest {
    @Test
    public void testVonat() {
        Vonat v = new Vonat("Siófok", "Gárdony", new Ido(11,15), new Ido(12, 30), 3, 20, 1200);
        Assert.assertEquals("Siófok", v.getIndulasHelye());
        Assert.assertEquals("Gárdony", v.getErkezesHelye());
        Assert.assertEquals(11, v.getIndulasIdeje().getOra());
        Assert.assertEquals(15, v.getIndulasIdeje().getPerc());
        Assert.assertEquals(12, v.getErkezesIdeje().getOra());
        Assert.assertEquals(30, v.getErkezesIdeje().getPerc());
        Assert.assertEquals(3, v.getVagonokSzama());
        Assert.assertEquals(20, v.getFerohely());
        Assert.assertEquals(1200.0, v.getAr(), 0.0);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testErtelmetlenErkezesIdopont() throws Exception {
        Vonat v = new Vonat("Siófok", "Gárdony", new Ido(11,15), new Ido(10, 30), 3, 20, 1200);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testIllegalFerohely() throws Exception {
        Vonat v = new Vonat("Siófok", "Gárdony", new Ido(11,15), new Ido(10, 30), 3, 0, 1200);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testIllegalFerohelyEsAr() throws Exception {
        Vonat v = new Vonat("Siófok", "Gárdony", new Ido(11,15), new Ido(10, 30), 3, 0, -1.0);
    }

    @Test
    public void testTultelnee() {
        //8 hely van a vonaton és alapból 0 a telítettség
        Vonat v = new Vonat("Siófok", "Gárdony", new Ido(11,15), new Ido(12, 30), 2, 4, 1200);
        Assert.assertEquals(false, v.tultelnee(2));
        Assert.assertEquals(false, v.tultelnee(8)); //épp megtelik
        Assert.assertEquals(true, v.tultelnee(9));

        //innentől kezdve 4 a telítettség, de még mindig 8 hely van a vonaton
        v.setTelitettseg(4);
        Assert.assertEquals(false, v.tultelnee(3));
        Assert.assertEquals(false, v.tultelnee(4)); //épp megtelik
        Assert.assertEquals(true, v.tultelnee(5));

    }
}
