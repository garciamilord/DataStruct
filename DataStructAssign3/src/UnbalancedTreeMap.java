

public class UnbalancedTreeMap extends BinaryNode{

    BinaryNode root;
    int value;
    OrderedKeyValue orderedKeyValue = new OrderedKeyValue(null, 0);

    void BinaryNode (int value){
        this.value = value;
        rightChild = null;
        leftChild = null;
    }

    public int get(String key) {
        if(key == orderedKeyValue.key) {
            return orderedKeyValue.value;
        }
        return 0;
    }

    public int put(String key, int value) {
        if(key == orderedKeyValue.key) {
            int oldNews = orderedKeyValue.value;
            orderedKeyValue.value = value;
            return oldNews;
        }else {
            BinaryNode(value);
        }
        return 0;
    }

    public String[] keySet() {
        BNinOrder(root);
        return null;
    }
    public void BNinOrder(BinaryNode node) {
        if (node == null)
            return;
        BNinOrder(node.leftChild);
        System.out.print(node + ", ");
        BNinOrder(node.rightChild);
    }
}
