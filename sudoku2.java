 import java.awt.event.*;
 import javax.swing.*;
 
class GraphicallyRepresentation extends JFrame implements ActionListener
 {
 Container con;
 JButton b[][]=new JButton[9][9];
 TextField t[]=new TextField[61];
 JMenuBar mbar;
 JMenu file,help,option,setting;
 JMenuItem submit,exit,about,Reset;
 
int[][] cp=new int[9][9];
 int[][] ip=new int[9][9];
 
GraphicallyRepresentation()
 {
 super("Play Sudoku");
 setSize(500,500);
 //setresizeable(false);
 
con=getContentPane();
 con.setLayout(new GridLayout(9,9));
 
Mylogic ob1=new Mylogic();
 ob1.complet_puzzle();
 ob1.puzzle();
 
int c=0;
 for(int i=0;i<9;i++)
 for(int j=0;j<9;j++)
 {
 b[i][j]=new JButton(""+ip[i][j]);
 b[i][j].setFont(new Font("ARIALBD",Font.BOLD,20));
 b[i][j].setForeground(Color.BLUE);
 if(ip[i][j]==0)
 {
 //b[i][j]=new JButton("");
 b[i][j].setText("");
 b[i][j].setBackground(Color.WHITE);
 b[i][j].addActionListener(this);
 
}
 
con.add(b[i][j]);
 
if(i==3 || i==4 || i==5 || j==3 || j==4 || j==5)
 {
 if(2<i></i> {
 b[i][j].setBackground(Color.CYAN);
 continue;
 }
 b[i][j].setBackground(Color.pink);
 
}
 
else
 b[i][j].setBackground(Color.CYAN);
 }
 
mbar=new JMenuBar();
 setJMenuBar(mbar);
 
file=new JMenu("File");
 option=new JMenu("Option");
 setting=new JMenu("Setting");
 help=new JMenu("Help");
 
about=new JMenuItem("About");
 Reset=new JMenuItem("reset");
 submit=new JMenuItem("Submit");
 exit=new JMenuItem("Exit");
 
submit.addActionListener(
 new ActionListener(){
 public void actionPerformed(ActionEvent e)
 {
 int r=0;
 
for(int i=0;i<9;i++)
 for(int j=0;j<9;j++)
 if(cp[i][j]!=Integer.parseInt(b[i][j].getText()))
 {r=1;
 break;}
 
for(int i=0;i<9;i++)
 {
 System.out.println();
 for(int j=0;j<9;j++)
 {
 System.out.print(cp[i][j]);
 System.out.print(Integer.parseInt(b[i][j].getText())+" ");
 }}
 System.out.print("\n"+r);
 if(r==0)
 JOptionPane.showMessageDialog(GraphicallyRepresentation.this,"You won the Game");
 //System.out.println("You won the Game");
 else
 //System.out.println("You lose the Game");
 JOptionPane.showMessageDialog(GraphicallyRepresentation.this,"You lose the Game"); }
 
});
 exit.addActionListener(
 new ActionListener(){
 public void actionPerformed(ActionEvent e)
 {
 System.exit(0);
 }
 
});
 
about.addActionListener(
 new ActionListener(){
 public void actionPerformed(ActionEvent e)
 {
 JOptionPane.showMessageDialog( GraphicallyRepresentation.this,
 "this is my project",
 "About", JOptionPane.PLAIN_MESSAGE );
 }
 }
 );
 Reset.addActionListener(
 new ActionListener()
 {
 public void actionPerformed(ActionEvent e)
 {
 //recall();
 }
 });
 
file.add(Reset);
 file.add(submit);
 file.addSeparator();
 file.add(exit);
 mbar.add(file);
 mbar.add(option);
 mbar.add(setting);
 mbar.add(help);
 mbar.add(about);
 
show();
 
//ob1.complet_puzzle();
 
MyWindowAdapter mwa=new MyWindowAdapter();
 addWindowListener(mwa);
 
}
 
class Mylogic extends Logic
 {
 void complet_puzzle()
 {
 cp=save();
 
/*for(int i=0;i<9;i++)
 {
 for(int j=0;j<9;j++)
 System.out.print(cp[i][j]+" ");
 System.out.println();
 }*/
 }
 void puzzle()
 {
 ip=hide();
 /*System.out.print("\n\n\n"+"nhiding puzzle :\n");
 for(int i=0;i<9;i++)
 {
 for(int j=0;j<9;j++)
 System.out.print(ip[i][j]+" ");
 System.out.println();
 }*/
 }
 
}
 
class MyWindowAdapter extends WindowAdapter
 {
 public void windowClosing(WindowEvent e)
 {
 System.exit(0);
 }
 }
 
public void actionPerformed(ActionEvent e)
 {
 for(int i=0;i<9;i++)
 for(int j=0;j<9;j++)
 {
 if(e.getSource()==b[i][j])
 {
 String s=JOptionPane.showInputDialog("enter your number");
 int c=Integer.parseInt(s);
 if(0c)
 {
 b[i][j].setText(s);
 //b[i][j].setBackground(Color.GRAY);
 b[i][j].setFont(new Font("ARIALBD",Font.BOLD,25));
 b[i][j].setForeground(Color.RED);
 }
 
break;
 }
 }
 }
 void recall()
 {
 GraphicallyRepresentation rs=new GraphicallyRepresentation();
 }
 
public static void main (String[] args) {
 GraphicallyRepresentation ob=new GraphicallyRepresentation();
 
}
 }