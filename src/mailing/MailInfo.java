package mailing;

public class MailInfo {

    private String senderName;
    private String senderAddress;
    private String receiverName;
    private String receiverAddress;

    public String getSenderName() {
        return senderName;
    }

    public MailInfo setSenderName(String senderName) {
        this.senderName = senderName;
        return this;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public MailInfo setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
        return this;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public MailInfo setReceiverName(String receiverName) {
        this.receiverName = receiverName;
        return this;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public MailInfo setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
        return this;
    }
}
