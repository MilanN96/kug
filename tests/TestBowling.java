import static org.junit.Assert.*;

import org.junit.Test;

public class TestBowling {

	/*@Test
	public void test() {
		fail("Not yet implemented");
	}*/
	
	@Test
	public void testStrike() throws BowlingException
	{
		BowlingGame bwlGame = new BowlingGame();
		
		Frame fr = new Frame(10,0);
		bwlGame.addFrame(fr);
		
		fr = new Frame(5,1);
		bwlGame.addFrame(fr);
		int score = bwlGame.score();
		assertEquals("Incorect score when strike",16,score);
	}
	@Test
	public void testSpare() throws BowlingException
	{
		BowlingGame bwlGame = new BowlingGame();
		Frame fr = new Frame(5,5);
		bwlGame.addFrame(fr);
		
		fr = new Frame(5,1);
		bwlGame.addFrame(fr);
		int score = bwlGame.score();
		assertEquals("Incorect score when spare",15,score);
	}
	

}
