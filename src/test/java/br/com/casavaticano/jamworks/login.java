package br.com.casavaticano.jamworks;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;
import pages.CadastroPages;



public class login {

	static WebDriver driver;
	static CadastroPages cadastroPages;
	private static String baseUrl;
    private static String baseurl = "https://homologacao.casavaticano.com.br/login";

    
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		 
		System.setProperty("webdriver.chrome.driver", "C:\\navegadores\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to(baseurl);
		//baseUrl = "https://homologacao.casavaticano.com.br/login";
		//driver.get("https://homologacao.casavaticano.com.br/login");
		//driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		cadastroPages = new CadastroPages(driver);

	}
	
   
   	@Test
	public void atestDeLoginA() throws InterruptedException {
   		cadastroPages.login();
   		//driver.quit();
	}
   	
 	@Test
	public void bbuscaContaMasterB() throws InterruptedException {
 		cadastroPages.buscaContaMaster();
 	}
 	
 	@Test
	public void cseletorDeContaC() throws InterruptedException {
 		cadastroPages.seletorDeConta();
 	}
 	
 	
 	
 	@Test
	public void dacessandoModuloTracksd() throws InterruptedException {
 		cadastroPages.acessandoModuloTracks();
 	}
 	
 	
 	@Test
	public void enovoProcessoe() throws InterruptedException {
 		cadastroPages.novoProcesso();
 	}
 	
 	@Test
	public void fmensagemDoProcessoIniciadoComSucessof() throws InterruptedException {
 		Assert.assertEquals(cadastroPages.validarMensagem(), "×"+"\n"+"Processo iniciado com sucesso.");
 	}
 	
 	@Test
	public void gbuscaDeProcessoAutomatizadog() throws InterruptedException {
 		cadastroPages.buscaDeProcessoAutomatizado();
 	}
 	
	@Test
	public void hacoesDoProcessoh() throws InterruptedException {
		cadastroPages.acoesDoProcesso(); 
 	}	
	
 	@Test
	public void imensagemDaPecaRenomeadaComSucessoi() throws InterruptedException {
 		Assert.assertEquals(cadastroPages.validarMensagem(), "×"+"\n"+"Peça renomeada para 'Teste Automatizado.'");
 	
 	}
	
 	
	@Test
	public void jbuscaDeAtividadeDoProcessoAutomatizadoj() throws InterruptedException {
	    cadastroPages.buscaDeAtividadeDoProcessoAutomatizado(); 

 	}	
 	
	@Test
	public void leditandoAtividadeDoProcessol() throws InterruptedException {
		cadastroPages.editandoAtividadeDoProcesso(); 

 	}	

 	@Test
	public void mensagemDaAtividadeSalvaComSucessom() throws InterruptedException {
 		//Mensagem da atividade salva
 		Assert.assertEquals(cadastroPages.validarMensagem(), "×"+"\n"+"Atividade salva com sucesso.");

 	}
		
 	@Test
	public void nacaoLogoutn() throws InterruptedException {
 		//Mensagem da atividade salva
 		cadastroPages.acaoLogout();


 	}
		
		
 	
    //Close Driver
	@AfterClass
	public static void tearDown() {
		
	//	driver.quit();
	}	

	
}
