package ar.nasa.view;

import ar.nasa.controller.MainController;
import ar.nasa.domain.Documento;
import ar.nasa.domain.Grupo;
import ar.nasa.ifs.domain.LverYPacc;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTreeCell;
import javafx.scene.image.Image;
import javafx.scene.input.Clipboard;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.*;

public class MainView {

    private MainController controller;

    private Stage stage;
    private TextField textBuscar;
    private Button botonBuscar;
    private TreeView<Documento> tree;
    private TextField textDestino;
    private Button botonDestino;
    private Text textInfo;
    private String stringInfo;
    private ProgressBar progressBar;
    private Button botonDescargar;
    private CheckBox checkTodo;
    private CheckBox checkLyP;
    private CheckBox checkHisto;
    private CheckBox checkHdM;
    private CheckBox checkLvL;
    private CheckBox checkMkbAsk;
    private CheckBox checkPcf;

    public MainView(Stage primaryStage) {
        stage = primaryStage;
        controller = new MainController();

        stage.setTitle("PyP - batch documentación");

        VBox vbox = new VBox(boxBuscar(), boxOpciones(), boxLista(), boxDestino(), boxDescargar());
        vbox.setMinWidth(500);
        vbox.setPrefHeight(700);
        vbox.setPadding(new Insets(15,15,15,15));

        Scene scene = new Scene(vbox);
        stage.setScene(scene);
        stage.getIcons().add(new Image("documentation.png"));
        stage.show();
    }

    private HBox boxBuscar() {
        botonBuscar = new Button("_Buscar");
        botonBuscar.setOnAction(event -> actionBuscar());
        botonBuscar.setMnemonicParsing(true);
        botonBuscar.defaultButtonProperty().bind(botonBuscar.focusedProperty());

        textBuscar = new TextField() {
            @Override
            public void paste() {
                Clipboard clipboard = Clipboard.getSystemClipboard();
                String text = this.getText();
                text += (this.getSelection().getStart() == text.length()
                        && !text.equals("")
                        && !text.endsWith(";")) ? ";" : "";

                String pasteText = clipboard.getString()
                        .replaceAll("\n", ";")
                        .replaceAll("\r\n", ";")
                        .replaceAll(",", ";");

                int inicio = this.getSelection().getStart();
                this.setText(text.substring(0, inicio)
                        + pasteText
                        + text.substring(this.getSelection().getEnd(), text.length()));
                this.positionCaret(inicio + pasteText.length());
            }
        };
        textBuscar.textProperty().addListener((ov, oldValue, newValue) -> textBuscar.setText(newValue.toUpperCase()));
        textBuscar.setOnAction(event -> actionBuscar());

        HBox hboxBuscar = new HBox(new Label("OT/Comp:"), textBuscar, botonBuscar);
        hboxBuscar.setPadding(new Insets(0,0,15,0));
        hboxBuscar.setSpacing(5);
        hboxBuscar.setAlignment(Pos.CENTER_LEFT);

        HBox.setHgrow(botonBuscar, Priority.ALWAYS);
        HBox.setHgrow(textBuscar, Priority.ALWAYS);

        return hboxBuscar;
    }

    private HBox boxOpciones() {
        checkTodo = new CheckBox("_TODO");

        checkLyP = new CheckBox("LVer PAcc");
        checkHisto = new CheckBox("Historial");
        VBox vBoxA = new VBox(checkLyP, checkHisto);
        vBoxA.setSpacing(10);
        checkHdM = new CheckBox("Hoja Medición");
        checkLvL = new CheckBox("Valores Limites");
        VBox vBoxB = new VBox(checkHdM, checkLvL);
        vBoxB.setSpacing(10);
        checkMkbAsk = new CheckBox("Mkb/Ask");
        checkPcf = new CheckBox("Planos");
        VBox vBoxC = new VBox(checkMkbAsk, checkPcf);
        vBoxC.setSpacing(10);

        checkTodo(true);

        checkTodo.setOnAction(
                (e) -> checkTodo(checkTodo.isSelected()));
        checkLyP.selectedProperty().addListener((obj, oldValue, newValue) -> {
            checkOpcion(newValue);
            controller.setBuscarLyp(newValue);
        });
        checkHisto.selectedProperty().addListener((obj, oldValue, newValue) -> {
            checkOpcion(newValue);
            controller.setBuscarHisto(newValue);
        });
        checkHdM.selectedProperty().addListener((obj, oldValue, newValue) -> {
            checkOpcion(newValue);
            controller.setBuscarHdM(newValue);
        });
        checkLvL.selectedProperty().addListener((obj, oldValue, newValue) -> {
            checkOpcion(newValue);
            controller.setBuscarLvL(newValue);
        });
        checkMkbAsk.selectedProperty().addListener((obj, oldValue, newValue) -> {
            checkOpcion(newValue);
            controller.setBuscarMkbAsk(newValue);
        });
        checkPcf.selectedProperty().addListener((obj, oldValue, newValue) -> {
            checkOpcion(newValue);
            controller.setBuscarPcf(newValue);
        });

        HBox hboxOpciones = new HBox(checkTodo, vBoxA, vBoxB, vBoxC);
        hboxOpciones.setPadding(new Insets(0,0,15,0));
        hboxOpciones.setSpacing(30);
        hboxOpciones.setAlignment(Pos.CENTER);

        return hboxOpciones;
    }

