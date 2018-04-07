package ar.nasa.pcf.domain;

import ar.nasa.domain.Documento;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;


public class PlanoCodFun extends Documento {
    private Path path;

    PlanoCodFun(Path path) {
        this.path = path;
    }

    @Override
    public void pdfEnCarpeta(String carpeta) {
        try {
            Files.copy(path, (new File(carpeta + path.getFileName().toString())).toPath(),
                    StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        String tmp = path.getFileName().toString();
        tmp = tmp.substring(0, tmp.length() - 4).replaceAll("_", " ");

        return tmp;
    }
}
