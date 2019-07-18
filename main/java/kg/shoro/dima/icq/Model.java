package kg.shoro.dima.icq;

//import android.view.View;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Model implements Runnable{

    DatagramSocket socket;
    MainActivity viewer;
    Thread thread;

    Model(MainActivity MainActivity) {
        this.viewer = MainActivity;

        thread = new Thread(this);
    }

    public void run() {

        while (true) {

            try {

                socket = new DatagramSocket(7890);

                byte buf[] = new byte[1000];

                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                buf = packet.getData();

                socket.receive(packet);

                String received = new String(packet.getData(), 0, packet.getLength());

                viewer.messageIn(received);
            } catch (IOException e) {
                e.printStackTrace();
            }

            socket.close();
        }
    }
}