    private void checkTodo(boolean value) {
        checkTodo.setSelected(value);
        controller.setBuscarTodo(value);

        checkLyP.setSelected(value);
        checkHisto.setSelected(value);
        checkHdM.setSelected(value);
        checkLvL.setSelected(value);
        checkMkbAsk.setSelected(value);
        checkPcf.setSelected(value);
    }

    private void checkOpcion(boolean value) {
        if (!value)
            checkTodo.setSelected(false);
        else if (isTodoCheck())
            checkTodo.setSelected(true);
    }

    private boolean isTodoCheck() {
        return checkLyP.isSelected()
                && checkHisto.isSelected()
                && checkHdM.isSelected()
                && checkLvL.isSelected()
                && checkMkbAsk.isSelected()
                && checkPcf.isSelected();
    }

    private void disableBuscar(boolean valor) {
        textBuscar.setDisable(valor);
        botonBuscar.setDisable(valor);
        tree.setDisable(valor);
        botonDestino.setDisable(valor);
        checkTodo.setDisable(valor);
        checkLyP.setDisable(valor);
        checkHisto.setDisable(valor);
        checkHdM.setDisable(valor);
        checkLvL.setDisable(valor);
        checkMkbAsk.setDisable(valor);
        checkPcf.setDisable(valor);

        if (valor)
            stage.getScene().setCursor(Cursor.WAIT);
        else
            stage.getScene().setCursor(Cursor.DEFAULT);
    }

    private Object actionBuscar() {
        if (textBuscar.getText().isEmpty())
            return null;

        disableBuscar(true);

        Task<CheckBoxTreeItem<Documento>> task = taskBuscar();
        task.setOnSucceeded(event -> {
            CheckBoxTreeItem<Documento> rootItem = task.getValue();

            if (!rootItem.isLeaf()) {
                tree.setRoot(rootItem);
                botonDescargar.requestFocus();
            } else {
                tree.setRoot(null);
            }

            disableBuscar(false);
        });
        progressBar.setVisible(true);
        progressBar.progressProperty().unbind();
        progressBar.progressProperty().bind(task.progressProperty());

        new Thread(task).start();

        return null;
    }

    private Task<CheckBoxTreeItem<Documento>> taskBuscar() {
        return new Task<CheckBoxTreeItem<Documento>>() {

            @Override
            protected CheckBoxTreeItem<Documento> call() {
                Integer count = 0;
                CheckBoxTreeItem<Documento> treeItemRoot =
                        new CheckBoxTreeItem<>(new Grupo("Todo"));

                TreeSet<String> listaBuscar = new TreeSet<>(Arrays.asList(textBuscar.getText().split(";")));
                listaBuscar.removeIf(s -> s.length() < 4);

                Integer vuelta = 0;
                for (String c: listaBuscar) {

                    stringInfo = "Buscando documentación de " + c + " [ " + ++vuelta + " / " + listaBuscar.size() +" ]";
                    Platform.runLater(() -> textInfo.setText(stringInfo));

                    List<Documento> docs = controller.documentosPara(c);

                    updateProgress(vuelta, listaBuscar.size() + 1);

                    if (!docs.isEmpty()) {
                        count += docs.size();

                        String name = c.toUpperCase();
                        if (docs.get(0) instanceof LverYPacc) {
                            LverYPacc lverYPacc = (LverYPacc) docs.get(0);
                            name = lverYPacc.getOt().getComponente().getMchCode()
                                    + "-" + lverYPacc.getOt().getOrganizacion().getOrgCode()
                                    + "-" + lverYPacc.getOt().getTipoTrabajo()
                                    + " " + lverYPacc.getOt().getDirectiva();
                        }
                        CheckBoxTreeItem<Documento> treeItem = new CheckBoxTreeItem<>(new Grupo(name));

                        for (Documento d: docs)
                            treeItem.getChildren().add(new CheckBoxTreeItem<>(d));

                        treeItem.setExpanded(true);
                        treeItemRoot.getChildren().add(treeItem);
                    }
                }

                if (count > 0) {
                    treeItemRoot.setSelected(true);
                    treeItemRoot.setExpanded(true);

                    Platform.runLater(() -> {
                        botonDescargar.setDisable(false);
                        textDestino.setDisable(false);
                    });
                } else {
                    Platform.runLater(() -> {
                        botonDescargar.setDisable(true);
                        textDestino.setDisable(true);
                    });
                }

                updateProgress(1, 1);
                stringInfo = count + " documentos encontrados";
                Platform.runLater(() -> textInfo.setText(stringInfo));

                return treeItemRoot;
            }
        };
    }

