package homework7;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Tester {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        start(Tests.class);
    }

    private static <T> void start(Class<T> testClass) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Constructor constructor = testClass.getConstructor();
        T instance = (T) constructor.newInstance();

        List<Method> methodListBefore = getListOfMethodsByAnno(testClass, BeforeSuite.class);
        for (Method method : methodListBefore) {
            method.invoke(instance);
        }

        List<Method> tests = getListOfMethodsByAnno(testClass, Test.class);
        tests.sort(Comparator.comparingInt((Method method) -> {
            return method.getAnnotation(Test.class).priority();
        }).reversed());
        for (Method test : tests) {
            test.invoke(instance);
        }

        List<Method> methodListAfter = getListOfMethodsByAnno(testClass, AfterSuite.class);
        for (Method method : methodListAfter) {
            method.invoke(instance);
        }
    }

    private static List<Method> getListOfMethodsByAnno(Class tclass, Class<? extends Annotation> anno) {
        List<Method> methods = new ArrayList<>();
        for (Method method : tclass.getMethods()) {
            if (method.isAnnotationPresent(anno)) {
                methods.add(method);
            }
        }
        if ((methods.size() >= 2) && ((anno.equals(BeforeSuite.class)) || (anno.equals(AfterSuite.class)))) {
            throw new RuntimeException("Аннотация" + anno.getName() + "не уникальна");
        }
        return methods;
    }
}
