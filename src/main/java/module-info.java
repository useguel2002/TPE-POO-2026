module org.example.tpe_poo_ulises_seguel {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.almasb.fxgl.all;

    opens org.example.Juego_De_La_Vida to javafx.fxml;
    exports org.example.Juego_De_La_Vida;
}