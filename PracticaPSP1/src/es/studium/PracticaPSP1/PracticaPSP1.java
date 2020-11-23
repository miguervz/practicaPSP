package es.studium.PracticaPSP1;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
public class PracticaPSP1 extends JFrame
{
private static final long serialVersionUID = 1L;
private JPanel contentPane;
/**
* Launch the application.
*/
public static void main(String[] args)
{
EventQueue.invokeLater(new Runnable() {

public void run() {
try {
PracticaPSP1 frame = new PracticaPSP1();
frame.setVisible(true);
} catch (Exception e) {
e.printStackTrace();
}
}
});
}
/**
* Create the frame.
*/

public PracticaPSP1()
{
this.setTitle("Práctica1");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(430, 150, 900, 600);

contentPane = new JPanel();
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
setContentPane(contentPane);
contentPane.setLayout(null);

JTextArea textArea1 = new JTextArea();
textArea1.setBounds(46, 90, 300, 200);


JLabel texto = new JLabel("Procesos activos");
JTextField textField = new JTextField();
textField.setBounds(46, 60, 180, 23);



DefaultListModel<String> listModel;
listModel = new DefaultListModel<String>();


JList<String> list = new JList<String>(listModel);



texto.setBounds(400, 270, 140, 30);
list.setBounds(400, 300, 340, 200);

JButton bEjecutar = new JButton("Ejecutar");
JButton bFinalizar = new JButton("Finalizar");
JButton bJuego = new JButton("Juego");
JButton bGestion = new JButton("Gestión");
JButton bPaint = new JButton("Paint");
JButton bNotas = new JButton("Notas");
bNotas.setBounds(600, 40, 70, 23);
bPaint.setBounds(600, 70, 70, 23);
bGestion.setBounds(590, 100, 90, 23);
bJuego.setBounds(600, 130, 70, 23);
bEjecutar.setBounds(246, 60, 100, 23);
bFinalizar.setBounds(745, 300, 100, 23);

contentPane.add(bNotas);
contentPane.add(bPaint);
contentPane.add(bJuego);
contentPane.add(bGestion);
contentPane.add(bFinalizar);
contentPane.add(bEjecutar);
contentPane.add(textField);
contentPane.add(texto);
contentPane.add(list);
contentPane.add(textArea1);


bEjecutar.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
	String textfield=textField.getText();
	try {
		
		Runtime.getRuntime().exec(textfield);
		
		
	} catch (IOException e1) {
		
		e1.printStackTrace();
	}
}
});


bNotas.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
	try {
		Runtime.getRuntime().exec("notepad.exe");
		listModel.addElement("Notas");
		bNotas.setEnabled(false);
	} catch (IOException e1) {
		
		e1.printStackTrace();
	}
}
});

bPaint.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
	try {
		Runtime.getRuntime().exec("mspaint.exe");
		listModel.addElement("Paint");
		bPaint.setEnabled(false);
	} catch (IOException e1) {
		
		e1.printStackTrace();
	}
}
});
bGestion.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
	try {
		Runtime.getRuntime().exec("mspaint.exe");
		listModel.addElement("Programa de gestión.");
	} catch (IOException e1) {
		e1.printStackTrace();
	}
}
});
bFinalizar.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
	
	String selected = list.getSelectedValue().toString();
	if (selected.equals("Paint")) {
    	 String cmd = "taskkill /IM mspaint.exe";

 		try {
 			Runtime.getRuntime().exec(cmd);





 		
 		} catch (IOException e1) {

 			e1.printStackTrace();
 		}
 		int index = list.getSelectedIndex();
 		listModel.remove(index);
    	 bPaint.setEnabled(true);
    	 }
     if (selected.equals("Notas")) {
    	 String cmd = "taskkill /IM notepad.exe";

 		try {
 			Runtime.getRuntime().exec(cmd);





 		
 		} catch (IOException e1) {

 			e1.printStackTrace();
 		}
 		int index = list.getSelectedIndex();
 		listModel.remove(index);
    	 bNotas.setEnabled(true);
    	 }
}
});


}
public String ruta(String pathname)
{
File filePathname = new File(pathname);

File[] files = filePathname.listFiles();
String res = "";
for (File element : files) {
if(res=="") {
res = element.getName();
} else {
res = res + "\n" + element.getName();
}
}
return res;
}
}
