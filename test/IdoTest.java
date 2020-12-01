import org.junit.Assert;
import org.junit.Test;

public class IdoTest {

    @Test
    public void testIdo() {
        Ido i = new Ido(11,15);
        Assert.assertEquals(11, i.getOra());
        Assert.assertEquals(15, i.getPerc());
    }

    @Test(expected=IllegalArgumentException.class)
    public void testIllegalOra() throws Exception {
        Ido i = new Ido(25,10);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testIllegalPerc() throws Exception {
        Ido i = new Ido(21,61);
    }


    @Test
    public void testToString() {
        Ido a = new Ido(1,5);
        Ido b = new Ido(11,5);
        Ido c = new Ido(1,15);
        Ido d = new Ido(11,15);
        String aEredmeny = a.toString();
        String bEredmeny = b.toString();
        String cEredmeny = c.toString();
        String dEredmeny = d.toString();
        Assert.assertEquals("01:05", aEredmeny);
        Assert.assertEquals("11:05", bEredmeny);
        Assert.assertEquals("01:15", cEredmeny);
        Assert.assertEquals("11:15", dEredmeny);
    }

    @Test
    public void teststringToIdo() {
        Ido i = new Ido(11,15);
        Ido test = new Ido().stringToIdo("11:15");

        Assert.assertEquals(test.getOra(), i.getOra());
        Assert.assertEquals(test.getPerc(), i.getPerc());
    }

    @Test(expected=IllegalArgumentException.class)
    public void testIllegalstringToIdo() throws Exception {
        Ido i = new Ido().stringToIdo("1115");
    }

    @Test(expected=IllegalArgumentException.class)
    public void testIllegalstringToIdo2() throws Exception {
        Ido i = new Ido().stringToIdo("11:15:00");
    }

    @Test
    public void testkesobbiIdopont() {
        Ido i1 = new Ido(11,15);
        Ido i2 = new Ido(11,50);
        Ido i3 = new Ido(12,5);

        Assert.assertEquals(true, i1.kesobbiIdopont(i2));
        Assert.assertEquals(false, i2.kesobbiIdopont(i1));
        Assert.assertEquals(false, i3.kesobbiIdopont(i2));
    }
}