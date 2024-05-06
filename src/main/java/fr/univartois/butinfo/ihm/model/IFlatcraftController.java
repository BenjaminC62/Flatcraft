package fr.univartois.butinfo.ihm.model;

public interface IFlatcraftController {

    void setFlatcraftGame(FlatcraftGame game);
    void initGame(GameMap map);
    void addMovable(AbstractMovable movable);
    void removeMovable(AbstractMovable movable);
}
