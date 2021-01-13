package controller;

import model.Kosten;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import repository.FileRepository;

public class Controller {
    private FileRepository repository;

    public Controller() throws Exception {
        this.repository = new FileRepository();
    }

    private List<Kosten> dateSort() {
        List<Kosten> result = new ArrayList<>();
        repository.findAll().forEach(result::add);
        result.sort((a, b) -> b.getDatum().compareTo(a.getDatum()));
        return result;
    }

    private List<Kosten> categoryFilter(List<Kosten> input, Kosten.Kategorie kategorie) {
        List<Kosten> result = new ArrayList<>();
        input.forEach(kosten -> {
            if (kosten.getKategorie().equals(kategorie))
                result.add(kosten);
        });
        return result;
    }

    public void readWrite(){
        File file1 = new File("files/food.txt");
        File file2 = new File("files/uni.txt");
        File file3 = new File("files/transport.txt");
        File file4 = new File("files/accommodation.txt");
        try {
            List<Kosten> sorted=this.dateSort();

            this.repository.saveToFile(this.categoryFilter(sorted, Kosten.Kategorie.FOOD), file1);
            this.repository.saveToFile(this.categoryFilter(sorted, Kosten.Kategorie.UNI), file2);
            this.repository.saveToFile(this.categoryFilter(sorted, Kosten.Kategorie.TRANSPORT), file3);
            this.repository.saveToFile(this.categoryFilter(sorted, Kosten.Kategorie.ACCOMODATION), file4);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
