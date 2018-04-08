package cn.hhm.workfileupload.components;

import org.springframework.stereotype.Component;
import org.thymeleaf.Arguments;
import org.thymeleaf.dom.Element;
import org.thymeleaf.dom.Node;
import org.thymeleaf.dom.Text;
import org.thymeleaf.processor.element.AbstractMarkupSubstitutionElementProcessor;

import java.util.ArrayList;
import java.util.List;

/**
 * @outhor Ming
 * @create 2018-04-03 10:20
 */
@Component
public class MyElementProcessor extends AbstractMarkupSubstitutionElementProcessor {

    public MyElementProcessor(){
        super("hello");
    }

    @Override
    protected List<Node> getMarkupSubstitutes(Arguments arguments, Element element) {

        String file = element.getAttributeValue("file");
        List<Node> nodes = null;

        if (file != null){
            Element e = new Element("div");
            Text text = new Text(file);
            e.addChild(text);
            nodes = new ArrayList<>();
            nodes.add(e);
        }else {
            Element h2 = new Element("strong");
            h2.setAttribute("style", "color:red");
            h2.addChild(new Text("无信息"));
            element.insertChild(0, h2);
            nodes = element.getChildren();
        }
        return nodes;
    }

    @Override
    public int getPrecedence() {
        return 1000;
    }
}
