package interfaz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;

import mundo.MetasGenericas;

public class Dialogo extends JDialog implements ActionListener {

	// ------------------------------------------------
	// Constantes
	// ------------------------------------------------
	private final static String GG_SELECTED = "GG seleccionado";

	// ------------------------------------------------
	// Atributos
	// ------------------------------------------------
	private InterfazCMMI principal;

	// TextFields

	private JTextArea txtDescripcion;
	private JTextArea txtNivelDeInst;

	// JButton
	private JButton btPracticas;

	// Pr�cticas
	private JTextArea txaPracticas;

	// JList
	//
	// private JList lista;
	private JScrollPane scroll;
	// JComboBox

	private JComboBox box;
	
	public Dialogo(InterfazCMMI ventana) {
		super(ventana, true);
		principal = ventana;
		setTitle("Metas gen�ricas de CMMI-Dev");
		setLayout(new GridLayout(1, 1));
		setPreferredSize(new Dimension(600, 385));
		setResizable(true);


		txaPracticas = new JTextArea(2, 2);
		txaPracticas.setBorder(new LineBorder(Color.BLACK));
		txaPracticas.setWrapStyleWord(true);
		txaPracticas.setLineWrap(true);
		txaPracticas.setEditable(false);
		txaPracticas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txaPracticas.setAutoscrolls(true);
		txaPracticas.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		scroll = new JScrollPane(txaPracticas);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		// lo del ComboBox
		String opciones[] = { "", "GG1", "GG2", "GG3" };
		box = new JComboBox<String>(opciones);
		box.setFont(new Font("Tahoma",Font.PLAIN,25));
		box.setEditable(false);
		box.addActionListener(this);
		box.setActionCommand(GG_SELECTED);

		JPanel cm = new JPanel();
		cm.setBorder(BorderFactory.createTitledBorder("C�digo:"));
		cm.setLayout(new GridLayout(1, 1));
		cm.add(box);
		
		JPanel txt = new JPanel();
		txt.setBorder(BorderFactory.createTitledBorder("Descripci�n:"));
		txt.setLayout(new GridLayout(1, 1));

		txtDescripcion = new JTextArea();
		txtDescripcion = new JTextArea();
		txtDescripcion.setBorder(new LineBorder(Color.BLACK));
		txtDescripcion.setWrapStyleWord(true);
		txtDescripcion.setLineWrap(true);
		txtDescripcion.setEditable(false);
		txtDescripcion.setFont(new Font("Calibri", Font.PLAIN, 14));
		txt.add(txtDescripcion);
		JPanel ni = new JPanel();
		ni.setBorder(BorderFactory.createTitledBorder("Nivel de institucionalizaci�n:"));
		ni.setLayout(new GridLayout(1, 1));
		txtNivelDeInst = new JTextArea();
		txtNivelDeInst.setBorder(new LineBorder(Color.BLACK));
		txtNivelDeInst.setWrapStyleWord(true);
		txtNivelDeInst.setLineWrap(true);
		txtNivelDeInst.setEditable(false);
		txtNivelDeInst.setFont(new Font("Calibri", Font.PLAIN, 14));
		ni.add(txtNivelDeInst);

		JPanel nose = new JPanel();
		nose.setLayout(new GridLayout(1, 1));
		nose.add(cm);

		JPanel prop = new JPanel();
		prop.setLayout(new GridLayout(3, 1));

		prop.add(nose);
		prop.add(txt);
		prop.add(ni);

		JPanel prac = new JPanel();
		prac.setBorder(BorderFactory.createTitledBorder("Pr�cticas:"));
		prac.setLayout(new GridLayout(1, 1));
		prac.add(scroll);
		
		JPanel todo = new JPanel();
		todo.setBorder(BorderFactory.createTitledBorder("Metas gen�ricas:"));
		todo.setLayout(new GridLayout(1, 2));
		todo.add(prop);
		todo.add(prac);
		add(todo);

		pack();
	}

	public String darMetaGenerica() {
		return (String) box.getSelectedItem();
	}

	public void actionPerformed(ActionEvent evento) {
		String comando = evento.getActionCommand();
		if (comando.equals(GG_SELECTED)) {
			if (darMetaGenerica().equals("GG1")) {
				setTxtDescripcion("Lograr las metas espec�ficas");
				setTxtNivelDeInst("Procesos realizados");

				setTxaPracticas(1);

			} else if (darMetaGenerica().equals("GG2")) {
				setTxtDescripcion("El proceso est� institucionalizado como un proceso gestionado.");
				setTxtNivelDeInst("Procesos definidos");
				setTxaPracticas(2);

			} else if (darMetaGenerica().equals("GG3")) {
				setTxtDescripcion("Institucionalizar un proceso definido.");
				setTxtNivelDeInst("El proceso est� institucionalizado como un proceso definido.");
				setTxaPracticas(3);

			} else if (darMetaGenerica().equals("")) {				
				setTxtDescripcion("");
				setTxtNivelDeInst("");
				setTxaPracticas(0);

			}
		}

	}


	public void setTxtDescripcion(String entrada) {
		this.txtDescripcion.setText(entrada);
	}

	public void setTxtNivelDeInst(String entrada) {
		this.txtNivelDeInst.setText(entrada);
	}

	public void setTxaPracticas(int num) {

		if (num == 1) {
			txaPracticas.setText("C�digo: GP 1.1\n"+ "Descripci�n: Realizar las pr�cticas espec�ficas\n");

		} else if (num == 2) {
			txaPracticas.setText("C�digo: GP 2.1\n"+ "Descripci�n: Establecer una pol�tica de la"
					+ " organizaci�n\n\n"+ "C�digo: GP 2.2\n"+"Descripcion: Planificar el proceso\n\n"+ 
					"C�digo: GP 2.3\n"+"Descripci�n: Proporcionar recursos\n\n"+ "C�digo: GP 2.4\n"+
					"Descripci�n: Asignar responsabilidad\n\n"+ "C�digo: GP 2.5\n"+ "Descripcion: "
					+ "Formar al personal\n\n"+ "C�digo: GP 2.6\n"+ "Descripci�n: Controlar los "
					+ "productos de trabajo\n\n"+ "C�digo: GP 2.7\n"+ "Descripci�n: Identificar e involucrar"
					+ " a las partes interesadas relevantes\n\n"+ "C�digo: GP 2.8\n"+ "Descripci�n: "
					+ "Monitorizar y controlar el proceso\n\n"+ "C�digo: GP 2.9\n"+ "Descripci�n: Evaluar "
					+ "objetivamente la adherencia\n\n" + "C�digo: GP 2.10\n"+ "Descripci�n:Revisar el"
					+ " estado con el nivel directivo\n");

		} else if (num == 3) {
			txaPracticas.setText("C�digo: GP 3.1\n"+ "Descripci�n: Establecer un proceso definido\n\n"
		    + "C�digo: GP 3.2\n"+"Descripci�n:Recopilar las experiencias relacionadas con los procesos\n");
		}
		else if (num == 0) {
		txaPracticas.setText("");
		

	}
	}
	}


