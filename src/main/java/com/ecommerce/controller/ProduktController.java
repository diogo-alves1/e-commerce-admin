package com.ecommerce.controller;

import com.ecommerce.dao.ProduktDAO;
import com.ecommerce.model.Produkt;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class ProduktController {

    @FXML private TableView<Produkt> produktTable;
    @FXML private TableColumn<Produkt, Integer> idColumn;
    @FXML private TableColumn<Produkt, String> nameColumn;
    @FXML private TableColumn<Produkt, Double> preisColumn;
    @FXML private TableColumn<Produkt, Integer> lagerbestandColumn;
    @FXML private TableColumn<Produkt, String> kategorieColumn;

    @FXML private TextField nameField;
    @FXML private TextField preisField;
    @FXML private TextField stockField;
    @FXML private TextField kategorieField;

    private final ProduktDAO produktDAO = new ProduktDAO();

    @FXML
    public void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        preisColumn.setCellValueFactory(new PropertyValueFactory<>("preis"));
        lagerbestandColumn.setCellValueFactory(new PropertyValueFactory<>("lagerbestand"));
        kategorieColumn.setCellValueFactory(new PropertyValueFactory<>("kategorie"));

        refreshTable();
    }

    @FXML
    private void handleAddProdukt() {

        if (nameField.getText().isEmpty()
                || preisField.getText().isEmpty()
                || stockField.getText().isEmpty()) {

            showAlert("Erro", "Preencha todos os campos obrigatórios.");
            return;
        }

        try {
            Produkt produkt = new Produkt(
                    0,
                    nameField.getText(),
                    Double.parseDouble(preisField.getText()),
                    Integer.parseInt(stockField.getText()),
                    kategorieField.getText()
            );

            produktDAO.insert(produkt);
            refreshTable();
            clearFields();

        } catch (NumberFormatException e) {
            showAlert("Erro", "Preço e Stock devem ser números.");
        }
    }

    @FXML
    private void handleDeleteProdukt() {

        Produkt selected = produktTable.getSelectionModel().getSelectedItem();

        if (selected == null) {
            showAlert("Erro", "Selecione um produto para apagar.");
            return;
        }

        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
        confirm.setTitle("Confirmação");
        confirm.setHeaderText("Apagar produto");
        confirm.setContentText("Tem a certeza que deseja apagar este produto?");

        if (confirm.showAndWait().orElse(ButtonType.CANCEL) == ButtonType.OK) {
            produktDAO.deleteById(selected.getId());
            refreshTable();
        }
    }

    private void refreshTable() {
        produktTable.setItems(
                FXCollections.observableArrayList(produktDAO.findAll())
        );
    }

    private void clearFields() {
        nameField.clear();
        preisField.clear();
        stockField.clear();
        kategorieField.clear();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.show();
    }
}