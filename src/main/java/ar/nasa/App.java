package ar.nasa;

import ar.nasa.view.MainView;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class App extends Application {

	private MainView view;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		view = new MainView(primaryStage);
	}

	public static void main(String[] args) {
        launch(args);
    }
	
	public void stop() {
		view.stop();
		
		Platform.exit();
        System.exit(0);
	}
}
