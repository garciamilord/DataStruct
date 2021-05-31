public class OrderedKeyValue implements Comparable {
    String key;
    int value;

    public OrderedKeyValue(String key,int value) {
        this.key = key;
        this.value=value;
    }


    @Override
    public int compareTo(Object o) {

        return compareTo(((OrderedKeyValue) o).key);
    }
}