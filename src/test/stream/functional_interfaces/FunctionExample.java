package test.stream.functional_interfaces;

import test.stream.Data;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionExample implements Function<String, Integer> {

    @Override
    public Integer apply(String myString) {
        return myString.length();
    }

    public static void extractedFunctionInterface() {
        FunctionExample mapper = new FunctionExample();
        List<Integer> integerList = Data.list.stream()
                .map(mapper)
                .collect(Collectors.toList());

        System.out.println(integerList);
    }

    /*List<Integer> listStream = list.stream()
                .map(String::length)
                .collect(Collectors.toList());

        System.out.println(listStream);*/

        /*List<String> listStream = list.stream()
                .map(el -> Integer.toString(el.length()))
                .collect(Collectors.toList());

        System.out.println(listStream);*/

        /*int[] arrayStream = Arrays.stream(array)
                .map(el -> {
                    if (el % 3 == 0) {
                        el = el / 3;
                    }
                    return el;
                })
                .toArray();

        System.out.println(Arrays.toString(arrayStream));*/

        /*int[] arrayStream = Arrays.stream(array)
                .map(el -> el % 3 == 0 ? el / 3 : el)
                .toArray();

        System.out.println(Arrays.toString(arrayStream));*/
}
