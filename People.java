
package cn.game.ddh;
//思路:设置一个布尔类型的变量，当按J键的时候变为true.paint方法里面加个for循环使img的值变为
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.imageio.event.IIOReadWarningListener;

public class People extends GameObject {
//	static Image[] imgs = new Image[16];
	static int y = 200;
	static int x = 100;
	static int y1;
	int n;
	boolean f= false;
	boolean t = true;
	boolean show = true;
	boolean ychange = true;
	static	int i = 2;
	static int speed = 20;
	boolean left,right,up,down;
	boolean draw = true;
	boolean J = false;
	boolean attack = false;
	static int inity;
	static int j = 1;
	static int initheight;
	boolean 黑洞judge = false;
	boolean[] ing = new boolean[]{false,false,false};
	Rectangle K;	
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
			break;
		case KeyEvent.VK_2:
			黑洞judge = true;

			if(i!=1)
	    		i = 10;
			break;
		default:
			break;
		}	
	}
	public void minusDirection(KeyEvent e) {
//		System.out.println("正常");
		switch (e.getKeyCode()) {
		case KeyEvent.VK_A:
			left = false;
			break;
		case KeyEvent.VK_D:
			right = false;
//			System.out.println("往右");
			break;
		case KeyEvent.VK_W:
//			up = false;
			break;
		case KeyEvent.VK_S:
			down = false;
			break;	
		case KeyEvent.VK_1:
			break;
		case KeyEvent.VK_2:
			break;
		default:
			break;
		}
	}
	public boolean judgeing(boolean[] a,int l) {
		for(int k = 0;k<a.length;k++)
		{
			if(a[k] == true&&k!=l)
				return t;
		}
		return f;
		
	}
	public void paintMyself(Graphics g)
	{

    if (left&&x>0) {
        x -= speed;
    }
    if (right&&x<500) {
        x += speed;
    }
   
    if (down&&y<500-this.height) {
        y += speed;
//    	System.out.println(y);
    }
    if(J&&!judgeing(ing,0)&&!show)
    {
    	ing[0] = true;
    	神指(g);
//    	System.out.println(1);
    }
    if(黑洞judge&&!judgeing(ing,1)&&!show)
    {	
    	ing[1] = true;
    	黑洞(g);
    }
    if (up&&!judgeing(ing,2)&&!show) {
    	ing[2] = true;
    	直跳(g);
//    	System.out.println(y);
//    	y1=y;
    	}
    	if(show)//判断是否已经执行过出场动画
    {
    	img = GameUtil.getImage("Images/大蛇-出场"+j+".png");
        if(j==1)
        {
       	inity = y;
        initheight = height;
//        y=y1;
        }
        if(j<71)
        	j++;
        y = inity-(height-initheight);
//        System.out.println(y+height);
        //	System.out.println(y);
        	
    	this.width = img.getWidth(null);
    	this.height = img.getHeight(null);
//        this.height = img.getHeight(null);
//        this.width = img.getWidth(null);
        g.drawImage(img, x, y ,width , height, null);
//        System.out.println(this.height);
    	if(j==71)
        {
    	show = false;
    	j=1;	
//    	ing[0] = false;
        }
    }
    if(draw&&!show)	//判断出场动画是否执行完毕
    {
//    System.out.println(y);
//    System.out.println(y);     
        img = GameUtil.getImage("Images/大蛇-站立"+j+".png");
//        System.out.println(j);
    	if(j<28)
    	j = j+1;
    	if(j==28)
    	j = 1;
//    	System.out.println(ing);
        g.drawImage( img, x, y , width , height , null);
    }
if(黑洞judge||J)
    	attack = true;
    K = new Rectangle(x,y,width,height);
	}
	
    public void 神指(Graphics g)
    {	
    	draw = false;
    	img = GameUtil.getImage("Images/大蛇-神指失败"+i+".png");
    	this.width = img.getWidth(null);
    	this.height = img.getHeight(null);

    	if(i<22)
    		i++;
    	if(!draw)
    	{	
    		g.drawRect(x, y , width , height);

    		g.drawImage(img, x, y , this.width,this.height, null);
//    	System.out.println(y);
//    	System.out.println(i);
//    	System.out.println(this.width);
    	if (i == 22)
    	{
			draw = true;
			i = 1;
			ing[0] = false;
			J = false;	
			attack = false;

//			System.out.println(ing);
		}

    	}
    }
    public void 黑洞(Graphics g)
    {	 	
    	draw = false;
    	img = GameUtil.getImage("Images/大蛇-黑洞"+i+".png");
    	this.width = img.getWidth(null);
    	this.height = img.getHeight(null);
    	y = inity-(height-initheight);

    	if(i<35)
    		i++;
    	if(!draw)
    	{	
    		g.drawRect(x, y , width , height);

    		g.drawImage(img, x, y , this.width,this.height, null);

    	if (i == 35)
    	{
			draw = true;
			i=1;
			黑洞judge = false;
			ing[1] = false;	
			attack = false;
		}
    	System.out.println(ing.length);
    	}
    }

    public void 直跳(Graphics g)
    {	 	
    	System.out.println("正常1");
    	draw = false;
    	img = GameUtil.getImage("Images/大蛇-直跳"+i+".png");
    	this.width = img.getWidth(null);
    	this.height = img.getHeight(null);
    	if(n<13)
    	{
    	y-=12;
    	n++;
    	}
    	if(n>12)
    	{		
    	y+=12;
    	n++;
    		
        }
    	if(n==24)
    		n=1;

    	if(i<24)
    		i++;
    	if(!draw)
    	{	
    		g.drawRect(x, y , width , height);

    		g.drawImage(img, x, y , this.width,this.height, null);
    	if (i == 24)
    	{
			draw = true;
			i = 1;
			ing[2] = false;	
			up = false;
		}
    	}
    }
	
	public People(int x,int y,int width,int height ) {
		this.width = width;
		this.height = height;
//		System.out.println(this.y);
	}
}
