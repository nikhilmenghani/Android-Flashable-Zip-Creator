/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aroma.installer;

/**
 *
 * @author Rajat
 */
public class ProgressBarUpdater implements java.lang.Runnable {
        /**
        * Progress bar that shows the current status
        */
        private javax.swing.JProgressBar jpb = null;
        /**
        * Progress bar value
        */
        private java.lang.Integer value = null;
        
        private java.lang.Integer maximum = 100;

        /**
        * Constructor
        * @param jpb The progress bar this has to update
        */
        public ProgressBarUpdater(javax.swing.JProgressBar jpb) {
            this.jpb = jpb;
            jpb.setMaximum(100);
        }

        /**
        * Sets the value to the progress bar
        * @param value Value to set
        */
        public void setValue(java.lang.Integer value) {
            this.value = value;
        }

        /**
        * Action of the thread will be executed here. The value of the progress bar will be set here.
        */
        public void run() {
            do {
                if (value != null) {
                    jpb.setStringPainted(true);
                    jpb.setValue((int)java.lang.Math.round(java.lang.Math.floor(value.intValue() * 100 / maximum)));
                }
                try {
                    java.lang.Thread.sleep(100L);
                } catch (java.lang.InterruptedException ex) {
                    ex.printStackTrace();
                }
            } while (value == null || value.intValue() < jpb.getMaximum());
        }
 
}
