package eu.inmite.android.fw.validation.forms.callback;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import eu.inmite.android.fw.validation.forms.FormsValidator;

/**
 * Callback that will show error text on first view with failed validation
 *
 * @author Tomas Vondracek
 */
public class SimpleErrorPopupCallback extends SimpleCallback {

	private final Drawable mErrorIcon;

	public SimpleErrorPopupCallback(Context context) {
		this(context, false, null);
	}

	public SimpleErrorPopupCallback(Context context, boolean focusFirstFail) {
		this(context, focusFirstFail, null);
	}

	public SimpleErrorPopupCallback(Context context, boolean focusFirstFail, Drawable errorIcon) {
		super(context, focusFirstFail);

		mErrorIcon = errorIcon;
	}

	@Override
	protected void showValidationMessage(FormsValidator.ValidationFail firstFail) {
		final TextView txt = (TextView) firstFail.view;
		if (mErrorIcon != null) {
			txt.setError(firstFail.message, mErrorIcon);
		} else {
			txt.setError(firstFail.message);
		}
	}
}