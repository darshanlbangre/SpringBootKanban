package com.kanban.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kanban.serviceobjects.WorkItem;


/**
 * @author DBangre
 *
 */
@Repository
public interface KanbanDao extends JpaRepository<WorkItem, Long>{

}
