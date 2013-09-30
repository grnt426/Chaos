import java.awt.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Author:      Grant Kurtz
 */
public class Cell{

	Set<Cell> neighbors = new HashSet<Cell>();

	// For choosing the next color
	int[][] dice = {
			{1, 2, 3, 4},
			{2, 1, 4, 3},
			{4, 3, 1, 2},
			{2, 4, 3, 1}
	};

	int val = 0;
	int roll = 0;
	int pass = 0;

	public Cell(int i){
		roll = i;
	}

	/**
	 * Just lazily passing around references to get all neighbors.
	 */
	public void addNeighbor(Cell c){
		if(neighbors.contains(c))
			return;
		neighbors.add(c);
		c.addNeighbor(this);
	}

	public void update(int iter){
		if(iter ==  0 && pass == dice[roll][3]){
			computeRoll();
			pass = 0;
		}
		else if(iter == 0)
			pass++;

		val = dice[roll][iter];
	}

	public void computeRoll(){
		for(Cell n : neighbors)
			roll = (roll + n.roll + 1) % 4;
	}

	public Color draw(){
		switch(val - 1){
			case 0 : return Color.RED;
			case 1 : return Color.GREEN;
			case 2 : return Color.BLUE;
			case 3 :
			default : return Color.YELLOW;
		}
	}
}
