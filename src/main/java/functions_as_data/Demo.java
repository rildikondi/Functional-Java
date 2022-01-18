package functions_as_data;

import org.omg.CORBA.TRANSACTION_MODE;
import return_functions.NoArgsFunction;

public class Demo {

    protected static class Person {
        private String name;
        private Integer age;

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }
    }

    protected static class DataLoader {
        private final NoArgsFunction<Person> loadPerson;

        public DataLoader(boolean isDevelopment) {
            this.loadPerson = isDevelopment
                    ? this::loadPersonFake
                    : this::loadPersonReal;
        }

        private Person loadPersonReal() {
            System.out.println("Loading real Person ...");
            return new Person("Real Person", 26);
        }

        private Person loadPersonFake() {
            System.out.println("Loading fake Person ...");
            return new Person("Fake Person", 100);
        }
    }

    public static void main(String[] args) {
        final boolean IS_DEVELOPMENT = true;

        DataLoader dataLoader = new DataLoader(IS_DEVELOPMENT);

        dataLoader.loadPerson.apply();


    }
}
