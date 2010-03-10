package com.eclipserunner.views.actions;

import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.jface.action.Action;

import com.eclipserunner.model.ILaunchConfigurationCategory;
import com.eclipserunner.model.ILaunchConfigurationSelection;
import com.eclipserunner.model.RunnerModel;

/**
 * Unbookmark launch configuration.
 * 
 * @author bary
 */
public class UnbookmarkLaunchAction extends Action {

	private ILaunchConfigurationSelection launchConfigurationSelection;

	public UnbookmarkLaunchAction(ILaunchConfigurationSelection launchConfigurationSelection) {
		this.launchConfigurationSelection = launchConfigurationSelection;
	}

	@Override
	public void run() {
		if (launchConfigurationSelection.isLaunchConfigurationSelected()) {
			ILaunchConfiguration launchConfiguration = launchConfigurationSelection.getSelectedLaunchConfiguration();
			ILaunchConfigurationCategory launchConfigurationCategory = RunnerModel.getDefault().getLaunchConfigurationCategory(launchConfiguration);
			launchConfigurationCategory.unbookmark(launchConfiguration);
		}
		if (launchConfigurationSelection.isLaunchConfigurationCategorySelected()) {
			ILaunchConfigurationCategory launchConfigurationCategory = launchConfigurationSelection.getSelectedLaunchConfigurationCategory();
			launchConfigurationCategory.unbookmarkAll();
		}
	}

}
