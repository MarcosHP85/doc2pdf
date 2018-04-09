package ar.nasa.view;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import ar.nasa.controller.MainController;
import ar.nasa.domain.Documento;
import ar.nasa.domain.Grupo;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.CheckBoxTreeItem;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.CheckBoxTreeCell;
import javafx.scene.input.Clipboard;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

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
    private CheckBox checkMkb;
    private CheckBox checkAsk;
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
                text += (text.endsWith(";")) ? "" : ";";
                text += clipboard.getString()
                        .replaceAll("\n", ";")
                        .replaceAll("\r\n", ";")
                        .replaceAll(",", ";");

                this.setText(text);
                this.positionCaret(this.getLength());
            }
        };
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
        checkTodo = new CheckBox("Todo");
        checkLyP = new CheckBox("LVer PAcc");
        checkHisto = new CheckBox("Historial");
        checkHdM = new CheckBox("Hoja Medición");
        checkLvL = new CheckBox("Valores Limites");
        checkMkb = new CheckBox("Mkb");
        checkAsk = new CheckBox("Ask");
        checkPcf = new CheckBox("Planos");

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
        checkMkb.selectedProperty().addListener((obj, oldValue, newValue) -> {
            checkOpcion(newValue);
            controller.setBuscarMkb(newValue);
        });
        checkAsk.selectedProperty().addListener((obj, oldValue, newValue) -> {
            checkOpcion(newValue);
            controller.setBuscarAsk(newValue);
        });
        checkPcf.selectedProperty().addListener((obj, oldValue, newValue) -> {
            checkOpcion(newValue);
            controller.setBuscarPcf(newValue);
        });

        HBox hboxOpciones = new HBox(checkTodo, checkLyP, checkHisto, checkHdM, checkLvL, checkMkb, checkAsk, checkPcf);
        hboxOpciones.setPadding(new Insets(0,0,15,0));
        hboxOpciones.setSpacing(10);
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
        checkMkb.setSelected(value);
        checkAsk.setSelected(value);
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
                && checkMkb.isSelected()
                && checkAsk.isSelected()
                && checkPcf.isSelected();
    }

    private void disableBuscar(boolean valor) {
        textBuscar.setDisable(valor);
        botonBuscar.setDisable(valor);
        tree.setDisable(valor);
        textDestino.setDisable(valor);
        botonDestino.setDisable(valor);
        botonDescargar.setDisable(valor);

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
                listaBuscar.removeIf(s -> s.length() < 5);

                Integer vuelta = 0;
                for (String c: listaBuscar) {

                    stringInfo = "Buscando documentación de " + c + " [ " + ++vuelta + " / " + listaBuscar.size() +" ]";
                    Platform.runLater(() -> textInfo.setText(stringInfo));
                    updateProgress(vuelta, listaBuscar.size() + 1);

                    List<Documento> docs = controller.documentosPara(c);

                    if (!docs.isEmpty()) {
                        count += docs.size();
                        CheckBoxTreeItem<Documento> treeItem = new CheckBoxTreeItem<>(new Grupo(c));

                        for (Documento d: docs)
                            treeItem.getChildren().add(new CheckBoxTreeItem<>(d));

                        treeItem.setExpanded(true);
                        treeItemRoot.getChildren().add(treeItem);
                    }
                }

                if (count > 0) {
                    treeItemRoot.setSelected(true);
                    treeItemRoot.setExpanded(true);

                    Platform.runLater(() -> botonDescargar.setDisable(false));
                } else {
                    Platform.runLater(() -> botonDescargar.setDisable(false));
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

                    for (TreeItem<Documento> d: comp.getChildren()) {

                        if (((CheckBoxTreeItem<Documento>)d).isSelected()) {
                            tmp.add(d.getValue());
                            total++;
                        }

                        if (!tmp.isEmpty())
                            arbol.put(comp.getValue().toString().toUpperCase(), tmp);
                    }
                }

                Integer count = 0;
                for (String key: arbol.keySet()) {
                    File carpeta = new File((arbol.keySet().size() > 1)
                            ? textDestino.getText() + File.separatorChar + key
                            : textDestino.getText());

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
