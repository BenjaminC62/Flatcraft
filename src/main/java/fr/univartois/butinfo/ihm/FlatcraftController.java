/**
 * Sample Skeleton for 'flatcraft-view.fxml' Controller Class
 */

package fr.univartois.butinfo.ihm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class FlatcraftController {

    @FXML // fx:id="Background"
    private GridPane Background; // Value injected by FXMLLoader

    @FXML // fx:id="mainpane"
    private GridPane mainpane; // Value injected by FXMLLoader

    @FXML // fx:id="niveauVie"
    private Label niveauVie; // Value injected by FXMLLoader

    private ImageView[][] cells;

    @FXML
    void onClickShowCraft(ActionEvent event) {

    }

    @FXML
    void onClickShowFurnace(ActionEvent event) {

    }

    @FXML
    void onClickShowInventory(ActionEvent event) {

    }

    private void initialize(){
        cells = new ImageView[mainpane.getRowCount() - 1][mainpane.getColumnCount()];


    }

}
