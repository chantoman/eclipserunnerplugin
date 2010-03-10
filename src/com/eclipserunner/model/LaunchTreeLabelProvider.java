package com.eclipserunner.model;

import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.debug.ui.IDebugModelPresentation;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.DecorationOverlayIcon;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import com.eclipserunner.RunnerPlugin;

/**
 * Launch configuration tree decorator.
 * 
 * @author vachacz
 */
public class LaunchTreeLabelProvider extends LabelProvider {

	private static final String IMG_CATEGORY = "category.gif";
	private static final String IMG_BOOKMARK = "pin.gif";

	private IDebugModelPresentation debugModelPresentation;

	public LaunchTreeLabelProvider() {
		debugModelPresentation = DebugUITools.newDebugModelPresentation();
	}

	@Override
	public String getText(Object element) {
		if (element instanceof ILaunchConfigurationCategory) {
			return ((ILaunchConfigurationCategory) element).getName();
		}
		return debugModelPresentation.getText(element);
	}

	@Override
	public Image getImage(Object element) {
		if (element instanceof ILaunchConfigurationCategory) {
			return RunnerPlugin.getDefault().getImageDescriptor(IMG_CATEGORY).createImage();
		}
		else if (element instanceof ILaunchConfiguration) {
			Image image = debugModelPresentation.getImage(element);
			ILaunchConfiguration launchConfiguration = (ILaunchConfiguration) element;
			ILaunchConfigurationCategory launchConfigurationCategory = RunnerModel.getDefault().getLaunchConfigurationCategory(launchConfiguration);

			if (launchConfigurationCategory.isBookmarked(launchConfiguration)) {
				ImageDescriptor bookmarkDescriptor = RunnerPlugin.getDefault().getImageDescriptor(IMG_BOOKMARK);
				DecorationOverlayIcon bookmarkedImage = new  DecorationOverlayIcon(image, bookmarkDescriptor, IDecoration.TOP_RIGHT);
				return bookmarkedImage.createImage();
			}

			return image;
		}
		else {
			return ImageDescriptor.getMissingImageDescriptor().createImage();
		}
	}

}