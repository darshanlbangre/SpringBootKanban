package com.kanban.service;

import java.util.List;

import com.kanban.serviceobjects.WorkItem;

/**
 * @author DBangre
 *
 */
public interface KanbanService {
	
	/**
	 * @return
	 */
	public List<WorkItem> getWorkItems();
	
	/**
	 * @param id
	 * @return
	 */
	public WorkItem getWorkItem(Long id);
	
	/**
	 * @param workItem
	 * @return
	 */
	public WorkItem addWorkItem(WorkItem workItem);
	
	/**
	 * @param workItem
	 * @param id
	 * @return
	 */
	public WorkItem updateWorkItem(WorkItem workItem);
	
	
	/**
	 * @param id
	 * @return
	 */
	public void deleteWorkItem(Long id);
	

}
