package com.uwich.interactivemap.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
// Data transfer object used to distinguish between room objects and building objects in search results
public class SearchResultDto {
    private String type;
    private Object data;
}
