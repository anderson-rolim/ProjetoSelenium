package br.com.casavaticano.jamworks;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;
import pages.CadastroPages;


public class TesteEclusao {

	
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

	//------------------------MODULO DAM --------------------

		//------------------------DAM------------------------
		@Test
		public void Teste15() throws InterruptedException {
			cadastroPages.acessandoModuloDAM();

		}
		
		@Test
		public void Teste16() throws InterruptedException {
			cadastroPages.estruturaPasta();

		}
		
		@Test
		public void Teste17() throws InterruptedException {
			
			cadastroPages.acaoCriarDiretorioDAM();
		}
		
		
	
		@Test
		public void Teste18() throws InterruptedException {
			Assert.assertEquals(cadastroPages.validarMensagem(), "×" + "\n" + "Pasta criada com sucesso.");
		}

	
/*		
		@Test
		public void Teste19() throws InterruptedException {
			
			cadastroPages.AcaoBuscarDAM();
		}
		
		@Test
		public void Teste20() throws InterruptedException {
			
			cadastroPages.AcaoExcluirDAM();
			
			
		}
*/

		//------------------------MODULO DRM --------------------

		

		@Test
		public void Teste20() throws InterruptedException {
			
			cadastroPages.acessandoModuloDRM();
			
			
		}
		
		@Test
		public void Teste21() throws InterruptedException {
			
			cadastroPages.drmArquivoDiretorio();
			
			
		}
		
		@Test
		public void Teste22() throws InterruptedException {
			Assert.assertEquals(cadastroPages.validarMensagem(), "×" + "\n" + "Direito de uso editado com sucesso.");
		}
		@Test
		public void Teste23() throws InterruptedException {
			
			cadastroPages.buscaDRM();
			
		}
		
		@Test
		public void Teste24() throws InterruptedException {
			
			cadastroPages.ordenacaoDRM();
			
		}

/*
		@Test
		public void Teste21() throws InterruptedException {
			// sair do sistema
			cadastroPages.acaoLogout();

		}

		*/
		@After
		public void tearDown() throws Exception {
	//		driver.close();
			
		}	

	}
