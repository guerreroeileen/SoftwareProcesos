package interfaz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import mundo.GP;
import mundo.MetasGenericas;

public class Dialogo2 extends JDialog implements ActionListener {

	// ------------------------------------------------
	// Constantes
	// ------------------------------------------------
	private final static String AP_SELECTED = "AP seleccionada";
	private final static String NA_SELECTED = "NA seleccionada";
	private final static String NO_SELECTED = "NO seleccionado";
	private final static String LISTO = "Listo";



	// ------------------------------------------------
	// Atributos
	// ------------------------------------------------
	private InterfazCMMI principal;
	
	private String entradaAP;
	private int entradaNA;
	private int entradaNO;

	// private JList lista;
	private JScrollPane scroll;
	// JComboBox

	private JComboBox boxAP;
	private JComboBox boxNA;
	private JComboBox boxNO;
	
	private JButton btnListo;
	
	private JTable tab;
	
	private DefaultTableModel tabla;

	private String[] cabecera;
	
	public Dialogo2(InterfazCMMI ventana) {
		super(ventana, true);
		principal = ventana;
		setTitle("Representación continua");
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(650, 385));
		setResizable(true);

		JPanel cm = new JPanel();
		cm.setBorder(BorderFactory.createTitledBorder("Incremento de niveles de capacidad"));
		cm.setLayout(new GridLayout(1, 4));
		
		JPanel Ap = new JPanel();
		Ap.setBorder(BorderFactory.createTitledBorder("Área de proceso"));
		Ap.setLayout(new GridLayout(1, 1));
		// lo del ComboBox
		String opciones[] = {"RSKM", "REQM", "OPD", "OPF", "OT", "OPP",
				"MA", "PPQA", "CM", "DAR", "CAR", "OPM", "IPM", "PMC",
				"PP", "QPM", "SAM", "PI", "RD", "TS", "VAL", "VER" };
		boxAP = new JComboBox<String>(opciones);
		boxAP.setEditable(false);
		boxAP.addActionListener(this);
		boxAP.setActionCommand(AP_SELECTED);
		Ap.add(boxAP);

		JPanel NA = new JPanel();
		NA.setBorder(BorderFactory.createTitledBorder("Nivel capacidad actual"));
		NA.setLayout(new GridLayout(1, 1));
		// lo del ComboBox
		
		//inicio
		String opciones2[] = {"0", "1", "2", "3"};
		boxNA = new JComboBox<String>(opciones2);
		boxNA.setEditable(false);
		boxNA.addActionListener(this);
		boxNA.setActionCommand(NA_SELECTED);
		NA.add(boxNA);
		
		JPanel NO = new JPanel();
		NO.setBorder(BorderFactory.createTitledBorder("Nivel capacidad objetivo"));
		NO.setLayout(new GridLayout(1, 1));
		// lo del ComboBox
		//final
		String opciones3[] = {"0", "1", "2", "3"};
		boxNO = new JComboBox<String>(opciones3);
		boxNO.setEditable(false);
		boxNO.addActionListener(this);
		boxNO.setActionCommand(NO_SELECTED);
		NO.add(boxNO);
		
		btnListo = new JButton("¡Listo!");
		btnListo.setActionCommand(LISTO);
		btnListo.addActionListener(this);
		btnListo.setBackground(Color.orange);
		btnListo.setFont(new Font("Calibri", Font.BOLD, 25));
		
		cm.add(Ap);
		cm.add(NA);
		cm.add(NO);
		cm.add(btnListo);

		add(cm, BorderLayout.NORTH);
		
		
		cabecera = new String [3];
		cabecera [0]="Práctica"; 
		cabecera [1]="Descripción";
		cabecera [2]="Elaboración del AP";
		
		
		String[][] datos = {};
		tabla = new DefaultTableModel(datos, cabecera);
		tab = new JTable(tabla);
		tab.setModel(tabla);
		scroll = new JScrollPane(tab);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		add(scroll, BorderLayout.CENTER);

		pack();
	}
	
	public String [][] llenarDesdeHasta (int inicio, int fin, ArrayList<MetasGenericas> arreglo){
		int tamanio=0;

//		ArrayList<GP> nuevo = new ArrayList<GP>();
//		for (int i = inicio; i <= fin; i++) {
//			MetasGenericas temporales = arreglo.get(i);
//			//Aqui da null y no sé porque
//			for (int j = 0; j < temporales.getPracticasGenericas().size(); j++) {
//				nuevo.add(temporales.getPracticasGenericas().get(j));
//				tamanio++;
//			}
//		}
		
		String [][] retorno = new String[15][3];
			
		for (int i = 0; i < 15; i++) {			
			retorno [i][0] = "hooo";
			retorno [i][1] = "hooo";
			retorno [i][2] = "hooo";
		}
		
		return retorno;
	}
	
	public void actualizarTabla (ArrayList<MetasGenericas> metas){
		String [][] tempo=llenarDesdeHasta(darNA(), darNO(), metas);
		tabla.setDataVector(tempo, cabecera);
	}
	

	public String darAP() {
		return (String) boxAP.getSelectedItem();
	}
	//inicio
	public int darNA() {
		return Integer.parseInt((String) boxNA.getSelectedItem());
	}
	//final
	public int darNO() {
		return Integer.parseInt((String) boxNO.getSelectedItem());
	}

	public void actionPerformed(ActionEvent evento) {
		String comando = evento.getActionCommand();
		if (comando.equals(AP_SELECTED)) {
			entradaAP=darAP();
			}
		if (comando.equals(NA_SELECTED)) {
			entradaNA=darNA();
		}
		if (comando.equals(NO_SELECTED)) {
			entradaNO=darNO();
		}
		if (comando.equals(LISTO)) {
			if(entradaNA>=entradaNO){
				JOptionPane.showMessageDialog(null, "El nivel actual debe ser menor al nivel objetivo","Error",JOptionPane.ERROR_MESSAGE);
			}
			else{
				actualizarTabla(principal.getMetasGenericas());
				}
		}


	}

	}