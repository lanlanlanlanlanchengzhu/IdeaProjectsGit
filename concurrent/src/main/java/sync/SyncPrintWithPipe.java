package sync;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.zip.CheckedOutputStream;

public class SyncPrintWithPipe {

    private final PipedInputStream noPipedInputStream;
    private final PipedInputStream charPipedInputStream;
    private final PipedOutputStream noPipedOutputStream;
    private final PipedOutputStream charPipedOutputStream;
    private final byte[] MSG;

    public SyncPrintWithPipe () {
        this.noPipedInputStream = new PipedInputStream();
        this.charPipedInputStream = new PipedInputStream();
        this.noPipedOutputStream = new PipedOutputStream();
        this.charPipedOutputStream = new PipedOutputStream();
        MSG = "GO".getBytes();
        try {
            noPipedInputStream.connect(charPipedOutputStream);
            charPipedInputStream.connect(noPipedOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void shutdown () throws IOException {
        noPipedInputStream.close();
        charPipedInputStream.close();
        noPipedInputStream.close();
        charPipedOutputStream.close();
    }

    String[] noArr = Helper.getNoArr(52);
    String[] charArr = Helper.getCharArr(26);

    public Runnable noThread () {
        return new Runnable() {
            public void run() {
                for (int i = 0; i < noArr.length; i = i+2) {
                    Helper.print(noArr[i], noArr[i+1]);
                    try {
                        noPipedOutputStream.write(MSG);
                        byte[] inArr = new byte[2];
                        noPipedInputStream.read(inArr);
                        while (true) {
                            if ("GO".equals(new String(inArr))) {
                                break;
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
    }

    public Runnable charThread () {
        return new Runnable() {
            public void run() {
                for (int i = 0; i < charArr.length; i++) {
                    byte[] inArr = new byte[2];
                    try {
                        charPipedInputStream.read(inArr);
                        while (true) {
                            if ("GO".equals(new String(inArr))) {
                                break;
                            }
                        }
                        Helper.print(charArr[i]);
                        charPipedOutputStream.write(MSG);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
    }

    public static void main(String[] args) throws IOException {
        SyncPrintWithPipe syncPrint = new SyncPrintWithPipe();
        Helper.instance.run(syncPrint.noThread());
        Helper.instance.run(syncPrint.charThread());
        Helper.instance.shutdown();
//        syncPrint.shutdown();
    }

}
