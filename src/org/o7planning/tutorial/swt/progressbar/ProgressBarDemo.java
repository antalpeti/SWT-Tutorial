package org.o7planning.tutorial.swt.progressbar;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

public class ProgressBarDemo {

  private static Thread[] threads;
  private static Boolean[] pause;

  public static void main(String[] args) {
    final Display display = new Display();
    Shell shell = new Shell(display);
    shell.setLayout(new FillLayout(SWT.VERTICAL));

    final ProgressBar bar = new ProgressBar(shell, SWT.SMOOTH);
    final int maximum1 = bar.getMaximum();

    Button btnStart = new Button(shell, SWT.NONE);
    btnStart.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
    btnStart.setText("Start");

    threads = new Thread[1];
    pause = new Boolean[1];
    pause[0] = false;

    btnStart.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent e) {
        if (threads[0] == null) {
          // start branch
          btnStart.setText("Pause");
          threads[0] = new Thread() {
            @Override
            public void run() {
              for (final int[] i = new int[1]; i[0] <= maximum1; i[0]++) {
                try {
                  synchronized (this) {
                    while (pause[0]) {
                      wait(50);
                    }
                  }
                  Thread.sleep(100);
                } catch (InterruptedException e) {
                  break;
                }
                if (display.isDisposed()) {
                  return;
                }
                display.asyncExec(new Runnable() {
                  @Override
                  public void run() {
                    if (bar.isDisposed()) {
                      return;
                    }
                    bar.setSelection(i[0]);
                  }
                });
              }
            }
          };
          threads[0].start();
        } else if (threads[0] != null && pause[0] == false) {
          pause[0] = true;
          btnStart.setText("Resume");
          pause();
        } else if (threads[0] != null && pause[0] == true) {
          pause[0] = false;
          btnStart.setText("Pause");
        }
      }
    });

    Button btnReset = new Button(shell, SWT.NONE);
    btnReset.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
    btnReset.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent e) {
        if (threads[0] != null) {
          btnStart.setText("Start");
          pause[0] = false;
          threads[0].interrupt();
          threads[0] = null;
          bar.setSelection(0);
        }
      }
    });
    btnReset.setText("Reset");

    shell.open();
    while (!shell.isDisposed()) {
      if (!display.readAndDispatch()) {
        display.sleep();
      }
    }
    display.dispose();
  }

  private static void pause() {
    pause[0] = true;
  }
}
