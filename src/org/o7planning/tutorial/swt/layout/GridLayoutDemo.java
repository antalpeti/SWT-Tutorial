package org.o7planning.tutorial.swt.layout;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class GridLayoutDemo {

  protected Shell shell;

  /**
   * Launch the application.
   *
   * @param args
   */
  public static void main(String[] args) {
    try {
      GridLayoutDemo window = new GridLayoutDemo();
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
    GridLayout gl_composite = new GridLayout(3, false);
    composite.setLayout(gl_composite);

    Button btnNewButton = new Button(composite, SWT.NONE);
    btnNewButton.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, true, 1, 1));
    btnNewButton.setText("B1");

    Button btnLongButton = new Button(composite, SWT.NONE);
    btnLongButton.setText("Long Button 2");

    Button btnButton = new Button(composite, SWT.NONE);
    btnButton.setText("Button 3");

    Button btnB = new Button(composite, SWT.NONE);
    GridData gd_btnB = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
    gd_btnB.heightHint = 66;
    gd_btnB.widthHint = 75;
    btnB.setLayoutData(gd_btnB);
    btnB.setText("B4");

    Button btnButton_1 = new Button(composite, SWT.NONE);
    GridData gd_btnButton_1 = new GridData(SWT.CENTER, SWT.CENTER, false, false, 2, 1);
    gd_btnButton_1.widthHint = 115;
    gd_btnButton_1.heightHint = 153;
    btnButton_1.setLayoutData(gd_btnButton_1);
    btnButton_1.setText("Button 5");
  }
}
