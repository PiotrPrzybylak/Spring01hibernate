package pl.coderslab.app;

import org.springframework.core.convert.converter.Converter;

public class SkillConverter implements Converter<String, Skill> {

    @Override
    public Skill convert(String source) {
        return new Skill( Integer.parseInt(source), "Test");
    }
}