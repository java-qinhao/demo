package com.luban.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{MyBeanPostProcessor.class.getName(),MyBeanFactoryPostProcessor.class.getName()};
    }
}
