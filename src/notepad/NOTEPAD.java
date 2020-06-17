
package notepad;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
public class NOTEPAD implements ActionListener{
  JFrame f;
  JMenuBar mb;
  JMenu File,Edit,Format,View,Help;
  JMenuItem New,Open,Save,cut,copy,paste;
  JTextArea ta;
  JFileChooser fc;
  NOTEPAD(){
  f=new JFrame("Notepad");
   
  New=new JMenuItem("New");
  Open=new JMenuItem("Open");
  Save=new JMenuItem("Save");
  cut=new JMenuItem("cut");
  copy=new JMenuItem("copy");
  paste=new JMenuItem("paste");
  
       New.setMnemonic('N');
        New.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
        
        Open.setMnemonic('O');
        Open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));
        
        cut.setMnemonic('X');
        cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));
        
        copy.setMnemonic('C');
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
        
        paste.setMnemonic('P');
        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
        
        Save.setMnemonic('S');
        Save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
      
  
  New.addActionListener(this);
  Open.addActionListener(this);
  Save.addActionListener(this);
  cut.addActionListener(this);
  copy.addActionListener(this);
  paste.addActionListener(this);
  
  
        JMenuItem menuItemOpen = new JMenuItem("Open");
          menuItemOpen.setMnemonic(KeyEvent.VK_O);
  
  mb=new JMenuBar();
  mb.setBounds(0,0,800,20);
 
  File=new JMenu("File");
  Edit=new JMenu("Edit");
  Format=new JMenu("Format");
  View=new JMenu("View");
  Help=new JMenu("Help");

  File.add(New);
  File.add(Open);
  File.add(Save);
  Edit.add(cut);
  Edit.add(copy);
  Edit.add(paste);
  
  mb.add(File);
  mb.add(Edit);
  mb.add(Format);
  mb.add(View);
  mb.add(Help);
  f.setJMenuBar(mb);
  
  ta=new JTextArea();
  ta.setBounds(0,20,800,800);
  f.add(ta);
  f.setSize(800,500);
  f.setLayout(null);
  f.setVisible(true);
  f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
public void actionPerformed(ActionEvent e) {    
    if(e.getSource()==New){
     ta.setText("");
    }
if(e.getSource()==Open){    
    JFileChooser fc=new JFileChooser();    
    fc.showOpenDialog(f);        
        File f= new File(fc.getSelectedFile().getAbsolutePath());
        FileReader fr;
        try{  
            fr=new FileReader(f);
        BufferedReader br=new BufferedReader(fr);    
        String s="",data="";                         
        while((data=br.readLine())!=null){    
        s=s+data+"\n";    
        }    
        ta.setText(s);    
        br.close();    
        }
        catch (Exception ex) {ex.printStackTrace();  }                 
    }    
  
       if(e.getSource()==Save){    
    JFileChooser fc=new JFileChooser();    
    fc.showSaveDialog(f);        
        File f= new File(fc.getSelectedFile().getAbsolutePath());
        FileWriter fw;
        try{ 
            fw=new FileWriter(f);
        BufferedWriter bw=new BufferedWriter(fw);    
        fw.write(ta.getText());
        bw.close();
        }    
          catch (Exception ex) {ex.printStackTrace();  } 
        }
       if(e.getSource()==cut){
           ta.cut();
       }
       if(e.getSource()==copy){
           ta.copy();
       }
       if(e.getSource()==paste){
           ta.paste();
       }
}

  public static void main(String[] args) {
       new NOTEPAD();


    }
    
}
