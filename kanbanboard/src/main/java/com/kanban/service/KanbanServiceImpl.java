package com.kanban.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kanban.dao.KanbanDao;
import com.kanban.serviceobjects.WorkItem;

/**
 * @author DBangre
 *
 */
@Service
public class KanbanServiceImpl implements KanbanService {
	
	/**
	 * kanbanDao
	 */
	@Autowired
	private KanbanDao kanbanDao;

	@Override
	public List<WorkItem> getWorkItems() {
		return kanbanDao.findAll();
	}
	
	@Override
	public WorkItem getWorkItem(Long id) {
		return kanbanDao.findOne(id);
	}

	@Override
	@Transactional
	public WorkItem addWorkItem(WorkItem workItem) {
		if(workItem.getId() == null){
			return kanbanDao.save(workItem);
		}
		return null;
	}

	@Override
	@Transactional
	public WorkItem updateWorkItem(WorkItem workItem) {
		
		if(kanbanDao.findOne(workItem.getId()) == null){
			return null;
		}
		return kanbanDao.save(workItem);
		}

	@Override
	@Transactional
	public void deleteWorkItem(Long id) {
		kanbanDao.delete(id);
	}

	
}
