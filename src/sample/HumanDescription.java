package sample;

import imperium.people.Human;
import imperium.people.Soul;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class HumanDescription implements Initializable {

    public Soul playerSoul = new Soul("Troi", null);
    public List<Human> population;

    @FXML
    private ListView<Human> populationView;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}