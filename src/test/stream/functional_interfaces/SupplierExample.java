package test.stream.functional_interfaces;

import test.stream.Data;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class SupplierExample implements Supplier<String> {
    private String name;

    public SupplierExample(String name) {
        this.name = name;
    }
    @Override
    public String get() {
        return "*Hello, " + name + "!*";
    }

    public static void extractedMyImplSupplier() {
        List<String> names = Data.list.stream()
                .map(name -> new SupplierExample(name).get())
                .collect(Collectors.toList());

        System.out.println(names);
    }
}