    private HBox boxLista() {
        tree = new TreeView<>();
        tree.setCellFactory(CheckBoxTreeCell.forTreeView());
        tree.setPrefWidth(1920);
        tree.setPrefHeight(1080);

        HBox hboxLista = new HBox(tree);
        hboxLista.setPadding(new Insets(0,0,15,0));
        hboxLista.setPrefWidth(470);

        HBox.setHgrow(hboxLista, Priority.ALWAYS);

        return hboxLista;
    }

    private HBox boxDestino() {
        String carpeta = System.getProperty("user.home");
        DirectoryChooser chooserDestino = new DirectoryChooser();
        chooserDestino.setInitialDirectory(new File(carpeta));

        textDestino = new TextField(carpeta);
        textDestino.setOnAction(event -> actionDescargar());
        textDestino.setDisable(true);
        botonDestino = new Button("...");
        botonDestino.defaultButtonProperty().bind(botonDestino.focusedProperty());

        botonDestino.setOnAction(event -> {
            File path = chooserDestino.showDialog(stage);

            if (path != null)
                textDestino.setText(path.getAbsolutePath());
        });

        HBox hboxDestino = new HBox(new Label("Destino:"), textDestino, botonDestino);
        hboxDestino.setPadding(new Insets(0,0,15,0));
        hboxDestino.setSpacing(5);
        hboxDestino.setAlignment(Pos.CENTER_LEFT);

        HBox.setHgrow(textDestino, Priority.ALWAYS);
        HBox.setHgrow(botonDestino, Priority.ALWAYS);

        return hboxDestino;
    }

    private HBox boxDescargar() {
        textInfo = new Text();

        progressBar = new ProgressBar(0);
        progressBar.setVisible(false);

        botonDescargar = new Button("_Descargar");
        botonDescargar.setMnemonicParsing(true);
        botonDescargar.defaultButtonProperty().bind(botonDescargar.focusedProperty());
        botonDescargar.setDisable(true);
        botonDescargar.setOnAction(event -> actionDescargar());

        HBox hboxDescargar = new HBox(textInfo, progressBar, botonDescargar);
        hboxDescargar.setSpacing(10);
        hboxDescargar.setAlignment(Pos.CENTER_RIGHT);

        return hboxDescargar;
    }

    private Object actionDescargar() {
        disableBuscar(true);

        Task<Void> task = taskDescargar();

        progressBar.progressProperty().unbind();
        progressBar.progressProperty().bind(task.progressProperty());

        new Thread(task).start();

        return null;
    }

    private Task<Void> taskDescargar() {
        return new Task<Void>() {

            @Override
            protected Void call() {
                updateProgress(0, 1);

                Map<String, List<Documento>> arbol = new HashMap<>();
                Integer total = 0;
                for (TreeItem<Documento> comp: tree.getRoot().getChildren()) {
                    List<Documento> tmp = new ArrayList<>();
                    LverYPacc documentoLyP = (comp.getChildren().get(0).getValue() instanceof LverYPacc)
                            ? (LverYPacc) comp.getChildren().get(0).getValue() : null;

                    for (TreeItem<Documento> d: comp.getChildren()) {

                        if (((CheckBoxTreeItem<Documento>)d).isSelected()) {
                            tmp.add(d.getValue());

                            if (documentoLyP != null)
                                documentoLyP.extraerInfo(d.getValue());

                            total++;
                        }

                        if (!tmp.isEmpty())
                            arbol.put(comp.getValue().toString(), tmp);
                    }
                }

                Integer count = 0;
                for (String key: arbol.keySet()) {

                    File carpeta = new File(textDestino.getText());
                    if (!carpeta.getName().startsWith(key.split("-")[0]))
                        carpeta = new File(textDestino.getText() + File.separatorChar + key.replaceAll("/", ", "));

                    if (!carpeta.isDirectory())
                        if (!carpeta.mkdirs()) break;

                    for (Documento d: arbol.get(key)) {
                        updateProgress(++count, total + 1);
                        stringInfo = "Descargando [ " + count + " / " + total + " ]";
                        Platform.runLater(() -> textInfo.setText(stringInfo));

                        d.pdfEnCarpeta(carpeta.getAbsolutePath() + File.separatorChar);
                    }
                }

                updateProgress(1, 1);

                stringInfo = count + " archivos descargados";
                Platform.runLater(() -> {
                    textInfo.setText(stringInfo);
                    disableBuscar(false);
                });

                return null;
            }
        };
    }

    public void stop() {
        controller.stop();
    }

}
