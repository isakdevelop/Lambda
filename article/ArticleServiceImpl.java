package article;

import java.util.List;

public class ArticleServiceImpl implements ArticleService{
    private static ArticleService instance;

    public static ArticleService getInstance()  {
        return instance;
    }

    public ArticleServiceImpl() {
        instance = new ArticleServiceImpl();
    }


    @Override
    public String writeArticle(String subject, String content, String writer) {
        return null;
    }

    @Override
    public String modifyArticle(int id, String subject, String content) {
        return null;
    }

    @Override
    public String deleteArticle(int id) {
        return null;
    }

    @Override
    public List<?> searchArticleByTitle(String title) {
        return null;
    }

    @Override
    public List<?> searchArticleByContent(String str) {
        return null;
    }

    @Override
    public List<?> searchArticleByWriter(String writer) {
        return null;
    }


}
