public class Frame {
	private int firstThrow;
	private int secondThrow;
	private int frameScore;

	public Frame(int firstThrow, int secondThrow) throws BowlingException {
		if (firstThrow + secondThrow > 10)
			throw new BowlingException("Frame score cannot be higher than 10");

		this.firstThrow = firstThrow;
		this.secondThrow = secondThrow;
		frameScore = this.firstThrow + this.secondThrow;
	}

	public int getFirstThrow() {
		return firstThrow;
	}

	public int getSecondThrow() {
		return secondThrow;
	}

	// returns the score of a single frame
	public int score() {
		frameScore = this.firstThrow + this.secondThrow;
		return frameScore;
	}

	// returns whether the frame is a strike or not
	public boolean isStrike() {
		return firstThrow == 10;
	}

	// return whether a frame is a spare or not
	public boolean isSpare() {
		return firstThrow + secondThrow == 10 && !isStrike();
	}

	public int getFrameScore() {
		return frameScore;
	}

	public void setFrameScore(int frameScore) {
		this.frameScore = frameScore;
	}
}
