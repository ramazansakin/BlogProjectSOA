package com.rsakin.blogapp.pojo;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PojoComment {
    private String text;
    private Long postId;
}
