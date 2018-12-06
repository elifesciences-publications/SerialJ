/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serialj;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

/**
 *
 * @author Xiaoxing
 */
public class DataParser implements Runnable {

    private volatile boolean stop;
    final private BlockingQueue<int[]> q;
    final private ArrayList<int[]> eventList;
    private int[] currEvent;
//    private int currIdx;
    private boolean ctrlIsSet = false;
    private int lastWriteTime;
    private String pathToFile;
    private UI.LogUpdator updater;

    public DataParser() {
        this.lastWriteTime = 0;
        this.stop = false;
        this.q = new LinkedBlockingQueue<>();
        this.eventList = new ArrayList<>();
        this.currEvent = new int[3];

    }

    public boolean setPathToFile(String pathToFile) {
        this.pathToFile = pathToFile;
        File targetFile = new File(pathToFile);
        if (targetFile.exists() && !pathToFile.toLowerCase().contains("temp")) {
            updater.updateString("File Already Exist!");
            SwingUtilities.invokeLater(() -> {

            });
            return false;
        }
        File parent = targetFile.getParentFile();
        if (!parent.exists() && !parent.mkdirs()) {
            updater.updateString("Cannot Create Directory " + parent);
            return false;
        }
        return true;
    }

    public void setUpdater(UI.LogUpdator updater) {
        this.updater = updater;
    }

    private int getIntTime() {
        long timeL = System.currentTimeMillis() & 0x7FFFFFFF;
        return (int) timeL;
    }

    private void process(int[] e) {
        for (int i : e) {
            if ((i & 0x80) == 0) { //cmd
                if (ctrlIsSet) {
                    currEvent[2] = 0xff;
                    updateEvents(currEvent);
                    currEvent = new int[3];
                }

                currEvent[0] = getIntTime();
                currEvent[1] = i;
                ctrlIsSet = true;
            } else { //data
                currEvent[2] = (i & 0x7f);
                if (!ctrlIsSet) {
                    currEvent[1] = 0xff;
                }
                updateEvents(currEvent);
                currEvent = new int[3];
                ctrlIsSet = false;
            }
        }

    }

    private void updateEvents(int[] event) {
        event[0] = getIntTime();
        eventList.add(event);
        updater.updateEvent(event);

        if (event[0] > lastWriteTime + 60000) {
            lastWriteTime = event[0];
            writeList(eventList, this.pathToFile);
            updater.updateString("File Saved");
        }
    }

    public void put(int[] in) {

        try {
            q.put(in);
        } catch (InterruptedException ex) {
            updater.updateString(ex.toString());
        }
    }

    @Override
    public void run() {
        while (!stop) {
            try {
                int[] e = q.poll(200, TimeUnit.MILLISECONDS);
                if (null != e) {
                    process(e);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(DataParser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void writeList(ArrayList<int[]> l, String pathToFile) {
        File targetFile = new File(pathToFile);
        File parent = targetFile.getParentFile();
        if (!parent.exists() && !parent.mkdirs()) {
            throw new IllegalStateException("Couldn't create dir: " + parent);
        }
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(targetFile))) {
            out.writeObject(l);
        } catch (IOException e) {
            updater.updateString(e.toString());
        }
    }

    public void stop() {
        stop = true;
        long millis = System.currentTimeMillis();
        while (System.currentTimeMillis() - millis < 400) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {

            }
        }
        writeList(eventList, this.pathToFile);
    }

}
