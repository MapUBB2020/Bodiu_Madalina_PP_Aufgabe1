package repository;

import model.Kosten;
import java.io.File;
import java.util.List;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FileRepository {
    private List<Kosten> kostenListe = new ArrayList<>();
    private File file;

    public FileRepository() throws Exception {
        this.file = new File("files/kosten.txt");
        this.readFromFile();
    }

    public Iterable<Kosten> findAll() {
        return this.kostenListe;
    }

    public void saveToFile(List<Kosten> outputList, File outputFile) throws Exception {
        PrintWriter output = new PrintWriter(outputFile);
        outputList.forEach(kosten -> {
            output.write(kosten.getName() + "#" + kosten.getKategorie() + "#" + kosten.getPreis() + "#" + kosten.getMenge() + "#" + kosten.getDatum().toString());
            output.write("\n");
        });
        output.close();
    }

    private void readFromFile() throws Exception {
        Scanner scanner = new Scanner(this.file);
        while (scanner.hasNextLine()) {
            String[] fileRow = scanner.nextLine().split("%");
            Kosten newKosten = new Kosten(fileRow[0], fileRow[1], fileRow[2], fileRow[3], fileRow[4]);
            this.kostenListe.add(newKosten);
        }
        scanner.close();
    }
}
