package article;

import common.AbstractService;
import enums.Messenger;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ArticleServiceImpl extends AbstractService implements ArticleService{
    private ArticleRepository articleRepository;
    private static ArticleService instance = new ArticleServiceImpl();

    public static ArticleService getInstance()  {
        return instance;
    }

    public ArticleServiceImpl() {
        articleRepository = ArticleRepository.getInstance();
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


    @Override
    public Messenger save(Object o) {
        return null;
    }

    @Override
    public List findAll() throws SQLException {
        return articleRepository.findAll();
    }

    @Override
    public Optional findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Long count() {
        return null;
    }

    @Override
    public Optional getOne(String id) {
        return Optional.empty();
    }

    @Override
    public Messenger delete(Object o) {
        return null;
    }

    @Override
    public String deleteAll() {
        return null;
    }

    @Override
    public Boolean existsById(Long id) {
        return null;
    }
}
