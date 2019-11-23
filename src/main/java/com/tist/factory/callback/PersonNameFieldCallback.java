package com.tist.factory.callback;

import com.tist.annotation.PersonName;
import com.tist.bean.Person;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

/**
 * @author Jack Lin
 */
public class PersonNameFieldCallback implements ReflectionUtils.FieldCallback {
    private Object bean;


    public PersonNameFieldCallback(Object bean) {
        this.bean = bean;
    }

    @Override
    public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
        if (!field.isAnnotationPresent(PersonName.class)) {
            return;
        }
        ReflectionUtils.makeAccessible(field);
        PersonName personName = field.getAnnotation(PersonName.class);
        Class<?> type = field.getType();
        if (type.equals(Person.class)) {
            Person person = new Person();
            person.setAge(personName.age());
            person.setName(personName.name());
            field.set(bean, person);
        }
    }
}
