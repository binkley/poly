package xxx.poly;

import org.springframework.core.io.DefaultResourceLoader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;

import static java.lang.System.out;
import static java.text.MessageFormat.format;
import static java.util.ResourceBundle.getBundle;

public final class Main {
    public static void main(final String... args)
            throws IOException {
        try (final InputStream gitProps = new DefaultResourceLoader().
                getResource("classpath:/git.properties").
                getInputStream()) {
            final ResourceBundle messages = getBundle("main");
            final Properties git = new Properties();
            git.load(gitProps);
            out.println(format(messages.getString("howdy"),
                    git.getProperty("git.commit.id")));
        }
    }
}
