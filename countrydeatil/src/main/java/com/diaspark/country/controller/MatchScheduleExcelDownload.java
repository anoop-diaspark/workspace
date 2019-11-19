package com.diaspark.country.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diaspark.country.entity.ScheduleEntity;
import com.diaspark.country.excel.ExcelGenerator;
import com.diaspark.country.repository.ScheduelRepository;

@RestController
@RequestMapping("/schedule")
public class MatchScheduleExcelDownload {

	@Autowired
	private ScheduelRepository scheduelRepository;

	@GetMapping(value = "/download/matchschedule.xlsx")
	public ResponseEntity<InputStreamResource> excelCustomersReport() throws IOException {
		List<ScheduleEntity> scheduel = (List<ScheduleEntity>) scheduelRepository.findAll();

		ByteArrayInputStream in = ExcelGenerator.scheduleToExcel(scheduel);
		// return IOUtils.toByteArray(in);

		
		  HttpHeaders headers = new HttpHeaders();
		  headers.add("Content-Disposition",
		  "attachment; filename=schedule.xlsx");
		 

		  headers.setContentType(new MediaType("application", "vnd.openxmlformats-officedocument.spreadsheetml.sheet"));
		  
		return ResponseEntity.ok()
				 .headers(headers)
				.body(new InputStreamResource(in));
	}
}
