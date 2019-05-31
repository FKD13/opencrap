module opencrap {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens fkd13.opencrap to javafx.fxml;
    exports fkd13.opencrap.GameBoard;
    exports fkd13.opencrap.Menu;
    exports fkd13.opencrap.Tracks;
    exports fkd13.opencrap;
}