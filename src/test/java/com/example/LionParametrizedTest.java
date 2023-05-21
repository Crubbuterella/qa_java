package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;

@RunWith(Parameterized.class)
public class LionParametrizedTest {

    @Mock
    Feline feline;

    private final String sex;
    private final Boolean haveMane;

    public LionParametrizedTest(String sex, Boolean haveMane) {
        this.sex = sex;
        this.haveMane = haveMane;
    }

    @Parameterized.Parameters(name = "Пол: {0}. Есть грива: {1}")
    public static Object[][] getTestData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Test
    public void doesHaveManeTest() throws Exception {
        Lion lion = new Lion(sex, feline);
        Assert.assertEquals(lion.doesHaveMane(), haveMane);
    }
}