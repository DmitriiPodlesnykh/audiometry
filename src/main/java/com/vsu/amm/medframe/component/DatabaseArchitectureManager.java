package com.vsu.amm.medframe.component;

import antlr.StringUtils;
import org.springframework.stereotype.Component;
import javax.transaction.Transactional;

import java.io.File;

@Component
public class DatabaseArchitectureManager {

    @Transactional
    public void installTables() {
    }

    @Transactional
    private void dropTables() {
    }

    @Transactional
    public void reinstallTables() {
        dropTables();
        installTables();
    }

    private String getFile(String fileName){
        ClassLoader classLoader = getClass().getClassLoader();
        //problem with spring boot
        File file = new File(classLoader.getResource(fileName).getFile());
        return " ";
    }
}
