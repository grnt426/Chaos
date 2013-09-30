import javax.swing.*;
import java.awt.*;

/**
 * Author:      Grant Kurtz
 */
public class Painter extends JPanel{

	Cell[][] board;

	@Override
	public void paint(Graphics g){
		super.paint(g);

		for(int i = 0; i < Chaos.ROW; i++){
			for(int k = 0; k < Chaos.COL; k++){
				g.setColor(board[i][k].draw());
				g.fillRect(i * 8, k * 6, 8, 6);
			}
		}
	}

	@Override
	public Dimension getPreferredSize(){
		return new Dimension(320, 240);
	}
}
