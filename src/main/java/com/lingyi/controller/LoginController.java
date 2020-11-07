package com.lingyi.controller;

import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    private Stage stage;

    private double offsetX;

    private double offsetY;
    @FXML
    private AnchorPane anchorPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //初始化界面
    }

    /**
     * 记录当前场景坐标
     *
     * @param mouseEvent 鼠标事件
     */
    public void setCurrentCoordinates(MouseEvent mouseEvent) {
        stage = (Stage) anchorPane.getScene().getWindow();
        this.offsetX = mouseEvent.getSceneX();
        this.offsetY = mouseEvent.getSceneY();
    }

    /**
     * 设置舞台坐标
     *
     * @param mouseEvent 鼠标事件
     */
    public void setStageCoordinates(MouseEvent mouseEvent) {
        stage.setX(mouseEvent.getScreenX() - this.offsetX);
        stage.setY(mouseEvent.getScreenY() - this.offsetY);
    }

    /**
     * 设置关闭标签的文本颜色
     *
     * @param mouseEvent 鼠标事件
     */
    public void setTextFill(MouseEvent mouseEvent) {
        Label label = (Label) mouseEvent.getSource();
        EventType<? extends MouseEvent> eventType = mouseEvent.getEventType();
        String name = eventType.getName();
        if ("MOUSE_MOVED".equals(name)) {
            label.setTextFill(Paint.valueOf("#787878"));
        } else if ("MOUSE_EXITED".equals(name)) {
            label.setTextFill(Paint.valueOf("#a3a3a3"));
        }
    }

    /**
     * 关闭舞台
     */
    public void close() {
        stage.close();
    }

}
