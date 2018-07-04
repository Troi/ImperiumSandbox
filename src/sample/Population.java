package sample;

import imperium.people.Human;
import imperium.people.Soul;
import imperium.politics.Family;
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
        int initialPeopleCount = 5;
        int generationCount = 3;
        int breedRatio = 15;
        population = new ArrayList<>(generationCount * initialPeopleCount);
        for (int i = 0; i < initialPeopleCount; i++) {
            population.add(new Human());
        }

        for (int i = 0; i < generationCount; i++) {
            System.out.println("Generation #" + i);
            List<Human> children = new ArrayList<>(population.size() * breedRatio);
            for (Human h : population) {
                if (!h.isAlive()) continue;
                children.addAll(this.makeChildren(h, breedRatio));
                h.age();
                Family.humanDeath(h);
            }
            System.out.println("People in generation " + children.size());
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
        if (selected.getFamily() != null) {
            System.out.println("Family " + selected.getFamily().getName());
            System.out.println("Family ruler " + selected.getFamily().getRuler().getName());
            if (selected.getFamily().getHeir() != null) {
                System.out.println("Family heir " + selected.getFamily().getHeir().getName());
            } else {
                System.out.println("Family has no heir");
            }
        }
        ancestorsTree.setRoot(new AncestorTreeItem(selected));
        childrenTree.setRoot(new ChildrenTreeItem(selected));
    }

    @FXML
    private void handleRandomSexButtonAction(ActionEvent event) {
        if (populationView.getSelectionModel().getSelectedItem() == null) return;
        Human selected = populationView.getSelectionModel().getSelectedItem();
        population.addAll(makeChildren(selected, 1));

        populationView.getItems().setAll(population);
    }

    private List<Human> makeChildren(Human human, int count) {
        System.out.println("Try to make " + count + " offsprings");
        List<Human> children = new ArrayList<>(count);
        Random rnd = new Random();
        for (int i = 0; i < count; i++) {
            Human second = population.get(rnd.nextInt(population.size() - 1));
            if (second != human && !human.isAncestor(second) && !second.isAncestor(human) && second.isAlive()) {
                children.add(human.makeOffspring(second));
            }
        }
        System.out.println(children.size() + " offsprings made");
        return children;
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