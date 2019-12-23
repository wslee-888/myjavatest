package other;

import java.io.*;

public class TestIOObject implements Serializable{



    private int id;
    private String str;

    public TestIOObject() {
    }

    public TestIOObject(int id, String str) {
        this.id = id;
        this.str = str;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return "TestIOObject{" +
                "id=" + id +
                ", str='" + str + '\'' +
                '}';
    }

/*    static int var = 76458;
    // assign a new serialPersistentFields
    private static final ObjectStreamField[] serialPersistentFields = {
            new ObjectStreamField("var", Integer.TYPE)
    };


    private void readObject(ObjectInputStream in)
            throws IOException, ClassNotFoundException {

        // get the field and assign it at var
        ObjectInputStream.GetField fields = in.readFields();

        // get var
        var = fields.get("var", 0);
    }

    private void writeObject(ObjectOutputStream out)
            throws IOException {

        // write into the ObjectStreamField array the variable var
        ObjectOutputStream.PutField fields = out.putFields();
        fields.put("var", var);
        out.writeFields();

    }*/

}
