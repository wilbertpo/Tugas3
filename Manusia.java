
public class Manusia {
	private String nama;
	private int umur;
	private double berat;
	private boolean jenisKelamin;

	public Manusia(String nama, int umur, double berat, boolean jenisKelamin)
	{
		this.nama = nama;
		this.umur = umur;
		this.berat = berat;
		this.jenisKelamin = jenisKelamin;
	}

	public String getNama() { return nama; }
	public int getUmur() { return umur; }
	public double getBerat() { return berat; }
	public boolean getJenisKelamin() { return jenisKelamin; }
}