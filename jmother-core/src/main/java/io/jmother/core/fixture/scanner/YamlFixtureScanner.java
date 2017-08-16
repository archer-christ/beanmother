package io.jmother.core.fixture.scanner;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Scanner to find .yaml or .yml prefixed files.
 */
public class YamlFixtureScanner extends AbstractFixtureScanner {

    private static Pattern extensionPattern = Pattern.compile("(\\.)(yml|yaml)$", Pattern.CASE_INSENSITIVE);

    public YamlFixtureScanner(ClassLoader classLoader) {
        super(classLoader);
    }

    @Override
    protected boolean isFixtureFile(File file) {
        if (!super.isFixtureFile(file)) return false;
        Matcher matcher = extensionPattern.matcher(file.getName());
        return matcher.find();
    }
}
