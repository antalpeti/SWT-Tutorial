package org.o7planning.tutorial.swt.swtsubclass;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class MyApplication {

  protected Shell shell;

  /**
   * Launch the application.
   *
   * @param args
   */
  public static void main(String[] args) {
    try {
      MyApplication window = new MyApplication();
      window.open();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Open the window.
   */
  public void open() {
    Display display = Display.getDefault();
    createContents();
    shell.open();
    shell.layout();
    while (!shell.isDisposed()) {
      if (!display.readAndDispatch()) {
        display.sleep();
      }
    }
  }

  /**
   * Create contents of the window.
   */
  protected void createContents() {
    shell = new Shell();
    shell.setSize(450, 300);
    shell.setText("SWT Application");
    shell.setLayout(new FillLayout(SWT.HORIZONTAL));

    Composite composite = new Composite(shell, SWT.NONE);
    composite.setLayout(new RowLayout(SWT.HORIZONTAL));

    Button btnNewButton = new Button(composite, SWT.NONE);
    btnNewButton.setLayoutData(new RowData(60, 40));
    btnNewButton.setText("Button");
    MyButton myButton = new MyButton(composite, SWT.NONE, 200, 200);
    myButton.setText("MyButton");

  }

}
