package fkd13.opencrap;

import fkd13.opencrap.GameBoard.Controller;
import fkd13.opencrap.Menu.Manager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
public class Main extends Application {


    private Manager manager = new Manager();

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Main.fxml"));
        loader.setController(new Controller(manager));
        Scene scene = new Scene(loader.load());
        primaryStage.setTitle("Openttd");
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);

//        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
//        primaryStage.setX(primaryScreenBounds.getMinX());
//        primaryStage.setY(primaryScreenBounds.getMinY());
//
//        primaryStage.setMaxWidth(primaryScreenBounds.getWidth());
//        primaryStage.setMinWidth(primaryScreenBounds.getWidth());
//
//        primaryStage.setMaxHeight(primaryScreenBounds.getHeight());
//        primaryStage.setMinHeight(primaryScreenBounds.getHeight());

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
