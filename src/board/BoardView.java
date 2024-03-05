package board;

import common.UtilService;
import common.UtilServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class BoardView {
    public static void main() {
        List<Board> articles = new ArrayList<>();
        UtilService util = UtilServiceImpl.getInstance();

        for (int i = 0; i < 5; i++) {
            articles.add(
                    Board.builder()
                            .subject(util.createRandomTitle())
                            .content(util.createRandomContent())
                            .writer(util.createRandomName())
                            .build());

        }

        for (Board board : articles) {
            System.out.println(board.getSubject() + "\t" +
                    board.getContent() + "\t" +
                    board.getWriter());
        }

        for (Board i : articles) {
            System.out.println(i.toString());
        }
        //외부 반복자. 요소가 밖으로 나갔다가 옴 / 객체가 움직이지 않음.

        articles.forEach(i -> {
            System.out.println(i.toString());
        });
        System.out.println();
        //메모리 변화가 일어나지 않음. 내부 반복자 / 객체가 움직임.


    }
}
