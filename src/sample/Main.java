package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
        String url = "jdbc:mysql://192.168.205.128:3306";
        String uname = "root";
        String pass = "secret";
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection myCon = DriverManager.getConnection(url, uname, pass);
            Statement myState = myCon.createStatement();
            String sql = "select  * from hr.employee";
            ResultSet rs = myState.executeQuery(sql);

            while (rs.next()) {
                System.out.println(rs.getString("last_name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
