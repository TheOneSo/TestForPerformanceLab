package com.data.Logic;

import java.io.FileWriter;
import java.io.IOException;

public final class FileHandler {

    private FileWriter file;
    /**
     * Save file by the way pathToFile
     * With searchname
     * In format .txt
     */
    public void saveFile(String pathToFile, String fileName, String Text){
        try {
            file = new FileWriter(pathToFile + fileName + ".txt", false);
            file.write(Text);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }finally {
            try{
                file.close();
            }catch (IOException e){
                System.out.println(e.getMessage());
                System.out.println("File don't close");
            }finally {
                System.out.println(fileName + ".txt success saved");
            }
        }
    }
}
