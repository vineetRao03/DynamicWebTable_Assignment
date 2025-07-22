package com.dynamicwebtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DynamicWebTableAssignmentSolution {

	public static void main(String[] args) {

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		WebDriver wd = new ChromeDriver(chromeOptions);
		wd.get("https://practice.expandtesting.com/dynamic-table");

		WebElement tableElement = wd.findElement(By.xpath("//table[contains(@class,\"table table-striped\")]"));
		Map<String, Integer> headerMap = new HashMap<String, Integer>();

		List<WebElement> headerList = tableElement.findElements(By.xpath(".//thead/tr/th")); // chaining of webelements
		List<TaskPOJO> taskList;
//		for (WebElement header : headerList) {
//        	System.out.println(header.getText());			
//		}

		for (int index = 0; index < headerList.size(); index++) {
//			System.out.println(headerList.get(index).getText()+" "+index);
			headerMap.put(headerList.get(index).getText().toLowerCase(), index);
		}
		System.out.println(headerMap);
		taskList = new ArrayList<TaskPOJO>();

		List<WebElement> rowList = tableElement.findElements(By.xpath(".//tbody//tr"));

		for (WebElement row : rowList) {
			List<WebElement> dataList = row.findElements(By.xpath(".//td"));

			taskList.add(new TaskPOJO(dataList.get(headerMap.get("name")).getText(),

					dataList.get(headerMap.get("memory")).getText(), dataList.get(headerMap.get("cpu")).getText(),
					dataList.get(headerMap.get("network")).getText(), dataList.get(headerMap.get("disk")).getText()));
		}
//	    for(TaskPOJO task: taskList) {
//	    	System.out.println(task);
//	    }

		List<TaskPOJO> result = taskList.stream().filter(x -> x.getName().contains("Chrome")).toList();
		System.out.println(result);
	}

}
