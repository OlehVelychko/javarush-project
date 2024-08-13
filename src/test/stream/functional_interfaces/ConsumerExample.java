package test.stream.functional_interfaces;

import test.stream.Data;

import java.util.function.Consumer;

public class ConsumerExample implements Consumer<String> {
    @Override
    public void accept(String string) {
        System.out.println(string);
    }

    public static void extractedMyImplConsumer() {
        ConsumerExample myConsumer = new ConsumerExample();

        Data.list.stream()
                .forEach(myConsumer);
    }
}
