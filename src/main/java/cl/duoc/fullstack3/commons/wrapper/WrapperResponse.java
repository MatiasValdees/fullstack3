package cl.duoc.fullstack3.commons.wrapper;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@JsonPropertyOrder({ "status", "timestamp", "data" })
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WrapperResponse<T> {
    private String status = "OK";

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime timestamp = LocalDateTime.now();

    private T data;

    public WrapperResponse(T data) {
        this.data = data;
    }
}