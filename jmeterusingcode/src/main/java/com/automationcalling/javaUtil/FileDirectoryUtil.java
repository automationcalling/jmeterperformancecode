package com.automationcalling.javaUtil;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileDirectoryUtil {

    public static void flushDirectory(File directoryName) throws IOException {
        FileUtils.cleanDirectory(directoryName);
    }
}
