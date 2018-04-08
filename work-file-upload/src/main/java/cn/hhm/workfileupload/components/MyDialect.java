package cn.hhm.workfileupload.components;

import org.springframework.stereotype.Component;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.spring4.dialect.SpringStandardDialect;

import java.util.HashSet;
import java.util.Set;

/**
 * @outhor Ming
 * @create 2018-04-03 10:18
 */
@Component
public class MyDialect extends SpringStandardDialect {
    @Override
    public String getPrefix() {
        return "hhm";
    }

    @Override
    public Set<IProcessor> getProcessors() {
        final Set<IProcessor> processors = new HashSet<>();
        processors.add(new MyElementProcessor());
        return processors;
    }
}
