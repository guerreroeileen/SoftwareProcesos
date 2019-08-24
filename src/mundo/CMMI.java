package mundo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CMMI {

	private Constelaciones CMMIDev;

	private Constelaciones CMMIAcq;

	private Constelaciones CMMIScv;

	public CMMI(Constelaciones cMMIDev, Constelaciones cMMIAcq, Constelaciones cMMIScv) {
		CMMIDev = cMMIDev;
		CMMIAcq = cMMIAcq;
		CMMIScv = cMMIScv;
	}

	public CMMI() {
		CMMIDev = new Constelaciones();
		CMMIAcq = new Constelaciones();
		CMMIScv = new Constelaciones();
	}

	public void inicializarConstelaciones(String arcDev, String arcAcq, String arcScv, String nomM) {
		iniciarCMMIDev(arcDev);
		iniciarCMMIAcq(arcAcq);
		iniciarCMMIScv(arcScv);
		inicializarMetasGenericas(nomM);
	}

	private void iniciarCMMIDev(String arcDev) {
		FileReader archivo;
		try {
			archivo = new FileReader(arcDev);
			BufferedReader reader = new BufferedReader(archivo);
			reader.readLine(); // CMMI Dev
			String[] codigo = null, nombre = null, proposito = null;
			while (reader.ready()) {
				nombre = reader.readLine().split(":"); // Nombre
				codigo = reader.readLine().split(":"); // Codigo
				proposito = reader.readLine().split(":"); // Proposito
				AreasProceso area = new AreasProceso(codigo[1], nombre[1], proposito[1]);
				ArrayList<AreasProceso> areas = CMMIDev.getAreas();
				areas.add(area);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void iniciarCMMIAcq(String arcAcq) {
		FileReader archivo;
		try {
			archivo = new FileReader(arcAcq);
			BufferedReader reader = new BufferedReader(archivo);
			reader.readLine(); // CMMI Acq
			String[] codigo = null, nombre = null, proposito = null;
			while (reader.ready()) {
				nombre = reader.readLine().split(":"); // Nombre
				codigo = reader.readLine().split(":"); // Codigo
				proposito = reader.readLine().split(":"); // Proposito
				AreasProceso area = new AreasProceso(codigo[1], nombre[1], proposito[1]);
				ArrayList<AreasProceso> areas = CMMIAcq.getAreas();
				areas.add(area);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void iniciarCMMIScv(String arcScv) {
		FileReader archivo;
		try {
			archivo = new FileReader(arcScv);
			BufferedReader reader = new BufferedReader(archivo);
			reader.readLine(); // CMMI Scv
			String[] codigo = null, nombre = null, proposito = null;
			while (reader.ready()) {
				nombre = reader.readLine().split(":"); // Nombre
				codigo = reader.readLine().split(":"); // Codigo
				proposito = reader.readLine().split(":"); // Proposito
				AreasProceso area = new AreasProceso(codigo[1], nombre[1], proposito[1]);
				ArrayList<AreasProceso> areas = CMMIScv.getAreas();
				areas.add(area);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void inicializarMetasGenericas(String nombreArchivo) {
		FileReader archivo;
		try {
			archivo = new FileReader(nombreArchivo);
			BufferedReader reader = new BufferedReader(archivo);
			reader.readLine();//
			reader.readLine();//
			String[] codigo = null, descripcion = null, nivel = null, codigoGP = null, descripGP = null;
			ArrayList<GP> genericos = new ArrayList<>();
			ArrayList<MetasGenericas> metaGG = CMMIDev.getMetasGenericas();
			while (reader.ready()) {
				codigo = reader.readLine().split(":");
				descripcion = reader.readLine().split(":");
				nivel = reader.readLine().split(":");
				GP gg = null;
				String linea=reader.readLine();
				while (!linea.equals("//")) {
					codigoGP = linea.split(":");
					descripGP = reader.readLine().split(":");
					gg = new GP(codigoGP[1], descripGP[1]);
					genericos.add(gg);
					linea=reader.readLine();
				}
				MetasGenericas mg = new MetasGenericas(codigo[1], descripcion[1], nivel[1]);
				mg.setGg(gg);
				metaGG.add(mg);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<AreasProceso> comunCMMIDevYCMMIAcq() {
		ArrayList<AreasProceso> dev = CMMIDev.getAreas();
		ArrayList<AreasProceso> acq = CMMIAcq.getAreas();
		ArrayList<AreasProceso> comun = new ArrayList<AreasProceso>();
		for (int i = 0; i < dev.size(); i++) {
			AreasProceso areatmp = dev.get(i);
			for (int j = 0; j < acq.size(); j++) {
				if (areatmp.getCodigo().equals(acq.get(j).getCodigo())) {
					comun.add(acq.get(j));
				}
			}
		}
		return comun;
	}

	public ArrayList<AreasProceso> comunCMMIDevYCMMIScv() {
		ArrayList<AreasProceso> dev = CMMIDev.getAreas();
		ArrayList<AreasProceso> Scv = CMMIScv.getAreas();
		ArrayList<AreasProceso> comun = new ArrayList<AreasProceso>();
		for (int i = 0; i < dev.size(); i++) {
			AreasProceso areatmp = dev.get(i);
			for (int j = 0; j < Scv.size(); j++) {
				if (areatmp.getCodigo().equals(Scv.get(j).getCodigo())) {
					comun.add(Scv.get(j));
				}
			}
		}
		return comun;
	}

	public ArrayList<AreasProceso> comunCMMIScvYCMMIAcq() {
		ArrayList<AreasProceso> scv = CMMIScv.getAreas();
		ArrayList<AreasProceso> Acq = CMMIAcq.getAreas();
		ArrayList<AreasProceso> comun = new ArrayList<AreasProceso>();
		for (int i = 0; i < scv.size(); i++) {
			AreasProceso areatmp = scv.get(i);
			for (int j = 0; j < Acq.size(); j++) {
				if (areatmp.getCodigo().equals(Acq.get(j).getCodigo())) {
					comun.add(Acq.get(j));
				}
			}
		}
		return comun;
	}

	public ArrayList<AreasProceso> comunTodas() {
		ArrayList<AreasProceso> scv = CMMIScv.getAreas();
		ArrayList<AreasProceso> Acq = CMMIAcq.getAreas();
		ArrayList<AreasProceso> dev = CMMIDev.getAreas();
		ArrayList<AreasProceso> comun = new ArrayList<AreasProceso>();
		for (int i = 0; i < scv.size(); i++) {
			AreasProceso areatmp = scv.get(i);
			for (int j = 0; j < Acq.size(); j++) {
				if (areatmp.getCodigo().equals(Acq.get(j).getCodigo())
						&& areatmp.getCodigo().equals(dev.get(j).getCodigo())) {
					comun.add(Acq.get(j));
				}
			}
		}
		return comun;
	}

	public ArrayList<AreasProceso> particularesCMMIDev() {
		ArrayList<AreasProceso> scv = CMMIScv.getAreas();
		ArrayList<AreasProceso> Acq = CMMIAcq.getAreas();
		ArrayList<AreasProceso> dev = CMMIDev.getAreas();
		ArrayList<AreasProceso> comun = new ArrayList<AreasProceso>();
		for (int i = 0; i < dev.size(); i++) {
			AreasProceso areatmp = dev.get(i);
			boolean esta = false;
			for (int j = 0; j < Acq.size(); j++) {
				if (areatmp.getCodigo().equals(Acq.get(j).getCodigo())
						|| areatmp.getCodigo().equals(scv.get(j).getCodigo())) {
					esta = true;
				}
			}
			if (scv.get(22).getCodigo().equals(areatmp.getCodigo())
					|| scv.get(23).getCodigo().equals(areatmp.getCodigo())) {
				esta = true;
			}
			if (!esta) {
				comun.add(areatmp);
			}
		}
		return comun;
	}

	public ArrayList<AreasProceso> particularesCMMIAcq() {
		ArrayList<AreasProceso> scv = CMMIScv.getAreas();
		ArrayList<AreasProceso> Acq = CMMIAcq.getAreas();
		ArrayList<AreasProceso> dev = CMMIDev.getAreas();
		ArrayList<AreasProceso> comun = new ArrayList<AreasProceso>();
		for (int i = 0; i < Acq.size(); i++) {
			AreasProceso areatmp = Acq.get(i);
			boolean esta = false;
			for (int j = 0; j < dev.size(); j++) {
				if (areatmp.getCodigo().equals(dev.get(j).getCodigo())
						|| areatmp.getCodigo().equals(scv.get(j).getCodigo())) {
					esta = true;
				}
			}
			if (scv.get(22).getCodigo().equals(areatmp.getCodigo())
					|| scv.get(23).getCodigo().equals(areatmp.getCodigo())) {
				esta = true;
			}
			if (!esta) {
				comun.add(areatmp);
			}
		}
		return comun;
	}

	public ArrayList<AreasProceso> particularesCMMIScv() {
		ArrayList<AreasProceso> scv = CMMIScv.getAreas();
		ArrayList<AreasProceso> Acq = CMMIAcq.getAreas();
		ArrayList<AreasProceso> dev = CMMIDev.getAreas();
		ArrayList<AreasProceso> comun = new ArrayList<AreasProceso>();
		for (int i = 0; i < Acq.size(); i++) {
			AreasProceso areatmp = scv.get(i);
			boolean esta = false;
			for (int j = 0; j < Acq.size(); j++) {
				if (areatmp.getCodigo().equals(Acq.get(j).getCodigo())
						|| areatmp.getCodigo().equals(dev.get(j).getCodigo())) {
					esta = true;
				}
			}
			if (!esta) {
				comun.add(areatmp);
			}
		}
		return comun;
	}

	public ArrayList<AreasProceso> CMMIListarTodoSinRepetidos() {
		ArrayList<AreasProceso> sinRepetidos = this.CMMIListarTodoConRepetidos();
		for (int i = 0; i < sinRepetidos.size(); i++) {
			AreasProceso comparador = sinRepetidos.get(i);
			for (int j = (i + 1); j < sinRepetidos.size(); j++) {
				if (comparador.getCodigo().equals(sinRepetidos.get(j).getCodigo())) {
					sinRepetidos.remove(j);
				}
			}
		}
		return sinRepetidos;
	}

	private ArrayList<AreasProceso> CMMIListarTodoConRepetidos() {
		ArrayList<AreasProceso> scv = CMMIScv.getAreas();
		ArrayList<AreasProceso> Acq = CMMIAcq.getAreas();
		ArrayList<AreasProceso> dev = CMMIDev.getAreas();
		ArrayList<AreasProceso> todo = new ArrayList<AreasProceso>();
		for (int i = 0; i < scv.size(); i++) {
			AreasProceso adicionar = scv.get(i);
			todo.add(adicionar);
		}
		for (int i = 0; i < Acq.size(); i++) {
			AreasProceso adicionar = Acq.get(i);
			todo.add(adicionar);
		}
		for (int i = 0; i < dev.size(); i++) {
			AreasProceso adicionar = dev.get(i);
			todo.add(adicionar);
		}
		return todo;
	}
	public ArrayList<AreasProceso> unionCMMIDevYCMMIAcq() {
		ArrayList<AreasProceso> Acq = CMMIAcq.getAreas();
		ArrayList<AreasProceso> dev = CMMIDev.getAreas();
		ArrayList<AreasProceso> union = new ArrayList<>();
		for (int i = 0; i < Acq.size(); i++) {
			union.add(Acq.get(i));
		}
		for (int i = 0; i < dev.size(); i++) {
			union.add(dev.get(i));
		}
		for (int i = 0; i < union.size(); i++) {
			AreasProceso comparador = union.get(i);
			for (int j = (i + 1); j < union.size(); j++) {
				if (comparador.getCodigo().equals(union.get(j).getCodigo())) {
					union.remove(j);
				}
			}
		}
		return union;
	}
	
	public ArrayList<AreasProceso> unionCMMIDevYCMMIScv() {
		ArrayList<AreasProceso> Scv = CMMIScv.getAreas();
		ArrayList<AreasProceso> dev = CMMIDev.getAreas();
		ArrayList<AreasProceso> union = new ArrayList<>();
		for (int i = 0; i < Scv.size(); i++) {
			union.add(Scv.get(i));
		}
		for (int i = 0; i < dev.size(); i++) {
			union.add(dev.get(i));
		}
		for (int i = 0; i < union.size(); i++) {
			AreasProceso comparador = union.get(i);
			for (int j = (i + 1); j < union.size(); j++) {
				if (comparador.getCodigo().equals(union.get(j).getCodigo())) {
					union.remove(j);
				}
			}
		}
		return union;
	}
	
	public ArrayList<AreasProceso> unionCMMIScvYCMMIAcq() {
		ArrayList<AreasProceso> Scv = CMMIScv.getAreas();
		ArrayList<AreasProceso> Acq = CMMIAcq.getAreas();
		ArrayList<AreasProceso> union = new ArrayList<>();
		for (int i = 0; i < Scv.size(); i++) {
			union.add(Scv.get(i));
		}
		for (int i = 0; i < Acq.size(); i++) {
			union.add(Acq.get(i));
		}
		for (int i = 0; i < union.size(); i++) {
			AreasProceso comparador = union.get(i);
			for (int j = (i + 1); j < union.size(); j++) {
				if (comparador.getCodigo().equals(union.get(j).getCodigo())) {
					union.remove(j);
				}
			}
		}
		return union;
	}

	public ArrayList<AreasProceso> particularesCMMIDevYCMMIScv() {
		ArrayList<AreasProceso> Scv = particularesCMMIScv();
		ArrayList<AreasProceso> dev = particularesCMMIDev();
		ArrayList<AreasProceso> part = new ArrayList<>();
		for (int i = 0; i < Scv.size(); i++) {
			part.add(Scv.get(i));
		}
		for (int i = 0; i < dev.size(); i++) {
			part.add(dev.get(i));
		}
		return part;
	}
	
	public ArrayList<AreasProceso> particularesCMMIDevYCMMIAcq() {
		ArrayList<AreasProceso> Acq = particularesCMMIAcq();
		ArrayList<AreasProceso> dev = particularesCMMIDev();
		ArrayList<AreasProceso> part = new ArrayList<>();
		for (int i = 0; i < Acq.size(); i++) {
			part.add(Acq.get(i));
		}
		for (int i = 0; i < dev.size(); i++) {
			part.add(dev.get(i));
		}
		return part;
	}
	
	public ArrayList<AreasProceso> particularesCMMIScvYCMMIAcq() {
		ArrayList<AreasProceso> Acq = particularesCMMIAcq();
		ArrayList<AreasProceso> Scv = particularesCMMIScv();
		ArrayList<AreasProceso> part = new ArrayList<>();
		for (int i = 0; i < Acq.size(); i++) {
			part.add(Acq.get(i));
		}
		for (int i = 0; i < Scv.size(); i++) {
			part.add(Scv.get(i));
		}
		return part;
	}
	
	public ArrayList<AreasProceso> particularesCMMITodo() {
		ArrayList<AreasProceso> Acq = particularesCMMIAcq();
		ArrayList<AreasProceso> Scv = particularesCMMIScv();
		ArrayList<AreasProceso> Dev = particularesCMMIDev();
		ArrayList<AreasProceso> part = new ArrayList<>();
		for (int i = 0; i < Acq.size(); i++) {
			part.add(Acq.get(i));
		}
		for (int i = 0; i < Scv.size(); i++) {
			part.add(Scv.get(i));
		}
		for (int i = 0; i < Dev.size(); i++) {
			part.add(Dev.get(i));
		}
		return part;
	}

	public Constelaciones getCMMIDev() {
		return CMMIDev;
	}

	public void setCMMIDev(Constelaciones cMMIDev) {
		CMMIDev = cMMIDev;
	}

	public Constelaciones getCMMIAcq() {
		return CMMIAcq;
	}

	public void setCMMIAcq(Constelaciones cMMIAcq) {
		CMMIAcq = cMMIAcq;
	}

	public Constelaciones getCMMIScv() {
		return CMMIScv;
	}

	public void setCMMIScv(Constelaciones cMMIScv) {
		CMMIScv = cMMIScv;
	}
}
