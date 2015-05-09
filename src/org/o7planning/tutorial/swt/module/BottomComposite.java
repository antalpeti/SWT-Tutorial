package org.o7planning.tutorial.swt.module;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

public class BottomComposite extends Composite {
  private Text text;

  /**
   * Create the composite.
   *
   * @param parent
   * @param style
   */
  public BottomComposite(Composite parent, int style) {
    super(parent, style);
    setLayout(new FillLayout(SWT.HORIZONTAL));

    Composite composite = new Composite(this, SWT.NONE);
    composite.setLayout(new GridLayout(1, false));

    Composite composite_1 = new Composite(composite, SWT.NONE);
    composite_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
    GridLayout gl_composite_1 = new GridLayout(3, false);
    gl_composite_1.marginHeight = 0;
    gl_composite_1.marginWidth = 0;
    composite_1.setLayout(gl_composite_1);

    Button btnAdd = new Button(composite_1, SWT.NONE);
    btnAdd.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
    btnAdd.setText("Add");

    Button btnDelete = new Button(composite_1, SWT.NONE);
    btnDelete.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
    btnDelete.setText("Delete");

    Button btnClear = new Button(composite_1, SWT.NONE);
    btnClear.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
    btnClear.setText("Clear");

    text = new Text(composite, SWT.BORDER | SWT.MULTI);
    text.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

  }

  @Override
  protected void checkSubclass() {
    // Disable the check that prevents subclassing of SWT components
  }

}
