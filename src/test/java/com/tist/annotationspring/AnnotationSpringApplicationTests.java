package com.tist.annotationspring;

import com.tist.annotation.PersonName;
import com.tist.bean.Person;
import com.tist.config.PersonNameProcessorConfig;
import com.tist.demo.Demo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = {PersonNameProcessorConfig.class})
class AnnotationSpringApplicationTests {

    @PersonName(age = 38, name = "王小明")
    private Person person;

    @Test
    void contextLoads() {
    }

    @Test
    @DisplayName("基本Annotation")
    public void testSimpleAnnotation() {
        Demo demo = new Demo();
        demo.printValue();
        demo.countAnnotatedFunctions();
    }

    @Test
    @DisplayName("Spring Annotation")
    public void testSpringAnnotation() {
        String introduce = String.format("我叫%s我今年%d歲", person.getName(), person.getAge());
        System.out.println(introduce);
    }

}
