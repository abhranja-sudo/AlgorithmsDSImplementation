package com.ar50645.OOD;


import jdk.jfr.SettingDefinition;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* implement linux find command as an api, the api will support finding files that has given size requirements and a file with a certain format like
        find all file >5mb
        find all xml
        Assume file class
        get name()
        directorylistfile()
        getFile()
        create a library flexible that is flexible
        Design classes, interfaces.

        // eg.
        find *abc.java .
*/

class FileSearchService {
    List<Path> search(Path path, List<Filter> toBeFiltered) {
        CompositeFilter filters = new CompositeFilter();
        filters.setFilters(filters);
        List<Path> result = new ArrayList<>();
        return result;
    }

    private void traverse(Path path, Filter filter, List<Path> result) {
        if(path.isFile()) {
            if(filter.match(path)) {
                result.add(path);
            }
        }
        else {
            path.next().forEach(p -> traverse(p, filter, result));
        }
    }
}

record Path(String fileName, boolean isFile, List<Path> next){}

interface Filter {
    boolean match(Path path);
};

class FilterBuilder {
    List<Filter> filterList;

    FilterBuilder addFilter(Filter filter){
        filterList.add(filter);
        return this;
    }

    static FilterBuilder getBuilder() {
        return new FilterBuilder();
    }
}

@Setter
class CompositeFilter implements Filter {
    private List<Filter> filters;

    @Override
    public boolean match(Path path) {
        boolean found = true;
        for(Filter filter : filters) {
            found = found && filter.match(path);
        }
        return found;
    }
}


class ExtensionFilter implements Filter {
    private String toMatch;
    ExtensionFilter(String toMatch) {
        this.toMatch=toMatch;
    }
    @Override
    public boolean match(Path path) {
        Pattern.compile("*.toMatch");
        // do regex match
        return true;
    }
}

class SizeFilter implements Filter {
    private int size;

    SizeFilter(int size) {
        this.size = size;
    }

    @Override
    public boolean match(Path path) {
        return file.size() < size;
    }
}


