package sample;

import imperium.people.Human;
import imperium.people.Soul;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class Population implements Initializable {

    public Soul playerSoul = new Soul("Troi", null);
    public List<Human> population;

    @FXML
    private ListView<Human> populationView;

    @FXML
    private TreeView<Human> ancestorsTree;

    @FXML
    private TreeView<Human> childrenTree;

    @FXML
    private void handleResetButtonAction(ActionEvent event) {
        int count = 5;
        population = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            population.add(new Human());
        }

        for (int i = 0; i < count; i++) {
            List<Human> children = new ArrayList<>(population.size());
            for (Human h : population) {
                Random rnd = new Random();
                Human second = population.get(rnd.nextInt(population.size() - 1));
                if (second != h && !h.isAncestor(second) && !second.isAncestor(h)) {
                    children.add(h.makeOffspring(second));
                }
                Human third = population.get(rnd.nextInt(population.size() - 1));
                if (third != h && !h.isAncestor(third) && !third.isAncestor(h)) {
                    children.add(h.makeOffspring(third));
                }
                h.die();
            }
            population.addAll(children);
        }

        populationView.getItems().setAll(population);
    }

    @FXML
    private void handleAgeAllButtonAction(ActionEvent event) {
        for (Human h : population) {
            h.age();
        }
        populationView.getItems().setAll(population);
    }

    @FXML
    private void handleAgeButtonAction(ActionEvent event) {
        if (populationView.getSelectionModel().getSelectedItem() == null) return;
        populationView.getSelectionModel().getSelectedItem().age();
        populationView.getItems().setAll(population);
    }

    @FXML
    private void handleSelectHuman() {
        Human selected = populationView.getSelectionModel().getSelectedItem();
        System.out.println();
        System.out.println("Selected " + selected);
        System.out.println("Mother " + selected.getMother());
        System.out.println("Father " + selected.getFather());
        ancestorsTree.setRoot(new AncestorTreeItem(selected));
        childrenTree.setRoot(new ChildrenTreeItem(selected));
    }

    @FXML
    private void handleRandomSexButtonAction(ActionEvent event) {
        if (populationView.getSelectionModel().getSelectedItem() == null) return;
        Human selected = populationView.getSelectionModel().getSelectedItem();
        Random rnd = new Random();
        Human second = population.get(rnd.nextInt(population.size() - 1));
        population.add(selected.makeOffspring(second));

        populationView.getItems().setAll(population);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    private class AncestorTreeItem extends TreeItem<Human> {
        public AncestorTreeItem(Human value) {
            super(value);
            setExpanded(true);
        }

        @Override
        public ObservableList<TreeItem<Human>> getChildren() {
            ObservableList<TreeItem<Human>> children = FXCollections.observableArrayList();
            if (this.getValue().getMother() != null) {
                children.add(new AncestorTreeItem(this.getValue().getMother()));
            }
            if (this.getValue().getFather() != null) {
                children.add(new AncestorTreeItem(this.getValue().getFather()));
            }
            super.getChildren().setAll(children);
            return super.getChildren();
        }

        @Override
        public boolean isLeaf() {
            return (this.getValue().getMother() == null) && (this.getValue().getFather() != null);
        }
    }

    private class ChildrenTreeItem extends TreeItem<Human> {
        public ChildrenTreeItem(Human value) {
            super(value);
            setExpanded(true);
        }

        public ObservableList<TreeItem<Human>> getChildren() {
            ObservableList<TreeItem<Human>> children = FXCollections.observableArrayList();
            for (Human child :
                    getValue().getChildren()) {
                children.add(new ChildrenTreeItem(child));
            }
            super.getChildren().setAll(children);
            return super.getChildren();
        }

        @Override
        public boolean isLeaf() {
            return this.getValue().getChildren().size() == 0;
        }
    }
}