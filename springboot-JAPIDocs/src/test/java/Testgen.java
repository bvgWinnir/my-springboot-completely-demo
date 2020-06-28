import io.github.yedaxia.apidocs.Docs;
import io.github.yedaxia.apidocs.DocsConfig;
import org.junit.Test;


public class Testgen {

    @Test
    public void test_gDocs(){
        DocsConfig docsConfig = new DocsConfig();
        docsConfig.setProjectPath("D:\\idea_projects\\my-springboot-completely-demo\\springboot-JAPIDocs\\src\\main\\java\\com");

        docsConfig.setApiVersion("V1.0");
        docsConfig.setAutoGenerate(Boolean.TRUE);
        docsConfig.setDocsPath("D:\\springboot-JAPIDocs\\src\\main\\java\\com\\doc");
        Docs.buildHtmlDocs(docsConfig);
    }

}