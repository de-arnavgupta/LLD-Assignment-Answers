import java.util.List;

// abstraction for invoice persistence - decouples from FileStore
public interface InvoiceStore {
    void save(String invoiceId, String content);
    int countLines(String invoiceId);
}

