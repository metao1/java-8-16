package com.metao.java8;

import java.util.List;

public class DecoratorIfs {

    static class ListValidator extends Validator {

        public ListValidator(Valid validator) {
            super(validator);
        }

        @Override
        public boolean validate(Valid validator, List<Integer> list) {
            return super.validator.validate(validator, list) &&  list != null && !list.isEmpty();
        }
    }

    static class ItemsValidator extends Validator {

        public ItemsValidator(Valid validator) {
            super(validator);
        }

        @Override
        public boolean validate(Valid validator, List<Integer> list) {
            return super.validator.validate(validator, list) &&  list.size() == 2;
        }
    }

    public static void main(String[] args) {
        List<Integer> items = List.of(1,2,3);
        var validator = new ListValidator(new ItemsValidator(null));
        validator.validate(null, items);
    }


    static abstract class Validator implements Valid {
        final Valid validator;

        public Validator(Valid validator) {
            this.validator = validator;
        }
    }

    interface Valid {
        boolean validate(Valid validator, List<Integer> list);
    }
}
