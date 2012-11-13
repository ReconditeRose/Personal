import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;

public class drawingFrame extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4L;
	private window controller;
	private static final int box = 40;
	private static final int offset = 5;
	private static final int poffSet = 20;
	private int width;
	private int height;
	private boolean flipper;

	int[][] gridIn;
	int[][] gridOut;

	public drawingFrame(int width, int height, window controller) {
		this.width = width;
		this.height = height;

		this.controller = controller;
		this.controller.resizeWindow((width + 1) * box, (height + 1) * box);
		gridIn = new int[width][height];
		gridOut = new int[width][height];
		this.setPreferredSize(new Dimension((width) * box * 2 + 5 + poffSet,
				(height) * box + 5));
		controller.pack();
	}

	@Override
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		Graphics2D graphics2 = (Graphics2D) graphics;
		Rectangle box2;
		for (int i = 0; i < gridIn.length; i++) {
			for (int j = 0; j < gridIn[0].length; j++) {
				box2 = new Rectangle(i * box + offset, j * box + offset, box
						- offset, box - offset);
				switch (gridIn[i][j]) {
				case 0:
					graphics2.setColor(Color.white);
					break;
				case 1:
					graphics2.setColor(Color.black);
					break;
				case 2:
					graphics2.setColor(new Color(255,0,0));
					break;
				case 3:
					graphics2.setColor(new Color(100,0,0));
					break;
				}
				graphics2.fill(box2);

				box2 = new Rectangle(i * box + offset + width * box + poffSet,
						j * box + offset, box - offset, box - offset);
				switch (gridOut[i][j]) {
				case 0:
					graphics2.setColor(Color.white);
					break;
				case 1:
					graphics2.setColor(Color.black);
					break;
				case 2:
					graphics2.setColor(Color.red);
					break;
				case 3:
					graphics2.setColor(Color.green);
					break;
				}
				graphics2.fill(box2);
			}
		}
	}
	private void flipCell(int x, int y,int domain, boolean global){
		try{
		if(domain==1){
			gridIn[x][y]= (gridIn[x][y]+1)%2;
			if(flipper && global){
				flipCell(x+1,y,domain,false);
				flipCell(x-1,y,domain,false);
				flipCell(x,y+1,domain,false);
				flipCell(x,y-1,domain,false);
			}
		}else{
			gridOut[x][y]= (gridOut[x][y]+1)%2;
			if(flipper && global){
				flipCell(x+1,y,domain,false);
				flipCell(x-1,y,domain,false);
				flipCell(x,y+1,domain,false);
				flipCell(x,y-1,domain,false);
			}
		}
		}catch(Exception e){
			
		}
	}
	public void clicked(int x, int y) {
		if(x<(width)*box){
			flipCell(x/box,y/box,1,true);
//			gridIn[x/box][y/box] =(gridIn[x/box][y/box]+1)%2;
		}else if(x>(width)*box+poffSet+offset){
			x-=(width)*box+poffSet;
			flipCell(x/box,y/box,2,true);
		}
		controller.repaint();
	}
	
	public int[][] differenceMap(){
		int[][] returnValue = new int[width][height];
		for(int i=0;i<width;i++){
			for(int j=0;j<height;j++){
				returnValue[i][j] = (gridIn[i][j]+gridOut[i][j])%2;
			}
		}
		return returnValue;
	}
	
	public void printValues(int[][] values){
		for(int i=0;i<values.length;i++){
			for(int j=0;j<values[0].length;j++){
				if(values[i][j] ==1){
					gridIn[i][j]+=2;
				}
			}
		}
		controller.repaint();
	}
	public void switchInput(){
		this.flipper = !this.flipper;
	}
}
