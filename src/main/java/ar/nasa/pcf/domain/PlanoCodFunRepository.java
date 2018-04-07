package ar.nasa.pcf.domain;

import ar.nasa.domain.Documento;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PlanoCodFunRepository {

//    private static final String PCF_FOLDER = "\\\\doccnaii\\tecnica\\ic\\cf";
    private static final String PCF_FOLDER = "/Users/ElMUDO-PC/cf";

    public List<Documento> findBy(String c) {
        List<Documento> listPcf = new ArrayList<>();

        try {
            Files.newDirectoryStream(Paths.get(PCF_FOLDER),
                path -> path.toFile().isDirectory())
                .forEach(path -> {
                    try {
                        Files.newDirectoryStream(path,
                            subPath ->  subPath.toString().endsWith("YS") || subPath.toString().endsWith("YF"))
                            .forEach(finalPath -> {
                                try {
                                    Files.newDirectoryStream(finalPath,
                                        file -> file.toString().contains(c)).forEach(
                                        plano -> listPcf.add(new PlanoCodFun(plano))
                                    );
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            });
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            );

        } catch (IOException e) {
            e.printStackTrace();
        }

        return listPcf;
    }
}
