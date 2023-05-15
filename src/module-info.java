module pharmagest {
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;
    requires java.sql;

    exports Pharmagest;
    exports Pharmagest.Modele;
    exports Pharmagest.login;
    exports Pharmagest.caisse;

    opens Pharmagest.login to javafx.fxml;
    opens Pharmagest to javafx;
    opens Pharmagest.Modele to java.sql, javafx;
    opens Pharmagest.caisse to javafx;

}