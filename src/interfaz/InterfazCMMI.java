package interfaz;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import mundo.CMMI;
import mundo.MetasGenericas;

public class InterfazCMMI extends JFrame {
	
	private PanelBanner panelBanner;
	private PanelBotones panelBotones;
	private PanelDatos panelDatos;
	
	private CMMI mundo;
	
	public InterfazCMMI() {
		super("CMMI");
		mundo = new CMMI();
		mundo.inicializarConstelaciones("Archivos/archivoCMMIDev.txt", "Archivos/archivoCMMIAqc.txt", "Archivos/archivoCMMISvc.txt", "Archivos/archivoMetasGenericas.txt");

		// Construye la forma
		setLayout(new BorderLayout());
		setSize(940, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		panelBanner=new PanelBanner();
		add(panelBanner, BorderLayout.NORTH);

		panelBotones=  new PanelBotones(this);
		add(panelBotones, BorderLayout.WEST);
		
		panelDatos=  new PanelDatos(this);
		add(panelDatos, BorderLayout.CENTER);
		
		
	}
	
	public ArrayList<MetasGenericas> getMetasGenericas () {
		return mundo.getCMMIDev().getMetasGenericas();
	}
	
	
	
	public void mostrarDialogo() {
		Dialogo dialogo = new Dialogo(this);
		dialogo.setLocationRelativeTo(this);
		dialogo.setVisible(true);
	}
	
	public void mostrarDialogo2() {
		Dialogo2 dialogo = new Dialogo2(this);
		dialogo.setLocationRelativeTo(this);
		dialogo.setVisible(true);
	}
	
	public CMMI darMundo(){
		return mundo;
	}
	
	
	
	public void refrescarPanel (ArrayList param){
		panelDatos.refrescarLista(param);
	}
	
	
	
	public JTextArea darProposito(){
		return panelDatos.getTxaProposito();
	}
	
	
	
	public static void main(String[] args) {
		InterfazCMMI a = new InterfazCMMI();
		a.setVisible(true);
	}

}
