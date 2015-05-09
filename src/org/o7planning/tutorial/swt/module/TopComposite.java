package org.o7planning.tutorial.swt.module;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class TopComposite extends Composite {
  private Text text;

  /**
   * Create the composite.
   *
   * @param parent
   * @param style
   */
  public TopComposite(Composite parent, int style) {
    super(parent, style);
    setLayout(new FillLayout(SWT.HORIZONTAL));

    Composite composite = new Composite(this, SWT.NONE);
    composite.setLayout(new GridLayout(1, false));

    Button btnPreferedSite = new Button(composite, SWT.CHECK);
    btnPreferedSite.setText("Prefered Site");

    Label lblColumnWidht = new Label(composite, SWT.NONE);
    lblColumnWidht.setText("Column width");

    text = new Text(composite, SWT.BORDER);
    text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

  }

  @Override
  protected void checkSubclass() {
    // Disable the check that prevents subclassing of SWT components
  }

}
