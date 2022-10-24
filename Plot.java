 /*
 * Class: CMSC203 
 * Instructor:Grinberg
 * Description: Designs a Property Management that collects the plot, property and combines it together in an organized fashion.
 * Due: 10/24/22
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here:Majd Haddad
*/
public class Plot {
	private int x;
	private int y;
	private int width;
	private int depth;
	
	public Plot() {
		x = 0;
		y = 0;
		width = 1;
		depth = 1;
	}
	public Plot(int x, int y, int width, int depth) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	public Plot (Plot otherPlot) {
		this.width = otherPlot.width;
		this.depth = otherPlot.depth;
		this.x = otherPlot.x;
		this.y = otherPlot.y;
	}
	public void setWidth(int width) {
		this.width = width;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getDepth() {
		return depth;
	}
	public int getWidth() {
		return width;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public boolean encompasses(Plot plot) {
		//Determines if the given plot is encompassed by (is contained by) this plot.(inclusive)
		
		boolean isEncompassed = false;
		if(this.getX() <= plot.getX() && this.getX() + width >= plot.getX() + plot.getWidth() && this.getY() <= plot.getY() && this.getY() + depth >= plot.getY() + plot.getDepth() ) {
			isEncompassed = true;
		}
		return isEncompassed;
	}
	public boolean overlaps(Plot plot) {
		//checks if any of the points touches or is inside the other point of the plot
		boolean isOverlap = true;
		if(this.getY() + this.getDepth() <= plot.getY() || plot.getY() >= this.getY() + this.getDepth()){
			isOverlap = false;
		}
		if(this.getX() + this.getWidth() <= plot.getX() || plot.getX() >= this.getX() + this.getWidth()) {
			isOverlap = false;
		}
		return isOverlap;
	}
	public String toString() {
		String str = getX() + "," + getY()+ "," + getWidth() + "," + getDepth();
		return str;
	}
}
