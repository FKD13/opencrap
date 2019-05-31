package fkd13.opencrap;

import fkd13.opencrap.GameBoard.Controller;
import fkd13.opencrap.Menu.Manager;
import fkd13.opencrap.Menu.MenuCompanion;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
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
        primaryStage.show();

        Stage stage = new Stage();
        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("/fxml/Menu.fxml"));
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
