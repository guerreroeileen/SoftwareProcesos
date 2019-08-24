package interfaz;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import mundo.AreasProceso;

public class PanelDatos extends JPanel implements ListSelectionListener {
	
	private JList listaAreas;
	private JScrollPane scroll;
	private JTextArea txaProposito;
	private AreasProceso area;
	
	private InterfazCMMI principal;
	
	public PanelDatos(InterfazCMMI inter) {
		
		principal = inter;
		setBorder(BorderFactory.createTitledBorder("Áreas"));
		setLayout(new GridLayout(1, 2));
		
		JPanel prop = new JPanel();
		prop.setBorder(BorderFactory.createTitledBorder("Propósito:"));
		prop.setLayout(new GridLayout(1, 1));
		txaProposito = new JTextArea( 2, 2 );
		txaProposito.setBorder( new LineBorder( Color.BLACK ) );
		txaProposito.setWrapStyleWord( true );
		txaProposito.setLineWrap( true );
		txaProposito.setEditable( false );
		txaProposito.setFont(new Font("Calibri", Font.PLAIN, 19));
		txaProposito.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
				
		JPanel lis = new JPanel();
		lis.setBorder(BorderFactory.createTitledBorder("Código/Nombre"));
		lis.setLayout(new GridLayout(1, 1));
		
		listaAreas = new JList( );
		listaAreas.addListSelectionListener(this);
		listaAreas.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );

		scroll = new JScrollPane( listaAreas );
		scroll.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
		scroll.setPreferredSize(new Dimension (400,200));
		scroll.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
		lis.add(scroll);
		prop.add(txaProposito);
		add(lis);
		add(prop);
	}
	
	
	public void refrescarLista (ArrayList lis) {
		if(lis!=null){
			listaAreas.setListData(lis.toArray());
			listaAreas.setSelectedIndex(0);
			updateUI();
		}
		else{
			ArrayList ago = new ArrayList<>();
			listaAreas.setListData(ago.toArray());
			listaAreas.setSelectedIndex(0);
			updateUI();
		}
		
	}
	
	
	

	public JTextArea getTxaProposito() {
		return txaProposito;
	}


	public void setTxaProposito(JTextArea txaProposito) {
		this.txaProposito = txaProposito;
	}


	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (listaAreas.getSelectedValue()!=null) {
			area = (AreasProceso) listaAreas.getSelectedValue();
			txaProposito.setText(area.getProposito());
		}
	}


}
