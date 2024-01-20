module com.example.md5bruteforce {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    opens com.example.md5bruteforce to javafx.fxml;
    exports com.example.md5bruteforce;
}