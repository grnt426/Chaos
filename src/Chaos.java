import javax.swing.*;

/**
 * Author:      Grant Kurtz
 */
public class Chaos{

	int iter = 0;

	static int ROW = 40;
	static int COL = 40;

	// Our science lab
	Cell[][] board = new Cell[ROW][COL];

	public static void main(String[] args){
		new Chaos();
	}

	public Chaos(){

		// Initialize all tiles to similar values
		for(int i = 0; i < ROW; i++){
			for(int k = 0; k < COL; k++){
				board[i][k] = new Cell(0);
				if(i > 0)
					board[i][k].addNeighbor(board[i-1][k]);
				if(k > 0)
					board[i][k].addNeighbor(board[i][k-1]);
			}
		}

//		board[ROW / 2][COL / 2].roll = 2;

		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setTitle("Chaos Impact!");
		Painter paint = new Painter();
		paint.board = board;
		window.getContentPane().add(paint);
		window.pack();
		window.setVisible(true);

		while(true){
			update();
			window.repaint();
			try{
				Thread.sleep(500);
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
			iter = (iter + 1) % 4;
		}
	}

	public void update(){
		for(Cell[] row : board){
			for(Cell col : row){
				col.update(iter);
			}
		}
	}
}
