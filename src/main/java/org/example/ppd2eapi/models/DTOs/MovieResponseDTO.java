package org.example.ppd2eapi.models.DTOs;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieResponseDTO {

    private Long id;
    private String title;
    @SerializedName("release_date")
    private Date releaseDate;
    private String overview;
}
