package com.wjproject.stockproject.global.common.response;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL) // null 필드 제거
public class ApiResponse<T> {

    private boolean success;
    private T data;
    private ErrorResponse error;
    private MetaResponse meta;

    // Success 200(Request Success)
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(true, data, null, MetaResponse.of());
    }

    // Success 200(Request delete / update)
    public static <T> ApiResponse<T> success() {
        return new ApiResponse<>(true, null, null, MetaResponse.of());
    }

    // Success 201(Create Success)
    public static <T> ApiResponse<T> created() {
        return new ApiResponse<>(true, null, null, MetaResponse.of());
    }

    // Fail
    public static <T> ApiResponse<T> fail(ErrorResponse error) {
        return new ApiResponse<>(false, null, error, null);
    }
}
