package com.autotesting.utilize.Logic;

import java.io.FileWriter;
import java.io.IOException;

public final class FileHandler {

    /**
     * Save file by the way pathToFile
     * With searchname
     * In format .txt
     */
    public void saveFile(String pathToFile, String fileName, String Text){
        try(FileWriter file = new FileWriter(pathToFile + fileName + ".txt", false)) {
            file.write(Text);
            file.close();
        } catch (IOException e){
            System.out.println(e.getMessage());
            System.out.println("File don't saved");
        }
    }
}
