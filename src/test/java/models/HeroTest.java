package models;
import junit.framework.TestCase;
import org.junit.Test;
import java.time.LocalDateTime;
import static org.junit.Assert.*;


public class HeroTest{
@Test
    public void NewHeroObjectGetsCorrectlyCorrected_true() throws Exception{
        Hero hero = setupNewHero();
        assertEquals(true, hero instanceof Hero);
    }

    @Test
    public void HeroInstantiatesWithName_true() throws Exception {
        Hero hero = setupNewHero();
        assertEquals("Batman", hero.getName());
    }






    private Hero setupNewHero() {
        return new Hero("Batman",43,"money","Ego");
    }
}
