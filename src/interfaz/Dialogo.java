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

	// Prácticas
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
		setTitle("Metas genéricas de CMMI-Dev");
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
		cm.setBorder(BorderFactory.createTitledBorder("Código:"));
		cm.setLayout(new GridLayout(1, 1));
		cm.add(box);
		
		JPanel txt = new JPanel();
		txt.setBorder(BorderFactory.createTitledBorder("Descripción:"));
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
		ni.setBorder(BorderFactory.createTitledBorder("Nivel de institucionalización:"));
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
		prac.setBorder(BorderFactory.createTitledBorder("Prácticas:"));
		prac.setLayout(new GridLayout(1, 1));
		prac.add(scroll);
		
		JPanel todo = new JPanel();
		todo.setBorder(BorderFactory.createTitledBorder("Metas genéricas:"));
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
				setTxtDescripcion("Lograr las metas específicas");
				setTxtNivelDeInst("Procesos realizados");

				setTxaPracticas(1);

			} else if (darMetaGenerica().equals("GG2")) {
				setTxtDescripcion("El proceso está institucionalizado como un proceso gestionado.");
				setTxtNivelDeInst("Procesos definidos");
				setTxaPracticas(2);

			} else if (darMetaGenerica().equals("GG3")) {
				setTxtDescripcion("Institucionalizar un proceso definido.");
				setTxtNivelDeInst("El proceso está institucionalizado como un proceso definido.");
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
			txaPracticas.setText("Código: GP 1.1\n"+ "Descripción: Realizar las prácticas específicas\n");

		} else if (num == 2) {
			txaPracticas.setText("Código: GP 2.1\n"+ "Descripción: Establecer una política de la"
					+ " organización\n\n"+ "Código: GP 2.2\n"+"Descripcion: Planificar el proceso\n\n"+ 
					"Código: GP 2.3\n"+"Descripción: Proporcionar recursos\n\n"+ "Código: GP 2.4\n"+
					"Descripción: Asignar responsabilidad\n\n"+ "Código: GP 2.5\n"+ "Descripcion: "
					+ "Formar al personal\n\n"+ "Código: GP 2.6\n"+ "Descripción: Controlar los "
					+ "productos de trabajo\n\n"+ "Código: GP 2.7\n"+ "Descripción: Identificar e involucrar"
					+ " a las partes interesadas relevantes\n\n"+ "Código: GP 2.8\n"+ "Descripción: "
					+ "Monitorizar y controlar el proceso\n\n"+ "Código: GP 2.9\n"+ "Descripción: Evaluar "
					+ "objetivamente la adherencia\n\n" + "Código: GP 2.10\n"+ "Descripción:Revisar el"
					+ " estado con el nivel directivo\n");

		} else if (num == 3) {
			txaPracticas.setText("Código: GP 3.1\n"+ "Descripción: Establecer un proceso definido\n\n"
		    + "Código: GP 3.2\n"+"Descripción:Recopilar las experiencias relacionadas con los procesos\n");
		}
		else if (num == 0) {
		txaPracticas.setText("");
		

	}
	}
	}


