package objekte;

public class Bewertung {
	
	private int matrikelnummer;
	private double noteAusarbeitung;
	private double noteSeminar;
	private double noteGesamt;
	public int getMatrikelnummer() {
		return matrikelnummer;
	}
	public void setMatrikelnummer(int matrikelnummer) {
		this.matrikelnummer = matrikelnummer;
	}
	public double getNoteAusarbeitung() {
		return noteAusarbeitung;
	}
	public void setNoteAusarbeitung(double noteAusarbeitung) {
		this.noteAusarbeitung = noteAusarbeitung;
	}
	public double getNoteSeminar() {
		return noteSeminar;
	}
	public void setNoteSeminar(double noteSeminar) {
		this.noteSeminar = noteSeminar;
	}
	public double getNoteGesamt() {
		return noteGesamt;
	}
	public void setNoteGesamt(double noteGesamt) {
		this.noteGesamt = noteGesamt;
	}
	public Bewertung(int matrikelnummer, double noteAusarbeitung, double noteSeminar, double noteGesamt) {
		super();
		this.matrikelnummer = matrikelnummer;
		this.noteAusarbeitung = noteAusarbeitung;
		this.noteSeminar = noteSeminar;
		this.noteGesamt = noteGesamt;
	}
	
	

}
