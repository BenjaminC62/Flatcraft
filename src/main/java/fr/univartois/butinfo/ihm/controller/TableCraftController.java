package fr.univartois.butinfo.ihm.controller;

import fr.univartois.butinfo.ihm.model.Resource;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TableCraftController {

    @FXML
    private ListView<Resource> listViewInventory;

    @FXML
    private GridPane tableDeCraftGrid;

    private Stage stage;
    private Scene gameScene;

    private Button[][] matrixButton;

    @FXML
    public void initialize(){
        matrixButton = new Button[3][3];
        for(int i = 0 ; i < 3 ; i++){
            for(int j = 0; j < 3; j++){
                matrixButton[i][j] = new Button();
                matrixButton[i][j].setPrefWidth(32); // On leur donne la taille width
                matrixButton[i][j].setPrefHeight(32);
                tableDeCraftGrid.add(matrixButton[i][j], j , i);
            }
        }

        listViewInventory
    }

    @FXML
    void onClickCloseInventory(ActionEvent event) {
        stage.setScene(gameScene);
    }

    public void setStage(Stage stage){
        this.stage = stage;
    }

    public void setGameScene(Scene gameScene){
        this.gameScene = gameScene;
    }

    public void getInventory(ObservableList<Resource> inventory) {
        listViewInventory.setItems(inventory);
    }
}
