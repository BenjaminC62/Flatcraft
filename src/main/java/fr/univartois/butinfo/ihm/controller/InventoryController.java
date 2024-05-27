package fr.univartois.butinfo.ihm.controller;

import fr.univartois.butinfo.ihm.model.FlatcraftGame;
import fr.univartois.butinfo.ihm.model.Resource;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class InventoryController {

    @FXML
    private ImageView labelDisplayImageView;

    private Stage stage;

    @FXML
    private ListView<Resource> listViewInventory;

    @FXML
    private Label nom;

    @FXML
    void onClickCloseInventory(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fr/univartois/butinfo/ihm/view/flatcraft-view.fxml"));
        Parent viewContent = fxmlLoader.load();

        FlatcraftController controller = fxmlLoader.getController();
        controller.setStage(stage);

        Scene scene = new Scene(viewContent);
        stage.setScene(scene);
    }

    public void getInventory(ObservableList<Resource> inventory) {
        listViewInventory.setItems(inventory);
    }

    @FXML
    private void initialize(){
        listViewInventory.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, resourceSelected) -> {
            if (resourceSelected != null) {
                labelDisplayImageView.setImage(resourceSelected.getSprite());
                nom.setText(resourceSelected.getName());
            }
        });
    }

    public Stage getStage(){
        return stage;
    }

    public void setStage(Stage stage){
        this.stage = stage;
    }



}
