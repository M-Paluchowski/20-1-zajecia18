package inner.exercise;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Company implements Iterable<String> {
    private List<String> employees = new ArrayList<>();

    public void addEmployee(String name) {
        employees.add(name);
    }

    @Override
    public Iterator<String> iterator() {
        return new CompanyIterator();
    }

    private /*final*/ class CompanyIterator implements Iterator<String> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < employees.size();
        }

        @Override
        public String next() {
            return employees.get(index++);
        }
    }
}
