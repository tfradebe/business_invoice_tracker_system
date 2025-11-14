package za.co.tfradebe.invoice_service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Objects;

@Data
@Embeddable
public class LineItem {
    private String name;
    private String description;
    @Column(precision = 10, scale = 2)
    private BigDecimal price;
    private int quantity;

    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o != null && o instanceof LineItem lineItem) {
            return Objects.equals(name, lineItem.name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
