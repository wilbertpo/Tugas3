import java.io.BufferedReader;
import java.nio.file.Path;
import java.util.List;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.PrintWriter;


public class ManusiaCSV implements CSV<Manusia> {

	@Override
	public void write(Path path, List<Manusia> items) {
		try(PrintWriter pw = new PrintWriter(path.toString());){
			for (Manusia m : items) pw.append(String.format("%s;%d;%f;%b\n",m.getNama(),m.getUmur(),m.getBerat(),m.getJenisKelamin())); //My Windows take ';' as separator
			pw.flush();
			pw.close();
		} catch (IOException e) {
            System.err.println("I/O exception occured when reading file");
        }	
	}
		

    @Override
    public List<Manusia> read(Path path) {
        List<Manusia> manusia = new ArrayList<Manusia>();
        try(BufferedReader r = new BufferedReader(new FileReader(path.toString()))){
            String baris;
            while((baris = r.readLine()) != null){
                String[] m = baris.split(";");
                manusia.add(new Manusia(m[0],Integer.parseInt(m[1]),Double.parseDouble(m[2]),Boolean.parseBoolean(m[3])));
            }
        } catch (IOException e) {
            System.err.println("I/O exception occured when reading file");
        } catch (NumberFormatException e){
            System.err.println("Data is invalid");
        } catch (ArrayIndexOutOfBoundsException e){
            System.err.println("Index Out of Bounds");
        }
        return manusia;
    }	
	
}
