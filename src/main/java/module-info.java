module dev.mutua.pos {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens dev.mutua.pos to javafx.fxml;
    exports dev.mutua.pos;
}