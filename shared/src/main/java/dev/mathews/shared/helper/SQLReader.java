package dev.mathews.shared.helper;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class SQLReader {

    private final Map<String, String> sqlQueries = new HashMap<>();

    public String getSql(String name) {
        return sqlQueries.get(name.toLowerCase());
    }

    /**
     * Loads a set of SQL files from the sql/ resource folder
     *
     * @throws IOException if an I/O error has occurred
     */
    public void loadFromResources() throws IOException {
        loadFromResources("sql/");
    }

    /**
     * Loads a set of SQL files from a specified resource folder
     *
     * @param path the resource folder to load from
     * @throws IOException if an I/O error has occurred
     */

    public void loadFromResources(String path) throws IOException {
        Class<?> callerClass;
        try {
            callerClass = Class.forName(Thread.currentThread().getStackTrace()[2].getClassName());
        } catch (ClassNotFoundException exception) {
            throw new IOException(exception);
        }

        final ClassLoader classLoader = callerClass.getClassLoader();

        URI uri;
        try {
            uri = callerClass.getProtectionDomain().getCodeSource().getLocation().toURI();
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(e);
        }

        final File file = new File(uri);
        if(!file.exists()) {
            throw new IllegalArgumentException("Could not find specified file");
        }
        if(file.isDirectory()) {
            throw new IllegalArgumentException("The specified folder must be a file");
        }

        JarFile jarFile = new JarFile(file);
        Enumeration<JarEntry> entries = jarFile.entries();

        while (entries.hasMoreElements()) {
            JarEntry entry = entries.nextElement();
            String name = entry.getName();

            if(name.length() < path.length() + 5 || !name.startsWith(path) || !name.endsWith(".sql")) {
                continue;
            }

            InputStream stream = classLoader.getResourceAsStream(name);
            if(stream == null) {
                return;
            }

            InputStreamReader reader = new InputStreamReader(stream);
            name = name.substring(path.length(), name.length() - 4);

            read(name, reader);
        }
    }

    private void read(String name, java.io.Reader reader) {
        StringBuilder stringBuilder = new StringBuilder();
        try(BufferedReader stream = new BufferedReader(reader)) {
            String line;

            while((line = stream.readLine()) != null) {
                stringBuilder.append(line)
                    .append("\n");
            }
        } catch (IOException e) {
            System.err.printf("Could not read \"%s\", skipping...", name);
            e.printStackTrace();
        }
        sqlQueries.put(name.toLowerCase(), stringBuilder.toString());
    }
}
