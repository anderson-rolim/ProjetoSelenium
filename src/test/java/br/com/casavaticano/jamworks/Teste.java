package br.com.casavaticano.jamworks;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;
import pages.CadastroPages;

public class Teste {

	static WebDriver driver;
	static CadastroPages cadastroPages;
	private static String baseUrl;
	private static String baseurl = "https://homologacao.casavaticano.com.br/login";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		System.setProperty("webdriver.chrome.driver", "C:\\navegadores\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to(baseurl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		cadastroPages = new CadastroPages(driver);

	}

	@Test
	public void Teste1() throws InterruptedException {
		cadastroPages.login();
	}

	@Test
	public void Teste2() throws InterruptedException {
		cadastroPages.buscaContaMaster();
	}

	@Test
	public void Teste3() throws InterruptedException {
		cadastroPages.seletorDeConta();
	}

	@Test
	public void Teste4() throws InterruptedException {
		cadastroPages.acessandoModuloTracks();

	}

	// novo
	@Test
	public void Teste5() throws InterruptedException {
		cadastroPages.novoProcesso();
	}

	
	@Test
	public void Teste6() throws InterruptedException {
		Assert.assertEquals(cadastroPages.validarMensagem(), "�" + "\n" + "Processo iniciado com sucesso.");
	}

	@Test
	public void Teste7() throws InterruptedException {
		cadastroPages.buscaDeProcessoAutomatizado();
	}

	@Test
	public void Teste8() throws InterruptedException {
		cadastroPages.acoesDoProcesso();
	}

	@Test
	public void Teste9() throws InterruptedException {
		Assert.assertEquals(cadastroPages.validarMensagem(), "�" + "\n" + "Pe�a renomeada para 'Teste Automatizado.'");

	}

	@Test
	public void Teste10() throws InterruptedException {
		cadastroPages.buscaDeAtividadeDoProcessoAutomatizado();

	}

	@Test
	public void Teste11() throws InterruptedException {
		cadastroPages.editandoAtividadeDoProcesso();

	}

	@Test
	public void Teste12() throws InterruptedException {
		// Mensagem da atividade salva
		Assert.assertEquals(cadastroPages.validarMensagem(), "�" + "\n" + "Atividade salva com sucesso.");

	}

	@Test
	public void Teste13() throws InterruptedException {
		Thread.sleep(1000);
		cadastroPages.acaoRemoverProcesso();
	}

	@Test
	public void Teste14() throws InterruptedException {
		Thread.sleep(1000);
		Assert.assertEquals(cadastroPages.validarMensagem(), "�" + "\n" + "Processo cancelado com sucesso.");

	}
	

	@Test
	public void Teste15() throws InterruptedException {
		// Mensagem da atividade salva
		cadastroPages.acaoLogout();

	}

	// Close Driver
	@AfterClass
	public static void tearDown() {

		// driver.quit();
	}

}
