import io.github.yedaxia.apidocs.Docs;
import io.github.yedaxia.apidocs.DocsConfig;
import io.github.yedaxia.apidocs.plugin.markdown.MarkdownDocPlugin;

public class Testgen {

    @org.junit.Test
    public void test_gDocs() {
        DocsConfig docsConfig = new DocsConfig();
        docsConfig.setProjectPath("D:\\idea_projects\\my-springboot-completely-demo\\springboot-JAPIDocs");
        docsConfig.setApiVersion("V1.0");
        docsConfig.setAutoGenerate(Boolean.TRUE);
        docsConfig.setDocsPath("D:\\springboot-JAPIDocs\\MarkdownDoc");
        docsConfig.addPlugin(new MarkdownDocPlugin());
        Docs.buildHtmlDocs(docsConfig);
    }

    @org.junit.Test
    public void test_gDocsWithResource() {
        DocsConfig docsConfig = new DocsConfig();
        docsConfig.setProjectPath("D:\\idea_projects\\my-springboot-completely-demo\\springboot-JAPIDocs");
        docsConfig.setApiVersion("V1.0");
        docsConfig.setAutoGenerate(Boolean.TRUE);
        docsConfig.setResourcePath("/Users/yeguozhong/Desktop/gitLibrary/JApiDocs/library/src/main/resources");
        docsConfig.setDocsPath("D:\\springboot-JAPIDocs\\doc");
        Docs.buildHtmlDocs(docsConfig);
    }

}
