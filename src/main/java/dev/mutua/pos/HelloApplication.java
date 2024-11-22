package dev.mutua.pos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Connection connection = null;
        String url = "jdbc:postgresql://localhost:5432/pos";
        try{
            connection = DriverManager.getConnection(url, "postgres", "test1234");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from names");
            while(resultSet.next()){
                System.out.println(resultSet.getString("name"));
            }
            if (connection != null) {
                System.out.println("Connected");
            }
            else {
                System.out.println("Not Connected");
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        launch();
    }
}