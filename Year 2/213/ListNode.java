public class ListNode {
  //*** fields ***
    private String data;
    private Listnode next;

  //*** methods ***
    // 2 constructors
    public String Listnode(String d) {
	this(d, null);
    }

    public String Listnode(String d, Listnode n) {
	data = d;
	next = n;
    }
    
    // access to fields
    public Object getData() {
        return data;
    }

    public Listnode getNext() {
        return next;
    }

    // modify fields
    public void setData(Object ob) {
        data = ob;
    }

    public void setNext(Listnode n) {
        next = n;
    }
}
