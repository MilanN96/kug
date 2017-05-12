import java.util.ArrayList;
import java.util.List;

import com.sun.xml.internal.bind.v2.runtime.reflect.ListIterator;
import com.sun.xml.internal.ws.api.pipe.ThrowableContainerPropertySet;

// Before you commit and push write your student ID and finish time here.
// Finish time:
// Student ID:

public class BowlingGame {
	//a bowling game is made of (at least) 10 frames
	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;
	private int score =0,counter=-1 ;
	private int bonusPoints=0;
	//private int frame=0;
	
	public BowlingGame(){}
	
	// adds a frame to the game
	public void addFrame(Frame frame) throws BowlingException{
		//to be implemented--
		 
             frames.add(frame);
             counter++;
		   
	}
	
	// Sets the bonus throws at the end of the game
	public void setBonus(int firstThrow, int secondThrow) {
		
		
	}
	
	// Returns the game score
	public int score(){
		
		for  (int i=0;i<frames.size();i++)
		{
			if(frames.get(i).isStrike())
			{
			score = score  + frames.get(i).score() + frames.get(i+1).score();
			}
			else if (frames.get(i).isSpare())
			{
				score= score + frames.get(i).score() + frames.get(i+1).getFirstThrow();
			}
			
		}
		return score;
	}
}
