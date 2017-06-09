import java.util.ArrayList;
import java.util.List;

// Before you commit and push write your student ID and finish time here.
// Finish time: 15:02 9.6.2017.
// Student ID: IT53/2015 Aleksandar Babic

public class BowlingGame {
	// a bowling game is made of (at least) 10 frames
	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;
	private int totalScore = 0;

	public BowlingGame() {
	}

	// adds a frame to the game
	public void addFrame(Frame frame) throws BowlingException {
		if (frames.size() < 10)
			frames.add(frame);
		else
			throw new BowlingException("Max number of frames exceded.");
	}

	// Returns the game score
	public int score() {
		for (int i = 0; i < frames.size(); i++) {

			// Skipping first frame, because Strike/Spare cannot be calculated
			// for it
			if (i != 0) {
				if (frames.get(i - 1).isStrike())
					frames.get(i - 1).setFrameScore(frames.get(i - 1).score() + frames.get(i).score());
				else if (frames.get(i - 1).isSpare())
					frames.get(i - 1).setFrameScore(frames.get(i - 1).score() + frames.get(i).getFirstThrow());
			}

			totalScore += frames.get(i).score();
		}
		// Checking if bonus is set (initialized)
		if (bonus != null) {
			if (frames.get(9).isSpare())
				totalScore += bonus.getFirstThrow();
			else if (frames.get(9).isStrike())
				totalScore += bonus.score();
		}
		return totalScore;
	}

	public List<Frame> getFrames() {
		return frames;
	}

	public void setFrames(List<Frame> frames) {
		this.frames = frames;
	}

	public Frame getBonus() {
		return bonus;
	}

	// Sets the bonus throws at the end of the game
	public void setBonus(int firstThrow, int secondThrow) throws BowlingException {
		// Init bonus Frame
		bonus = new Frame(firstThrow, secondThrow);
	}
}
