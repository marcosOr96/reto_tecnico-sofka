module proyecto.reto_tecnicosofka {
    requires javafx.controls;
    requires javafx.fxml;


    opens proyecto.reto_tecnicosofka to javafx.fxml;
    exports proyecto.reto_tecnicosofka;
}