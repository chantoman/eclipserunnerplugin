package com.eclipserunner.model;

import java.util.List;

/**
 * @author vachacz
 */
public interface INodeSelection {

	boolean isSelectionOfOneClass();
	boolean isSingleSelection();

	Object getFirstSelectedObject();
	List<Object> getAllSelectedObjects();

	boolean isLaunchNodeSelected();
	ILaunchNode getSelectedLaunchNode();
	List<ILaunchNode> getSelectedLaunchNodes();

	boolean isLaunchTypeNodeSelected();
	ILaunchTypeNode getSelectedLaunchTypeNode();
	List<ILaunchTypeNode> getSelectedLaunchTypeNodes();

	boolean isCategoryNodeSelected();
	ICategoryNode getSelectedCategoryNode();
	List<ICategoryNode> getSelectedCategoryNodes();

}