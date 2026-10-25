package cse213.midtermsolnautumn24creditcard;

import javafx.scene.control.Alert;

import java.time.LocalDate;

public class CreditCard {
    private String cardNo, holderName, gatewayName, cardType;
    private LocalDate dateOfExpiry;
    private int creditLimit;

    public CreditCard(String cardNo, String holderName, String gatewayName, String cardType, LocalDate dateOfExpiry, int creditLimit) {
        this.cardNo = cardNo;
        this.holderName = holderName;
        this.gatewayName = gatewayName;
        this.cardType = cardType;
        this.dateOfExpiry = dateOfExpiry;
        this.creditLimit = creditLimit;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public String getGatewayName() {
        return gatewayName;
    }

    public void setGatewayName(String gatewayName) {
        this.gatewayName = gatewayName;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public LocalDate getDateOfExpiry() {
        return dateOfExpiry;
    }

    public void setDateOfExpiry(LocalDate dateOfExpiry) {
        this.dateOfExpiry = dateOfExpiry;
    }

    public int getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(int creditLimit) {
        this.creditLimit = creditLimit;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "cardNo='" + cardNo + '\'' +
                ", holderName='" + holderName + '\'' +
                ", gatewayName='" + gatewayName + '\'' +
                ", cardType='" + cardType + '\'' +
                ", dateOfExpiry=" + dateOfExpiry +
                ", creditLimit=" + creditLimit +
                '}';
    }

    public void showCardInfoToAlert(){

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Credit Card Information");
        alert.setHeaderText("Card Details");
        alert.setContentText(
                        "Card Number: " + cardNo + "\n" +
                        "Holder Name: " + holderName + "\n" +
                        "Expiry Date: " + dateOfExpiry + "\n" +
                        "Gateway: " + gatewayName + "\n" +
                        "Credit Limit: " + creditLimit + "\n" +
                        "Card Type: " + cardType
        );

        alert.showAndWait();
    }
}
