package com.lingyi;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AppMain extends Application {

    private double offsetX;

    private double offsetY;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/com/lingyi/controller/login.fxml"));
        Scene scene = new Scene(root);
        //鼠标按下事件
        scene.setOnMousePressed(mouseEvent -> {
            this.offsetX = mouseEvent.getSceneX();
            this.offsetY = mouseEvent.getSceneY();
        });
        //鼠标拖动事件（按下鼠标左键移动时）
        scene.setOnMouseDragged(mouseEvent -> {
            primaryStage.setX(mouseEvent.getScreenX() - this.offsetX);
            primaryStage.setY(mouseEvent.getScreenY() - this.offsetY);
        });
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

