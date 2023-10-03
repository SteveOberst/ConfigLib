package net.sxlver.configlib.configs.yaml;

import com.google.common.jimfs.Jimfs;
import net.sxlver.configlib.classes.TestClass;
import net.sxlver.configlib.configs.yaml.YamlConfiguration.YamlProperties;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;

import static net.sxlver.configlib.util.CollectionFactory.mapOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

class YamlSourceTest {
    private FileSystem fileSystem;
    private Path configPath;

    @BeforeEach
    void setUp() {
        fileSystem = Jimfs.newFileSystem();
        configPath = fileSystem.getPath("/a/b/config.yml");
    }

    @AfterEach
    void tearDown() throws IOException {
        fileSystem.close();
    }

    @Test
    void yamlSourceCreatesDirectories() throws IOException {
        YamlSource source = new YamlSource(configPath, YamlProperties.DEFAULT);
        Path parentDir = configPath.getParent();
        assertThat(Files.exists(parentDir), is(false));
        source.saveConfiguration(new TestClass(configPath), mapOf());
        assertThat(Files.exists(parentDir), is(true));
    }
}