package interfaz;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class PanelBanner extends JPanel {
	  public PanelBanner()
	    {
	    	 JLabel imagen = new JLabel( );
		        ImageIcon icono = new ImageIcon( "data/cmmi.jpg" );
		        // La agrega a la etiqueta
		        imagen = new JLabel( "" );
		        imagen.setIcon( icono );
		        add( imagen );
		        

		        setBackground( Color.WHITE );
		        setBorder( new LineBorder( Color.BLACK ) );
	    }
}
