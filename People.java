package cn.game.ddh;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
public class People extends GameObject {
	static int y = 400;
	static int x = 100;
	static int y1;
	boolean ychange = true;
	static	int i = 2;
	static int speed = 20;
	boolean left,right,up,down;
	boolean draw = true;//draw变量用于判断出场动画是否已经播放完毕
	boolean J = false;//判断是否按下J键
	int inity;
	int initheight;

	
	public void addDirection(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_A:
			left = true;
			break;
		case KeyEvent.VK_D:
			right = true;
			break;
		case KeyEvent.VK_W:
			up = true;
			break;
		case KeyEvent.VK_S:
			down = true;
			break;	
		case KeyEvent.VK_1:
			J = true;
		default:
			break;
		}	
	}
	public void minusDirection(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_A:
			left = false;
			break;
		case KeyEvent.VK_D:
			right = false;
			break;
		case KeyEvent.VK_W:
			up = false;
			break;
		case KeyEvent.VK_S:
			down = false;
			break;	
		case KeyEvent.VK_1:
			break;
		default:
			break;
		}
	}
	public void paintMyself(Graphics g)
	{	
	img = GameUtil.getImage("Images/图层 1.png");//设置图片资源
    if (left) 
    {
        x -= speed;
    }
    if (right) 
    {
        x += speed;
    }
    if (up) {
    	y -= speed;
    	}
    if (down) 
    {
        y += speed;
    }
    if(J)
    {
    	attack(g);
    }
    if(draw)
    {
    img = GameUtil.getImage("Images/图层 1.png");
    inity = y;
    initheight = height;
    this.width = img.getWidth(null);
    this.height = img.getHeight(null);
    g.drawImage(img, x, y ,width , height, null);
	}
	}
    public void attack(Graphics g)
    {	
    	draw = false;
    	img = GameUtil.getImage("Images/图层 "+i+".png");
    	this.width = img.getWidth(null);
    	this.height = img.getHeight(null);
    	y = inity-(height-initheight);//使得图片的最下边的Y坐标始终为一个定值，这样展示出来的效果才好。
    	System.out.println(this.x);
    	if(i<73)
    		i++;
    	if(!draw)
    	{	
    		g.drawRect(x, y , width , height);
    		g.drawImage(img, x, y , this.width,this.height, null);

    	if (i==72) {
			draw = true;
			i=1;
			J = false;
		}
    	}
    	}
	
	public People(int x,int y,int width,int height ) {
		this.width = width;
		this.height = height;
	}
}
