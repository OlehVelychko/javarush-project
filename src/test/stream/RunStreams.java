package test.stream;

import test.stream.functional_interfaces.ConsumerExample;
import test.stream.functional_interfaces.FunctionExample;
import test.stream.functional_interfaces.PredicateExample;
import test.stream.functional_interfaces.SupplierExample;

public class RunStreams {


    public static void main(String[] args) {
        /**
         * Calling <Functional interface> in stream
         */
        FunctionExample.extractedFunctionInterface();

        /**
         * Calling <Predicate interface> in stream
         */
        PredicateExample.extractedMyImpPredicate();

        /**
         * Calling <Consumer interface> in stream
         */
        ConsumerExample.extractedMyImplConsumer();

        /**
         * Calling <Supplier interface> in stream
         */
        SupplierExample.extractedMyImplSupplier();


    }


}