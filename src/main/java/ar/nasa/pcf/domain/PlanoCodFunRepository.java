package ar.nasa.pcf.domain;

import ar.nasa.domain.Documento;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PlanoCodFunRepository {

    public static final String PCF_FOLDER = "\\\\doccnaii\\tecnica\\ic\\cf";

    public List<Documento> findBy(String c) {
        List<Documento> listPcf = new ArrayList<>();

        try {
            Files.newDirectoryStream(Paths.get(PCF_FOLDER),
                    path -> path.toString().endsWith(".pdf"))
                    .forEach(path -> listPcf.add(new PlanoCodFun(path)));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return listPcf;
    }
}
