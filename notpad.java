import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
class notpad extends JFrame implements ActionListener
{
JMenuBar mb;
JMenu mn1,mn2,mn3,mn4,mn5,mn6;
JMenuItem mi1,mi2,mi3,mi4,mi5,mi6,mi7,mi8;
JRadioButtonMenuItem rm1,rm2,rm3,rm4,rm5,rm6,rm7,rm8;
JTextArea ta1;
Container con=getContentPane();
notpad()
{
setSize(1000,1000);

mb=new JMenuBar();

ta1=new JTextArea();

mn1=new JMenu("File");
mn2=new JMenu("Format");
mn3=new JMenu("App");
mn4=new JMenu("Help");
mn5=new JMenu("Background");
mn6=new JMenu("FontColor");

mi1=new JMenuItem("New");
mi2=new JMenuItem("Open");
mi3=new JMenuItem("Save");
mi4=new JMenuItem("Exit");
mi5=new JMenuItem("Calculator");
mi6=new JMenuItem("MSPaint");
mi7=new JMenuItem("Login");
mi8=new JMenuItem("About");


rm1=new JRadioButtonMenuItem("Red");
rm2=new JRadioButtonMenuItem("Cyan");
rm3=new JRadioButtonMenuItem("Pink");
rm4=new JRadioButtonMenuItem("Custom");
rm5=new JRadioButtonMenuItem("White");
rm6=new JRadioButtonMenuItem("Black");
rm7=new JRadioButtonMenuItem("Blue");
rm8=new JRadioButtonMenuItem("Custom");

ButtonGroup bg=new ButtonGroup();
bg.add(rm1);
bg.add(rm2);
bg.add(rm3);
bg.add(rm4);

ButtonGroup bg1=new ButtonGroup();
bg1.add(rm5);
bg1.add(rm6);
bg1.add(rm7);
bg1.add(rm8);

mn1.add(mi1);
mn1.add(mi2);
mn1.add(mi3);
mn1.add(mi4);

mn5.add(rm1);
mn5.add(rm2);
mn5.add(rm3);
mn5.add(rm4);

mn2.add(mn5);
mn2.add(mn6);


mn5.add(rm1);
mn5.add(rm2);
mn5.add(rm3);
mn5.add(rm4);


mn6.add(rm5);
mn6.add(rm6);
mn6.add(rm7);
mn6.add(rm8);

mn3.add(mi5);
mn3.add(mi6);
mn3.add(mi7);

mn4.add(mi8);

mb.add(mn1);
mb.add(mn2);
mb.add(mn3);
mb.add(mn4);

add(ta1,"Center");
JScrollPane s1=new JScrollPane(ta1,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

rm1.addActionListener(this);
rm2.addActionListener(this);
rm3.addActionListener(this);
rm4.addActionListener(this);
rm5.addActionListener(this);
rm6.addActionListener(this);
rm7.addActionListener(this);
rm8.addActionListener(this);
mi5.addActionListener(this);
mi6.addActionListener(this);
mi7.addActionListener(this);
mi2.addActionListener(this);
mi3.addActionListener(this);
mi1.addActionListener(this);
mi4.addActionListener(this);
mi8.addActionListener(this);
add(s1);

setJMenuBar(mb);
setVisible(true);
}

public void actionPerformed(ActionEvent e)
{
if(e.getSource()==rm1)
ta1.setBackground(Color.red);

if(e.getSource()==rm2)
ta1.setBackground(Color.cyan);

if(e.getSource()==rm3)
ta1.setBackground(Color.pink);

if(e.getSource()==rm4)
{
JColorChooser ch=new JColorChooser();
Color c=ch.showDialog(this,"Select Color",Color.red);
ta1.setBackground(c);
}
if(e.getSource()==rm5)
ta1.setForeground(Color.white);

if(e.getSource()==rm6)
ta1.setForeground(Color.black);


if(e.getSource()==rm7)
ta1.setForeground(Color.blue);

if(e.getSource()==rm8)
{
JColorChooser ch1=new JColorChooser();
Color c1=ch1.showDialog(this,"Select Color",Color.green);
ta1.setForeground(c1);
}

if(e.getSource()==mi1)
{
int a=JOptionPane.showConfirmDialog(this,"Do You Want To Save The File");
if(a==0)
{
JFileChooser fs1=new JFileChooser(); 
fs1.showSaveDialog(this);
String d2=fs1.getSelectedFile().getPath();
try
{
BufferedWriter bw=new BufferedWriter(new FileWriter(d2));
bw.write(ta1.getText());
}
catch(Exception e13)
{
}
}
else if(a==1)
{
ta1.setText("");
}
}


if(e.getSource()==mi2)
{
try
{
JFileChooser fs=new JFileChooser();
fs.showOpenDialog(this);
String d1=fs.getSelectedFile().getPath();
BufferedReader br=new BufferedReader(new FileReader(d1));
String s9="",s8="";
while((s9=br.readLine())!=null)
{
s8=s8+s9+"\n";
}
ta1.setText(s8);
br.close();
}
catch(Exception e9)
{
JOptionPane.showMessageDialog(this,"Bhai File Nhi Mil Rahi");
}
}

if(e.getSource()==mi3)
{
try
{
JFileChooser fs1=new JFileChooser(); 
fs1.showSaveDialog(this);
String d2=fs1.getSelectedFile().getPath();
BufferedWriter bw=new BufferedWriter(new FileWriter(d2));
bw.write(ta1.getText());
bw.close();
}
catch(Exception e13)
{
}
}

if(e.getSource()==mi4)
{
System.exit(0);
}

if(e.getSource()==mi5)
new calc();


if(e.getSource()==mi6)
{
Runtime r=Runtime.getRuntime();
try
{
Process p=r.exec("mspaint.exe");
}
catch(Exception e1)
{
JOptionPane.showMessageDialog(this,"Bhia File Nhi Mil Rahi");
}
}

if(e.getSource()==mi8)
JOptionPane.showMessageDialog(this,"Please Don't Trust On This Notepad");



if(e.getSource()==mi7)
new id();





}
public static void main(String kl[])
{
new notpad();
}
}