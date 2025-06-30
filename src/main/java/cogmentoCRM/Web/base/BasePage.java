package cogmentoCRM.Web.base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;

import cogmentoCRM.Web.utilities.ElementActionsImpl;
import cogmentoCRM.Web.utilities.LoggerUtil;

public class BasePage {

	protected WebDriver driver;
	protected ElementActionsImpl elementActions;
	protected LoggerUtil log;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.elementActions = new ElementActionsImpl(driver);
		this.log = new LoggerUtil();
	}

	public String screenShotOnFailure(ITestResult result) throws IOException {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss").format(new Date());
		String testName = result.getName();

		String screenshotFileName = "./errorshots/" + testName + "@Test_failed on_" + timestamp + ".png";

		// Create directory if it doesn't exist (for relative path)
		File directory = new File("./errorshots/");
		if (!directory.exists()) {
			directory.mkdirs(); // Create the directory if it doesn't exist
		}
		// Save the screenshot to the specified path
		File destFile = new File(screenshotFileName);
		FileHandler.copy(screenshot, destFile);
		log.info("Failed Screenshot has been taken and saved to " + destFile.getAbsolutePath());

		// Return the file path for the Extent report for attachment
		return destFile.getAbsolutePath();

	}

	public void dateandTimePicker(String data) {
		log.info("Performing calender Input");

		String[] splitdata = data.split(" ");
		String dataMonth = splitdata[1];
		String dataDate = splitdata[2];
		String dataYear = splitdata[splitdata.length - 1];
		String dataTime = splitdata[3];
		try {
			WebElement reqMonth = null;

			while (!data.isEmpty()) {
				reqMonth = driver.findElement(By.xpath("//div[@class='react-datepicker__current-month']"));
				String monthYearValue = reqMonth.getText().trim();
				if (monthYearValue.contains(dataMonth) && monthYearValue.contains(dataYear)) {
					List<WebElement> allDates = null;
					try {
						allDates = driver.findElements(By.xpath("//div[contains(@class,'day')]"));
						for (WebElement ele : allDates) {
							if (ele.isDisplayed()) {
								@Nullable
								String domAttribute = ele.getDomAttribute("aria-label");
								try {
									if (domAttribute.contains(dataDate) && domAttribute.contains(dataMonth)
											&& domAttribute.contains(dataYear)) {
										ele.click();
										break;
									}
								} catch (Exception e) {
								}
							}
						}
						break;
					} catch (Exception e) {
					}
				} else {
					WebElement nextMonthBtn = driver.findElement(By.xpath("//button[@aria-label='Next Month']"));
					nextMonthBtn.click();
					reqMonth = driver.findElement(By.xpath("//div[@class='react-datepicker__current-month']"));
				}
			}
			// picking Time
			List<WebElement> allTimes = driver.findElements(By.xpath("//ul[@aria-label='Time']//li"));
			for (WebElement ele : allTimes) {
				String time = ele.getText().trim();
				if (dataTime.contains(time)) {
					ele.click();
					break;
				}

			}
		} catch (Exception e) {
			log.error("Failed to perform Calender input as :" + data);
		}
	}

}
