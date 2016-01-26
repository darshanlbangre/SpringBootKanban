package com.kanban.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.mariadb.jdbc.internal.mysql.listener.impl.AuroraListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kanban.service.KanbanService;
import com.kanban.serviceobjects.WorkItem;

/**
 * @author DBangre
 *
 */
@RestController
public class MainController {

	/**
	 * kanbanService
	 */
	@Autowired
	private KanbanService kanbanService;
	
	private static final Logger logger = Logger.getLogger(KanbanService.class);
	
	@RequestMapping(
			value = "/kanban/workitem", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<WorkItem>> getAllWorkItem() {

		logger.info("Invoking getAllWorkItem method");
		return new ResponseEntity<List<WorkItem>>(kanbanService.getWorkItems(),HttpStatus.OK);
	}
	
	/**
	 * @param id
	 * @return
	 */
	@RequestMapping(
			value = "/kanban/workitem/{id}", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<WorkItem> getWorkItem(@PathVariable("id") Long id) {
		
		logger.info("Invoking getWorkItem method");
		return new ResponseEntity<WorkItem>(kanbanService.getWorkItem(id),HttpStatus.OK);
	}

	/**
	 * @param workItem
	 * @return
	 */
	@RequestMapping(
			value = "/kanban/workitem", 
			method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<WorkItem> addWorkItemm(@RequestBody WorkItem workItem) {
		
		logger.info("Invoking addWorkItem method");
		return new ResponseEntity<WorkItem>(kanbanService.addWorkItem(workItem),HttpStatus.OK);
	}

	/**
	 * @param workItem
	 * @param id
	 * @return
	 */
	@RequestMapping(
			value = "/kanban/workitem", 
			method = RequestMethod.PUT, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<WorkItem> updateWorkItemm(@RequestBody WorkItem workItem) {

		logger.info("Invoking updateWorkItem method");
		return new ResponseEntity<WorkItem>(kanbanService.updateWorkItem(workItem),HttpStatus.OK);
	}

	/**
	 * @param id
	 * @return
	 */
	@RequestMapping(
			value = "/kanban/workitem/{id}", 
			method = RequestMethod.DELETE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> removeWorkItem(@PathVariable("id") Long id) {

		logger.info("Invoking removeWorkItem method");
		kanbanService.deleteWorkItem(id);
		return new ResponseEntity<Boolean>(true,HttpStatus.OK);
	}

}
