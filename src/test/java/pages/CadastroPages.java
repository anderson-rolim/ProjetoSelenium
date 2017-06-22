package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CadastroPages {
	private WebDriver driver;

	public CadastroPages(WebDriver driver) {

		this.driver = driver;
	}

	public void login() {

		WebElement login = driver.findElement(By.id("username"));
		login.sendKeys("anderson.rolim");

		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("jamworks");

		WebElement entrar = driver.findElement(By.id("_submit"));
		entrar.submit();

	}

	// Busca a conta no ambiente Master
	public void buscaContaMaster() {

		// Busca da conta 31
		WebElement campoBusca = driver.findElement(By.id("master_account_search_text"));
		campoBusca.sendKeys("31");

		WebElement buscar = driver.findElement(By.id("master_accont_search"));
		buscar.submit();

	}

	public void seletorDeConta() throws InterruptedException {
		// Administrar Conta
		Thread.sleep(1000);
		WebElement admConta = driver.findElement(By.cssSelector("i.icon-administration"));
		admConta.click();

		Thread.sleep(1000);

		// Entrar no Grupo da Conta
		WebElement entrar = driver.findElement(By.id("master_accont_admin"));
		entrar.submit();

	}

	public void acessandoModuloTracks() throws InterruptedException {
		// Acessando Modulo Tracks
		WebElement moduloTracks = driver.findElement(By.linkText("Tracks"));
		moduloTracks.click();
		Thread.sleep(1000);
	}

	public void buscaDeProcessoAutomatizado() throws InterruptedException {
		// Fazendo a busca.
		Thread.sleep(1000);

		WebElement limpaBusca = driver.findElement(By.id("admin_user_serach_input"));
		limpaBusca.clear();

		WebElement escreverBusca = driver.findElement(By.id("admin_user_serach_input"));
		escreverBusca.sendKeys("Teste Automatizado.");

		WebElement fazerBusca = driver.findElement(By.id("admin_user_serach-btn"));
		fazerBusca.click();
	}

	public void buscaDeAtividadeDoProcessoAutomatizado() throws InterruptedException {
		Thread.sleep(1000);

		// Fazendo a Busca por tipo da atividade (Principal)

		WebElement limpaBusca = driver.findElement(By.id("admin_user_serach_input"));
		limpaBusca.clear();

		WebElement escreverBusca = driver.findElement(By.id("admin_user_serach_input"));
		escreverBusca.sendKeys("Principal");

		WebElement fazerBusca = driver.findElement(By.id("admin_user_serach-btn"));
		fazerBusca.click();
	}

	public void acoesDoProcesso() throws InterruptedException {
		Thread.sleep(1000);
		// Editar nome de Processo
		acaoEditarProcesso();
		Thread.sleep(1000);

		// Escrever comentario
		acaoComentarioProcesso();
		Thread.sleep(1000);

		// Renomear
		acaoRenomearProcesso();

	}

	// Remover processo
	public void acaoRemoverProcesso() throws InterruptedException {

		WebElement acaoRemoverDadosProcesso = driver.findElement(By.cssSelector("i.icon-remove"));
		acaoRemoverDadosProcesso.click();

		Thread.sleep(1000);
		WebElement limpar = driver.findElement(By.id("comentario_texto"));
		limpar.clear();
		WebElement editarProcesso = driver.findElement(By.id("comentario_texto"));
		editarProcesso.sendKeys("Exclusão de processo da Automação de Teste.");

		WebElement btnRemoverDadosProcesso = driver.findElement(By.id("tracker_ations_cancel_process_save"));
		btnRemoverDadosProcesso.click();

		Thread.sleep(1000);
	}

	// Editar dados do processo
	public void acaoEditarProcesso() throws InterruptedException {

		WebElement editarDadosProcesso = driver.findElement(By.cssSelector("i.icon-pencil"));
		editarDadosProcesso.click();

		Thread.sleep(1000);
		WebElement limpar = driver.findElement(By.id("processo_title"));
		limpar.clear();
		WebElement editarProcesso = driver.findElement(By.id("processo_title"));
		editarProcesso.sendKeys("Teste Automatizado");

		WebElement acaoEditarProcessoTracks = driver.findElement(By.id("tracker_actions_edit_process"));
		acaoEditarProcessoTracks.click();

	}

	// Inserir Comentario do processo
	public void acaoComentarioProcesso() throws InterruptedException {

		WebElement comentario = driver.findElement(By.cssSelector("i.icon-comment"));
		comentario.click();
		Thread.sleep(1000);

		WebElement limpar = driver.findElement(By.id("comentario_texto"));
		limpar.clear();

		WebElement escreverComentario = driver.findElement(By.id("comentario_texto"));
		escreverComentario.sendKeys(
				"Teste automatizado de comentário para homologação.\nTexto automatizado\n----------------------\n Uma pessoa gosta do país em que vive e não há nada a fazer. "
				+ "Parece-me assim essencial que o país se submeta a segunda volta contra o doutor Mário Soares e que o Professor Doutor Aníbal Cavaco Silva ganhe. Assim como na "
						+ "direita há demasiado medo da segunda volta, na esquerda existem demasiadas esperanças. "
						+ "O risco de Mário Soares ganhar é muito menos grave que a falta de clivagem e definição do país com que inevitavelmente vamos"
						+ "do lugar e da forma mais inteligente de utilizar em beneficio de todos a inevitabilidade humana de coisas como a inveja, o "
						+ "egoísmo, a ganância, a ambição, finalmente, do sentido a dar à Justiça.");

		WebElement acaoEscrever = driver.findElement(By.id("tracker_actions_comment_save"));
		acaoEscrever.click();

	}

	// Renomear peca do processo
	public void acaoRenomearProcesso() throws InterruptedException {

		WebElement renomear = driver.findElement(By.cssSelector("i.icon-rename"));
		renomear.click();

		Thread.sleep(1000);

		WebElement limpar = driver.findElement(By.id("peca_name"));
		limpar.clear();

		WebElement renomearPeca = driver.findElement(By.id("peca_name"));
		renomearPeca.sendKeys("Teste Automatizado.");

		WebElement acaoRenomearProcessoTracks = driver.findElement(By.id("tracker_action_rename_submit"));
		acaoRenomearProcessoTracks.click();

	}

	// Validando mensagem com sucesso
	public String validarMensagem() {

		// errormsg errormsg_0_GmailAddress
		// Pega o texto do erro.

		return driver.findElement(By.cssSelector("div.alert.alert-success")).getText();

	}

	// Novo Processo
	public void novoProcesso() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.linkText("Tracks")).click();
		driver.findElement(By.id("new-process-instance")).click();
		// Achando Elemento (Processo) Estava invisivel;

		JavascriptExecutor executor = (JavascriptExecutor) driver;

		WebElement invisibleelement = driver.findElement(By.id("tracks_process_20"));

		executor.executeScript("arguments[0].click();", invisibleelement);

		 formularioPeca();
		 preencherCampos();

	}

	// Formulario da Peca
	public void formularioPeca() throws InterruptedException {
		Thread.sleep(1000);

		driver.findElement(By.id("form_2_field_1")).clear();
		driver.findElement(By.id("form_2_field_1")).sendKeys("Teste Automatizado");

		Thread.sleep(1000);
		WebElement agencia = driver.findElement(By.xpath(".//*[@id='form_2_field_3']/option[3]"));
		agencia.click();

		Thread.sleep(2000);
		WebElement anunciante = driver.findElement(By.xpath(".//*[@id='form_2_field_4']/option[3]"));
		anunciante.click();

		Thread.sleep(1000);
		WebElement produto = driver.findElement(By.xpath(".//*[@id='form_2_field_5']/option[2]"));
		produto.click();

	}

	// Formulario do processo
	public void preencherCampos() throws InterruptedException {
		Thread.sleep(1000);

		driver.findElement(By.id("tracker_form_peca_save")).click();

		campoTituloDaAtividadeDoProcesso();
		campoEmailDaAtividadeDoProcesso();

		WebElement comboRelacionamento = driver.findElement(By.xpath(".//*[@id='form_1_field_1038']/option[2]"));
		comboRelacionamento.click();

		campoTextoGrandeDaAtividadeDoProcesso();
		campoWidgetDeTabelaDaAtividadeDoProcesso();

		driver.findElement(By.name("btn")).click();
	}

	// Entrando na atividade
	public void entrandoNaAtividadeDoProcesso() throws InterruptedException {
		Thread.sleep(1000);
		WebElement entrandoNaAtividadePricnipal = driver.findElement(By.id("tracker_list_activity_1"));
		entrandoNaAtividadePricnipal.click();

	}

	// Campo Titulo
	public void campoTituloDaAtividadeDoProcesso() throws InterruptedException {
		Thread.sleep(1000);
		WebElement campoTitulo = driver.findElement(By.id("form_1_field_1037"));
		campoTitulo.clear();
		campoTitulo.sendKeys("Teste Automatizado no Jamworks");
	}

	// Campo Email
	public void campoEmailDaAtividadeDoProcesso() throws InterruptedException {
		Thread.sleep(1000);
		WebElement campoEmail = driver.findElement(By.id("form_1_field_1036"));
		campoEmail.clear();
		campoEmail.sendKeys("teste@teste.com.br");
		campoEmail.clear();
		campoEmail.sendKeys("anderson.rolim@casavaticano.com.br");

	}

	// Campo Texto Grande
	public void campoTextoGrandeDaAtividadeDoProcesso() throws InterruptedException {
		Thread.sleep(1000);
		WebElement campoTextoGrande = driver.findElement(By.id("form_1_field_1039"));
		campoTextoGrande.clear();
		campoTextoGrande.sendKeys("teste");
		campoTextoGrande.clear();
		campoTextoGrande.sendKeys(
				"Uma pessoa gosta do país em que vive e não há nada a fazer. Parece-me assim essencial que o país se submeta a segunda volta contra o doutor Mário Soares e que o Professor Doutor Aníbal Cavaco Silva ganhe. Assim como na direita há demasiado medo da segunda volta, na esquerda existem demasiadas esperanças. O risco de Mário Soares ganhar é muito menos grave que a falta de clivagem e definição do país com que inevitavelmente vamos ainda chegar à primeria das voltas, onde só os extremos beneficiam. Por essa altura Jerónimo Sousa, Francisco Louçã e Manuel Alegre ainda parecerão candidatos decentes, as três pessoas que congregam sozinhos os piores traços da nação (ainda assim com aspectos adoráveis, pricipalmente se andamos a ler Goethe).");

	}

	public void campoWidgetDeTabelaDaAtividadeDoProcesso() throws InterruptedException {
		Thread.sleep(1000);
		// Widget de tabela
		driver.findElement(By.id("form_table_form_1_field_1041_row1_cel1]")).clear();
		driver.findElement(By.id("form_table_form_1_field_1041_row1_cel1]")).sendKeys("121244556613");
		driver.findElement(By.id("form_table_form_1_field_1041_row1_cel2]")).clear();
		driver.findElement(By.id("form_table_form_1_field_1041_row1_cel2]")).sendKeys("Camisa - Vermelha Teste");
		driver.findElement(By.id("form_table_form_1_field_1041_row1_cel3]")).clear();
		driver.findElement(By.id("form_table_form_1_field_1041_row1_cel3]")).sendKeys("GG");
		driver.findElement(By.id("form_table_form_1_field_1041_row2_cel1]")).clear();
		driver.findElement(By.id("form_table_form_1_field_1041_row2_cel1]")).sendKeys("121244556614");
		driver.findElement(By.id("form_table_form_1_field_1041_row2_cel2]")).clear();
		driver.findElement(By.id("form_table_form_1_field_1041_row2_cel2]")).sendKeys("Camisa - Azul Teste");
		driver.findElement(By.id("form_table_form_1_field_1041_row2_cel3]")).clear();
		driver.findElement(By.id("form_table_form_1_field_1041_row2_cel3]")).sendKeys("PP");
		driver.findElement(By.id("form_table_form_1_field_1041_row3_cel1]")).clear();
		driver.findElement(By.id("form_table_form_1_field_1041_row3_cel1]")).sendKeys("121244556615");
		driver.findElement(By.id("form_table_form_1_field_1041_row3_cel2]")).clear();
		driver.findElement(By.id("form_table_form_1_field_1041_row3_cel2]")).sendKeys("Camisa - Amarela Teste");
		driver.findElement(By.id("form_table_form_1_field_1041_row3_cel3]")).clear();
		driver.findElement(By.id("form_table_form_1_field_1041_row3_cel3]")).sendKeys("PPE");
		driver.findElement(By.id("form_table_form_1_field_1041_row4_cel1]")).clear();
		driver.findElement(By.id("form_table_form_1_field_1041_row4_cel1]")).sendKeys("121244556616");
		driver.findElement(By.id("form_table_form_1_field_1041_row4_cel2]")).clear();
		driver.findElement(By.id("form_table_form_1_field_1041_row4_cel2]")).sendKeys("Camisa - Azul Teste");
		driver.findElement(By.id("form_table_form_1_field_1041_row4_cel3]")).clear();
		driver.findElement(By.id("form_table_form_1_field_1041_row4_cel3]")).sendKeys("GG");
		driver.findElement(By.id("form_table_form_1_field_1041_row5_cel1]")).clear();
		driver.findElement(By.id("form_table_form_1_field_1041_row5_cel1]")).sendKeys("121244556617");
		driver.findElement(By.id("form_table_form_1_field_1041_row5_cel2]")).clear();
		driver.findElement(By.id("form_table_form_1_field_1041_row5_cel2]")).sendKeys("Camisa - Preta Teste");
		driver.findElement(By.id("form_table_form_1_field_1041_row5_cel3]")).clear();
		driver.findElement(By.id("form_table_form_1_field_1041_row5_cel3]")).sendKeys("42");
		driver.findElement(By.id("form_table_form_1_field_1041_row6_cel1]")).clear();
		driver.findElement(By.id("form_table_form_1_field_1041_row6_cel1]")).sendKeys("121244556618");
		driver.findElement(By.id("form_table_form_1_field_1041_row6_cel2]")).clear();
		driver.findElement(By.id("form_table_form_1_field_1041_row6_cel2]")).sendKeys("Camisa - Rosa Teste");
		driver.findElement(By.id("form_table_form_1_field_1041_row6_cel3]")).clear();
		driver.findElement(By.id("form_table_form_1_field_1041_row6_cel3]")).sendKeys("40");
		driver.findElement(By.id("form_table_form_1_field_1041_row7_cel1]")).clear();
		driver.findElement(By.id("form_table_form_1_field_1041_row7_cel1]")).sendKeys("121244556619");
		driver.findElement(By.id("form_table_form_1_field_1041_row7_cel2]")).clear();
		driver.findElement(By.id("form_table_form_1_field_1041_row7_cel2]")).sendKeys("Camisa - Roxa Teste");
		driver.findElement(By.id("form_table_form_1_field_1041_row7_cel3]")).clear();
		driver.findElement(By.id("form_table_form_1_field_1041_row7_cel3]")).sendKeys("42");

	}

	public void acaoSalvarAtividadeDoProcesso() throws InterruptedException {
		Thread.sleep(1000);
		// Botão Salvar
		WebElement salvar = driver.findElement(By.id("tracker_form_activity_save"));
		salvar.click();
	}

	public void editandoAtividadeDoProcesso() throws InterruptedException {
		Thread.sleep(1000);

		entrandoNaAtividadeDoProcesso();
		campoTituloDaAtividadeDoProcesso();
		campoEmailDaAtividadeDoProcesso();
		campoTextoGrandeDaAtividadeDoProcesso();
		campoWidgetDeTabelaDaAtividadeDoProcesso();
		acaoSalvarAtividadeDoProcesso();

	}

	public void acaoLogout() throws InterruptedException {

		// Efetuar logout do Sistema

		Thread.sleep(1000);

		driver.findElement(By.cssSelector("i.icon-chevron-down.icon-white")).click();
		driver.findElement(By.id("cloud_accout_logout")).click();

	}

	public void preencherCampos88() {

		WebElement nome = driver.findElement(By.id("FirstName"));
		nome.sendKeys("Anderson");

		WebElement sobrenome = driver.findElement(By.id("LastName"));
		sobrenome.sendKeys("Dog");

		WebElement email = driver.findElement(By.id("GmailAddress"));
		email.sendKeys("dog.rolim@gmail.com");

		WebElement password = driver.findElement(By.id("Passwd"));
		password.sendKeys("ruthrolim");

		WebElement confirmaPassword = driver.findElement(By.id("PasswdAgain"));
		confirmaPassword.sendKeys("ruthrolim");

		WebElement dia = driver.findElement(By.id("BirthDay"));
		dia.sendKeys("22");

		WebElement mes = driver.findElement(By.xpath("//*[@id='BirthMonth']"));
		mes.click();

		WebElement mesdeoutubro = driver.findElement(By.xpath("//*[@id=':a']/div"));
		mesdeoutubro.click();

		WebElement ano = driver.findElement(By.id("BirthYear"));
		ano.sendKeys("1983");

		WebElement sexo = driver.findElement(By.xpath("//*[@id='Gender']/div[1]"));
		sexo.click();

		WebElement sexomasculino = driver.findElement(By.xpath("//*[@id=':f']/div"));
		sexomasculino.click();

		WebElement telefone = driver.findElement(By.xpath("//*[@id='RecoveryPhoneNumber']"));
		telefone.sendKeys(" 11 39961379");

		WebElement emailresgate = driver.findElement(By.xpath("//*[@id='RecoveryEmailAddress']"));
		emailresgate.sendKeys("automatizador@gmail.com");

		WebElement passoseguinte = driver.findElement(By.xpath("//*[@id='submitbutton']"));
		passoseguinte.submit();

		// *[@id="RecoveryPhoneNumber"]
		// *[@id=":f"]/div

	}

}
