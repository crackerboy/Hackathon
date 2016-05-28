package com.otfd.doorbell.server;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import com.otfd.doorbell.R;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Enumeration;


public class VideoStream extends Activity {
    private TextView serverStatus;
    private Handler handler = new Handler();
    private ServerSocket serverSocket;
    private static final String TAG = "VIDEO_STREAM";
    public static String SERVERIP = "172.16.0.1";  // DEFAULT IP
    public static final int SERVERPORT = 8080;  // DESIGNATE A PORT

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // serverStatus = (TextView) findViewById(R.id.connection_info);

        new Thread(new Runnable() {
            public void run(){
                try {
                    if (SERVERIP != null) {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                Log.e(TAG, "Listening on IP: " + SERVERIP);
                                // serverStatus.setText("Listening on IP: " + SERVERIP);
                            }
                        });
                        serverSocket = new ServerSocket(SERVERPORT);
                        while (true) {
                            // LISTEN FOR INCOMING CLIENTS
                            Socket client = serverSocket.accept();
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    Log.e(TAG, "Connected");
                                    // serverStatus.setText("Connected.");
                                }
                            });

                            try {
                                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                                String line = null;
                                while ((line = in.readLine()) != null) {
                                    Log.d("", line);
                                    handler.post(new Runnable() {
                                        @Override
                                        public void run() {
                                            Log.e(TAG, "ROGER ROGER UNDERSTOOD!");
                                        }
                                    });
                                }
                                break;
                            } catch (Exception e) {
                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        Log.e(TAG, "Connection interrupted");
                                        // serverStatus.setText("Oops. Connection interrupted. Please reconnect your phones.");
                                    }
                                });
                                e.printStackTrace();
                            }
                        }
                    } else {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                Log.e(TAG, "No internet connection");
                                // serverStatus.setText("Couldn't detect internet connection.");
                            }
                        });
                    }
                } catch (Exception e) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Log.e(TAG, "General error");
                            // serverStatus.setText("Error");
                        }
                    });
                    e.printStackTrace();
                }
            }
        }).start();
    }

    // GETS THE IP ADDRESS OF YOUR PHONE'S NETWORK
    private String getLocalIpAddress() {
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress()) { return inetAddress.getHostAddress().toString(); }
                }
            }
        } catch (SocketException ex) {
            Log.e("", ex.toString());
        }
        return null;
    }
}
