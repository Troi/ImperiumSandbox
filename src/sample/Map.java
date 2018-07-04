package sample;

import imperium.map.source.resource.MapResourceInterface;
import imperium.map.source.resource.system.AbstractGravityObject;
import imperium.map.source.resource.system.AsteroidBelt;
import imperium.map.source.resource.system.SpaceStation;
import imperium.map.view.PoliticMapResourceDecorator;
import imperium.map.view.SystemMap;
import imperium.people.Human;
import imperium.people.Soul;
import imperium.politics.Family;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class Map implements Initializable {

    private SystemMap map;

    @FXML
    private TreeView<MapResourceInterface> mapTree;

    @FXML
    private ListView<String> resourceDescription;

    @FXML
    private Button addStationButton;

    @FXML
    private void handleAddStationButtonAction(ActionEvent event) {
        if (mapTree.getSelectionModel().getSelectedItem() != null) {
            MapResourceInterface resource = mapTree.getSelectionModel().getSelectedItem().getValue();

            if (resource instanceof AbstractGravityObject) {
                ((AbstractGravityObject) resource).addSatelite(new SpaceStation());
            }
            System.out.println("Added");
            mapTree.setRoot(new PlanetTreeItem(map.getResources().iterator().next()));
        } else {
            System.out.println("getSelectedItem() NULL");
        }
    }

    @FXML
    private void handleSelectMapAction() {
        if (mapTree.getSelectionModel().getSelectedItem() != null) {
            MapResourceInterface resource = mapTree.getSelectionModel().getSelectedItem().getValue();
            System.out.println(resource);
        } else {
            System.out.println("getSelectedItem() NULL");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.map  = new SystemMap();
        for (PoliticMapResourceDecorator mapResource: map.getPersonalizedResources(null)){
            System.out.println(mapResource);
            mapTree.setRoot(new PlanetTreeItem(mapResource));
        }
    }

    private class PlanetTreeItem extends TreeItem<MapResourceInterface> {
        public PlanetTreeItem(MapResourceInterface value) {
            super(value);
            setExpanded(true);
        }
        public PlanetTreeItem(PoliticMapResourceDecorator value) {
            super(value.getProperty());
            setExpanded(true);
        }

        @Override
        public ObservableList<TreeItem<MapResourceInterface>> getChildren() {
            ObservableList<TreeItem<MapResourceInterface>> children = FXCollections.observableArrayList();

            MapResourceInterface value = this.getValue();
            System.out.println(value);
            if (value instanceof AbstractGravityObject) {
                for (MapResourceInterface satelite : ((AbstractGravityObject) value).getSatelites()) {
                    children.add(new PlanetTreeItem(satelite));
                }
            }
            if (value instanceof AsteroidBelt) {
            }
            return children;
        }

        @Override
        public boolean isLeaf() {
            if (this.getValue() instanceof AbstractGravityObject) {
                return ((AbstractGravityObject) this.getValue()).getSatelites().size() == 0;
            }
            if (this.getValue() instanceof AsteroidBelt) {
                return true;
            }
            return true;
        }
    }
}