package ra.edu.ss8homework.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookUpdateStockDTO {
    @NotNull(message = "Stock cannot be null")
    @Min(value = 0, message = "Stock must be a non-negative integer.")
    private Integer stock;
}
