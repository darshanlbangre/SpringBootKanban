package com.kanban.constants;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;

/**
 * @author DBangre
 *
 */
public class Constants {

	private static final Map<String, String> status = createMap();

    private static Map<String, String> createMap() {
        Map<String, String> result = new HashMap<String, String>();
        result.put("1", "ToDo");
        result.put("2", "Development");
        result.put("3", "Code Review");
        result.put("4", "Test");
        return Collections.unmodifiableMap(result);
    }
}
