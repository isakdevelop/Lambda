package board;

import lombok.*;

@NoArgsConstructor
@Getter
@ToString

public class Board {
    private Integer id;
    private String subject;
    private String content;
    private String writer;

    @Builder(builderMethodName = "builder")

    public Board(int id, String subject, String content, String writer) {
        this.id = id;
        this.subject = subject;
        this.content = content;
        this.writer = writer;
    }
}
