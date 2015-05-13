package solid;

/**
 * Created by Squall on 13/05/2015.
 */
public interface SRPExample {
    //Empty On Purpose
}

interface Modem {
    public void dial(String pno);
    public void hangup();
    public void send(char c);
    public char receive();
}
//Send and Receive are not truly the responsibility of the modem
//Seperating them

interface Connection {
    public void dial(String pno);
    public void hangup();
}

interface DataChannel {
    public void send(char c);
    public char receive();
}
