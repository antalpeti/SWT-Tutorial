package org.o7planning.tutorial.swt.helloswt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class MySWTApplication {

  protected Shell shell;

  /**
   * Launch the application.
   *
   * @param args
   */
  public static void main(String[] args) {
    try {
      MySWTApplication window = new MySWTApplication();
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
    composite.setLayout(new GridLayout(3, false));

    Button btnMyButton = new Button(composite, SWT.NONE);
    btnMyButton.setText("My Button");

    Button btnRadioButton = new Button(composite, SWT.RADIO);
    btnRadioButton.setText("Radio Up");

    Button btnCheckButton = new Button(composite, SWT.CHECK);
    btnCheckButton.setText("Check Button");
    new Label(composite, SWT.NONE);

    Button btnRadioButton_1 = new Button(composite, SWT.RADIO);
    btnRadioButton_1.setText("Radio Down");
    new Label(composite, SWT.NONE);

    Composite composite_1 = new Composite(composite, SWT.NONE);
    composite_1.setLayout(new GridLayout(3, false));
    composite_1.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1));

    Button btnRadioButton_2 = new Button(composite_1, SWT.RADIO);
    btnRadioButton_2.setBounds(0, 0, 90, 16);
    btnRadioButton_2.setText("Radio Left");

    Button btnRadioButton_3 = new Button(composite_1, SWT.RADIO);
    btnRadioButton_3.setBounds(0, 0, 90, 16);
    btnRadioButton_3.setText("Radio Center");

    Button btnRadioButton_4 = new Button(composite_1, SWT.RADIO);
    btnRadioButton_4.setText("Radio Right");
  }
}
