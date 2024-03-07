package article;

import java.util.List;

public interface ArticleService {
    String writeArticle(String subject, String content, String writer);
    String modifyArticle(int id, String subject, String content);
    String deleteArticle(int id);
    List<?> searchArticleByTitle(String title);
    List<?> searchArticleByContent(String str);
    List<?> searchArticleByWriter(String writer);
}
