public class Pole {
	private int x;
	private int height;
	private int discNumber;
	private Disc[] discs;

	public Pole(int x, int height) {
		this.x = x;
		this.height = height;
		this.discNumber = 0;
	}

	public int getX() {
		return x;
	}

	public int getHeight() {
		return height;
	}

	public int getDiscNumber() {
		return discNumber;
	}

	public void setDiscNumber(int discNumber) {
		this.discNumber = discNumber;
	}

	public void addDisc() {
		discNumber++;
	}

	public void removeDisc() {
		discNumber--;
	}

}
