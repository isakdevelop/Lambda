package com.dennis.api.menu;

import lombok.*;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Menu {
    private Long id;
    private String item; // enum의 기능명
    private String category; // 패키지 명
}
