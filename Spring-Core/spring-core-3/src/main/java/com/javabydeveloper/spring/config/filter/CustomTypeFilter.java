package com.javabydeveloper.spring.config.filter;

import java.io.IOException;
import java.util.Arrays;

import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import com.javabydeveloper.spring.bean.animal.amphibians.Amphibian;

public class CustomTypeFilter implements TypeFilter {

	@Override
	public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory)
			throws IOException {
		
		ClassMetadata classMetadata = metadataReader.getClassMetadata();
        String[] interfaces = classMetadata.getInterfaceNames();

        if (Arrays.stream(interfaces).anyMatch(Amphibian.class.getName()::equals))
            return true;
        
        String className = classMetadata.getClassName();
     
        if(className.endsWith("Crocodle"))
        	return true;
        
		return false;
	}
}
