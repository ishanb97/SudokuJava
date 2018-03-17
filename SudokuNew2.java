package JPack;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class SudokuNew2 extends JApplet implements ActionListener
{
    JTextField t[][]=new JTextField[9][9];
    GridLayout gr= new GridLayout(10,9);
    int x=0,space=30;
    int sud[][]=new int[9][9];
    int gen[]={1,2,3,4,5,6,7,8,9};
    JButton jb[]=new JButton[9];
    public void init()
     {
      jb[0]=new JButton("Level 1");
      jb[1]=new JButton("Level 2");
      jb[2]=new JButton("Level 3");
      jb[3]=new JButton("Level 4");
      jb[4]=new JButton("Level 5");
      jb[5]=new JButton("Solve");
      jb[6]=new JButton("Check");
      jb[7]=new JButton("Next Puzzle");
      jb[8]=new JButton("Close");
      for(int co=0;co<9;co++)
       jb[co].addActionListener(this);
       setVisible(true);
       setLayout(gr);
       setSize(600,800);
       create();
       for(int d1=0;d1<10;d1++)
       { 
       for(int d2=0;d2<9;d2++)
       {
       if(d1<9)
       {
        t[d1][d2]=new JTextField();
        t[d1][d2].setText((sud[d1][d2] +""));
        t[d1][d2].setEditable(false);
        add(t[d1][d2]);
         }
         else
         add(jb[d2]);
       }
       }
       create_Spaces();
     }
     public void set()
     {
         for(int d1=0;d1<10;d1++)
       { 
       for(int d2=0;d2<9;d2++)
       {
       if(d1<9)
       {
        t[d1][d2].setText((sud[d1][d2] +""));
        t[d1][d2].setEditable(false);
        t[d1][d2].setBackground(Color.WHITE);
       }
       }
       }
        }
    public int generate()
    {
         int rnd=0;
         boolean chk=false; 
         while(chk==false)
        {
            rnd=0;
         while(rnd==0||rnd==10)
         rnd=(int)(Math.random()*10);         
         if(gen[rnd-1]!=0)
         {
             chk=true;
             
            }
        }
        gen[rnd-1]=0;
        return rnd;
    }
    public void create()
    {
        int rnd=0;
        for(int i=1;i<10;i++)
        {
        rnd=generate();
        x=rnd;
        for(int j=0;j<9;j++)
        {
            sud[j][x-1]=i;
            if((j+1)%3==0)
            x+=4;
            else
            x+=3;
            if(x>9)
            {
                x=x-9;
            }
        }
      }
    }
    public void actionPerformed(ActionEvent e)
    {
     int count=8;
     for(count=0;count<9;count++)
      {
       if(e.getSource()==jb[count])
       break;
      }
     switch(count)
     {
         case 0:space=10;
         break;
         case 1:space=20;
         break;
         case 2:space=30;
         break;
         case 3:space=40;
         break;
         case 4:space=50;
         break;
         case 5:solve();
         break;
         case 6:check();
         break;
         case 7:
         for(int z=1;z<10;z++)
         gen[z-1]=z;
         create();
         set();
         create_Spaces();
         break;
         case 8:System.exit(0);
       }
    } 
    public void create_Spaces()
    {
        int r1=10,r2=10;
        for(int i=0;i<=space;i++ )
        {
            r1=10;
            r2=10;
            while(r1>=9 ||  r2>=9)
          {
            r1=(int)(Math.random()*10);
            r2=(int)(Math.random()*10);
          }
          t[r1][r2].setText("");
          t[r1][r2].setEditable(true);
        }
    }
    public void check()
    {
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
           {
               if(t[i][j].getText().equals(""))
               t[i][j].setBackground(new Color(200,100,100));
               else
                if(Integer.parseInt(t[i][j].getText())==sud[i][j]  )
                t[i][j].setBackground(new Color(100,200,100));
                else
                t[i][j].setBackground(new Color(200,100,100));
            
           }
        }
                
    }
    public void solve()
    {
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
           {
                //if(t[i][j].getText()==" ")
                t[i][j].setText((sud[i][j] +""));
          }
         }
        }
}