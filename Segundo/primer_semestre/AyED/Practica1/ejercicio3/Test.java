package ejercicio3;
public class Test {

	public static void main(String[] args) {
		Estudiante[] vecE = new Estudiante[2]; 
		Profesor[] vecP = new Profesor[3];
		
		// ASIGNACIÓN DE VALORES
		for(int i = 0;i<2; i++) {
			vecE[i] = new Estudiante();
			vecE[i].setNombre("NomEst"+i);
			vecE[i].setApellido("ApeEst"+i);
			vecE[i].setEmail("MailEst"+i);
			vecE[i].setComision("ComEst"+i);
			vecE[i].setDireccion("DirEst"+i);
		}
		for(int i=0;i<3;i++) {
			vecP[i] = new Profesor();
			vecP[i].setNombre("NomPro"+i);
			vecP[i].setApellido("ApePro"+i);
			vecP[i].setEmail("MailPro"+i);
			vecP[i].setCatedra("CatePro"+i);
			vecP[i].setFacultad("FacuPro"+i);
		}
		// RECORRIDO E IMPRESION
		for(int i=0;i<2;i++) {
			System.out.println(vecE[i].tusDatos());
		}
		for(int i=0;i<3;i++) {
			System.out.println(vecP[i].tusDatos());
		}
	}
}
