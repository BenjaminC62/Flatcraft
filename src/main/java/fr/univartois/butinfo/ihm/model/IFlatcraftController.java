package fr.univartois.butinfo.ihm.model;

import javafx.beans.property.IntegerProperty;

public interface IFlatcraftController {

    void setFlatcraftGame(FlatcraftGame game);
    void initGame(GameMap map);
    void addMovable(AbstractMovable movable);
    void removeMovable(AbstractMovable movable);
    IntegerProperty setHealthProperty(IntegerProperty healthProperty);
}
