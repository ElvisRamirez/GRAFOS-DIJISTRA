package mundo;

public class Grafo {
	 private int mCoeficiente[][] = new int[51][51];
	    private int mAdyacencia[][] = new int[51][51];
	    private int cordeX[] = new int[51];
	    private int cordeY[] = new int[51];
	    private int nombre[] = new int[51];
	    private int enGrafo[];

	    public Grafo() {

	    }

	    public int getmCoeficiente(int i, int j) {
	        return mCoeficiente[i][j];
	    }

	    public int getmAdyacencia(int i, int j) {
	        return mAdyacencia[i][j];
	    }

	    public int getCordeX(int i) {
	        return cordeX[i];
	    }

	    public int getCordeY(int i) {
	        return cordeY[i];
	    }

	    public int getNombre(int i) {
	        return nombre[i];
	    }

	    public int getEnGrafo(int i) {
	        return enGrafo[i];
	    }

	    public void setmCoeficiente(int i, int j, int mCoeficiente) {
	        this.mCoeficiente[i][j] = mCoeficiente;
	    }

	    public void setmAdyacencia(int i, int j, int mAdyacencia) {
	        this.mAdyacencia[i][j] = mAdyacencia;
	    }

	    public void setCordeX(int i, int cordeX) {
	        this.cordeX[i] = cordeX;
	    }

	    public void setCordeY(int i, int cordeY) {
	        this.cordeY[i] = cordeY;
	    }

	    public void setNombre(int i, int nombre) {
	        this.nombre[i] = nombre;
	    }

	    public void setEnGrafo(int i, int enGrafo) {
	        this.enGrafo[i] = enGrafo;
	    }

	    public void crearEnGrafo(int i) {
	        enGrafo = new int[i];
	    }

}
