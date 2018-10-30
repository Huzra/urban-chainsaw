package LifeGame;

import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;




public class World extends JPanel implements Runnable{

	private final int rows;
	private final int cols;
	private boolean NextCells[][];
	private boolean CurrentCells[][];
	private boolean isChanged=false;
	public World(int rows,int cols)
	{
		this.rows=rows;
		this.cols=cols;
		NextCells=new boolean[rows][cols];
		CurrentCells=new boolean[rows][cols];
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				NextCells[i][j]=false;
				CurrentCells[i][j]=false;
				
			}
		}
	}
	@Override
	public void run() {
		while(true)
		{
			synchronized(this)
			{
				while(isChanged)
				{
					try 
					{
						this.wait();
					} catch (InterruptedException e) 
					{
						e.printStackTrace();
					}
				}
				repaint();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				for(int i=0;i<20;i++)
				{
					for(int j=0;j<20;j++)
					{
						CellsCheck(i,j);
					}
				}
				//������������
				boolean[][] temp=new boolean[20][20];
				CurrentCells=NextCells;
				NextCells=temp;
			}
		}
	}

//���Ƶ�ͼ
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		for (int i = 0; i < rows; i++) 
        {
            for (int j = 0; j < cols; j++) 
            {
            	if(CurrentCells[i][j])
            	{
            		g.fillRect(j * 20, i * 20, 20, 20);
            	}
            	else
            	{
                    g.drawRect(j * 20, i * 20, 20, 20);            		
            	}
            }
        }
	}
	//
//�ж���һ��ϸ��״̬
	private void CellsCheck(int row,int col)
	{
		int SurroundAliveCells=0;
		//�жϲ�λ�ڱ߲���ϸ��
		if(row>0&&col>0&&row<19&&col<19)
		{

				if(CurrentCells[row-1][col-1])
				{
					SurroundAliveCells++;
				}
				if(CurrentCells[row-1][col])
				{
					SurroundAliveCells++;
				}
				if(CurrentCells[row-1][col+1])
				{
					SurroundAliveCells++;
				}
				if(CurrentCells[row][col-1])
				{
					SurroundAliveCells++;
				}
				if(CurrentCells[row][col+1])
				{
					SurroundAliveCells++;
				}
				if(CurrentCells[row+1][col-1])
				{
					SurroundAliveCells++;
				}
				if(CurrentCells[row+1][col])
				{
					SurroundAliveCells++;
				}
				if(CurrentCells[row+1][col+1])
				{
					SurroundAliveCells++;
				}
			
		}
		//�ж�λ�ڱ߲���λ�ڽǲ���ϸ��
		else if(row==0&&col!=0&&col!=19)
		{
				if(CurrentCells[row][col-1])
				{
					SurroundAliveCells++;
				}
				if(CurrentCells[row+1][col-1])
				{
					SurroundAliveCells++;
				}
				if(CurrentCells[row][col+1])
				{
					SurroundAliveCells++;
				}
				if(CurrentCells[row+1][col])
				{
					SurroundAliveCells++;
				}
				if(CurrentCells[row+1][col+1])
				{
					SurroundAliveCells++;
				}
		}
		else if(col==0&&row!=0&&row!=19)
			{
				if(CurrentCells[row-1][col])
				{
					SurroundAliveCells++;
				}
				if(CurrentCells[row-1][col+1])
				{
					SurroundAliveCells++;
				}
				if(CurrentCells[row][col+1])
				{
					SurroundAliveCells++;
				}
				if(CurrentCells[row+1][col+1])
				{
					SurroundAliveCells++;
				}
				if(CurrentCells[row+1][col])
				{
					SurroundAliveCells++;
				}
			}
		else if(row==19&&col!=0&&col!=19)
		{
				if(CurrentCells[row-1][col-1])
				{
					SurroundAliveCells++;
				}
				if(CurrentCells[row-1][col])
				{
					SurroundAliveCells++;
				}
				if(CurrentCells[row-1][col+1])
				{
					SurroundAliveCells++;
				}
				if(CurrentCells[row][col+1])
				{
					SurroundAliveCells++;
				}
				if(CurrentCells[row][col-1])
				{
					SurroundAliveCells++;
				}
		}
		else if(col==19&&row!=0&&row!=19)
		{
			if(CurrentCells[row-1][col])
			{
				SurroundAliveCells++;
			}
			if(CurrentCells[row-1][col-1])
			{
				SurroundAliveCells++;
			}
			if(CurrentCells[row][col-1])
			{
				SurroundAliveCells++;
			}
			if(CurrentCells[row+1][col-1])
			{
				SurroundAliveCells++;
			}
			if(CurrentCells[row+1][col])
			{
				SurroundAliveCells++;
			}
		}
		//�жϽ���ϸ��
		else if(row==0)
		{
			if(CurrentCells[row+1][col])
			{
				SurroundAliveCells++;
			}
			if(col==0)
			{
				if(CurrentCells[row+1][col+1])
				{
					SurroundAliveCells++;
				}
				if(CurrentCells[row][col+1])
				{
					SurroundAliveCells++;
				}
			}
			if(col==19)
			{
				if(CurrentCells[row+1][col-1])
				{
					SurroundAliveCells++;
				}
				if(CurrentCells[row][col-1])
				{
					SurroundAliveCells++;
				}
			}
		}
		else {
			if(CurrentCells[row-1][col])
			{
				SurroundAliveCells++;
			}
			if(col==0)
			{
				if(CurrentCells[row-1][col+1])
				{
					SurroundAliveCells++;
				}
				if(CurrentCells[row][col+1])
				{
					SurroundAliveCells++;
				}
			}
			if(col==19)
			{
				if(CurrentCells[row-1][col-1])
				{
					SurroundAliveCells++;
				}
				if(CurrentCells[row][col-1])
				{
					SurroundAliveCells++;
				}
			}
		}
		if(SurroundAliveCells==3)
		{
			NextCells[row][col]=true;
		}
		else if(SurroundAliveCells!=2)
		{
			NextCells[row][col]=false;
		}
		else
		{
			NextCells[row][col]=CurrentCells[row][col];
		}
	}
	//�������ͼ��
	public void RandomInitialize(int n)
	{
		isChanged=true;
		Random rand=new Random();
		int a=0;
		int x=0,y=0;
			synchronized(this)
			{
				//��ʼ��ǰ���ϸ��
				for(int i=0;i<rows;i++)
				{
					for(int j=0;j<cols;j++)
					{
						CurrentCells[i][j]=false;
					}
				}
				while(a<n)
				{
					x=rand.nextInt(20);
					y=rand.nextInt(20);
					if(!CurrentCells[y][x])
					{
						CurrentCells[y][x]=true;
						a++;
					}
				}
				isChanged=false;
				this.notifyAll();
			}
	}
}
