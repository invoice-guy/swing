package com.swing.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SvcUpdateRequestDto {
    private String olmagoyn;

    @Builder
    public SvcUpdateRequestDto(String olmagoyn) {
        this.olmagoyn = olmagoyn;
    }
}
