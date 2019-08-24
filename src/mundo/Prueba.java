package mundo;

import java.util.ArrayList;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CMMI cmmi = new CMMI();
		String arcDev = "Archivos/archivoCMMIDev.txt";
		String arcAcq = "Archivos/archivoCMMIAcq.txt";
		String arcScv = "Archivos/archivoCMMIScv.txt";
		String metas = "Archivos/archivoMetasGenericas.txt";
		cmmi.inicializarConstelaciones(arcDev, arcAcq, arcScv, metas);

		ArrayList<AreasProceso> areasParticulares = cmmi.particularesCMMIDev();
		mostrarArrayList(areasParticulares);
	}

	public static void mostrarArrayList(ArrayList<AreasProceso> A) {

		for (int i = 0; i < A.size(); i++) {
			System.out.println(A.get(i).toString());
		}

	}

}
