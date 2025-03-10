package BookMyShowLLD.Model;

import BookMyShowLLD.Enum.PaymentStatus;
import BookMyShowLLD.Enum.PaymentType;

public class Payment {
    PaymentStatus paymentStatus;
    int id;
    PaymentType paymentType;
    public Payment(int id, PaymentType paymentType){
        this.id = id;
        this.paymentType = paymentType;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }
}
