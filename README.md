# Dynamic Web Table Automation

This project automates a dynamic web table using Selenium WebDriver and Java.

## What it does

- Launches: https://practice.expandtesting.com/dynamic-table
- Reads the table headers and row data dynamically
- Maps the data into a custom Java POJO (`TaskPOJO`)
- Filters and prints only the rows where the name contains "Chrome"

## 🔄 Dynamic Behavior on Every Refresh

The values in the table (like CPU %, Memory, Network) **change automatically every few seconds** or on every page refresh.

This automation:
- Fetches **live data** at the time of execution
- Uses **header-column mapping** so it's not affected by column position changes
- Works even if the DOM structure or values update frequently

✅ Ideal for testing real-time dashboards or monitoring systems!

## Tech Stack

- Java
- Selenium WebDriver
- ChromeDriver

## How to Run

1. Clone the repo
2. Make sure Selenium JARs are added to your project
3. Run `DynamicWebTableAssignmentSolution.java`

## Output Example

[TaskPOJO [name=Chrome, memory=43.3 MB, cpu=9.5%, network=9 Mbps, disk=0.9 MB/s]]
