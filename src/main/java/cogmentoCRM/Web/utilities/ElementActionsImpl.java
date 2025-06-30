package cogmentoCRM.Web.utilities;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cogmentoCRM.Web.actions.ElementAction;

public class ElementActionsImpl implements ElementAction {

	private WebDriver driver;
	private LoggerUtil log;

	public ElementActionsImpl(WebDriver driver) {
		this.driver = driver;
		this.log = new LoggerUtil();
	}

	@Override
	public void scrollToElement(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
		} catch (Exception e) {
			log.error(e.getMessage());
		}

	}

	@Override
	public void jsClick(WebDriver driver, WebElement element) {
		try {
			Thread.sleep(1000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);
		} catch (InterruptedException e) {
			log.error(e.getMessage());
		}
	}

	private String stringGenerator(int length) {
		final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		Random random = new Random();
		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			int index = random.nextInt(CHARACTERS.length());
			sb.append(CHARACTERS.charAt(index));
		}
		return sb.toString();

	}

	public String mobileNumGenerator() {
		Random random = new Random();
		int firstDigit = 7 + random.nextInt(3); // 7, 8, or 9
		StringBuilder mobileNumber = new StringBuilder();
		mobileNumber.append(firstDigit);
		for (int i = 0; i < 9; i++) {
			mobileNumber.append(random.nextInt(10)); // 0 to 9
		}
		return mobileNumber.toString();
	}

	@Override
	public void inputText(WebElement element, String data) {
		scrollToElement(element);
		if (data.toLowerCase().startsWith("@@mob")) {
			String mobileNo = mobileNumGenerator();
			data = mobileNo;
		} else if (data.toLowerCase().startsWith("@@str")) {
			String len = data.substring(6, data.length() - 1);
			int strLen = Integer.parseInt(len);
			String randomString = stringGenerator(strLen);
			data = randomString;
		}
		try {
			element.clear();
			element.sendKeys(data, Keys.TAB);
			log.info("Performed Text Input as-- " + data);
		} catch (Exception e) {
			element.sendKeys(data, Keys.ENTER);
			log.error("Failed to Perform Text Input as-- " + data);
		}
	}

	@Override
	public void clickElement(WebElement element) {
		scrollToElement(element);
		String elelabel = element.getText().trim();
		if (elelabel.isEmpty()) {
			elelabel = getlabelText(element);
		}
		try {
			jsClick(driver, element);
			log.info("Performed Click Action on Element-- " + elelabel);
		} catch (Exception e) {
			log.error("Failed to Perform Click Action on Element-- " + elelabel);
		}

	}

	@Override
	public void selectOption(WebElement element, String data) {
		String iconExp = null;
		try {
			scrollToElement(element);

			try {
				iconExp = element.getDomAttribute("aria-expanded").trim();
			} catch (Exception e) {
				iconExp = element.findElement(By.xpath("./parent::div")).getDomAttribute("aria-expanded").trim();
			}
			if (iconExp.equalsIgnoreCase("false")) {
				waitForElementToBeClickable(element, 2);
				element.click();
			}
			Thread.sleep(1000);
			List<WebElement> options = element.findElements(By.xpath(".//div[@role='option']/span"));
			if (options.isEmpty()) {
				options = element.findElements(By.xpath("./parent::div//div[@role='option']/span"));
			}
			for (WebElement ele : options) {
				if (ele.getText().trim().equalsIgnoreCase(data)) {
					ele.click();
					log.info("Selected the dropdown option as-- " + data);
					break;
				}
			}
		} catch (Exception e) {
			log.error("Failed to select the dropdown Option as-- " + data);
		}

	}

	@Override
	public void switchToggle(WebElement element, String data) {
		try {
			if (data.equalsIgnoreCase("Yes")) {
				jsClick(driver, element);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	@Override
	public String getlabelText(WebElement element) {
		String label = "";
		try {
			label = element.getDomAttribute("class").trim();
			if (label.isEmpty()) {
				label = element.findElement(By.xpath("./following-sibling::span")).getText().trim();
			}
		} catch (Exception e) {
			log.error("unlabeled Element");
		}
		return (label != null && !label.isEmpty()) ? label : null;
	}

	@Override
	public void waitForElementToBeVisible(WebElement element, int timeoutInSeconds) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			log.error(e.getMessage());
		}

	}

	@Override
	public void waitForElementToBeClickable(WebElement element, int timeoutInSeconds) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
			wait.until(ExpectedConditions.elementToBeClickable(element));

		} catch (Exception e) {
			log.error(e.getMessage());
		}

	}

	@Override
	public void clearText(WebElement element) {
		// TODO Auto-generated method stub

	}

	@Override
	public void inputRadio(WebElement element, String data) {
		// TODO Auto-generated method stub

	}

	@Override
	public void inputCheckbox(WebElement element, String data) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isDisplayed(WebElement element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled(WebElement element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSelected(WebElement element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void hoverOverElement(WebElement element) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getAttribute(WebElement element, String attribute) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCssValue(WebElement element, String property) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isElementPresent(WebElement element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void fileUpload(WebElement element, String filepath) {
		try {
			scrollToElement(element);
			element.sendKeys(filepath);
		} catch (Exception e) {
			log.error("Failed to upload file.." + e.getMessage());
		}

	}

	@Override
	public String getValue(WebElement element) {
		scrollToElement(element);
		waitForElementToBeVisible(element, 2);
		String capturedValue = "";
		try {
			capturedValue = element.getDomAttribute("value").trim();
		} catch (Exception e) {
			log.error("Value is empty or Not Captured");
		}
		return capturedValue;
	}

	@Override
	public void waitForElementsToBeVisible(List<WebElement> elements, int timeoutInSeconds) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
			wait.until(ExpectedConditions.visibilityOfAllElements(elements));
		} catch (Exception e) {
			log.error(e.getMessage());
		}

	}


}
