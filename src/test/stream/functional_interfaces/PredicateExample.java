package test.stream.functional_interfaces;

import test.stream.Data;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateExample implements Predicate<String> {
    @Override
    public boolean test(String string) {
        return string.length() > 5;
    }

    public static void extractedMyImpPredicate() {
        PredicateExample myPredicate = new PredicateExample();
        List<String> filteredNames = Data.list.stream()
                .filter(myPredicate)
                .collect(Collectors.toList());

        System.out.println(filteredNames);
    }
}
