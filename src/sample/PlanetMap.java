package sample;

import imperium.map.source.resource.MapResourceInterface;
import imperium.map.source.resource.system.AbstractGravityObject;
import imperium.map.source.resource.system.SpaceStation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class PlanetMap implements Initializable {

    private imperium.map.view.PlanetMap map;

    @FXML
    private ListView<MapResourceInterface> mapTree;

    @FXML
    private ListView<String> resourceDescription;

    @FXML
    private Button addSettlementButton;

    @FXML
    private void handleAddSettlementButtonAction(ActionEvent event) {
        if (mapTree.getSelectionModel().getSelectedItem() != null) {
            // do something
        }
    }

    @FXML
    private void handleSelectMapAction() {
        if (mapTree.getSelectionModel().getSelectedItem() != null) {
//            MapResourceInterface resource = mapTree.getSelectionModel().getSelectedItem().getValue();
//            ObservableList<String> descriptions = FXCollections.observableArrayList();
//             make output
//            this.resourceDescription.setItems(descriptions);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.map = new imperium.map.view.PlanetMap();
    }
}