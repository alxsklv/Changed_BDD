package Resources;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.picocontainer.Disposable;

public class lazyDriver extends baseResources implements WebDriver, Disposable {

	public WebDriver delegate = null;

    public WebDriver getDelegate() throws IOException {
        if (delegate == null) {
        	
            delegate = initializeDriver();
            //delegate.get(prop.getProperty("url"));            
            
        }
        return delegate;
    }

    @Override
    public void get(String url) {
        try {
			getDelegate().get(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @Override
    public String getCurrentUrl() {
        try {
			return getDelegate().getCurrentUrl();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }

    @Override
    public String getTitle() {
        try {
			return getDelegate().getTitle();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }

    @Override
    public List<WebElement> findElements(By by) {
        try {
			return getDelegate().findElements(by);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }

    @SuppressWarnings("unchecked")
	@Override
    public WebElement findElement(By by) {
        try {
			return getDelegate().findElement(by);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }

    @Override
    public String getPageSource() {
        try {
			return getDelegate().getPageSource();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }

    @Override
    public void close() {
        try {
			getDelegate().close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @Override
    public void quit() {
        try {
			getDelegate().quit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @Override
    public Set<String> getWindowHandles() {
        try {
			return getDelegate().getWindowHandles();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }

    @Override
    public String getWindowHandle() {
        try {
			return getDelegate().getWindowHandle();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }

    @Override
    public TargetLocator switchTo() {
        try {
			return getDelegate().switchTo();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }

    @Override
    public Navigation navigate() {
        try {
			return getDelegate().navigate();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }

    @Override
    public Options manage() {
        try {
			return getDelegate().manage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }

    @Override
    public void dispose() {
        System.out.println("Killing WebDriver");
        if(delegate != null){
            delegate.quit();
        }
    }
}
