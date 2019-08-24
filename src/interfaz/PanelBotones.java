package interfaz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PanelBotones extends JPanel implements ActionListener{

	private final static String ACCION = "accion";
	private final static String METAS_DEV = "metas Dev";
	private final static String UNION = "Union";
	private final static String INTERSECCION = "Interseccion";
	private final static String PARTICULAR = "Particular";
	private final static String INCREMENTAR = "Incrementar";

	
	
	private InterfazCMMI interfaz;
	
    private JToggleButton btnDev;
    private JToggleButton btnAcq;
    private JToggleButton btnSvc;
	private JRadioButton btrUnion, btrInter, btrParti;
	private ButtonGroup grupoBotones;
	private JButton btnMetasDev;
	private JButton btnIncremento;

	
	public PanelBotones(InterfazCMMI inter){
		
		interfaz = inter;
		setBorder(BorderFactory.createTitledBorder("Opciones"));
		setLayout(new GridLayout(2,2));
		
		btnDev = new JToggleButton("DEV");
		btnDev.addActionListener(this);
		btnDev.setActionCommand(ACCION);
		btnDev.setBackground(Color.YELLOW);
		btnDev.setEnabled(false);
		btnAcq = new JToggleButton("ACQ");
		btnAcq.addActionListener(this);
		btnAcq.setActionCommand(ACCION);
		btnAcq.setBackground(Color.GREEN);
		btnAcq.setEnabled(false);
		btnSvc = new JToggleButton("SVC");
		btnSvc.addActionListener(this);
		btnSvc.setActionCommand(ACCION);
		btnSvc.setBackground(Color.BLUE);
		btnSvc.setEnabled(false);
		JPanel prop = new JPanel();
		prop.setLayout(new GridLayout(3, 1));
		prop.add(btnDev);
		prop.add(btnAcq);
		prop.add(btnSvc);
		grupoBotones = new ButtonGroup();
		btrUnion = new JRadioButton("Union");
		btrUnion.setActionCommand(UNION);
		btrUnion.addActionListener(this);
		grupoBotones.add(btrUnion);
		btrInter = new JRadioButton("Intersección");
		btrInter.setActionCommand(INTERSECCION);
		btrInter.addActionListener(this);
		grupoBotones.add(btrInter);
		btrParti = new JRadioButton("Particular");
		btrParti.setActionCommand(PARTICULAR);
		btrParti.addActionListener(this);
		grupoBotones.add(btrParti);
		btnMetasDev = new JButton("Metas G. CMMI-Dev");
		btnMetasDev.setActionCommand(METAS_DEV);
		btnMetasDev.addActionListener(this);
		btnMetasDev.setEnabled(false);
		btnIncremento = new JButton("Incrementar nivel");
		btnIncremento.setActionCommand(INCREMENTAR);
		btnIncremento.addActionListener(this);
//		btnIncremento.setEnabled(false);
		JPanel rad = new JPanel();
		rad.setLayout(new GridLayout(5, 1));
		rad.add(btrUnion);
		rad.add(btrInter);
		rad.add(btrParti);
		rad.add(btnMetasDev);
		rad.add(btnIncremento);
		add(prop);
		add(rad);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		if(comando.equals(UNION)||comando.equals(INTERSECCION)||comando.equals(PARTICULAR)){
			btnAcq.setEnabled(true);
			btnDev.setEnabled(true);
			btnSvc.setEnabled(true);
		}
		
		if(comando.equals(UNION)){
			//Ninguno
			if(!btnDev.isSelected()&&!btnAcq.isSelected()&&!btnSvc.isSelected()){
				btnMetasDev.setEnabled(false);
				interfaz.refrescarPanel(null);
			}
			// solo dev 
			else if(btnDev.isSelected()&&!btnAcq.isSelected()&&!btnSvc.isSelected()){
				btnMetasDev.setEnabled(true);
				interfaz.refrescarPanel(interfaz.darMundo().getCMMIDev().getAreas());
			}
			// solo acq
			else if(!btnDev.isSelected()&&btnAcq.isSelected()&&!btnSvc.isSelected()){
				btnMetasDev.setEnabled(false);
				interfaz.refrescarPanel(interfaz.darMundo().getCMMIAcq().getAreas());
			}
			// solo svc 
			else if(!btnDev.isSelected()&&!btnAcq.isSelected()&&btnSvc.isSelected()){
				btnMetasDev.setEnabled(false);
				interfaz.refrescarPanel(interfaz.darMundo().getCMMIScv().getAreas());
			}
			//Todos
			else if(btnDev.isSelected()&&btnAcq.isSelected()&&btnSvc.isSelected()){
				btnMetasDev.setEnabled(true);
				interfaz.refrescarPanel(interfaz.darMundo().CMMIListarTodoSinRepetidos());
			} 
			// dev y acq 
			else if(btnDev.isSelected()&&btnAcq.isSelected()&&!btnSvc.isSelected()){
				btnMetasDev.setEnabled(true);
				interfaz.refrescarPanel(interfaz.darMundo().unionCMMIDevYCMMIAcq());
			}
			// dev y svc
			else if(btnDev.isSelected()&&!btnAcq.isSelected()&&btnSvc.isSelected()){
				btnMetasDev.setEnabled(true);
				interfaz.refrescarPanel(interfaz.darMundo().unionCMMIDevYCMMIScv());
			}
			// acq y svc
			else if(!btnDev.isSelected()&&btnAcq.isSelected()&&btnSvc.isSelected()){
				btnMetasDev.setEnabled(false);
				interfaz.refrescarPanel(interfaz.darMundo().unionCMMIScvYCMMIAcq());
			}
		}
		
		if(comando.equals(INTERSECCION)){
			//Ninguno
			if(!btnDev.isSelected()&&!btnAcq.isSelected()&&!btnSvc.isSelected()){
				btnMetasDev.setEnabled(false);
				interfaz.refrescarPanel(null);
			}
			// solo dev 
			else if(btnDev.isSelected()&&!btnAcq.isSelected()&&!btnSvc.isSelected()){
				btnMetasDev.setEnabled(true);
				interfaz.refrescarPanel(interfaz.darMundo().getCMMIDev().getAreas());
			}
			// solo acq
			else if(!btnDev.isSelected()&&btnAcq.isSelected()&&!btnSvc.isSelected()){
				btnMetasDev.setEnabled(false);
				interfaz.refrescarPanel(interfaz.darMundo().getCMMIAcq().getAreas());
			}
			// solo svc 
			else if(!btnDev.isSelected()&&!btnAcq.isSelected()&&btnSvc.isSelected()){
				btnMetasDev.setEnabled(false);
				interfaz.refrescarPanel(interfaz.darMundo().getCMMIScv().getAreas());
			}
			// todos
			else if(btnDev.isSelected()&&btnAcq.isSelected()&&btnSvc.isSelected()){
				btnMetasDev.setEnabled(true);
				interfaz.refrescarPanel(interfaz.darMundo().comunTodas());
			} 
			// dev y acq 
			else if(btnDev.isSelected()&&btnAcq.isSelected()&&!btnSvc.isSelected()){
				btnMetasDev.setEnabled(true);
				interfaz.refrescarPanel(interfaz.darMundo().comunCMMIDevYCMMIAcq());
			}
			// dev y svc
			else if(btnDev.isSelected()&&!btnAcq.isSelected()&&btnSvc.isSelected()){
				btnMetasDev.setEnabled(true);
				interfaz.refrescarPanel(interfaz.darMundo().comunCMMIDevYCMMIScv());
			}
			// acq y svc
			else if(!btnDev.isSelected()&&btnAcq.isSelected()&&btnSvc.isSelected()){
				btnMetasDev.setEnabled(false);
				interfaz.refrescarPanel(interfaz.darMundo().comunCMMIScvYCMMIAcq());
			}
		}
		if(comando.equals(PARTICULAR)){
			//Ninguno
			if(!btnDev.isSelected()&&!btnAcq.isSelected()&&!btnSvc.isSelected()){
				btnMetasDev.setEnabled(false);
				interfaz.refrescarPanel(null);
			}
			// solo dev 
			else if(btnDev.isSelected()&&!btnAcq.isSelected()&&!btnSvc.isSelected()){
				btnMetasDev.setEnabled(true);
				interfaz.refrescarPanel(interfaz.darMundo().particularesCMMIDev());
			}
			// solo acq
			else if(!btnDev.isSelected()&&btnAcq.isSelected()&&!btnSvc.isSelected()){
				btnMetasDev.setEnabled(false);
				interfaz.refrescarPanel(interfaz.darMundo().particularesCMMIAcq());
			}
			// solo svc 
			else if(!btnDev.isSelected()&&!btnAcq.isSelected()&&btnSvc.isSelected()){
				btnMetasDev.setEnabled(false);
				interfaz.refrescarPanel(interfaz.darMundo().particularesCMMIScv());
			}
			// todos
			if(btnDev.isSelected()&&btnAcq.isSelected()&&btnSvc.isSelected()){
				btnMetasDev.setEnabled(true);
				interfaz.refrescarPanel(interfaz.darMundo().particularesCMMITodo());
			} 
			// dev y acq 
			else if(btnDev.isSelected()&&btnAcq.isSelected()&&!btnSvc.isSelected()){
				btnMetasDev.setEnabled(true);
				interfaz.refrescarPanel(interfaz.darMundo().particularesCMMIDevYCMMIAcq());
			}
			// dev y svc
			else if(btnDev.isSelected()&&!btnAcq.isSelected()&&btnSvc.isSelected()){
				btnMetasDev.setEnabled(true);
				interfaz.refrescarPanel(interfaz.darMundo().particularesCMMIDevYCMMIScv());
			}
			// acq y svc
			else if(!btnDev.isSelected()&&btnAcq.isSelected()&&btnSvc.isSelected()){
				btnMetasDev.setEnabled(false);
				interfaz.refrescarPanel(interfaz.darMundo().particularesCMMIScvYCMMIAcq());
			}
		}
		
		if(comando.equals(METAS_DEV)){
			interfaz.mostrarDialogo();
		
		}
		if(comando.equals(INCREMENTAR)){
			interfaz.mostrarDialogo2();
		
		}
		
		if(comando.equals(ACCION)){
			//Ninguno
			if(!btnDev.isSelected()&&!btnAcq.isSelected()&&!btnSvc.isSelected()){
				btnMetasDev.setEnabled(false);
				interfaz.refrescarPanel(null);
				interfaz.darProposito().setText("");
			}
			// uniones
			if(btrUnion.isSelected()){
				//Ninguno
				if(!btnDev.isSelected()&&!btnAcq.isSelected()&&!btnSvc.isSelected()){
					btnMetasDev.setEnabled(false);
					interfaz.refrescarPanel(null);
				}
				// solo dev 
				else if(btnDev.isSelected()&&!btnAcq.isSelected()&&!btnSvc.isSelected()){
					btnMetasDev.setEnabled(true);
					interfaz.refrescarPanel(interfaz.darMundo().getCMMIDev().getAreas());
				}
				// solo acq
				else if(!btnDev.isSelected()&&btnAcq.isSelected()&&!btnSvc.isSelected()){
					btnMetasDev.setEnabled(false);
					interfaz.refrescarPanel(interfaz.darMundo().getCMMIAcq().getAreas());
				}
				// solo svc 
				else if(!btnDev.isSelected()&&!btnAcq.isSelected()&&btnSvc.isSelected()){
					btnMetasDev.setEnabled(false);
					interfaz.refrescarPanel(interfaz.darMundo().getCMMIScv().getAreas());
				}
				// todos
				if(btnDev.isSelected()&&btnAcq.isSelected()&&btnSvc.isSelected()){
					btnMetasDev.setEnabled(true);
					interfaz.refrescarPanel(interfaz.darMundo().CMMIListarTodoSinRepetidos());
				} 
				// dev y acq 
				else if(btnDev.isSelected()&&btnAcq.isSelected()&&!btnSvc.isSelected()){
					btnMetasDev.setEnabled(true);
					interfaz.refrescarPanel(interfaz.darMundo().unionCMMIDevYCMMIAcq());
				}
				// dev y svc
				else if(btnDev.isSelected()&&!btnAcq.isSelected()&&btnSvc.isSelected()){
					btnMetasDev.setEnabled(true);
					interfaz.refrescarPanel(interfaz.darMundo().unionCMMIDevYCMMIScv());
				}
				// acq y svc
				else if(!btnDev.isSelected()&&btnAcq.isSelected()&&btnSvc.isSelected()){
					btnMetasDev.setEnabled(false);
					interfaz.refrescarPanel(interfaz.darMundo().unionCMMIScvYCMMIAcq());
				}
			// intersecciones	
			} else if(btrInter.isSelected()){
				//Ninguno
				if(!btnDev.isSelected()&&!btnAcq.isSelected()&&!btnSvc.isSelected()){
					btnMetasDev.setEnabled(false);
					interfaz.refrescarPanel(null);
				}
				// solo dev 
				else if(btnDev.isSelected()&&!btnAcq.isSelected()&&!btnSvc.isSelected()){
					btnMetasDev.setEnabled(true);
					interfaz.refrescarPanel(interfaz.darMundo().getCMMIDev().getAreas());
				}
				// solo acq
				else if(!btnDev.isSelected()&&btnAcq.isSelected()&&!btnSvc.isSelected()){
					btnMetasDev.setEnabled(false);
					interfaz.refrescarPanel(interfaz.darMundo().getCMMIAcq().getAreas());
				}
				// solo svc 
				else if(!btnDev.isSelected()&&!btnAcq.isSelected()&&btnSvc.isSelected()){
					btnMetasDev.setEnabled(false);
					interfaz.refrescarPanel(interfaz.darMundo().getCMMIScv().getAreas());
				}
				// todos
				if(btnDev.isSelected()&&btnAcq.isSelected()&&btnSvc.isSelected()){
					btnMetasDev.setEnabled(true);
					interfaz.refrescarPanel(interfaz.darMundo().comunTodas());
				} 
				// dev y acq 
				else if(btnDev.isSelected()&&btnAcq.isSelected()&&!btnSvc.isSelected()){
					btnMetasDev.setEnabled(true);
					interfaz.refrescarPanel(interfaz.darMundo().comunCMMIDevYCMMIAcq());
				}
				// dev y svc
				else if(btnDev.isSelected()&&!btnAcq.isSelected()&&btnSvc.isSelected()){
					btnMetasDev.setEnabled(true);
					interfaz.refrescarPanel(interfaz.darMundo().comunCMMIDevYCMMIScv());
				}
				// acq y svc
				else if(!btnDev.isSelected()&&btnAcq.isSelected()&&btnSvc.isSelected()){
					btnMetasDev.setEnabled(false);
					interfaz.refrescarPanel(interfaz.darMundo().comunCMMIScvYCMMIAcq());
				}
			}
			else if (btrParti.isSelected()){
				//Ninguno
				if(!btnDev.isSelected()&&!btnAcq.isSelected()&&!btnSvc.isSelected()){
					btnMetasDev.setEnabled(false);
					interfaz.refrescarPanel(null);
				}
				// solo dev 
				else if(btnDev.isSelected()&&!btnAcq.isSelected()&&!btnSvc.isSelected()){
					btnMetasDev.setEnabled(true);
					interfaz.refrescarPanel(interfaz.darMundo().particularesCMMIDev());
				}
				// solo acq
				else if(!btnDev.isSelected()&&btnAcq.isSelected()&&!btnSvc.isSelected()){
					btnMetasDev.setEnabled(false);
					interfaz.refrescarPanel(interfaz.darMundo().particularesCMMIAcq());
				}
				// solo svc 
				else if(!btnDev.isSelected()&&!btnAcq.isSelected()&&btnSvc.isSelected()){
					btnMetasDev.setEnabled(false);
					interfaz.refrescarPanel(interfaz.darMundo().particularesCMMIScv());
				}
				// todos
				if(btnDev.isSelected()&&btnAcq.isSelected()&&btnSvc.isSelected()){
					btnMetasDev.setEnabled(true);
					interfaz.refrescarPanel(interfaz.darMundo().particularesCMMITodo());
				} 
				// dev y acq 
				else if(btnDev.isSelected()&&btnAcq.isSelected()&&!btnSvc.isSelected()){
					btnMetasDev.setEnabled(true);
					interfaz.refrescarPanel(interfaz.darMundo().particularesCMMIDevYCMMIAcq());
				}
				// dev y svc
				else if(btnDev.isSelected()&&!btnAcq.isSelected()&&btnSvc.isSelected()){
					btnMetasDev.setEnabled(true);
					interfaz.refrescarPanel(interfaz.darMundo().particularesCMMIDevYCMMIScv());
				}
				// acq y svc
				else if(!btnDev.isSelected()&&btnAcq.isSelected()&&btnSvc.isSelected()){
					btnMetasDev.setEnabled(false);
					interfaz.refrescarPanel(interfaz.darMundo().particularesCMMIScvYCMMIAcq());
				}
			}
		}
	}
		
}