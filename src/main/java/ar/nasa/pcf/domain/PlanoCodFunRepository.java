package ar.nasa.pcf.domain;

import ar.nasa.domain.Documento;
import io.github.cdimascio.dotenv.Dotenv;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PlanoCodFunRepository {

    private final String PCF_FOLDER;

    public PlanoCodFunRepository(Dotenv dotenv) {
        PCF_FOLDER = dotenv.get("CF_FOLDER", "\\\\doccnaii\\planos\\ic\\cf");
    }

    public List<Documento> findBy(String c) {
        List<Documento> listPcf = new ArrayList<>();
        String comp = c.toUpperCase();

        try {
            Files.newDirectoryStream(Paths.get(PCF_FOLDER),
                    path -> path.toFile().isDirectory())
                    .forEach(path -> {
                        try {
                            Files.newDirectoryStream(path,
                                    subPath -> subPath.toString().endsWith("YS") || subPath.toString().endsWith("YF"))
                                    .forEach(subPath -> {
                                        try {
                                            Files.newDirectoryStream(subPath,
                                                    comPath -> comPath.toString().endsWith(comp.substring(0,5)))
                                                    .forEach(finalPath -> {
                                                        try {
                                                            Files.newDirectoryStream(finalPath,
                                                                    file -> {
                                                                        String filePath = file.toString().toUpperCase();
                                                                        return filePath.endsWith(".PDF") && filePath.contains(comp);
                                                                    })
                                                                    .forEach(
                                                                            plano -> listPcf.add(new PlanoCodFun(plano))
                                                                    );
                                                        } catch (IOException e) {
                                                            e.printStackTrace();
                                                        }
                                                    });
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                    });
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });

        } catch (IOException e) {
            e.printStackTrace();
        }

        return listPcf;
    }
}
