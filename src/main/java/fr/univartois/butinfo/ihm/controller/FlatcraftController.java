/**
 * Sample Skeleton for 'flatcraft-view.fxml' Controller Class
 */

package fr.univartois.butinfo.ihm.controller;

import fr.univartois.butinfo.ihm.model.AbstractMovable;
import fr.univartois.butinfo.ihm.model.FlatcraftGame;
import fr.univartois.butinfo.ihm.model.GameMap;
import fr.univartois.butinfo.ihm.model.IFlatcraftController;
import javafx.beans.property.IntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.List;

public class FlatcraftController implements IFlatcraftController {

    private static final int WIDTH = 1280;
    private static final int HEIGHT = 720;
    private static final int CELLS_LENGHT = 30;

    private Stage stage;

    @FXML // fx:id="Background"
    private GridPane background; // Value injected by FXMLLoader

    @FXML // fx:id="mainpane"
    private GridPane mainpane; // Value injected by FXMLLoader

    @FXML // fx:id="niveauVie"
    private Label niveauVie; // Value injected by FXMLLoader

    private ImageView[][] backgroundCell;
    private ImageView[][] mainCellFrame;
    private List<AbstractMovable> movables;

    /* Attribut complétant l'interface */
    private FlatcraftGame game;
    private GameMap map;

    private IntegerProperty healthProperty;

    @FXML
    void onClickShowCraft(ActionEvent event) {

    }

    @FXML
    void onClickShowFurnace(ActionEvent event) {

    }

    @FXML
    void onClickShowInventory(ActionEvent event) {

    }

    @FXML
    private void initialize(){
        backgroundCell = new ImageView[HEIGHT / CELLS_LENGHT][WIDTH / CELLS_LENGHT];
        mainCellFrame = new ImageView[HEIGHT / CELLS_LENGHT][WIDTH / CELLS_LENGHT];

        for(int i = 0 ; i < HEIGHT / CELLS_LENGHT ; i++){
            for (int j = 0 ; j < WIDTH / CELLS_LENGHT ; j++){
                backgroundCell[i][j] = new ImageView(); //On créer des images view
                backgroundCell[i][j].setFitWidth(CELLS_LENGHT); // On leur donne la taille width
                backgroundCell[i][j].setFitHeight(CELLS_LENGHT); // On leur donne la taille width
                background.add(backgroundCell[i][j], j , i); // On l'ajoute dans la grille (En gros on créer nous même les lignes et column)

                mainCellFrame[i][j] = new ImageView(); // same que au dessus
                mainCellFrame[i][j].setFitWidth(CELLS_LENGHT);
                mainCellFrame[i][j].setFitHeight(CELLS_LENGHT);
                mainpane.add(mainCellFrame[i][j], j , i);
            }
        }
    }

    public void setStage(Stage stage){
        this.stage = stage;
    }

    @Override
    public void setFlatcraftGame(FlatcraftGame game) {
        this.game = game;
    }

    @Override
    public void initGame(GameMap map) { // Parcour de la map
        for(int i = 0; i < map.getHeight(); i++){
            for (int j = 0; j < map.getWidth(); j++){
                backgroundCell[i][j].imageProperty().bind(map.getAt(i,j).spriteProperty()); //Permet d'adapter la map automatiquement avec un link entre le background et la map proprety
            }
        }
        stage.addEventFilter(KeyEvent.KEY_PRESSED, e ->{
            if (e.getCode() == KeyCode.LEFT) {
                game.moveLeft();
            } else if (e.getCode() == KeyCode.RIGHT) {
                game.moveRight();
            }
        });
    }

    @Override
    public void showMovable(AbstractMovable movable) {
        mainCellFrame[movable.getRow()][movable.getColumn()].setImage(movable.getSprite());
    }

    @Override
    public void hideMovable(AbstractMovable movable) {
        mainCellFrame[movable.getRow()][movable.getColumn()].setImage(null);
    }

    @Override
    public void setHealthProperty(IntegerProperty healthProperty) {
        this.healthProperty = healthProperty;
        niveauVie.textProperty().bind(healthProperty.asString()); // On lie le valeur du texte du label du niveau de vie au healthProperty
    }
}
