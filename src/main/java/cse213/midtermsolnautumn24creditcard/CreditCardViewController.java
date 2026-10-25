package cse213.midtermsolnautumn24creditcard;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class CreditCardViewController
{
    @javafx.fxml.FXML
    private TextField cardNoTextField;
    @javafx.fxml.FXML
    private TableColumn<CreditCard, String> cardNoTableCol;
    @javafx.fxml.FXML
    private TableColumn<CreditCard, String> holderNameTableCol;
    @javafx.fxml.FXML
    private TableColumn<CreditCard, Integer> creditLimitTableCol;
    @javafx.fxml.FXML
    private TextField creditLimitTextField;
    @javafx.fxml.FXML
    private DatePicker dateOfExpiryDatePicker;
    @javafx.fxml.FXML
    private TableView<CreditCard> creditCardTableView;
    @javafx.fxml.FXML
    private TextField holderNameTextField;
    @javafx.fxml.FXML
    private TextField filterCreditLimitTextField;
    @javafx.fxml.FXML
    private Label outputLabel;
    @javafx.fxml.FXML
    private TableColumn<CreditCard, String> gatewayNameTableCol;
    @javafx.fxml.FXML
    private ComboBox<String> cardTypeComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> gatewayNameComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> filterGateWayNameComboBox;
    private ArrayList<CreditCard> cardList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {

        cardTypeComboBox.getItems().addAll("Silver", "Gold", "Platinum", "Titanium");
        gatewayNameComboBox.getItems().addAll("Visa", "Master Card");
        filterGateWayNameComboBox.getItems().addAll("Visa", "Master Card");

        cardNoTableCol.setCellValueFactory(new PropertyValueFactory<CreditCard, String>("cardNo"));
        holderNameTableCol.setCellValueFactory(new PropertyValueFactory<CreditCard, String>("holderName"));
        gatewayNameTableCol.setCellValueFactory(new PropertyValueFactory<CreditCard, String>("gatewayName"));
        creditLimitTableCol.setCellValueFactory(new PropertyValueFactory<CreditCard, Integer>("creditLimit"));
    }

    @javafx.fxml.FXML
    public void showAverageCreditLimitFromLoadedTableViewButtonOnAction(ActionEvent actionEvent) {

        int count = 0;
        int totalLimit = 0;
        for (CreditCard card : creditCardTableView.getItems()){
            totalLimit += card.getCreditLimit();
            count++;
        }

        int avg = totalLimit / count;
        outputLabel.setText("Average Credit Limit: " + avg);
    }

    @javafx.fxml.FXML
    public void searchAndLoadTableButtonOnAction(ActionEvent actionEvent) {
        creditCardTableView.getItems().clear();
        String selectedGateway = filterGateWayNameComboBox.getValue();
        int minLimit = Integer.parseInt(filterCreditLimitTextField.getText());

        for (CreditCard card : cardList){
            if (card.getGatewayName().equals(selectedGateway) && card.getCreditLimit() >= minLimit){
                creditCardTableView.getItems().add(card);
            }
        }
    }

    @javafx.fxml.FXML
    public void validateAndAddNewCardButtonOnAction(ActionEvent actionEvent) {

        if(cardNoTextField.getText().length() != 16){
            showErrorAlert("Card Number must be exactly 16 digits long.");
            return;
        }

        for (int i = 0; i < cardNoTextField.getText().length(); i++){
            if (!Character.isDigit(cardNoTextField.getText().charAt(i))){
                showErrorAlert("Card Number must contain only digits.");
                return;
            }
        }

        if(gatewayNameComboBox.getValue().equals("Visa") && !cardNoTextField.getText().startsWith("4")){
            showErrorAlert("Visa Card number must start with 4.");
            return;
        } else if (gatewayNameComboBox.getValue().equals("Master Card") && !cardNoTextField.getText().startsWith("5")) {
            showErrorAlert("Master Card number must start with 5.");
            return;
        }

        //String cardNo, String holderName, String gatewayName, String cardType, LocalDate dateOfExpiry, int creditLimit
        CreditCard newCard = new CreditCard(
                cardNoTextField.getText(),
                holderNameTextField.getText(),
                gatewayNameComboBox.getValue(),
                cardTypeComboBox.getValue(),
                dateOfExpiryDatePicker.getValue(),
                Integer.parseInt(creditLimitTextField.getText()));

        cardList.add(newCard);
        creditCardTableView.getItems().clear();
        creditCardTableView.getItems().addAll(cardList);
    }

    private void showErrorAlert(String message){
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("Validation Error!");
        a.setHeaderText("Error Message!");
        a.setContentText(message);
        a.showAndWait();
    }
}