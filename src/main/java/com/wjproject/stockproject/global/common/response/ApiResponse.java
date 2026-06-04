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

    // 성공
    public static <T> ApiResponse<T> success(T data, String requestId) {
        return new ApiResponse<>(true, data, null, MetaResponse.requestId(requestId));
    }

    // 실패
    public static <T> ApiResponse<T> fail(ErrorResponse error) {
        return new ApiResponse<>(false, null, error, null);
    }
}
