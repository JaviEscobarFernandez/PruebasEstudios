package videotutoria08;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FTPClient2 ftp = new FTPClient2();
        ftp.open();
        ftp.close();
    }
}
