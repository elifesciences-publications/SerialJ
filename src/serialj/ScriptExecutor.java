/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serialj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Libra
 */
public class ScriptExecutor implements Runnable {

    final private PortAccessor p;
    final private ScheduledExecutorService ses;
    final private File f;

    public ScriptExecutor(File f, PortAccessor p) {
        this.p = p;
        ses = new ScheduledThreadPoolExecutor(1);
        this.f = f;
    }

    @Override
    public void run() {
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            synchronized (this) {
                StringBuilder sum = new StringBuilder();
                String s;
                while ((s = br.readLine()) != null) {
                    sum.append(s.trim());
                }

                p.writeByte((byte) 0x2a);
                ses.schedule(new wakeMe(), 2, TimeUnit.SECONDS);
                wait();
                for (int i = 0; i < sum.length(); i++) {

                    switch (sum.charAt(i)) {
                        case '0':
                            p.writeByte((byte) 0x30);
                            break;
                        case '1':
                            p.writeByte((byte) 0x31);
                            break;
                        case '2':
                            p.writeByte((byte) 0x32);
                            break;
                        case '3':
                            p.writeByte((byte) 0x33);
                            break;
                        case '4':
                            p.writeByte((byte) 0x30);
                            break;
                        case '5':
                            p.writeByte((byte) 0x35);
                            break;
                        case '6':
                            p.writeByte((byte) 0x36);
                            break;
                        case '7':
                            p.writeByte((byte) 0x37);
                            break;
                        case '8':
                            p.writeByte((byte) 0x38);
                            break;
                        case '9':
                            p.writeByte((byte) 0x39);
                            break;
                        case 'r':
                        case 'R':
                            p.writeByte((byte) 0x2a);
                            break;
                        case 's':
                        case 'S':
                            ses.schedule(new wakeMe(), 1000, TimeUnit.MILLISECONDS);
                            wait();
                            break;
                        case 'm':
                        case 'M':
                            ses.schedule(new wakeMe(), 60, TimeUnit.SECONDS);
                            wait();
                            break;
                        case 'h':
                        case 'H':
                            ses.schedule(new wakeMe(), 60, TimeUnit.MINUTES);
                            wait();
                            break;

                    }
                    ses.schedule(new wakeMe(), 1000, TimeUnit.MILLISECONDS);
                    wait();
                }
            }
        } catch (IOException | InterruptedException e) {
            Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    class wakeMe implements Runnable {

        @Override
        public void run() {
            synchronized (ScriptExecutor.this) {
                ScriptExecutor.this.notify();
            }
        }
    }
}
