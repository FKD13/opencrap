package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.GameBoard.Controller;
import sample.Menu.Manager;
import sample.Menu.MenuCompanion;

public class Main extends Application {


    private Manager manager = new Manager();

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
        loader.setController(new Controller(manager));
        Scene scene = new Scene(loader.load());
        primaryStage.setTitle("Openttd");
        primaryStage.setScene(scene);
        primaryStage.show();

        Stage stage = new Stage();
        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("Menu.fxml"));
        loader2.setController(new MenuCompanion(manager));
        Scene scene2 = new Scene(loader2.load());
        stage.setTitle("Menu");
        stage.setScene(scene2);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
