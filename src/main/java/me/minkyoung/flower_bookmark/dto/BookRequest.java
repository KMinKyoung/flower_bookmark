package me.minkyoung.flower_bookmark.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookRequest {

    @NotBlank
    @Size(max = 255)
    private String title;

    @NotBlank
    @Size(max = 100)
    private String publisher;

    @NotBlank
    @Size(max = 100)
    private String author;

    @NotNull
    @Min(0)
    private Integer price;

    @NotNull
    @Min(0)
    private Integer stock_quantity;

    @Size(max = 500)
    @JsonProperty("image_url")  // JSON은 snake_case, Java는 camelCase
    private String image_url;

    private String description;
}
