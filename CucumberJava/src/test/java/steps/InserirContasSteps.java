package steps;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class InserirContasSteps {
	
	private WebDriver driver;
	
	@Dado("^que estou acessando a aplicação$")
	public void que_estou_acessando_a_aplicação() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://seubarriga.wcaquino.me/login");
	}

	@Quando("^informo o usuário \"([^\"]*)\"$")
	public void informo_o_usuário(String arg1) throws Throwable {
		driver.findElement(By.id("email")).sendKeys(arg1);
	}

	@Quando("^a senha \"([^\"]*)\"$")
	public void a_senha(String arg1) throws Throwable {
		driver.findElement(By.id("senha")).sendKeys(arg1);
	}

	@Quando("^seleciono entrar$")
	public void seleciono_entrar() throws Throwable {
		driver.findElement(By.tagName("button")).click();


	}

	@Então("^visualizo a página inicial$")
	public void visualizo_a_página_inicial() throws Throwable {
		String texto = driver.findElement(By.xpath("/html/body/div[1]")).getText();
		assertEquals("Bem vindo, a!", texto);

	}

	@Quando("^seleciono Contas$")
	public void seleciono_Contas() throws Throwable {
		driver.findElement(By.linkText("Contas")).click();

	}

	@Quando("^seleciono Adicionar$")
	public void seleciono_Adicionar() throws Throwable {
		driver.findElement(By.linkText("Adicionar")).click();

	}
	
	@Quando("^informo a conta \"([^\"]*)\"$")
	public void informo_a_conta(String arg1) throws Throwable {
		driver.findElement(By.id("nome")).sendKeys(arg1);

	}
	
	@Quando("^seleciono Salvar$")
	public void seleciono_Salvar() throws Throwable {
		driver.findElement(By.tagName("button")).click();

	}

	@Então("^a conta é inserida com sucesso$")
	public void a_conta_é_inserida_com_sucesso() throws Throwable {
		String texto = driver.findElement(By.xpath("/html/body/div[1]")).getText();
		assertEquals("Conta adicionada com sucesso!", texto);

	}

	@Então("^sou notificar que o nome da conta é obrigatório$")
	public void sou_notificar_que_o_nome_da_conta_é_obrigatório() throws Throwable {
		String texto = driver.findElement(By.xpath("/html/body/div[1]")).getText();
		assertEquals("Informe o nome da conta", texto);

	}

	@Então("^sou notificado que já existe uma conta com esse nome$")
	public void sou_notificado_que_já_existe_uma_conta_com_esse_nome() throws Throwable {
		String texto = driver.findElement(By.xpath("/html/body/div[1]")).getText();
		assertEquals("Já existe uma conta com esse nome!", texto);
	}
	
	@Então("^recebo a mensagem \"([^\"]*)\"$")
	public void recebo_a_mensagem(String arg1) throws Throwable {
		
		String texto = driver.findElement(By.xpath("/html/body/div[1]")).getText();
		assertEquals(arg1, texto);
	}
	
	@After(order = 1)
	public void screenshot(Scenario cenario) {
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("target/screenshot/"+cenario.getId()+".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@After(order = 0) //será o ultimo after executado!!
	public void afterScenario() {
		driver.quit();
		
	}
	
}
