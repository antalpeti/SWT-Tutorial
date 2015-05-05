package org.o7planning.tutorial.swt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class HelloSWT {

  public static void main(String[] args) {
    // Create Display
    Display display = new Display();
    // Create Shell (Window) from diplay
    Shell shell = new Shell(display);

    shell.open();

    while (!shell.isDisposed()) {
      if (!display.readAndDispatch()) {
        display.sleep();
      }
    }
    display.dispose();
  }
}
