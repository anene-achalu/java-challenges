module ch4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    opens com.example.chapter4_challenge_diarymanager_gui to javafx.fxml;
    exports com.example.chapter4_challenge_diarymanager_gui;
}